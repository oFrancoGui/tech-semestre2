package com.tc.tech_challange.repositories;

import com.tc.tech_challange.domain.endereco.Endereco;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.PathVariable;

public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {
    Endereco getReferenceById(PathVariable id);
    Page<Endereco> findAll(Pageable paginacao);
}
