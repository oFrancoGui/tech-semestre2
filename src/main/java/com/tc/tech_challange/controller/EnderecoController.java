package com.tc.tech_challange.controller;

import com.tc.tech_challange.domain.endereco.DadosCadastroEndereco;
import com.tc.tech_challange.domain.endereco.DadosDetalhamentoEndereco;
import com.tc.tech_challange.domain.endereco.Endereco;
import com.tc.tech_challange.repositories.EnderecoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("api/v2/endereco")
public class EnderecoController {
    @Autowired
    private EnderecoRepository repository;
    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroEndereco dados, UriComponentsBuilder uriBuilder) {
        var endereco = new Endereco(dados);
        repository.save(endereco);
        var uri = uriBuilder.path("/endereco/{id}").buildAndExpand(endereco.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoEndereco(endereco));
    }
    //ARRUMANDO ISSO AQUI
    @GetMapping("/{texto}")
    @Transactional
    public ResponseEntity detalhar(@PathVariable String texto){
            var endereco = repository.findAll(texto);
            return ResponseEntity.ok(new DadosDetalhamentoEndereco(endereco));
    }
}
