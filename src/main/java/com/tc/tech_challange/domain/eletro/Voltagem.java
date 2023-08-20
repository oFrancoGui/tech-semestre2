package com.tc.tech_challange.domain.eletro;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Voltagem {

    V110("110"),
    V220("220");
    private final String VoltagemDescricao;

}
