package com.querocasar.apirest.controller;

import com.querocasar.apirest.models.PresenteModel;
import com.querocasar.apirest.repository.PresenteRepository;
import com.querocasar.apirest.services.ServicoNotificacaoAssinaturaPresente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.List;

@RestController
@RequestMapping(value = "/api/presentes")
@CrossOrigin(origins = "*")
public class PresenteController {

    @Autowired
    PresenteRepository presenteRepository;

    @GetMapping(path = "/{id}")
    public ResponseEntity getPresente(@PathVariable("id") Long id){
        return presenteRepository.findById(id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping(path = "/")
    public List<PresenteModel> getPresentes(){
        return presenteRepository.findAll();
    }

    @PutMapping(path = "/alterar")
    public PresenteModel putPresente(@RequestBody PresenteModel presente){
        return presenteRepository.save(presente);
    }

    @DeleteMapping(path = "/{id}/delete")
    public void deletePresente(@PathVariable("id") Long id){
        presenteRepository.deleteById(id);
    }

    @PostMapping(path = "/salvar")
    public PresenteModel postPresente(@RequestBody PresenteModel presente){
        return presenteRepository.save(presente);
    }

    @GetMapping(path = "/enviaremail")
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseEntity enviaEmail(@QueryParam("email") String email, @QueryParam("convidado") String convidado, @QueryParam("item") String item){
        ServicoNotificacaoAssinaturaPresente notificacaoAssinaturaPresente = new ServicoNotificacaoAssinaturaPresente();
        notificacaoAssinaturaPresente.enviarNotificacao(email, convidado, item);
        return ResponseEntity.ok().build();
    }
}
