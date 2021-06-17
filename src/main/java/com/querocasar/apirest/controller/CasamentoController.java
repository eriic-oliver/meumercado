package com.querocasar.apirest.controller;

import com.querocasar.apirest.models.CasamentoModel;
import com.querocasar.apirest.models.SendEmail;
import com.querocasar.apirest.repository.CasamentoRepository;
import com.querocasar.apirest.services.ServicoNotificacaoAssinaturaPresente;
import com.querocasar.apirest.services.ServicoNotificacaoCadastroCasamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
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
    @Produces(MediaType.APPLICATION_JSON)
    public CasamentoModel postCasamento(@RequestBody CasamentoModel casamento){
        ServicoNotificacaoCadastroCasamento notificacao = new ServicoNotificacaoCadastroCasamento();
        return casamentoRepository.save(casamento);
    }

    @PostMapping(path = "/enviaremail")
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseEntity enviaEmail(@RequestBody CasamentoModel casamento){
        ServicoNotificacaoCadastroCasamento notificacao = new ServicoNotificacaoCadastroCasamento();
        notificacao.enviarNotificacaoCadastro(casamento.email_adm, casamento.id);
        return ResponseEntity.ok().build();
    }
}
