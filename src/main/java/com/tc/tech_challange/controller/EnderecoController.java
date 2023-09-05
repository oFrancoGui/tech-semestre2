package com.tc.tech_challange.controller;

import com.tc.tech_challange.domain.endereco.DadosCadastroEndereco;
import com.tc.tech_challange.domain.endereco.DadosDetalhamentoEndereco;
import com.tc.tech_challange.domain.endereco.Endereco;
import com.tc.tech_challange.repositories.EnderecoRepository;
import jakarta.validation.Valid;
import lombok.SneakyThrows;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.UUID;

@RestController
@RequestMapping("api/v2/endereco")
public class EnderecoController {
    @Autowired
    private EnderecoRepository repository;
    @PostMapping
    @Transactional
    public ResponseEntity<DadosDetalhamentoEndereco> cadastrar(@RequestBody @Valid DadosCadastroEndereco dados, UriComponentsBuilder uriBuilder) {
        var endereco = new Endereco(dados);
        repository.save(endereco);
        var uri = uriBuilder.path("/endereco/{id}").buildAndExpand(endereco.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoEndereco(endereco));
    }
    //ARRUMANDO ISSO AQUI
    @GetMapping("/{id}")
    @Transactional
    public ResponseEntity<DadosDetalhamentoEndereco> detalhar(@PathVariable UUID id){
            var endereco = repository.getReferenceById(id);
            return ResponseEntity.ok(new DadosDetalhamentoEndereco(endereco));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable UUID id) {
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @SneakyThrows
    @PutMapping("/{id}")
    public ResponseEntity<String> atualizar(@PathVariable UUID id, @RequestBody @Valid DadosCadastroEndereco dados) {
        JSONObject response = new JSONObject();

        Endereco enderecoAtualizado = repository.findById(id).orElseThrow(() -> new RuntimeException("endereco não encontrado"));
        enderecoAtualizado.setBairro(dados.bairro());
        enderecoAtualizado.setCep(dados.cep());
        enderecoAtualizado.setCidade(dados.cidade());
        enderecoAtualizado.setCompl(dados.compl());
        enderecoAtualizado.setEstado(dados.estado());
        enderecoAtualizado.setNumero(dados.numero());
        enderecoAtualizado.setRua(dados.rua());
        repository.save(enderecoAtualizado);
        response.put("message", "Dados atualizados com sucesso");
        return ResponseEntity.status(HttpStatus.OK).body(response.toString());
    }
}
