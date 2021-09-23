package com.example.ClinicaaOdontologica.Hibernate.persistence.entities;

import com.example.ClinicaaOdontologica.Hibernate.persistence.enums.RoleName;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "Users")
@Getter
@Setter
public class User {
    @Id
    @SequenceGenerator(name = "administrator_sequence", sequenceName = "administrator_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "administrator_sequence")
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
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_role", referencedColumnName = "roleName")
    private Role role;

    public User() {
    }

    public User(String userName, String email, String password, Role role) {
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.role = role;
    }
}
