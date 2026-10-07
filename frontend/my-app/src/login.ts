document.getElementById("loginBtn")?.addEventListener("click", async (event) => {
    event.preventDefault(); // Prevent the default form submission

    const username = (document.getElementById("username") as HTMLInputElement).value;
    const password = (document.getElementById("password") as HTMLInputElement).value;

    // Create the request payload
    const payload = {
        username: username,
        password: password
    };

    try {
        const response = await fetch("/api/auth/login", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(payload)
        });
        console.log("Response status:", response.status);

        if (response.ok) {
            const data = await response.json();
            console.log("Login successful:", data);
            // Handle successful login (e.g., redirect to dashboard)
        } else {
            const errorData = await response.json();
            console.error("Login failed:", errorData);
            // Handle login failure (e.g., show error message)
        }
    } catch (error) {
        console.error("Error during login:", error);
        // Handle network or other errors
    }
});