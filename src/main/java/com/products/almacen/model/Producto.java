package com.products.almacen.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "productos")
public class Producto {
    @Id
    @GeneratedValue
    @Size(max = 8)
    private long id;
    
    @NotBlank
    @Size(max = 50)
    private String nombre;
    
    @NotBlank
    @Size(max = 50)
    private String descripcion;  
    
    @NotBlank
    double precio;
    @NotBlank
    double cantidad;

    public Producto() {
    }

    public Producto(String nombre, String descripcion, double precio, double cantidad) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }
            
    
    
}
