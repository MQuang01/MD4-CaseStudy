package com.example.md4casestudyfastfood.model.dto.req;

import lombok.Getter;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;

@Getter
@Setter
public class LoginReqDto {
    private String email;
    private String password;
}
