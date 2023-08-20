package com.tc.tech_challange.domain.pessoas;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.br.CPF;

import java.util.Date;

public record DadosCadastroPessoa(

        @NotEmpty(message = "cpf nao pode ser nulo")
        @Size(min = 11, max = 11, message = "must have {min} characters")
        @CPF
        String cpf,
        @NotEmpty(message = "nome nao pode ser nulo")
        @Size(min = 2, max = 150, message = "size must be between {min} and {max}")
        @Pattern(regexp = "[A-zÀ-ú\s]+", message = "must contain only letters")
        String nome,

        @NotEmpty(message = "email nao pode ser nulo")
        @Email(message = "email invalido")
        String email,


        @NotNull(message = "data nao pode ser nulo")
        @Past(message = "must be before the current date")
        Date data,

        @NotNull(message = "Parentesco nao pode ser nulo")
        Parentesco parentesco,
        @NotNull(message = "genero nao pode ser nulo")
        @Enumerated(EnumType.STRING)
        Genero genero)
        {

        }
