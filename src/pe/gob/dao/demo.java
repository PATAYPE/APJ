package pe.gob.dao;

import java.util.ArrayList;

import pe.gob.model.Articulo;
import pe.gob.model.Categoria;
import pe.gob.model.Empleado;



public class demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		EmpleadoDao dao  = new EmpleadoDao();
		
		Empleado emp = dao.get(1);
		
		//System.out.println(emp.getNombre()+"\n"+ emp.getPaterno());
		
		CategoriaDao daocat = new CategoriaDao();
		ArrayList<Categoria> cat = daocat.list();
		
		for (Categoria x : cat) {
		//	System.out.println(" "+ x.getIdcategoria() + ":"+x.getCategoria() +"\n");
		}
		
		ArticuloDap artDao = new ArticuloDap();
		ArrayList<Articulo> lista = artDao.list();
		
		for (Articulo x : lista) {
			System.out.println(" "+ x.getNombre()  +"\n");
		}
		
		
	}

}
