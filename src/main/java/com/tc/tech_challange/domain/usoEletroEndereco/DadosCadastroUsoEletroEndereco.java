package com.tc.tech_challange.domain.usoEletroEndereco;

import com.tc.tech_challange.domain.eletro.Eletro;
import com.tc.tech_challange.domain.endereco.Endereco;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroUsoEletroEndereco(
        @NotNull(message = "e necessrio indicar um eletronico para cadastrar")
        Eletro eletro,
        @NotNull(message = "e necessario indicar um endereco para cadastrar")
        Endereco endereco,
        int horasUso
)
{
}
