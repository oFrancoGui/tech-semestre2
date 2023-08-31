package com.tc.tech_challange.controller;

import com.tc.tech_challange.domain.usoEletroEndereco.DadosCadastroUsoEletroEndereco;
import com.tc.tech_challange.domain.usoEletroEndereco.UsoEletroEndereco;
import com.tc.tech_challange.repositories.UsoEletroEnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v2/usoEletroEndereco")
public class UsoEletroEnderecoController {

    @Autowired
    private UsoEletroEnderecoRepository usoEletroEnderecoRepository;

    @PostMapping
    public ResponseEntity<String> registrarUsoEletroEndereco(@RequestBody DadosCadastroUsoEletroEndereco dados) {
        var usoEletroEndereco = new UsoEletroEndereco(dados);
        usoEletroEnderecoRepository.save(usoEletroEndereco);
        return ResponseEntity.ok("Uso de eletrônico registrado com sucesso.");
    }



}
