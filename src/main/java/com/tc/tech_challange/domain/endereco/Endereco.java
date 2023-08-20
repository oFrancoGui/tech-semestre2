package com.tc.tech_challange.domain.endereco;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "endereco")
@Entity(name = "Endereco")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@EqualsAndHashCode(of = "id")
public class Endereco {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private int cep ;
        private String rua;
        private int numero;
        private String compl;
        private String bairro;
        private String cidade;
        private String estado;

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
