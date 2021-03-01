package pe.gob.controller;

import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

import pe.gob.dao.CategoriaDao;
import pe.gob.model.Categoria;



@ManagedBean
@SessionScoped
public class CategoriaBean {
	
	
	
	private ArrayList<Categoria> listacategoria = new ArrayList<Categoria>();
	private ArrayList<SelectItem> listaItem = null;
	
	private String cmbitem;
	
	@PostConstruct
	public void init() {
		if (listaItem == null) {
			listaItem = new ArrayList<SelectItem>();
			CategoriaDao dao = new CategoriaDao();
			listacategoria = dao.list();
			
			for (Categoria x : listacategoria) {
				SelectItem cmbcategoria =  new SelectItem(x.getIdcategoria(),x.getCategoria());
				listaItem.add(cmbcategoria);	
			}
		}
	}
	
	public ArrayList<SelectItem> getListaItem() {
		
		return listaItem;
	}

	public String getCmbitem() {
		return cmbitem;
	}

	public void setCmbitem(String cmbitem) {
		this.cmbitem = cmbitem;
	}
	
	
	
	
	
	
	
}
