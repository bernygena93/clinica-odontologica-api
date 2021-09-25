package com.example.ClinicaaOdontologica.Hibernate.security.controller;

import com.example.ClinicaaOdontologica.Hibernate.security.dto.JwtDTO;
import com.example.ClinicaaOdontologica.Hibernate.security.dto.UserSignInDTO;
import com.example.ClinicaaOdontologica.Hibernate.security.dto.UserSignUpDTO;
import com.example.ClinicaaOdontologica.Hibernate.security.jwt.JwtProvider;
import com.example.ClinicaaOdontologica.Hibernate.security.persistence.entities.Role;
import com.example.ClinicaaOdontologica.Hibernate.security.persistence.entities.User;
import com.example.ClinicaaOdontologica.Hibernate.security.persistence.enums.RoleName;
import com.example.ClinicaaOdontologica.Hibernate.security.service.IRoleService;
import com.example.ClinicaaOdontologica.Hibernate.security.service.IUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    IUserService iUserService;
    @Autowired
    IRoleService iRoleService;
    @Autowired
    JwtProvider jwtProvider;

    @PostMapping(path = "/signup")
    public ResponseEntity<?> signUp(@RequestBody UserSignUpDTO userSignUp){
        if(iUserService.existsByUserName(userSignUp.getUserName())){
            return ResponseEntity.ok("El usuario ya existe");
        }if(iUserService.existsByEmail(userSignUp.getEmail())){
            return ResponseEntity.ok("El email ya se encunetra en uso");
        }
        User user = new User(userSignUp.getUserName(), userSignUp.getEmail(), passwordEncoder.encode(userSignUp.getPassword()));
        Role role = new Role();
        role = iRoleService.findBYRoleName(RoleName.USER).get();
        if(userSignUp.getRole().equals("ADMIN"))
            role = iRoleService.findBYRoleName(RoleName.ADMIN).get();
        user.setRole(role);
        iUserService.save(user);
        return ResponseEntity.ok("Usuario creado con exito");
    }

    @PostMapping("/signin")
    public ResponseEntity<JwtDTO> signIn(@RequestBody UserSignInDTO userSignIn){
        Authentication authentication = authenticationManager.authenticate( new UsernamePasswordAuthenticationToken(userSignIn.getUserName(),
                        userSignIn.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtProvider.generateToken(authentication);
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        JwtDTO jwtDTO = new JwtDTO(jwt, userDetails.getUsername(), userDetails.getAuthorities());
        return new ResponseEntity(jwtDTO, HttpStatus.OK);
    }


}
