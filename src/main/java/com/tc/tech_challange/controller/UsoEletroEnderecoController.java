package com.tc.tech_challange.controller;

import com.tc.tech_challange.domain.usoEletroEndereco.DadosCadastroUsoEletroEndereco;
import com.tc.tech_challange.domain.usoEletroEndereco.UsoEletroEndereco;
import com.tc.tech_challange.repositories.UsoEletroEnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("api/v2/usoEletroEndereco")
public class UsoEletroEnderecoController {

    @Autowired
    private UsoEletroEnderecoRepository usoEletroEnderecoRepository;

    @PostMapping
    public ResponseEntity<String> registrarUsoEletroEndereco(@RequestBody DadosCadastroUsoEletroEndereco dados) {
        var usoEletroEndereco = new UsoEletroEndereco(dados);
        usoEletroEnderecoRepository.save(usoEletroEndereco);
        return ResponseEntity.ok("Uso de eletrônico registrado com sucesso. ID = " + usoEletroEndereco.getId());
    }

    @PutMapping("/{id}/{totalHoras}")
    public ResponseEntity<String> atualizarHorasConsumo(@PathVariable UUID id, @PathVariable int totalHoras) {
        Optional<UsoEletroEndereco> usoEletroEndereco = usoEletroEnderecoRepository.findById(id);
        if (usoEletroEndereco.isPresent()) {
            usoEletroEndereco.get().setHorasUso(totalHoras);
        } else {
            throw new RuntimeException("nao foi possível encontrar o usoEletroEndereco");
        }
        return ResponseEntity.ok("total de horas utilizadas atualizada com sucesso.");
    }
}
