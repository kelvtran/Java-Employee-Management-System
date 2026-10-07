package com.example.demo.service;

import com.example.demo.AuthResponse;
import com.example.demo.LoginRequest;
import com.example.demo.AppUser;
import com.example.demo.UserRepository;

//CORS
@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:*") // or "*" for dev

// import com.yourapp.security.JwtService;
// import org.springframework.security.authentication.BadCredentialsException;
// import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository userRepository;
    // private final PasswordEncoder passwordEncoder;
    // private final JwtService jwtService;

    // Constructor injection — Spring hands us everything
    public AuthService(UserRepository userRepository,
                    //    PasswordEncoder passwordEncoder,
                    //    JwtService jwtService
                    ) {
        this.userRepository = userRepository;
        // this.passwordEncoder = passwordEncoder;
        // this.jwtService = jwtService;
    }

    /**
     * Authenticates a user from JSON login data.
     * @param request parsed JSON body
     * @return token + user info if valid
     * @throws BadCredentialsException if username or password is wrong
     */
    public AuthResponse login(LoginRequest request) {

        // 1. Validate input isn't empty
        if (request.getUsername() == null || request.getPassword() == null) {
            throw new BadCredentialsException("Username and password required");
        }

        // 2. Look up the user in the DB
        User user = userRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new BadCredentialsException("Invalid credentials"));

        // // 3. Compare raw password against the stored hash
        // if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
        //     throw new BadCredentialsException("Invalid credentials");
        // }

        // // 4. Generate JWT
        // String token = jwtService.generateToken(user);

        // 5. Return safe response (no password!)
        return new AuthResponse(user.getUsername());
    }
}