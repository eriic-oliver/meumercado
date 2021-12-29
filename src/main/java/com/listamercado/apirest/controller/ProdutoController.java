package com.listamercado.apirest.controller;

import com.listamercado.apirest.repository.ProdutoRepository;
import com.listamercado.apirest.models.ProdutoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@RestController
@RequestMapping(value = "/api/produto")
@CrossOrigin(origins = "*")
public class ProdutoController {

    @Autowired
    ProdutoRepository produtoRepository;

    @GetMapping(path = "/{id}")
    public ResponseEntity getProduto(@PathVariable("id") Long id){
        return produtoRepository.findById(id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }
    @GetMapping(path = "/")
    public List<ProdutoModel> getProdutos(){
        return produtoRepository.findAll();
    }

    @PutMapping(path = "/alterar")
    public ProdutoModel putProduto(@RequestBody ProdutoModel produto){
        return produtoRepository.save(produto);
    }

    @DeleteMapping(path = "/{id}/delete")
    public void deleteProduto(@PathVariable("id") Long id){
        produtoRepository.deleteById(id);
    }

    @PostMapping(path = "/salvar")
    @Produces(MediaType.APPLICATION_JSON)
    public ProdutoModel postProduto(@RequestBody ProdutoModel produto){
        return produtoRepository.save(produto);
    }

}
