package com.example.md4casestudyfastfood.model;

import com.example.md4casestudyfastfood.model.dto.res.RoleResDto;
import com.example.md4casestudyfastfood.model.dto.res.UserResDto;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String phoneNumber;
    private LocalDate dob;
    private String address;
    private String email;
    private String password;

    @ManyToMany
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private List<Role> roles = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<Order> orders = new ArrayList<>();

    public void addRole(Role role) {
        roles.add(role);
    }

    public UserResDto toUserResDto() {
        List<RoleResDto> roleResDtos = roles.stream().map(Role::toRoleResDto).collect(Collectors.toList());
        return new UserResDto(id, name,phoneNumber, address, email, password, roleResDtos);
    }
}
