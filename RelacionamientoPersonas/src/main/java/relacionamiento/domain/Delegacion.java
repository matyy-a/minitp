package relacionamiento.domain;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
//@Table(name = "delegacion")
public class Delegacion {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(cascade = CascadeType.PERSIST)
    //@JoinColumn(name = "persona_id")
    //@Column(insertable=false, updatable=false)
    private Persona autorizante;

    @ManyToOne(cascade = CascadeType.PERSIST)
    //@JoinColumn(name = "persona_id")
    //@Column(insertable=false, updatable=false)
    private Persona autorizado;

    @Enumerated(EnumType.STRING)
    //@Column(insertable=false, updatable=false)
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
