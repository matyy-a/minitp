package relacionamiento.domain;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@DiscriminatorValue("1")
public class Persona extends Usuario {

    private String nombre;

    private String apellido;

    private String dni;

    private LocalDate nacimiento;

    private String localidadResidencia;

    private String foto;

    private String ciudad;

    @OneToMany
    @JoinColumn(name = "delegacioneAceptarMias_id")
    //@Column(insertable=false, updatable=false)
    private List<Delegacion> delegacionesAAceptarMias=new ArrayList<>();;
    //
    @OneToMany
    @JoinColumn(name = "delegacionAprobadasMias_id")
    //@Column(insertable=false, updatable=false)
    private List<Delegacion> delegacionesAprobadasMias=new ArrayList<>();;

    @OneToMany
    @JoinColumn(name = "delegacionAAceptarDeOtros_id")
    //@Column(insertable=false, updatable=false)
    private List<Delegacion> delegacionesAAceptarDeOtros=new ArrayList<>();;

    @OneToMany
    @JoinColumn(name = "delegacionAprobadasDeOtros_id")
    //@Column(insertable=false, updatable=false)
    private List<Delegacion> delegacionesAprobadasDeOtros=new ArrayList<>();


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

    public Persona() {
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



    public void agregarDelegacionesAAceptarMias(Delegacion delegacion){
        delegacionesAprobadasMias.add(delegacion);
    }
    public void agregarDelegacionesAprobadasMias(Delegacion delegacion){
        delegacionesAprobadasMias.add(delegacion);
    }
    public void agregarDelegacionesAAceptarDeOtros(Delegacion delegacion){
        delegacionesAprobadasDeOtros.add(delegacion);
    }
    public void agregarDelegacionesAprobadasDeOtros(Delegacion delegacion){
        delegacionesAprobadasDeOtros.add(delegacion);
    }

    public void aceptarAutorizacion(Delegacion delegacion){
        //TODO
    }


}
