package org.example.service;

import org.example.model.Aprendiz;
import org.example.model.Entrenador;
import org.example.repository.AprendizRepository;
import org.example.repository.EntrenadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserSecurityService implements UserDetailsService {

    private final AprendizRepository aprendizRepository;
    private final EntrenadorRepository entrenadorRepository;

    @Autowired
    public UserSecurityService(AprendizRepository aprendizRepository, EntrenadorRepository entrenadorRepository) {
        this.aprendizRepository = aprendizRepository;
        this.entrenadorRepository = entrenadorRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Aprendiz> aprendiz = aprendizRepository.findById(Integer.parseInt(username));
        Optional<Entrenador> entrenador = entrenadorRepository.findById(Integer.parseInt(username));

        if (aprendiz.isPresent()) {
            Aprendiz aprendizEncontrado = aprendiz.get();
            System.out.println(aprendiz.get());

            return User.builder()
                    .username(username)
                    .password(aprendizEncontrado.getPassword())
                    .roles("ADMIN")
                    .build();
        } else if (entrenador.isPresent()) {
            Entrenador entrenadorEncontrado = entrenador.get();
            System.out.println(entrenador.get());

            return User.builder()
                    .username(username)
                    .password(entrenadorEncontrado.getPassword())
                    .roles("ADMIN")
                    .build();
        } else {
            throw new UsernameNotFoundException("\n-->No se encontró el username.");
        }
    }
}
