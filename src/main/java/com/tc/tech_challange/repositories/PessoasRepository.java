package com.tc.tech_challange.repositories;

import com.tc.tech_challange.domain.pessoas.Pessoa;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.PathVariable;

public interface PessoasRepository extends JpaRepository<Pessoa, Integer> {
    Pessoa getReferenceById(PathVariable id);

    Page<Pessoa> findAll(Pageable paginacao);

    Boolean existsByCpf(String cpf);

}
