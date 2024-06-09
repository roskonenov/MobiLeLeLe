package bg.softuni.mobilelele.model.dto;


import bg.softuni.mobilelele.model.anotations.Email;
import bg.softuni.mobilelele.model.anotations.Password;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UserRegisterDTO {
    @NotBlank(message = "{register.user.firstName.not.empty}")
    @Size(min = 5, max = 20, message = "{register.user.firsName.length}")
    private String firstName;

    @NotBlank(message = "{register.user.lastName.not.empty}")
    @Size(min = 5, max = 20, message = "{register.user.lastName.length}")
    private String lastName;

    @NotBlank(message = "{register.user.email.not.empty}")
    @Email(message = "{register.user.email.invalid}")
    private String email;

    @NotBlank(message = "{register.user.password.not.empty}")
    @Password(message = "{register.user.password.invalid}")
    @Size(min = 8, max = 50, message = "{register.user.password.length}")
    private String password;

    public String getFirstName() {
        return firstName;
    }

    public UserRegisterDTO setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UserRegisterDTO setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserRegisterDTO setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserRegisterDTO setPassword(String password) {
        this.password = password;
        return this;
    }

    @Override
    public String toString() {
        return "UserRegisterDTO{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + (password == null ? "N/A" : "[PROVIDED]" ) + '\'' +
                '}';
    }
}
