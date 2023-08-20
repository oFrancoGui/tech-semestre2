package com.tc.tech_challange.controller;

import com.tc.tech_challange.domain.pessoas.DadosCadastroPessoa;
import com.tc.tech_challange.domain.pessoas.DadosDetalhamentoPessoas;
import com.tc.tech_challange.domain.pessoas.Pessoas;
import com.tc.tech_challange.domain.pessoas.PessoasRepository;
import jakarta.validation.Valid;
import lombok.SneakyThrows;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("api/v2/pessoa")
public class PessoasController {
    @Autowired
    private PessoasRepository repository;

    @SneakyThrows // TODO: NAO USAR ISSO AQUI
    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroPessoa dados, UriComponentsBuilder uriBuilder){
        JSONObject response = new JSONObject();

        if(repository.existsByCpf(dados.cpf())){
            response.put("message", "Usuario ja registrdo");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response.toString());
        }
        else {
            var pessoas = new Pessoas(dados);
            repository.save(pessoas);
            var uri = uriBuilder.path("/pessoas/{id}").buildAndExpand(pessoas.getId()).toUri();
            response.put("message", "Usuario registrdo com sucesso");
            return ResponseEntity.status(HttpStatus.OK).body(response.toString());
        }
    }
    @GetMapping("/{id}")
    @Transactional
    public ResponseEntity detalhar(@PathVariable Integer id){
        var pessoas = repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoPessoas(pessoas));
    }
}
