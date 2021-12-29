package com.listamercado.apirest.repository;

import com.listamercado.apirest.models.MercadoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MercadoRepository extends JpaRepository<MercadoModel, Long> {
}
