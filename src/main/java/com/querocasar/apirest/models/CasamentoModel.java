package com.querocasar.apirest.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "TB_CASAMENTO")
public class CasamentoModel implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    public Long id;

    @Column(nullable = false, length = 150)
    public String prim_nome_noivo;

    @Column(nullable = false, length = 150)
    public String prim_nome_noiva;

    @Column(nullable = false, length = 150)
    public String dados_conta;

    @Column(nullable = false, length = 100)
    public String latitude;

    @Column(nullable = false, length = 100)
    public String longitude;

    @Column(nullable = false, length = 150)
    public String email_adm;

    @Column(nullable = false, length = 150)
    public String senha_adm;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPrimNomeNoivo() {
        return prim_nome_noivo;
    }

    public void setPrimNomeNoivo(String prim_nome_noivo) {
        this.prim_nome_noivo = prim_nome_noivo;
    }

    public String getPrimNomeNoiva() {
        return prim_nome_noiva;
    }

    public void setPrimNomeNoiva(String prim_nome_noiva) {
        this.prim_nome_noiva = prim_nome_noiva;
    }

    public String getDadosConta() {
        return dados_conta;
    }

    public void setDadosConta(String dados_conta) {
        this.dados_conta = dados_conta;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getEmail_adm() {
        return email_adm;
    }

    public void setEmail_adm(String email_adm) {
        this.email_adm = email_adm;
    }

    public String getSenha_adm() {
        return senha_adm;
    }

    public void setSenha_adm(String senha_adm) {
        this.senha_adm = senha_adm;
    }
}
