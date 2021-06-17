package com.querocasar.apirest.controller;

import com.querocasar.apirest.models.PresenteModel;
import com.querocasar.apirest.models.SendEmail;
import com.querocasar.apirest.repository.PresenteRepository;
import com.querocasar.apirest.services.ServicoNotificacaoAssinaturaPresente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
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
    @GetMapping(path = "/casamentoid/{id}")
    public ResponseEntity getPresentePorCasamento(@PathVariable("id") Long id){
        List<PresenteModel> listaPresentes = presenteRepository.findAll();
        List<PresenteModel> send = new ArrayList<PresenteModel>();
        for (PresenteModel presente: listaPresentes) {
            int i = 0;
            if(presente.casamento_id.equals(id)){
                send.add(i, presente);
            }
            i++;
        }
        return ResponseEntity.ok().body(send);
    }

    @GetMapping(path = "/categoria/{categoria}/{idCasamento}")
    public ResponseEntity getPresentePorCategoria(@PathVariable("categoria") Long categoria,
                                                  @PathVariable("idCasamento") Long idCasamento){
        List<PresenteModel> send = new ArrayList<>();
        List<PresenteModel> listaPresentes = presenteRepository.findAll();
        for (PresenteModel presente:listaPresentes) {
            int i = 0;
            if(presente.getCategoria().equals(categoria) && presente.getCasamentoID().equals(idCasamento)){
                send.add(i, presente);
            }
            i++;
        }
        return ResponseEntity.ok().body(send);
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

    @PostMapping(path = "/salvarVarios")
    public ResponseEntity postVariosPresentes(@RequestBody List<PresenteModel> presentes){
        for(PresenteModel presente:presentes){
            presenteRepository.save(presente);
        }
        return ResponseEntity.ok().build();
    }

    @PostMapping(path = "/enviaremail")
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseEntity enviaEmail(@RequestBody SendEmail sendEmail){
        ServicoNotificacaoAssinaturaPresente notificacaoAssinaturaPresente = new ServicoNotificacaoAssinaturaPresente();
        notificacaoAssinaturaPresente.enviarNotificacao(sendEmail.getEmail(), sendEmail.getConvidado(), sendEmail.getItem());
        return ResponseEntity.ok().build();
    }
}
