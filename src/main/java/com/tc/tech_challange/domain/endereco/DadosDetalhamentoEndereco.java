package com.tc.tech_challange.domain.endereco;

public record DadosDetalhamentoEndereco(int cep, String rua, int numero, String compl,String bairro, String cidade, String estado) {

    public DadosDetalhamentoEndereco(Endereco endereco){
        this(endereco.getCep(),endereco.getRua(), endereco.getNumero(), endereco.getCompl(), endereco.getBairro(), endereco.getCidade(), endereco.getEstado());
    }

}
