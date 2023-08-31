package com.tc.tech_challange.repositories;

import com.tc.tech_challange.domain.usoEletroEndereco.UsoEletroEndereco;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UsoEletroEnderecoRepository extends JpaRepository<UsoEletroEndereco, UUID> {

}
