package com.listamercado.apirest.controller;

import com.listamercado.apirest.models.MercadoModel;
import com.listamercado.apirest.repository.MercadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@RestController
@RequestMapping(value = "/api/mercado")
@CrossOrigin(origins = "*")
public class MercadoController {
    @Autowired
    MercadoRepository mercadoRepository;

    @GetMapping(path = "/{id}")
    public ResponseEntity getMercado(@PathVariable("id") Long id){
        return mercadoRepository.findById(id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }
    @GetMapping(path = "/")
    public List<MercadoModel> getMercados(){
        return mercadoRepository.findAll();
    }

    @PutMapping(path = "/alterar")
    public MercadoModel putMercados(@RequestBody MercadoModel mercado){
        return mercadoRepository.save(mercado);
    }

    @DeleteMapping(path = "/{id}/delete")
    public void deleteMercado(@PathVariable("id") Long id){
        mercadoRepository.deleteById(id);
    }

    @PostMapping(path = "/salvar")
    @Produces(MediaType.APPLICATION_JSON)
    public MercadoModel postMercado(@RequestBody MercadoModel mercado){
        return mercadoRepository.save(mercado);
    }

    /*@PostMapping(path = "/login")
    public ResponseEntity loginAdm(@RequestBody AdmModel adm){
        List<MercadoModel> casamentos = mercadoRepository.findAll();
        MercadoModel casamentoAlvo = new MercadoModel();
        for (MercadoModel casamento:casamentos) {
            if(casamento.getEmail_adm().equals(adm.getEmail().trim()) &&
                    casamento.getSenha_adm().equals(adm.getSenha())){
                casamentoAlvo = casamento;
            }
        }
        if(casamentoAlvo==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(casamentoAlvo);
    }*/

}
