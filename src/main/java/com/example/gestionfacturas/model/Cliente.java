package com.example.gestionfacturas.model;

import com.example.gestionfacturas.exceptions.DatoInvalidoException;

public class Cliente {
    private String id;
    private String nombre;
    private String apellido;
    private String telefono;
    private String email;

    public Cliente(String id, String nombre, String apellido, String telefono, String email) throws DatoInvalidoException {
        if (id == null || id.trim().isEmpty()) {
            throw new DatoInvalidoException("El ID del cliente es requerido.");
        }else if (nombre == null || nombre.trim().isEmpty()) {
            throw new DatoInvalidoException("El nombre del cliente es requerido.");
        } else if (apellido == null || apellido.trim().isEmpty()) {
            throw new DatoInvalidoException("El apellido del cliente es requerido.");
        } else if (telefono == null || telefono.trim().isEmpty()) {
            throw new DatoInvalidoException("El teléfono del cliente es requerido.");
        } else if (email == null || email.trim().isEmpty() || !email.contains("@")) {
            throw new DatoInvalidoException("El email del cliente es requerido o tiene formato invalido.");
        }

        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.email = email;
    }

    public String getId() {
        return id;
    }

}
