package com.geekster.Recipe.Management.Repo;

import com.geekster.Recipe.Management.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User,Integer> {
    User findByUserEmail(String newEmail);
}
