package datos;

import domain.Inscripcion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Juan
 */
public class InscripcionJDBC {
    private static final String SQL_SELECT = "SELECT id_Inscripto, nota, id_Alumno, id_Materia FROM inscripcion Where nota > 8";
    private static final String SQL_INSERT = "INSERT INTO inscripcion (id_Inscripto, nota, id_Alumno, id_Materia) VALUES (?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE inscripcion SET nota=? WHERE id_Inscripto = ?";
    private static final String SQL_DELETE = "DELETE FROM inscripcion WHERE id_Inscripto = ?";
    
    public List<Inscripcion> select(){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Inscripcion i = null;
        List<Inscripcion> ins = new ArrayList<Inscripcion>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while(rs.next()){
                
                //Recuperamos las columnas de cada Registro
                int id_Inscripto= rs.getInt("id_Inscripto");
                int nota = rs.getInt("nota");
                int id_Alumno = rs.getInt("id_Alumno");
                int id_Materia = rs.getInt("id_Materia");
                
                //Creamos la Inscripcion
                i = new Inscripcion();
                i.setId_Inscripto(id_Inscripto);
                i.setNota(nota);
                i.setId_Alumno(id_Alumno);
                i.setId_Materia(id_Materia);
                
                //Agregamos cada Inscripcion a la Lista
                ins.add(i);
            }
                
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally{
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return ins;
    }
    
    public int insert(Inscripcion ins){
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setInt(1, ins.getId_Inscripto());
            stmt.setInt(2, ins.getNota());
            stmt.setInt(3, ins.getId_Alumno());
            stmt.setInt(4, ins.getId_Materia());
            
            
            System.out.println("ejecutando query:" + SQL_INSERT);
            rows = stmt.executeUpdate();
            System.out.println("Registros afectados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally{
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        
        return rows;
    }
    
    public int delete(Inscripcion inscripcion){
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, inscripcion.getId_Inscripto());
            rows = stmt.executeUpdate();
            System.out.println("Registros eliminados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally{
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }
    
}
