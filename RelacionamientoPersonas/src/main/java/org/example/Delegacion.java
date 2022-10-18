package org.example;

import java.time.LocalDate;

public class Delegacion {
    private Persona autorizante;
    private Persona autorizado;
    private Estado estado;
    private LocalDate fechaAutorizacion;
    private LocalDate fechaAceptacion;

    public Delegacion(Persona autorizante, Persona autorizado, Estado estado, LocalDate fechaAutorizacion, LocalDate fechaAceptacion) {
        this.autorizante = autorizante;
        this.autorizado = autorizado;
        this.estado = estado;
        this.fechaAutorizacion = fechaAutorizacion;
        this.fechaAceptacion = fechaAceptacion;
    }

    public Persona getAutorizante() {
        return autorizante;
    }

    public void setAutorizante(Persona autorizante) {
        this.autorizante = autorizante;
    }

    public Persona getAutorizado() {
        return autorizado;
    }

    public void setAutorizado(Persona autorizado) {
        this.autorizado = autorizado;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public LocalDate getFechaAutorizacion() {
        return fechaAutorizacion;
    }

    public void setFechaAutorizacion(LocalDate fechaAutorizacion) {
        this.fechaAutorizacion = fechaAutorizacion;
    }

    public LocalDate getFechaAceptacion() {
        return fechaAceptacion;
    }

    public void setFechaAceptacion(LocalDate fechaAceptacion) {
        this.fechaAceptacion = fechaAceptacion;
    }

    public void autorizarPersona(Persona persona){
        //TODO
    }
}
