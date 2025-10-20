package com.example.demo.viewModels;

public class RegistrationForm {
        private String name;
        private String LastName;
        private String username;
        private String password;
        private Integer phoneNumber;
        private String email;

        // Getters and setters omitted for brevity

        public RegistrationForm(String name, String lastname,
                                String username, String password,
                                Integer phoneNumber, String email) {
            this.name = name;
            this.LastName = lastname;
            this.username = username;
            this.password = password;
            this.phoneNumber = phoneNumber;
            this.email = email;
        }

        public RegistrationForm() {
        }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return LastName;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }
}
