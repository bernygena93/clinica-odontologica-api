package com.example.ClinicaaOdontologica.Hibernate.security.persistence.entities;

import com.sun.istack.NotNull;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

public class PrimaryUser implements UserDetails{
    private String userName;
    private String email;
    private String password;
    private GrantedAuthority authority;

    public PrimaryUser(String userName, String email, String password, GrantedAuthority authority) {
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.authority = authority;
    }

    public static PrimaryUser build(User user){
        Role role = user.getRole();
        GrantedAuthority authority =
                 new SimpleGrantedAuthority(role.getRoleName().name());
        return new PrimaryUser(user.getUserName(),user.getEmail(),user.getPassword(), authority);
    }

    public String getEmail() {
        return email;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(authority);
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
