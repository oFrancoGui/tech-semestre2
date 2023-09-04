package com.tc.tech_challange.domain.endereco;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;


public record DadosCadastroEndereco(
        @NotNull(message = "Cep cannot be null")
        int cep,
        @NotNull(message = "rua cannot be null")
        String rua,
        @NotNull(message = "numero cannot be null")
        int numero,
        @NotNull(message = "complemento cannot be null")
        String compl,
        @NotNull(message = "bairro cannot be null")
        String bairro,
        @NotNull(message = "cidade cannot be null")
        String cidade,
        @NotNull(message = "estado cannot be null")
        String estado

        ) { }
