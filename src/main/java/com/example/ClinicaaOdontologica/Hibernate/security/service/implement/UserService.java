package com.example.ClinicaaOdontologica.Hibernate.security.service.implement;

import com.example.ClinicaaOdontologica.Hibernate.security.persistence.entities.User;
import com.example.ClinicaaOdontologica.Hibernate.security.persistence.repository.UserRepository;
import com.example.ClinicaaOdontologica.Hibernate.security.service.IUserService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService implements IUserService {
    private UserRepository userRepository;
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public Optional<User> findByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }

    @Override
    public boolean existsByUserName(String userName) {
        return userRepository.existsByUserName(userName);
    }

    @Override
    public boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

}
