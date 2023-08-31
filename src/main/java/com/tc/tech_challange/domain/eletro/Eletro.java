package com.tc.tech_challange.domain.eletro;

import com.tc.tech_challange.domain.usoEletroEndereco.UsoEletroEndereco;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@NoArgsConstructor
@Getter
@Setter
@Table(name = "eletro")
@Entity(name = "Eletro")

public class Eletro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="Titulo")
    private String titulo;
    @Column(name="EAN")
    private String ean;
    @Column(name="Marca")
    private String marca;
    @Column(name="Potencia")
    private int potencia;
    @Enumerated(EnumType.STRING)
    private Voltagem voltagem;
    @OneToMany (mappedBy = "eletro")
    private Set<UsoEletroEndereco> usoEletroEndereco;

    public Eletro(DadosCadastroEletro dados) {
        this.titulo = dados.titulo();
        this.ean = dados.ean();
        this.marca = dados.marca();
        this.potencia = dados.potencia();
        this.voltagem = dados.voltagem();
    }
}
