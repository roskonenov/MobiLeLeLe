package bg.softuni.mobilelele.service.impl;

import bg.softuni.mobilelele.model.User;
import bg.softuni.mobilelele.repository.UserRepository;
import bg.softuni.mobilelele.service.CurrentUser;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;

    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(email)
                .map(this::mapToUserDetails)
                .orElseThrow(() ->new  UsernameNotFoundException("User not found!"));
    }

    private UserDetails mapToUserDetails(User user) {
        return new CurrentUser(
                user.getEmail(),
                user.getPassword(),
                List.of(),
                user.getFirstName(),
                user.getLastName()
        );
    }
}
