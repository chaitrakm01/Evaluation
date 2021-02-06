package com.robosoftin.evaluation.newsapp.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.robosoftin.evaluation.newsapp.model.ApplicationUser;

public interface ApplicationUserRepository extends JpaRepository<ApplicationUser, Long> {
    ApplicationUser findByUsername(String username);
    ApplicationUser findByUniqueUserId(String uniqueUserId);

}
