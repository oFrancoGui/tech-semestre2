package com.tc.tech_challange.domain.endereco;

import com.tc.tech_challange.domain.eletro.Eletro;
import com.tc.tech_challange.domain.pessoas.Pessoa;
import com.tc.tech_challange.domain.usoEletroEndereco.UsoEletroEndereco;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.*;

@Table(name = "tabela_endereco")
@Entity(name = "Endereco")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Endereco {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name="uuid_endereco")
    private UUID id;
    @Column(name="CEP")
    private int cep;
    @Column(name="Rua")
    private String rua;
    @Column(name="Numero")
    private int numero;
    @Column(name="Complemento")
    private String compl;
    @Column(name="Bairro")
    private String bairro;
    @Column(name="Cidade")
    private String cidade;
    @Column(name="Estado")
    private String estado;
    @ManyToMany
    @JoinTable(
            name = "enderecoPessoa",
            joinColumns = @JoinColumn(name = "uuid_endereco"),
            inverseJoinColumns = @JoinColumn(name = "uuid_pessoa")
    )
    Set<Pessoa> pessoas = new HashSet<>();
    @OneToMany(mappedBy = "endereco")
    private Set<UsoEletroEndereco> usoEletroEndereco;

        public Endereco(DadosCadastroEndereco dados){
            this.cep = dados.cep();
            this.rua = dados.rua();
            this.numero = dados.numero();
            this.compl = dados.compl();
            this.bairro = dados.bairro();
            this.cidade = dados.cidade();
            this.estado = dados.estado();
        }

    public Set<UsoEletroEndereco> getUsoEletroEndereco() {
        return usoEletroEndereco;
    }

    public void setUsoEletroEndereco(Set<UsoEletroEndereco> usoEletroEndereco) {
        this.usoEletroEndereco = usoEletroEndereco;
    }
}
