package bg.softuni.mobilelele.model.dto;

import bg.softuni.mobilelele.model.anotations.Email;
import bg.softuni.mobilelele.model.anotations.Password;

import jakarta.validation.constraints.NotBlank;

public class LoginDTO {

    @NotBlank(message = "{register.user.email.not.empty}")
    @Email(message = "{register.user.email.not.empty}" )
    private String email;

    @NotBlank
    @Password
    private String password;

    public String getEmail() {
        return email;
    }

    public LoginDTO setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public LoginDTO setPassword(String password) {
        this.password = password;
        return this;
    }

    @Override
    public String toString() {
        return "LoginDTO{" +
                "email='" + email + '\'' +
                ", password='" + (password == null ? "N/A" : "[PROVIDED]") + '\'' +
                '}';
    }
}
