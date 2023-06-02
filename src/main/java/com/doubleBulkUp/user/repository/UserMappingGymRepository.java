package com.doubleBulkUp.user.repository;

import com.doubleBulkUp.user.entity.User;
import com.doubleBulkUp.user.entity.UserMappingGym;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserMappingGymRepository extends JpaRepository<UserMappingGym, Integer> {

    List<UserMappingGym> findByUser(User user);
}
