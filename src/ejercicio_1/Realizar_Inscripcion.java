package ejercicio_1;

import datos.InscripcionJDBC;
import domain.Inscripcion;
import java.util.List;

/**
 *
 * @author Juan
 */
public class Realizar_Inscripcion {

    public static void main(String[] args) {

        InscripcionJDBC ins = new InscripcionJDBC();

        List<Inscripcion> i = ins.select();

        for (Inscripcion inscripcion : i) {
            System.out.println("Inscriptos: " + inscripcion);
        }

        //Inscripcion 1
        /*Inscripcion in = new Inscripcion();
        in.setNota(9);
        in.setId_Alumno(2);
        in.setId_Materia(4);
        
        ins.insert(in);*/
        ins.select();

        InscripcionJDBC inscripcionJDBC = new InscripcionJDBC();
        Inscripcion inscripcion = new Inscripcion();
        inscripcion.setId_Inscripto(8); // reemplaza 1 con el id_Inscripto del alumno que deseas desinscribir
        inscripcionJDBC.delete(inscripcion);
    }

}
