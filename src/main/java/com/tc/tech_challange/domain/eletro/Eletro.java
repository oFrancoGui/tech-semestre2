package com.tc.tech_challange.domain.eletro;

import com.tc.tech_challange.domain.usoEletroEndereco.UsoEletroEndereco;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.util.Set;
import java.util.UUID;

@NoArgsConstructor
@Getter
@Setter
@Table(name = "tabela_eletro")
@Entity(name = "Eletro")

public class Eletro {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name="uuid_eletro")
    private UUID id;
    @Column(name="titulo")
    private String titulo;
    @Column(name="EAN")
    private String ean;
    @Column(name="marca")
    private String marca;
    @Column(name="potencia")
    private int potencia;
    @Column(name="horas_uso")
    private int horasUso;
    @Enumerated(EnumType.STRING)
    private Voltagem voltagem;

    @OneToMany (mappedBy = "eletro")
    private Set<UsoEletroEndereco> usoEletroEndereco;

    public Eletro(DadosCadastroEletro dados) {
        this.titulo = dados.titulo();
        this.ean = dados.ean();
        this.marca = dados.marca();
        this.potencia = dados.potencia();
        this.horasUso = dados.horasUso();
        this.voltagem = dados.voltagem();
    }
}
