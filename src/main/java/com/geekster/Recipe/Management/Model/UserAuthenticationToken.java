package com.geekster.Recipe.Management.Model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Token")
public class UserAuthenticationToken {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer tokenId;
    private String tokenValue;
    private LocalDateTime tokenCreationTime;

    @OneToOne
    @JoinColumn(name="user_id")
    User user;

    public UserAuthenticationToken(User user){
        this.user=user;
        this.tokenCreationTime=LocalDateTime.now();
        this.tokenValue= UUID.randomUUID().toString();
    }

}
