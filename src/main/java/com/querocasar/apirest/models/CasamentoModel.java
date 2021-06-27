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

    @Column(nullable = false)
    public String end_noivo;

    @Column(nullable = false)
    public String end_noiva;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPrim_nome_noivo() {
        return prim_nome_noivo;
    }

    public void setPrim_nome_noivo(String prim_nome_noivo) {
        this.prim_nome_noivo = prim_nome_noivo;
    }

    public String getPrim_nome_noiva() {
        return prim_nome_noiva;
    }

    public void setPrim_nome_noiva(String prim_nome_noiva) {
        this.prim_nome_noiva = prim_nome_noiva;
    }

    public String getDados_conta() {
        return dados_conta;
    }

    public void setDados_conta(String dados_conta) {
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

    public String getEnd_noivo() {
        return end_noivo;
    }

    public void setEnd_noivo(String end_noivo) {
        this.end_noivo = end_noivo;
    }

    public String getEnd_noiva() {
        return end_noiva;
    }

    public void setEnd_noiva(String end_noiva) {
        this.end_noiva = end_noiva;
    }
}
