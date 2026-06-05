package com.example.gestionfacturas.model;

import com.example.gestionfacturas.enums.Puesto;
import com.example.gestionfacturas.exceptions.DatoInvalidoException;

public class Empleado {
    private String id;
    private String nombre;
    private String apellido;
    private double salario;
    private Puesto puesto;

    public Empleado(String id, String nombre, String apellido, double salario, Puesto puesto) throws DatoInvalidoException {
        if (id == null || id.trim().isEmpty()) {
            throw new DatoInvalidoException("El ID del empleado es requerido.");
        }else if (nombre == null || nombre.trim().isEmpty()) {
            throw new DatoInvalidoException("El nombre del empleado es requerido.");
        } else if (apellido == null || apellido.trim().isEmpty()) {
            throw new DatoInvalidoException("El apellido del empleado es requerido.");
        } else if (salario <= 0) {
            throw new DatoInvalidoException("El salario del empleado debe ser mayor a cero.");
        } else if (puesto == null) {
            throw new DatoInvalidoException("El puesto del empleado es requerido.");
        }
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.salario = salario;
        this.puesto = puesto;
    }

    public String getId() {
        return id;
    }

}
