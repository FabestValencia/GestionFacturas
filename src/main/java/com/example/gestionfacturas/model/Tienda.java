package com.example.gestionfacturas.model;


import com.example.gestionfacturas.exceptions.ElementoDuplicadoException;
import com.example.gestionfacturas.exceptions.FacturaNoEncontradaException;
import com.example.gestionfacturas.exceptions.ProductoNoEncontradoException;

import java.util.ArrayList;
import java.util.List;

public class Tienda {
    private List<Empleado> empleados;
    private List<Cliente> clientes;
    private List<Producto> inventario;
    private List<Factura> facturas;

    public Tienda() {
        this.empleados = new ArrayList<>();
        this.clientes = new ArrayList<>();
        this.inventario = new ArrayList<>();
        this.facturas = new ArrayList<>();
    }

    public void registrarEmpleado(Empleado nuevoEmpleado) throws ElementoDuplicadoException {
        boolean yaExiste = empleados.stream()
                .anyMatch(emp -> emp.getId().equals(nuevoEmpleado.getId()));
        if (yaExiste) {
            throw new ElementoDuplicadoException("El empleado con ID " + nuevoEmpleado.getId() + " ya existe.");
        }
        empleados.add(nuevoEmpleado);
    }

    public void registrarCliente(Cliente nuevoCliente) throws ElementoDuplicadoException {
        boolean yaExiste = clientes.stream()
                .anyMatch(cli -> cli.getId().equals(nuevoCliente.getId()));
        if (yaExiste) {
            throw new ElementoDuplicadoException("El cliente con ID " + nuevoCliente.getId() + " ya existe.");
        }
        clientes.add(nuevoCliente);
    }

    public void registrarProducto(Producto nuevoProducto) throws ElementoDuplicadoException {
        boolean yaExiste = inventario.stream()
                .anyMatch(prod -> prod.getId().equals(nuevoProducto.getId()));
        if (yaExiste) {
            throw new ElementoDuplicadoException("El producto con ID " + nuevoProducto.getId() + " ya existe.");
        }
        inventario.add(nuevoProducto);
    }

    public void registrarFactura(Factura nuevaFactura) throws ElementoDuplicadoException {
        boolean yaExiste = facturas.stream()
                .anyMatch(fact -> fact.getId().equals(nuevaFactura.getId()));
        if (yaExiste) {
            throw new ElementoDuplicadoException("La factura con ID " + nuevaFactura.getId() + " ya existe.");
        }
        facturas.add(nuevaFactura);
    }

    public void reemplazarProductoPorId(String idBuscado, Producto nuevoProducto) throws ProductoNoEcontradoException {
        Producto productoViejo = inventario.stream()
                .filter(prod -> prod.getId().equals(idBuscado))
                .findFirst()
                .orElseThrow(() -> new ProductoNoEncontradoException("No se puede reemplazar. El producto con ID " + idBuscado + " no exite."));

        int indice = inventario.indexOf(productoViejo);
        inventario.set(indice, nuevoProducto);
    }

    public Factura consultarFacturaPorId(String idBuscado) throws FacturaNoEncontradaException {
        return facturas.stream()
                .filter(fact -> fact.getId().equals(idBuscado))
                .findFirst()
                .orElseThrow(() -> new FacturaNoEncontradaException("No se pudo encontrar. La factura con ID " + idBuscado + " no existe"));
    }

    public long contarFacturasPorProducto(String nombreProducto) {
        return facturas.stream()
                .filter(fact -> fact.getDetalles().stream()
                        .anyMatch(detalle -> detalle.getProducto.getNombre.equalsIgnoreCase(nombreProducto)))
                .count();
    }
}
