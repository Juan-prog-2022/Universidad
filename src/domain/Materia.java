package domain;

/**
 *
 * @author Juan
 */
public class Materia {
    private int id_Materia;
    private String nombre;
    private int anio;
    private boolean estado;

    public int getId_Materia() {
        return id_Materia;
    }

    public void setId_Materia(int id_Materia) {
        this.id_Materia = id_Materia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Materia{" + "id_Materia=" + id_Materia + ", nombre=" + nombre + ", anio=" + anio + ", estado=" + estado + '}';
    }

    
}
