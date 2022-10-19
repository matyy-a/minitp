package relacionamiento.domain;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "delegacion")
public class Delegacion {

    @Id
    private int id;

    @ManyToOne
    @JoinColumn(name = "autorizante_id")
    private Persona autorizante;

    @ManyToOne
    @JoinColumn(name = "autorizado_id")
    private Persona autorizado;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado")
    private Estado estado;

    @Column
    private LocalDate fechaAutorizacion;

    @Column
    private LocalDate fechaAceptacion;

    public Delegacion(Persona autorizante, Persona autorizado, Estado estado, LocalDate fechaAutorizacion, LocalDate fechaAceptacion) {
        this.autorizante = autorizante;
        this.autorizado = autorizado;
        this.estado = estado;
        this.fechaAutorizacion = fechaAutorizacion;
        this.fechaAceptacion = fechaAceptacion;
    }

    public Delegacion() {

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
