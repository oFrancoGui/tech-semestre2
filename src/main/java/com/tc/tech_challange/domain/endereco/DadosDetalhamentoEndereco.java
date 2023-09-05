package com.tc.tech_challange.domain.endereco;

import java.util.UUID;

public record DadosDetalhamentoEndereco(UUID id, int cep, String rua, int numero, String compl, String bairro, String cidade, String estado) {

    public DadosDetalhamentoEndereco(Endereco endereco){
        this(endereco.getId(), endereco.getCep(),endereco.getRua(), endereco.getNumero(), endereco.getCompl(), endereco.getBairro(), endereco.getCidade(), endereco.getEstado());
    }

}
