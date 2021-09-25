package com.example.ClinicaaOdontologica.Hibernate.security.service.implement;

import com.example.ClinicaaOdontologica.Hibernate.security.persistence.entities.PrimaryUser;
import com.example.ClinicaaOdontologica.Hibernate.security.persistence.entities.User;
import com.example.ClinicaaOdontologica.Hibernate.security.persistence.repository.UserRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailService implements UserDetailsService {

    private final UserRepository userRepository;
    @Autowired
    public UserDetailService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = userRepository.findByUserName(userName).get();
        return PrimaryUser.build(user);
    }
}
