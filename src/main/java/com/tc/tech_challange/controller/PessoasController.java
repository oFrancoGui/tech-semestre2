package com.tc.tech_challange.controller;

import com.tc.tech_challange.domain.pessoas.DadosCadastroPessoa;
import com.tc.tech_challange.domain.pessoas.DadosDetalhamentoPessoas;
import com.tc.tech_challange.domain.pessoas.Pessoa;
import com.tc.tech_challange.repositories.PessoasRepository;
import jakarta.validation.Valid;
import lombok.SneakyThrows;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.UUID;

@RestController
@RequestMapping("api/v2/pessoa")
public class PessoasController {
    @Autowired
    private PessoasRepository repository;

    @SneakyThrows // TODO: NAO USAR ISSO AQUI
    @PostMapping
    @Transactional
    public ResponseEntity<String> cadastrar(@RequestBody @Valid DadosCadastroPessoa dados, UriComponentsBuilder uriBuilder){
        JSONObject response = new JSONObject();

        if(repository.existsByCpf(dados.cpf())){
            response.put("message", "Usuario ja registrdo");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response.toString());
        }
        else {
            var pessoa = new Pessoa(dados);
            repository.save(pessoa);
            var uri = uriBuilder.path("/pessoas/{id}").buildAndExpand(pessoa.getId()).toUri();
            response.put("message", "Usuario registrado com sucesso, ID: " + pessoa.getId());
            return ResponseEntity.status(HttpStatus.OK).body(response.toString());
        }
    }
    @GetMapping("/{id}")
    @Transactional
    public ResponseEntity<DadosDetalhamentoPessoas> detalhar(@PathVariable UUID id){
        var pessoas = repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoPessoas(pessoas));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable UUID id){
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @SneakyThrows
    @PutMapping("{id}")
    public ResponseEntity<String> atualizar(@PathVariable UUID id, @Valid @RequestBody DadosCadastroPessoa dados) {
        JSONObject response = new JSONObject();

        Pessoa pessoaAtualizado = repository.findById(id).orElseThrow(() -> new RuntimeException("pessoa não encontrado"));
        pessoaAtualizado.setCpf(dados.cpf());
        pessoaAtualizado.setData(dados.data());
        pessoaAtualizado.setEmail(dados.email());
        pessoaAtualizado.setGenero(dados.genero());
        pessoaAtualizado.setNome(dados.nome());
        pessoaAtualizado.setParentesco(dados.parentesco());
        repository.save(pessoaAtualizado);
        response.put("message", "Dados atualizados com sucesso");
        return ResponseEntity.status(HttpStatus.OK).body(response.toString());
    }
}
