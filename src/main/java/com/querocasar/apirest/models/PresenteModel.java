package com.querocasar.apirest.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="TB_PRESENTE")
public class PresenteModel implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id@GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    @Column(nullable = false, length = 100)
    public String convidado;

    @Column(nullable = false, length = 100)
    public String item;

    @Column(nullable = false, length = 10)
    public String preco;

    @Column(nullable = false, length = 350)
    public String link;

    @Column(nullable = false)
    public Long casamento_id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getConvidado() {
        return convidado;
    }

    public void setConvidado(String convidado) {
        this.convidado = convidado;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Long getCasamentoID() {
        return casamento_id;
    }

    public void setCasamentoID(Long casamento_id) {
        this.casamento_id = casamento_id;
    }
}
