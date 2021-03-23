package com.products.almacen.repository;

import com.products.almacen.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryProducto extends JpaRepository<Producto, Long> {
    
}
