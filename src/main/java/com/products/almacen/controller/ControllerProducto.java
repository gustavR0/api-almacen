package com.products.almacen.controller;

import com.products.almacen.message.ErrorParameter;
import java.util.List;
import com.products.almacen.model.Producto;
import com.products.almacen.repository.RepositoryProducto;
import java.util.HashMap;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ControllerProducto {
    
    @Autowired
    private RepositoryProducto repository;
    
    @GetMapping("/productos")
    public List<Producto> showAll(){
        return repository.findAll();
    }
    
     @GetMapping("/productos/{id}")
    public ResponseEntity<Producto> searchById(@PathVariable(value = "id") Long id) throws ErrorParameter {

        Producto productos = repository.findById(id).orElseThrow(
                () -> new ErrorParameter("No se encontro el id : " + id)
        );

        return ResponseEntity.ok().body(productos);

    }

    @PostMapping("/productos")
    public Producto create(@Valid @RequestBody Producto producto) {
        return repository.save(producto);
    }

    @PutMapping("/productos/{id}")
    public ResponseEntity<Producto> update(@PathVariable(value = "id") Long id, @Valid @RequestBody Producto updateProducto)
            throws ErrorParameter {
        
        Producto producto = repository.findById(id).orElseThrow(
                () -> new ErrorParameter("No se encontro el id : " + id)
        );
        
        producto.setNombre(updateProducto.getNombre());
        producto.setDescripcion(updateProducto.getDescripcion());
        producto.setPrecio(updateProducto.getPrecio());
        producto.setCantidad(updateProducto.getCantidad());
        
        final Producto prod = repository.save(producto);
        return ResponseEntity.ok(prod);

    }
    
    @DeleteMapping("/empleados/{id}")
    public Map<String,Boolean> delete (@PathVariable(value = "id") Long id) throws ErrorParameter {
        
        Producto producto = repository.findById(id).orElseThrow(
                () -> new ErrorParameter("No se encontro el id : " + id)
        );
        
        repository.delete(producto);
        Map<String,Boolean> respuesta = new HashMap<>();
        respuesta.put("delete", Boolean.TRUE);
        return respuesta;
    }
    
}
