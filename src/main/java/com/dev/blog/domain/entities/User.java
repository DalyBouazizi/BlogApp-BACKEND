package com.dev.blog.domain.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String Name;

    @Column(nullable = false)
    private LocalDateTime CreatedAt;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(email, user.email) && Objects.equals(password, user.password) && Objects.equals(Name, user.Name) && Objects.equals(CreatedAt, user.CreatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, password, Name, CreatedAt);
    }
    @PrePersist
    protected void onCreate(){
        this.CreatedAt = LocalDateTime.now();
    }
}
