package com.api.OctoberEats.repositories;

import com.api.OctoberEats.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<UserModel, Long> {
    UserModel findByEmail(String email);
    UserModel findByUserId(Long userId);
}
