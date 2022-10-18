package org.example;

import java.time.LocalDate;
import java.util.List;
import java.util.spi.LocaleNameProvider;

public class Persona extends Usuario {
    private String nombre;
    private String apellido;
    private String dni;
    private LocalDate nacimiento;
    private String localidadResidencia;
    private String foto;
    private String ciudad;

    private List<Delegacion> delegacionesAAceptarMias;
    private List<Delegacion> delegacionesAprobadasMias;
    private List<Delegacion> delegacionesAAceptarDeOtros;
    private List<Delegacion> delegacionesAprobadasDeOtros;

    public Persona(String nombre, String apellido, String dni, LocalDate nacimiento, String localidadResidencia, String foto, String ciudad, List<Delegacion> delegacionesAAceptarMias, List<Delegacion> delegacionesAprobadasMias, List<Delegacion> delegacionesAAceptarDeOtros, List<Delegacion> delegacionesAprobadasDeOtros) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.nacimiento = nacimiento;
        this.localidadResidencia = localidadResidencia;
        this.foto = foto;
        this.ciudad = ciudad;
        this.delegacionesAAceptarMias = delegacionesAAceptarMias;
        this.delegacionesAprobadasMias = delegacionesAprobadasMias;
        this.delegacionesAAceptarDeOtros = delegacionesAAceptarDeOtros;
        this.delegacionesAprobadasDeOtros = delegacionesAprobadasDeOtros;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public LocalDate getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(LocalDate nacimiento) {
        this.nacimiento = nacimiento;
    }

    public String getLocalidadResidencia() {
        return localidadResidencia;
    }

    public void setLocalidadResidencia(String localidadResidencia) {
        this.localidadResidencia = localidadResidencia;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public List<Delegacion> getDelegacionesAAceptarMias() {
        return delegacionesAAceptarMias;
    }

    public List<Delegacion> getDelegacionesAprobadasMias() {
        return delegacionesAprobadasMias;
    }

    public List<Delegacion> getDelegacionesAAceptarDeOtros() {
        return delegacionesAAceptarDeOtros;
    }

    public List<Delegacion> getDelegacionesAprobadasDeOtros() {
        return delegacionesAprobadasDeOtros;
    }

    public void aceptarAutorizacion(Delegacion delegacion){
        //TODO
    }


}
