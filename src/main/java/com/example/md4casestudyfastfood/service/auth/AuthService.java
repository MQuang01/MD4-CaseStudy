package com.example.md4casestudyfastfood.service.auth;
import com.example.md4casestudyfastfood.model.CustomUserDetails;
import com.example.md4casestudyfastfood.model.Role;
import com.example.md4casestudyfastfood.model.User;
import com.example.md4casestudyfastfood.model.dto.req.LoginReqDto;
import com.example.md4casestudyfastfood.model.dto.req.RegisterReqDto;
import com.example.md4casestudyfastfood.repository.IRoleRepository;
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
    private final IRoleRepository roleRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return new CustomUserDetails(user);
    }

    @Override
    public void save(RegisterReqDto registerReqDto) {
        Role role = roleRepository.findById(2L).get();
        User user = new User();
        user.setName(registerReqDto.getName());
        user.setPhoneNumber(registerReqDto.getPhoneNumber());
        user.setDob(registerReqDto.getDob());
        user.setAddress(registerReqDto.getAddress());
        user.addRole(role);
        user.setEmail(registerReqDto.getEmail());
        user.setPassword(passwordEncoder.encode(registerReqDto.getPassword()));
        userRepository.save(user);
    }

    @Override
    public String login(LoginReqDto loginReqDto) {
        UserDetails userDetails = loadUserByUsername(loginReqDto.getEmail());
        if (!passwordEncoder.matches(loginReqDto.getPassword(), userDetails.getPassword())) {
            throw new IllegalStateException("Wrong password or username");
        }
        return jwTokenProvider.generateToken(userDetails.getUsername());
    }
}
