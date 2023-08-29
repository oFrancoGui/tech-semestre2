package com.tc.tech_challange.domain.endereco;

import com.tc.tech_challange.domain.eletro.Eletro;
import com.tc.tech_challange.domain.pessoas.Pessoa;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Table(name = "endereco")
@Entity(name = "Endereco")
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Endereco {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name="uuid_endereco")
        private Long id;
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

        public Endereco(DadosCadastroEndereco dados){
            this.cep = dados.cep();
            this.rua = dados.rua();
            this.numero = dados.numero();
            this.compl = dados.compl();
            this.bairro = dados.bairro();
            this.cidade = dados.cidade();
            this.estado = dados.estado();
        }
}
