package com.tc.tech_challange.domain.usoEletroEndereco;

import com.tc.tech_challange.domain.eletro.Eletro;
import com.tc.tech_challange.domain.endereco.Endereco;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Table(name = "uso_eletro_endereco")
@Entity
public class UsoEletroEndereco {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name="uuid_uso_eletro_endereco")
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "id_eletro", nullable = false)
    Eletro eletro;
    @ManyToOne
    @JoinColumn(name = "uuid_endereco", nullable = false)
    Endereco endereco;

    @Column(name="HorasUso")
    private int horasUso;

    public UsoEletroEndereco(DadosCadastroUsoEletroEndereco dados) {
        this.eletro = dados.eletro();
        this.endereco = dados.endereco();
        this.horasUso = dados.horasUso();
    }
}
