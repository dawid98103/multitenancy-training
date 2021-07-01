package pl.kobylarz.playground.core.tenant.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "\"user\"")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private int userId;

    private String username;

    private String password;

    private String email;

    @Column(name = "user_avatar")
    private String userAvatar;

    @Column(name = "role_id")
    private int roleId;

    @Column(name = "created_date", nullable = false, updatable = false)
    private LocalDateTime createdDate;
    @Column(name = "last_updated", nullable = false, updatable = false)
    private LocalDateTime lastUpdated;
}
