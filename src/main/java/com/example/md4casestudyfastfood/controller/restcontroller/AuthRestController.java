package com.example.md4casestudyfastfood.controller.restcontroller;

import com.example.md4casestudyfastfood.service.auth.IAuthService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auths")
@AllArgsConstructor
public class AuthRestController {
    private final IAuthService authService;
}
