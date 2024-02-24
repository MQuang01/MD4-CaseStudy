package com.example.md4casestudyfastfood.controller.restcontroller;

import com.example.md4casestudyfastfood.model.dto.req.LoginReqDto;
import com.example.md4casestudyfastfood.model.dto.req.RegisterReqDto;
import com.example.md4casestudyfastfood.service.auth.IAuthService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auths")
@AllArgsConstructor
public class AuthRestController {
    private final IAuthService authService;
    @PostMapping("/register")
    public ResponseEntity<Void> save(@RequestBody RegisterReqDto registerReqDto){
        authService.save(registerReqDto);
        return ResponseEntity.ok().build();
    }
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginReqDto loginReqDto) {
        try {
            return ResponseEntity.ok(authService.login(loginReqDto));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
