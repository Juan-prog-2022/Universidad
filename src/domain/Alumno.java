package domain;

import java.time.LocalDate;

/**
 *
 * @author Juan
 */
public class Alumno {

    private int id_Alumno;
    private String dni;
    private String apellido;
    private String nombre;
    private LocalDate fechaNac;
    private boolean estado;

    public int getId_Alumno() {
        return id_Alumno;
    }

    public void setId_Alumno(int id_Alumno) {
        this.id_Alumno = id_Alumno;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(LocalDate fechaNac) {
        this.fechaNac = fechaNac;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Alumno{" + "id_Alumno=" + id_Alumno + ", dni=" + dni + ", apellido=" + apellido + ", nombre=" + nombre + ", fechaNac=" + fechaNac + ", estado=" + estado + '}';
    }

    
}
