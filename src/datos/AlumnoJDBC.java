package datos;

import domain.Alumno;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Juan
 */
public class AlumnoJDBC {
    private static final String SQL_SELECT = "SELECT id_Alumno, dni, apellido, nombre, fechaNac, estado FROM alumno";
    private static final String SQL_INSERT = "INSERT INTO alumno(dni, apellido, nombre, fechaNac, estado) VALUES(?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE alumno SET Apellido=?, Nombre=? WHERE id_Alumno=?";
    private static final String SQL_DELETE = "DELETE FROM alumno WHERE id_Alumno=?";
    
    public List<Alumno> select(){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Alumno alumno = null;
        List<Alumno> alumnos = new ArrayList<Alumno>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while(rs.next()){
                
                //Recuperamos las columnas de cada Registro
                int id_Alumno= rs.getInt("id_Alumno");
                String dni = rs.getString("dni");
                String nombre = rs.getString("apellido");
                String apellido = rs.getString("nombre");
                LocalDate fechaNac = rs.getDate("fechaNac").toLocalDate();
                boolean estado = rs.getBoolean("estado");
                
                //Creamos el Objeto Alumno
                alumno = new Alumno();
                alumno.setId_Alumno(id_Alumno);
                alumno.setDni(dni);
                alumno.setApellido(apellido);
                alumno.setNombre(nombre);
                alumno.setFechaNac(fechaNac);
                alumno.setEstado(estado);
                
                //Agregamos cada Alumno a la Lista
                alumnos.add(alumno);
            }
                
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally{
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return alumnos;
    }
    
    public int insert(Alumno alumno){
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, alumno.getDni());
            stmt.setString(2, alumno.getApellido());
            stmt.setString(3, alumno.getNombre());
            stmt.setDate(4, java.sql.Date.valueOf(alumno.getFechaNac()));
            stmt.setBoolean(5, alumno.isEstado());
            
            
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
    
    public int update(Alumno alumno){
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        
        try {
            conn = Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, alumno.getDni());
            stmt.setString(2, alumno.getApellido());
            stmt.setString(3, alumno.getNombre());
            stmt.setDate(4, java.sql.Date.valueOf(alumno.getFechaNac()));
            stmt.setBoolean(5, alumno.isEstado());
            
            
            rows = stmt.executeUpdate();
            System.out.println("Registros actualizados:" + rows);
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally{
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        
        return rows;
    }
    
    public int delete(Alumno alumno){
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, alumno.getId_Alumno());
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
