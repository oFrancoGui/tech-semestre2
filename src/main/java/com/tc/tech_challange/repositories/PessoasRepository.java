package com.tc.tech_challange.repositories;

import com.tc.tech_challange.domain.pessoas.Pessoa;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

public interface PessoasRepository extends JpaRepository<Pessoa, UUID> {
    Pessoa getReferenceById(UUID id);

    Page<Pessoa> findAll(Pageable paginacao);

    Boolean existsByCpf(String cpf);

}
