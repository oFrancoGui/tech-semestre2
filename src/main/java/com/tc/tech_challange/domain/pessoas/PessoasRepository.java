package com.tc.tech_challange.domain.pessoas;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.PathVariable;

public interface PessoasRepository extends JpaRepository<Pessoas, Integer> {
    Pessoas getReferenceById(PathVariable id);

    Page<Pessoas> findAll(Pageable paginacao);

    Boolean existsByCpf(String cpf);

}
