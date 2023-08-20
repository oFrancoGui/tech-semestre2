package com.tc.tech_challange.domain.pessoas;

import java.util.Date;

public record DadosDetalhamentoPessoas (String cpf, String nome, String email, Date data, Parentesco parentesco, Genero genero) {
      public DadosDetalhamentoPessoas (Pessoas pessoas) {
        this(pessoas.getCpf(),pessoas.getNome(),pessoas.getEmail(),pessoas.getData(), pessoas.getParentesco(), pessoas.getGenero());
    }
}
