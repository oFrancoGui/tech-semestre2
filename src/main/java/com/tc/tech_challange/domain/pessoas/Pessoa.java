package com.tc.tech_challange.domain.pessoas;


import com.tc.tech_challange.domain.users.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tabela_pessoa")


public class Pessoa {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name="uuid_pessoa")
    private UUID id;
    @ManyToOne
    @JoinColumn (name = "uuid_user")
    private User user;
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



    public Pessoa(DadosCadastroPessoa dados){
        this.cpf = dados.cpf();
        this.nome = dados.nome();
        this.email = dados.email();
        this.data = dados.data();
        this.parentesco = dados.parentesco();
        this.genero = dados.genero();
    }
}







