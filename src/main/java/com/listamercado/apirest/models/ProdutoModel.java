package com.listamercado.apirest.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "TB_PRODUTO")
public class ProdutoModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    public Long id;

    @Column(nullable = false, length = 150)
    public String nome;

    @Column(nullable = false, length = 100)
    public String quantidade;

    @Column(nullable = false, length = 150)
    public String valor;

    @Column(nullable = false, length = 100)
    public String corredor;

    @Column(nullable = false, length = 150)
    public String mercado_id;
}
