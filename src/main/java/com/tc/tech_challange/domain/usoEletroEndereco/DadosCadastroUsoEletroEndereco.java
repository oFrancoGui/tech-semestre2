package com.tc.tech_challange.domain.usoEletroEndereco;

import com.tc.tech_challange.domain.eletro.Eletro;
import com.tc.tech_challange.domain.endereco.Endereco;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record DadosCadastroUsoEletroEndereco(

        UUID id,
        @NotNull(message = "e necessrio indicar um eletronico para cadastrar")
        Eletro eletro,
        @NotNull(message = "e necessario indicar um endereco para cadastrar")
        Endereco endereco,
        int horasUso
)
{
        public DadosCadastroUsoEletroEndereco(UUID id, @NotNull(message = "e necessrio indicar um eletronico para cadastrar")
        Eletro eletro, @NotNull(message = "e necessario indicar um endereco para cadastrar")
                                              Endereco endereco, int horasUso) {
                this.id = id;
                this.eletro = eletro;
                this.endereco = endereco;
                this.horasUso = horasUso;
        }
}
