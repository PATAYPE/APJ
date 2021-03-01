package pe.gob.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import javax.faces.model.SelectItem;

import pe.gob.dao.ArticuloDap;
import pe.gob.model.Articulo;
import pe.gob.model.Categoria;


@ManagedBean
@RequestScoped

public class BMArticulo implements Serializable {
	


	/**
	 * 
	 */
	private static final long serialVersionUID = -9033052834544477148L;

	Logger logger = Logger.getLogger(BMArticulo.class.getName());
	
	
	private Articulo articulo = new Articulo(); 
	private ArrayList<Articulo> listaarticulo;
	
	private Categoria categoria = new Categoria();
	private ArrayList<Categoria> listacategoria;
	
	private List<SelectItem> listacat = null;
	private String accion;
	
	

	public Articulo getArticulo() {
		return articulo;
	}

	public void setArticulo(Articulo articulo) {
		this.articulo = articulo;
	}

	public ArrayList<Articulo> getListaarticulo() {
		return listaarticulo;
	}

	public void setListaarticulo(ArrayList<Articulo> listaarticulo) {
		this.listaarticulo = listaarticulo;
	}
	
	public String getAccion() {
		return accion;
	}

	public void setAccion(String accion) {
		limpiar();
		this.accion = accion;
	}

	public ArrayList<Categoria> getListacategoria() {
		return listacategoria;
	}

	public void setListacategoria(ArrayList<Categoria> listacategoria) {
		this.listacategoria = listacategoria;
	}
	
	public List<SelectItem> getListacat() {
		return listacat;
	}
	
	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public void setListacat(List<SelectItem> listacat) {
		this.listacat = listacat;
	}
	
	

	//metodos del crud 
	public void listarArticulos() {
		ArticuloDap daoArt = new ArticuloDap();
		try {
			listaarticulo = daoArt.list();
		} catch (Exception e) {
			System.out.println("listarArticulos " + e);
		}
	} 
	
	public void operar() {
		switch (accion) {
		case "registrar":
			this.addArt();
			limpiar();
			break;
		case "modificar":
			this.updateArt();
			limpiar();
			break;
		}
		listarArticulos();
	}
	
	private void addArt() {
		ArticuloDap dao = new ArticuloDap();
		try {
			
			dao.save(articulo);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	private  void updateArt() {
		ArticuloDap dao = new ArticuloDap();
		try {
			
			dao.update(articulo);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void getArt(int cod) {
		ArticuloDap dao = new ArticuloDap();
		Articulo temp ;
		try {
			temp = dao.get(cod);
			
			if (temp!=null) {
				this.articulo = temp;
				this.accion="modificar";
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	
	
	public void deleteArt(int cod) {
		ArticuloDap dao = new ArticuloDap();
		try {
			dao.delete(cod);
			listarArticulos();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	private void limpiar() {
		this.articulo.setIdarticulo(0);
		this.articulo.setNombre("");
		this.articulo.setDescripcion("");
		this.articulo.setPrecio(0);
		this.articulo.setFoto("");
	}
}
