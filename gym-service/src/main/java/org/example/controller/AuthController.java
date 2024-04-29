package org.example.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.example.config.JwtUtil;
import org.example.dto.*;
import org.example.exception.GymRequestException;
import org.example.service.AprendizService;
import org.example.service.EntrenadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@Tag(name = "Login y registro 🔐")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    private final AprendizService aprendizService;
    private final EntrenadorService entrenadorService;

    @Autowired
    public AuthController(AuthenticationManager authenticationManager, JwtUtil jwtUtil, AprendizService aprendizService, EntrenadorService entrenadorService) {
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
        this.aprendizService = aprendizService;
        this.entrenadorService = entrenadorService;
    }

    @Operation(summary = "Registrar un aprendiz", description = "Registra un nuevo aprendiz en la base de datos SQL.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Aprendiz creado exitosamente."),
            @ApiResponse(responseCode = "400", description = "Error de usuario. La solicitud es incorrecta"),
            @ApiResponse(responseCode = "404", description = "Error de usuario. No existe el recurso solicitado"),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor.")
    })
    @PostMapping("/registro/aprendiz")
    public ResponseEntity<String> crearAprendiz(@RequestBody @Valid AprendizDTO aprendizDTO) throws GymRequestException {
        aprendizService.crearAprendiz(aprendizDTO);
        return new ResponseEntity<>("Registro de aprendiz exitoso", HttpStatus.CREATED);
    }

    @Operation(summary = "Registrar un entrenador", description = "Registra un nuevo entrenador en la base de datos SQL.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Entrenador creado exitosamente."),
            @ApiResponse(responseCode = "400", description = "Error de usuario. La solicitud es incorrecta"),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor.")
    })
    @PostMapping("/registro/entrenador")
    public ResponseEntity<String> crearEntrenador(@RequestBody @Valid EntrenadorDTO entrenadorDTO) throws GymRequestException {
        entrenadorService.crearEntrenador(entrenadorDTO);
        return new ResponseEntity<>("Registro de entrenador exitoso", HttpStatus.CREATED);
    }

    @Operation(summary = "Generar token", description = "Generar el JSON Web Token para acceder a los recursos de la API.")
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginDto loginDto) throws BadCredentialsException {
        UsernamePasswordAuthenticationToken login = new UsernamePasswordAuthenticationToken(loginDto.getUsername(), loginDto.getPassword());

        // Hace el proceso de autenticación. Si la autenticación es correcta, continúa a crear el JWT
        Authentication authentication = this.authenticationManager.authenticate(login);

        if (!authentication.isAuthenticated()) {
            throw new BadCredentialsException("Usuario o contraseña inválidos");
        }

        System.out.println(authentication.isAuthenticated());
        System.out.println(authentication.getPrincipal());

        // Crear un JSON Web Token
        String jwt = this.jwtUtil.create(loginDto.getUsername());

        return new ResponseEntity<>(jwt, HttpStatus.OK);
    }
}
