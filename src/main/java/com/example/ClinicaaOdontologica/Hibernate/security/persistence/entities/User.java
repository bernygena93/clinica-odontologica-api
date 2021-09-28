package com.example.ClinicaaOdontologica.Hibernate.security.persistence.entities;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "Users")
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Column(unique = true)
    private String userName;
    @NotNull
    @Column
    private String email;
    @NotNull
    @Column
    private String password;
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_role", referencedColumnName = "roleName")
    private Role role;

    public User() {
    }


    public User(String userName, String email, String password) {
        this.userName = userName;
        this.email = email;
        this.password = password;
    }
}
