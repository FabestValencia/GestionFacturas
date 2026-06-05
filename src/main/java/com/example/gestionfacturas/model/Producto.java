package com.example.gestionfacturas.model;

import com.example.gestionfacturas.exceptions.DatoInvalidoException;

public class Producto {
    private String id;
    private String nombre;
    private double precio;
    private int stock;

    public Producto(String id, String nombre, double precio, int stock) throws DatoInvalidoException {
        if(id == null || id.trim().isEmpty()) {
            throw new DatoInvalidoException("El ID del producto es requerido.");
        } else if (nombre == null || nombre.trim().isEmpty()) {
            throw new DatoInvalidoException("El nombre del producto es requerido.");
        } else if (precio <= 0) {
            throw new DatoInvalidoException("El precio del producto debe ser mayor a cero.");
        } else if (stock < 0) {
            throw new DatoInvalidoException("El stock del producto no puede ser negativo.");
        }

        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    public double getPrecio() {
        return precio;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getStock() {
        return stock;
    }
}
