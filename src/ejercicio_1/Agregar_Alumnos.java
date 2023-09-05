package ejercicio_1;

import datos.AlumnoJDBC;
import domain.Alumno;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author Juan
 */
public class Agregar_Alumnos {

    public static void main(String[] args) {
        
        AlumnoJDBC alumnos = new AlumnoJDBC();
        
        List<Alumno> alumno = alumnos.select();
        
        for (Alumno alum : alumno) {
            System.out.println("Alumno:" + alum);
        }
        // Alumno 1
        Alumno alum1 = new Alumno();
        alum1.setDni("50200100");
        alum1.setApellido("Robledo");
        alum1.setNombre("Roberto Ismael");
        alum1.setFechaNac(LocalDate.of(2000, 8, 15));
        alum1.setEstado(true);
        
        alumnos.insert(alum1);
        
        // Alumno 2
        Alumno alum2 = new Alumno();
        alum2.setDni("45200780");
        alum2.setApellido("Gonzales");
        alum2.setNombre("Maria Carla");
        alum2.setFechaNac(LocalDate.of(2000, 4, 20));
        alum2.setEstado(true);
        
        alumnos.insert(alum2);
        
        // Alumno 3
        Alumno alum3 = new Alumno();
        alum3.setDni("45100200");
        alum3.setApellido("Martinez");
        alum3.setNombre("Jose Luis ");
        alum3.setFechaNac(LocalDate.of(2000, 6, 15));
        alum3.setEstado(true);
        
        alumnos.insert(alum3);
        
        alumnos.select();
        
    }
}
