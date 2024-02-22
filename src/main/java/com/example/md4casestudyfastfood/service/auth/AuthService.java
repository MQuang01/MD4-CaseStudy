package com.example.md4casestudyfastfood.service.auth;
import com.example.md4casestudyfastfood.model.CustomUserDetails;
import com.example.md4casestudyfastfood.model.User;
import com.example.md4casestudyfastfood.repository.IUserRepository;
import com.example.md4casestudyfastfood.util.JwTokenProvider;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthService implements UserDetailsService,IAuthService {
    private final IUserRepository userRepository;
    private final JwTokenProvider jwTokenProvider;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return new CustomUserDetails(user);
    }
}
