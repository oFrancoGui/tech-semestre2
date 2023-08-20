package com.tc.tech_challange.domain.eletro;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroEletro(

        @NotNull(message = "titulo nao pode ser nulo")
        String titulo,
        @NotNull(message = "ean nao pode ser nulo")
        String ean,
        @NotNull(message = "marca nao pode ser nulo")
        String marca,
        @NotNull(message = "potencia nao pode ser nulo")
        int potencia,
        @NotNull(message = "voltagem nao pode ser nulo")
        @Enumerated(EnumType.STRING)
        Voltagem voltagem



) { }

