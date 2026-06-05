package com.example.gestionfacturas.model;

import com.example.gestionfacturas.exceptions.DatoInvalidoException;

import java.time.LocalDate;
import java.util.List;

public class Factura {
    private String id;
    private LocalDate fecha;
    private Cliente cliente;
    private Empleado empleado;
    private List<DetalleFactura> detalles;
    private double total;

    public Factura(String id, LocalDate fecha, Cliente cliente, Empleado empleado, List<DetalleFactura> detalles) throws DatoInvalidoException {
        if(id == null || id.trim().isEmpty()) {
            throw new DatoInvalidoException("El ID de la factura es requerido.");
        }else if(fecha == null) {
            throw new DatoInvalidoException("La fecha de la factura es requerida.");
        }else if(cliente == null) {
            throw new DatoInvalidoException("El cliente de la factura es requerido.");
        }else if (empleado == null) {
            throw new DatoInvalidoException("El empleado de la factura es requerido.");
        }else if (detalles == null || detalles.isEmpty()) {
            throw new DatoInvalidoException("Los detalles de la factura son requeridos.");
        }
        this.id = id;
        this.fecha = fecha;
        this.cliente = cliente;
        this.empleado = empleado;
        this.detalles = detalles;
        this.total = calcularTotal();
    }

    private double calcularTotal() {
        return detalles.stream()
                .mapToDouble(DetalleFactura::getSubtotal)
                .sum();
    }

    public String getId() {
        return id;
    }

    public List<DetalleFactura> getDetalles() {
        return detalles;
    }

    public double getTotal() {
        return total;
    }

}
