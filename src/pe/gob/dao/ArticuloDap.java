package pe.gob.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import pe.gob.conexion.Conexion;
import pe.gob.model.Articulo;



public class ArticuloDap extends Conexion{
	
	
	 public ArrayList<Articulo> list() {
	        //arreglo de objetos tipo articulo
	        ArrayList<Articulo> lista = new ArrayList<Articulo>();
	        Articulo ar;
	        //instruccion sql para extraer todos los articulos de la BD
	        String sql = "SELECT * FROM ARTICULO";

	        try {
	            //abrir al conexion a  la base de datos tienda
	            cn = abrirConexion();
	            //creamos un objeto PreparedStatement con la conexion  a la base de datos
	            stm = cn.prepareStatement(sql);
	            //ejecutar objeto PreparedStatement
	            rs = stm.executeQuery();
	            while (rs.next()) {
	                //crear objeto ar
	                ar = new Articulo();
	                //encastmular datos en obejto ar
	                ar.setIdarticulo(rs.getInt(1));
	                ar.setIdcategoria(rs.getInt(2));
	                ar.setNombre(rs.getString(3));
	                ar.setDescripcion(rs.getString(4));
	                ar.setPrecio(rs.getDouble(5));
	                ar.setFoto(rs.getString(6));
	                ar.setEstado(rs.getInt(7));
	                //asignar objeto ar arreglo de objeto lista
	                lista.add(ar);
	            }
	            
	        } catch (SQLException ex) {
	            ex.printStackTrace();
	        } finally {
	            cerrar(cn);
	            cerrar(stm);
	            cerrar(rs);
	        }
	        return lista;

	    }

	    public Articulo get(int cod) {
	        Articulo ar = null;
	        //instruccion sql para extraer todos los articulos de la BD
	        String sql = "SELECT * FROM articulo WHERE idarticulo=?";
	        //objeto preparastamet para ejecutar instrucion sql a traves de  su metodo
	        //executequery y la conexion cn
	        try {
	            //abrir al conexion a  la base de datos tienda
	            cn = abrirConexion();
	            //creamos un objeto PreparedStatement con la conexion  a la base de datos
	            stm = cn.prepareStatement(sql);
	            stm.setInt(1, cod);
	            //ejecutar  objeto preparedstament 
	            rs = stm.executeQuery();
	            //leer resulset
	            if (rs.next()) {
	                //crear objeto ar
	                ar = new Articulo();
	                //encapsular datos en obejto ar
	                ar.setIdarticulo(rs.getInt(1));
	                ar.setIdcategoria(rs.getInt(2));
	                ar.setNombre(rs.getString(3));
	                ar.setDescripcion(rs.getString(4));
	                ar.setPrecio(rs.getDouble(5));
	                ar.setEstado(rs.getInt(6));
	            }
	        } catch (SQLException ex) {
	            ex.printStackTrace();
	        } finally {
	            cerrar(cn);
	            cerrar(stm);
	            cerrar(rs);
	        }
	        return ar;
	    }

	    public  void save(Articulo t) {
	        String sql = "INSERT INTO articulo(nombre,idcategoria,descripcion,precio,estado) VALUES(?,?,?,?,?)";
	        try {
	            //abrir al conexion a  la base de datos tienda
	            cn = abrirConexion();
	            //creamos un objeto PreparedStatement con la conexion  a la base de datos
	            stm = cn.prepareStatement(sql);
	            stm.setString(1, t.getNombre());
	            stm.setInt(2, t.getIdcategoria());
	            stm.setString(3, t.getDescripcion());
	            stm.setDouble(4, t.getPrecio());
	            stm.setInt(5, t.getEstado());
	            //ejecutar sentencia sql
	            stm.executeUpdate();
	        } catch (SQLException ex) {
	            ex.printStackTrace();
	        } finally {
	            cerrar(cn);
	            cerrar(stm);
	            cerrar(rs);
	        }
	    }

	    public void update(Articulo t) {
	        String sql = "UPDATE articulo SET nombre=?, idcategoria=?, descripcion=?, precio=?, estado=? WHERE idarticulo=?";

	        try {
	            //abrir al conexion a  la base de datos tienda
	            cn = abrirConexion();
	            //creamos un objeto PreparedStatement con la conexion  a la base de datos
	            stm = cn.prepareStatement(sql);
	            stm.setString(1, t.getNombre());
	            stm.setInt(2, t.getIdcategoria());
	            stm.setString(3, t.getDescripcion());
	            stm.setDouble(4, t.getPrecio());
	            stm.setInt(5, t.getIdarticulo());
	            stm.setInt(6, t.getEstado());
	            //ejecutar sentencia sql
	            stm.executeUpdate();
	        } catch (SQLException ex) {
	            ex.printStackTrace();
	        } finally {
	            cerrar(cn);
	            cerrar(stm);
	            cerrar(rs);
	        }

	    }

	    public void delete(int cod) {
	        String sql = "delete from  articulo where idarticulo=?";
	        try {
	            //abrir al conexion a  la base de datos tienda
	            cn = abrirConexion();
	            //creamos un objeto PreparedStatement con la conexion  a la base de datos
	            stm = cn.prepareStatement(sql);
	            stm.setInt(1, cod);
	            //ejecutar sentencia sql
	            stm.executeUpdate();
	        } catch (SQLException ex) {
	            ex.printStackTrace();
	        } finally {
	            cerrar(cn);
	            cerrar(stm);
	            cerrar(rs);
	        }
	    }
	    
	
}
