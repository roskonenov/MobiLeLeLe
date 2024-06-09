package bg.softuni.mobilelele.service;

import bg.softuni.mobilelele.model.dto.LoginDTO;
import bg.softuni.mobilelele.model.dto.UserRegisterDTO;

public interface UserService {
    void registerUser(UserRegisterDTO userRegisterDTO);

    boolean login(LoginDTO loginDTO);
}
