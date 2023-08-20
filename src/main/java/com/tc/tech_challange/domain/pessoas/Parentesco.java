package com.tc.tech_challange.domain.pessoas;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Parentesco {
    PAI("Pai"), MAE("Mãe"), IRMAO("Irmão"), IRMA("Irmã"), TIO("Tio"), TIA("Tia"),
    PRIMO("Primo"), PRIMA("Prima"), AVO1("Avô"), AVO2("Avó"), ESPOSO("Esposo"),
    ESPOSA("Esposa"), NAMORADA("Namorada"), NAMORADO("Namorado"), FILHO("Filho"),
    FILHA("Filha"), CONHECIDO("Conhecido"), COLEGA("Colega"), AMIGO("Amigo"), OUTRO("Outro");

    private String nomePartentesco;
}
