package com.example.gestionfacturas.model;

import com.example.gestionfacturas.exceptions.DatoInvalidoException;

public class DetalleFactura {
    private Producto producto;
    private int cantidad;
    private double subtotal;

    public DetalleFactura(Producto producto, int cantidad) throws DatoInvalidoException {
        if(producto == null){
            throw new DatoInvalidoException("El producto no puede ser nulo.");
        } else if (cantidad <= 0) {
            throw new DatoInvalidoException("La cantidad debe ser mayor a cero.");
        }

        this.producto = producto;
        this.cantidad = cantidad;
        this.subtotal = producto.getPrecio() * cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getSubtotal() {
        return subtotal;
    }
}
