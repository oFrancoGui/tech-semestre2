package com.tc.tech_challange.controller;

import com.tc.tech_challange.domain.eletro.DadosCadastroEletro;
import com.tc.tech_challange.domain.eletro.DadosDetalhamentoEletro;
import com.tc.tech_challange.domain.eletro.Eletro;
import com.tc.tech_challange.repositories.EletroRepository;
import jakarta.validation.Valid;
import lombok.SneakyThrows;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Optional;

@RestController
@RequestMapping("api/v2/eletro")
public class EletroController<uriBuilder> {
    @Autowired
    private EletroRepository repository;

    @SneakyThrows
    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroEletro dados, UriComponentsBuilder uriBuilder){
        JSONObject response = new JSONObject();

        if(repository.existsByEan(dados.ean())){
            response.put("message", "Eletronico ja registrdo");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response.toString());
        }

        var eletro = new Eletro(dados);
        repository.save(eletro);
        var uri = uriBuilder.path("/eletro/{id}").buildAndExpand(eletro.getId()).toUri();
        response.put("message", "Eletro registrdo com sucesso");
        return ResponseEntity.status(HttpStatus.OK).body(response.toString());


    }
    @GetMapping("/{id}")
    @Transactional
    public ResponseEntity detalhar(@PathVariable Long id){
        var eletro = repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoEletro(eletro));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        Optional<Eletro> device = repository.findById(id);
        device.ifPresentOrElse(repository::delete, () -> {
            throw new RuntimeException("Device not found!");
        });

        return ResponseEntity.noContent().build();
    }
}
