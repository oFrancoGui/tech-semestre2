package com.tc.tech_challange.repositories;
import com.tc.tech_challange.domain.eletro.Eletro;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

public interface EletroRepository extends JpaRepository<Eletro, UUID> {
    Eletro getReferenceById(UUID id);

    Page<Eletro> findAll(Pageable paginacao);

    Boolean existsByEan(String ean);
}
