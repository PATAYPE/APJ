package pe.gob.dao;


import java.util.ArrayList;

import pe.gob.conexion.Conexion;
import pe.gob.model.Empleado;




public class EmpleadoDao  extends Conexion{

	public ArrayList<Empleado> list() {
        //comando sql para sleccinar todos los empleados
        String sql = "SELECT * FROM EMPLEADO";
        ArrayList<Empleado> lista = new ArrayList<Empleado>();
        Empleado emp;
        try {
            //abrir al conexion a  la base de datos tienda
            cn = abrirConexion();
            //creamos un objeto PreparedStatement con la conexion  a la base de datos
            stm = cn.prepareStatement(sql);
            //ejecutar objeto PreparedStatement
            rs = stm.executeQuery();
            while (rs.next()) {
                emp = new Empleado();
                emp.setIdempleado(rs.getInt(1));
                emp.setNombre(rs.getString(2));
                emp.setPaterno(rs.getString(3));
                emp.setMaterno(rs.getString(4));
                emp.setCargo(rs.getString(5));
                lista.add(emp);
            }
        } catch (Exception ex) {
            System.out.println("Error lista empleado:" + ex);
        } finally {
            cerrar(cn);
            cerrar(stm);
            cerrar(rs);
        }
        return lista;
    }

    public Empleado get(int cod) {
    	
        //comando sql para buscar empleado
        String sql = "SELECT * FROM EMPLEADO  WHERE IDEMPLEADO=?";
        Empleado emp = null;
        try {
            //abrir al conexion a  la base de datos tienda
            cn = abrirConexion();
            //creamos un objeto PreparedStatement con la conexion  a la base de datos
            stm = cn.prepareStatement(sql);
            //asignamos  valores a los parametros ?
            stm.setInt(1, cod);
            //ejecutar objeto PreparedStatement
            rs = stm.executeQuery();
            if (rs.next()) {
                emp = new Empleado();
                emp.setIdempleado(rs.getInt(1));
                emp.setNombre(rs.getString(2));
                emp.setPaterno(rs.getString(3));
                emp.setMaterno(rs.getString(4));
                emp.setCargo(rs.getString(5));
            }
        } catch (Exception ex) {
            System.out.println("Error en buscar empleado:" + ex);
        } finally {
            cerrar(cn);
            cerrar(stm);
            cerrar(rs);
        }
        return emp;
    }

    public void save(Empleado t) {
        //comando sql para insertar empleado
        String sql = "INSERT INTO EMPLEADO(NOMBRE,APEPATERNO, APEMATERNO,CARGO)VALUES(?,?,?,?)";
        try {
            //abrir al conexion a  la base de datos tienda
            cn = abrirConexion();
            //creamos un objeto PreparedStatement con la conexion  a la base de datos
            stm = cn.prepareStatement(sql);
            //asignamos  valores a los parametros ?,?,?,?
            stm.setString(1, t.getNombre());
            stm.setString(2, t.getPaterno());
            stm.setString(3, t.getMaterno());
            stm.setString(4, t.getCargo());
            //ejecutar objeto PreparedStatement
            stm.executeUpdate();
        } catch (Exception ex) {
            System.out.println("Error en grabar empleado:" + ex);
        } finally {
            cerrar(cn);
            cerrar(stm);
            cerrar(rs);
        }
    }

    public void update(Empleado t) {
        //comando sql para modficar empleado
        String sql = "UPDATE EMPLEADO SET NOMBRE=?,APEPATERNO=?, APEMATERNO=?,CARGO=? WHERE IDEMPLEADO=?";
        try {
            //abrir al conexion a  la base de datos tienda
            cn = abrirConexion();
            //creamos un objeto PreparedStatement con la conexion  a la base de datos
            stm = cn.prepareStatement(sql);
            //asignamos  valores a los parametros ?,?,?,?,?
            stm.setString(1, t.getNombre());
            stm.setString(2, t.getPaterno());
            stm.setString(3, t.getMaterno());
            stm.setString(4, t.getCargo());
            stm.setInt(5, t.getIdempleado());
            //ejecutar objeto PreparedStatement
            stm.executeUpdate();
        } catch (Exception ex) {
            System.out.println("Error en modificar empleado:" + ex);
        } finally {
            cerrar(cn);
            cerrar(stm);
            cerrar(rs);
        }
    }

    public void delete(Empleado t) {
        //comando sql para eliminar empleado
        String sql = "DELETE FROM EMPLEADO WHERE IDEMPLEADO=?";
        try {
            //abrir al conexion a  la base de datos tienda
            cn = abrirConexion();
            //creamos un objeto PreparedStatement con la conexion  a la base de datos
            stm = cn.prepareStatement(sql);
            //asignamos  valores a los parametro ?
            stm.setInt(1, t.getIdempleado());
            //ejecutar objeto PreparedStatement
            stm.executeUpdate();
        } catch (Exception ex) {
            System.out.println("Error en eliminar empleado:" + ex);
        } finally {
            cerrar(cn);
            cerrar(stm);
            cerrar(rs);
        }
    }
	
}
