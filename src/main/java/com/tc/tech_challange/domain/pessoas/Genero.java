package com.tc.tech_challange.domain.pessoas;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Genero {
    MASCULINO_CIS("MC"),
    MASCULINO_TRANS("MT"),
    FEMININO_CIS("FC"),
    FEMININO_TRANS("FT"),
    NAO_BINARIO("NB");

    private final String GeneroDescricao;
}








