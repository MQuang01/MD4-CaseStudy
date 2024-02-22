package com.example.md4casestudyfastfood.repository;

import com.example.md4casestudyfastfood.model.User;
import com.example.md4casestudyfastfood.model.dto.res.UserResDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
    UserResDto findByEmailAndPassword(String email, String password);
}
