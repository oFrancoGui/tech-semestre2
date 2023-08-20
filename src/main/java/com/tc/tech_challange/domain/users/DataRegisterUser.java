package com.tc.tech_challange.domain.users;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record DataRegisterUser (
        @Email
        String email,
        @NotNull(message = "senha nao pode ser nulo")
        String password
){
}
