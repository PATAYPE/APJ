package pe.gob.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import pe.gob.conexion.Conexion;
import pe.gob.model.Categoria;



public class CategoriaDao extends Conexion {

	public ArrayList<Categoria> list() {
        //arreglo de objetos tipo articulo
        ArrayList<Categoria> lista = new ArrayList<Categoria>();
        //conexion a la BD
        cn = abrirConexion();
        //variable tipo articulo
        Categoria ar;
        //instruccion sql para extraer todos los articulos de la BD
        String sql = "select * from categoria";
        //objeto resultset para almacenar em memoria los articulos
        ResultSet rs;
        //objeto preparastamet para ejecutar instrucion sql a traves de  su metodo
        //executequery y la conexion cn
        PreparedStatement stm;
        try {
            stm = cn.prepareStatement(sql);
            //ejecutar  objeto preparedstament 
            rs = stm.executeQuery();

            //leer resulset
            while (rs.next()) {
                //crear objeto ar
                ar = new Categoria();
                //encapsular datos en obejto ar
                ar.setIdcategoria(rs.getInt(1));
                ar.setCategoria(rs.getString(2));
                //asignar objeto al arreglo de objeto lista
                lista.add(ar);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return lista;

    }

	
}
