package com.geekster.Recipe.Management.Repo;

import com.geekster.Recipe.Management.Model.UserAuthenticationToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TokenRepo extends JpaRepository<UserAuthenticationToken,Integer> {
    UserAuthenticationToken findFirstByTokenValue(String tokenValue);
}
