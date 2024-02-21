package com.example.md4casestudyfastfood.model.dto.res;

import com.example.md4casestudyfastfood.model.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserResDto {
    private Long id;
    private String name;
    private String phoneNumber;
    private String address;
    private String email;
    private String password;

    private List<RoleResDto> roles = new ArrayList<>();
}
