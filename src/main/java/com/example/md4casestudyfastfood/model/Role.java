package com.example.md4casestudyfastfood.model;

import com.example.md4casestudyfastfood.model.dto.res.RoleResDto;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "roles")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToMany(mappedBy = "roles")
    private List<User> users = new ArrayList<>();
    public Role(String name) {
        this.name = name;
    }

    public RoleResDto toRoleResDto() {
        return new RoleResDto(id, name);
    }
}
