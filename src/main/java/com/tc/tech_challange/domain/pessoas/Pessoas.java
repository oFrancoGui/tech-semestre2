package com.tc.tech_challange.domain.pessoas;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.util.Date;
import java.util.UUID;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "pessoas")


public class Pessoas {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name="uuid_pessoa")
    private UUID id;
    @Column(name="cpf")
    private String cpf;
    @Column(name="nome")
    private String nome;
    @Column(name="email")
    private String email;
    @Column(name="data")
    private Date data;
    @Enumerated(EnumType.STRING)
    @Column(name="parentesco")
    private Parentesco parentesco;
    @Enumerated(EnumType.STRING)
    @Column(name="genero")
    private Genero genero;



    public Pessoas (DadosCadastroPessoa dados){
        this.cpf = dados.cpf();
        this.nome = dados.nome();
        this.email = dados.email();
        this.data = dados.data();
        this.parentesco = dados.parentesco();
        this.genero = dados.genero();
    }
}







