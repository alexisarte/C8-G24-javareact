package com.nocountry.No_Country.repository;

import com.nocountry.No_Country.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
