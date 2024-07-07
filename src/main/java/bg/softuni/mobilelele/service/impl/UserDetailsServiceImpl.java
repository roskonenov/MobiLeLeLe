package bg.softuni.mobilelele.service.impl;

import bg.softuni.mobilelele.model.entity.Role;
import bg.softuni.mobilelele.model.entity.User;
import bg.softuni.mobilelele.model.enums.RoleEnum;
import bg.softuni.mobilelele.repository.UserRepository;
import bg.softuni.mobilelele.model.user.CurrentUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;

    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(email)
                .map(this::mapToUserDetails)
                .orElseThrow(() -> new  UsernameNotFoundException("User not found!"));
    }


    private UserDetails mapToUserDetails(User user) {
        return new CurrentUser(
                user.getEmail(),
                user.getPassword(),
                user.getRoles().stream().map(Role::getRole).map(UserDetailsServiceImpl::map).toList(),
                user.getFirstName(),
                user.getLastName()
        );
    }

    private static GrantedAuthority map(RoleEnum role){
        return new SimpleGrantedAuthority("ROLE_" + role);
    }
}
