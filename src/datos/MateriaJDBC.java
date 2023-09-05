package datos;

import domain.Materia;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Juan
 */
public class MateriaJDBC {
    private static final String SQL_SELECT = "SELECT id_Materia, nombre, año, estado FROM materia";
    private static final String SQL_INSERT = "INSERT INTO materia (nombre, año, estado) VALUES (?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE materia SET nombre=?, año=?,  WHERE id_Materia=?";
    private static final String SQL_DELETE = "DELETE FROM materia WHERE id_Materia=?";
    
    public List<Materia> select(){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Materia materia = null;
        List<Materia> materias = new ArrayList<Materia>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while(rs.next()){
                
                //Recuperamos las columnas de cada Registro
                int id_Materia= rs.getInt("id_Materia");
                String nombre = rs.getString("nombre");
                int anio = rs.getInt("año");
                boolean estado = rs.getBoolean("estado");
                
                //Creamos el Objeto Materia
                materia = new Materia();
                materia.setId_Materia(id_Materia);
                materia.setNombre(nombre);
                materia.setAnio(anio);
                materia.setEstado(estado);
                
                //Agregamos cada Materia a la Lista
                materias.add(materia);
            }
                
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally{
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return materias;
    }
    
    public int insert(Materia materia){
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setInt(1, materia.getId_Materia());
            stmt.setString(2, materia.getNombre());
            stmt.setInt(3, materia.getAnio());
            stmt.setBoolean(4, materia.isEstado());
            
            
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
    
}
