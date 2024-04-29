package org.example.service;

import org.example.exception.GymDetailsException;
import org.example.exception.GymRequestException;
import org.example.model.Aprendiz;
import org.example.repository.AprendizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserSecurityService implements UserDetailsService {

    private final AprendizRepository aprendizRepository;

    @Autowired
    public UserSecurityService(AprendizRepository aprendizRepository) {
        this.aprendizRepository = aprendizRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Aprendiz> aprendiz = aprendizRepository.findById(Integer.parseInt(username));

        if (aprendiz.isEmpty()) {
            try {
                throw new GymRequestException("\n-->No se encontró el username.",
                        new GymDetailsException("El aprendiz no está registrado",
                                HttpStatus.NOT_FOUND));
            } catch (GymRequestException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println(aprendiz.get());

        return User.builder()
                .username(username)
                .password(aprendiz.get().getPassword())
                .roles("ADMIN")
                .build();
    }
}
