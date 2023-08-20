package com.tc.tech_challange.domain.eletro;

public record DadosDetalhamentoEletro(String titulo, String ean, String marca, int potencia, Voltagem voltagem) {
    public DadosDetalhamentoEletro (Eletro eletro){
        this(eletro.getTitulo(),eletro.getEan(),eletro.getMarca(),eletro.getPotencia(),eletro.getVoltagem());
    }
}
