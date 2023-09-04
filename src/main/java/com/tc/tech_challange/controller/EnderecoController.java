package com.tc.tech_challange.controller;

import com.tc.tech_challange.domain.eletro.DadosCadastroEletro;
import com.tc.tech_challange.domain.eletro.Eletro;
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
    @GetMapping("/{id}")
    @Transactional
    public ResponseEntity detalhar(@PathVariable Integer id){
            var endereco = repository.getReferenceById(id);
            return ResponseEntity.ok(new DadosDetalhamentoEndereco(endereco));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Integer id) {
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping
    public ResponseEntity<Endereco> atualizar(@PathVariable Integer id, @Valid DadosCadastroEndereco dados) {
        Endereco enderecoAtualizado = repository.findById(id).orElseThrow(() -> new RuntimeException("endereco não encontrado"));
        enderecoAtualizado.setBairro(dados.getBairro());
        enderecoAtualizado.setCep(dados.getCep());
        enderecoAtualizado.setCidade(dados.cidade());
        enderecoAtualizado.setCompl(dados.compl());
        enderecoAtualizado.setEstado(dados.getEstado());
        enderecoAtualizado.setNumero(dados.getNumero());
        enderecoAtualizado.setRua(dados.getRua());
        repository.save(enderecoAtualizado);
        return ResponseEntity.ok(enderecoAtualizado);
    }
}
