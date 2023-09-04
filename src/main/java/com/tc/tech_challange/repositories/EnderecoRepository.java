package com.tc.tech_challange.repositories;

import com.tc.tech_challange.domain.endereco.Endereco;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface EnderecoRepository extends JpaRepository<Endereco, UUID> {
    Endereco getReferenceById(UUID id);

    @Query("SELECT '*' FROM Endereco where bairro =:texto ")
    Endereco findAll(String texto);

    Page<Endereco> findAll(Pageable paginacao);
}
