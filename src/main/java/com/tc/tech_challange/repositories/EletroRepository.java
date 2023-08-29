package com.tc.tech_challange.repositories;
import com.tc.tech_challange.domain.eletro.Eletro;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.PathVariable;

public interface EletroRepository extends JpaRepository<Eletro, Long> {
    Eletro getReferenceById(PathVariable id);

    Page<Eletro> findAll(Pageable paginacao);

    Boolean existsByEan(String ean);
}
