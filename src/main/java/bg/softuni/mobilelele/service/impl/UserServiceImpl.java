package bg.softuni.mobilelele.service.impl;

import bg.softuni.mobilelele.model.User;
import bg.softuni.mobilelele.model.dto.UserRegisterDTO;
import bg.softuni.mobilelele.repository.UserRepository;
import bg.softuni.mobilelele.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void registerUser(UserRegisterDTO userRegisterDTO) {
        userRepository.saveAndFlush(map(userRegisterDTO));
    }

    private User map(UserRegisterDTO userRegisterDTO){
        User mappedUser = modelMapper.map(userRegisterDTO, User.class);
        mappedUser.setPassword(passwordEncoder.encode(userRegisterDTO.getPassword()));
        return mappedUser;
    }
}
