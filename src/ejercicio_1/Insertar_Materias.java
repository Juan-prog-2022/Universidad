package ejercicio_1;

import datos.MateriaJDBC;
import domain.Materia;
import java.util.List;

/**
 *
 * @author Juan
 */
public class Insertar_Materias {

    public static void main(String[] args) {

        MateriaJDBC materias = new MateriaJDBC();

        List<Materia> materia = materias.select();

        for (Materia materia1 : materia) {
            System.out.println("Materias:" + materia1);
        }
        //Materia 1
        /*Materia mat1 = new Materia();
        
        mat1.setNombre("Álgebra");
        mat1.setAnio(1);
        mat1.setEstado(true);
       
        materias.insert(mat1);
        //Materia 2
        Materia mat2 = new Materia();
        
        mat2.setNombre("Ingles Técnico");
        mat2.setAnio(1);
        mat2.setEstado(true);
       
        materias.insert(mat2);

        //Materia 3
        Materia mat3 = new Materia();

        mat3.setNombre("Introduccion a la Programación");
        mat3.setAnio(1);
        mat3.setEstado(true);

        materias.insert(mat3);
        
        // Materia 4
        Materia mat4 = new Materia();

        mat4.setNombre("Estadistica I");
        mat4.setAnio(1);
        mat4.setEstado(true);

        materias.insert(mat4);*/
        
        materias.select();
    }
}
