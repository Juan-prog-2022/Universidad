package domain;

/**
 *
 * @author Juan
 */
public class Inscripcion {
    private int id_Inscripto;
    private int nota;
    private int id_Alumno;
    private int id_Materia;

    public int getId_Inscripto() {
        return id_Inscripto;
    }

    public void setId_Inscripto(int id_Inscripto) {
        this.id_Inscripto = id_Inscripto;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public int getId_Alumno() {
        return id_Alumno;
    }

    public void setId_Alumno(int id_Alumno) {
        this.id_Alumno = id_Alumno;
    }

    public int getId_Materia() {
        return id_Materia;
    }

    public void setId_Materia(int id_Materia) {
        this.id_Materia = id_Materia;
    }

    @Override
    public String toString() {
        return "Inscripcion{" + "id_Inscripto=" + id_Inscripto + ", nota=" + nota + ", id_Alumno=" + id_Alumno + ", id_Materia=" + id_Materia + '}';
    }
    
}
