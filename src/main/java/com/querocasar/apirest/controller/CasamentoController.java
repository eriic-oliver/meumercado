package com.querocasar.apirest.controller;

import com.querocasar.apirest.models.CasamentoModel;
import com.querocasar.apirest.repository.CasamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/casamentos")
@CrossOrigin(origins = "*")
public class CasamentoController {
    @Autowired
    CasamentoRepository casamentoRepository;

    @GetMapping(path = "/{id}")
    public ResponseEntity getCasamento(@PathVariable("id") Long id){
        return casamentoRepository.findById(id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }
    @GetMapping(path = "/")
    public List<CasamentoModel> getCasamentos(){
        return casamentoRepository.findAll();
    }

    @PutMapping(path = "/alterar")
    public CasamentoModel putCasamentos(@RequestBody CasamentoModel casamento){
        return casamentoRepository.save(casamento);
    }

    @DeleteMapping(path = "/{id}/delete")
    public void deleteCasamento(@PathVariable("id") Long id){
        casamentoRepository.deleteById(id);
    }

    @PostMapping(path = "/salvar")
    public CasamentoModel postCasamento(@RequestBody CasamentoModel casamento){
        return casamentoRepository.save(casamento);
    }
}
