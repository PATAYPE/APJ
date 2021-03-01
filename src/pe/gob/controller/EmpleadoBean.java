package pe.gob.controller;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import pe.gob.dao.EmpleadoDao;
import pe.gob.model.Empleado;




@ManagedBean
@SessionScoped
public class EmpleadoBean {
	
	private Empleado empleado = new Empleado();
	
	private ArrayList<Empleado> listaemp;
	
	private String accion;

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public ArrayList<Empleado> getListaemp() {
		return listaemp;
	}

	public void setListaemp(ArrayList<Empleado> listaemp) {
		this.listaemp = listaemp;
	}
	
	public String getAccion() {
		return accion;
	}

	public void setAccion(String accion) {
		this.accion = accion;
	}
	
	// metodos

	public void listar() {
		EmpleadoDao dao= new EmpleadoDao();
		try {

			listaemp = dao.list();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	public  void operar() {
		switch (accion) {
		case "registrar":
			this.add();
			break;
		case "modificar":
			this.updateEmp();
			break;
		}
		listar();

	}
	// add
	private  void add() {
		EmpleadoDao dao = new EmpleadoDao();
		try {
			dao.save(empleado);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	// 
	private  void updateEmp() {
		EmpleadoDao dao = new EmpleadoDao();
		try {
			dao.update(empleado);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	//edit
	public void getempleado(int codigo) {
		EmpleadoDao dao = new EmpleadoDao();
		Empleado temp;
		try {
			temp = dao.get(codigo);
			if (temp!=null) {
				this.empleado = temp;
				this.accion="modificar";
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	// delete }
	public void deleteEmpleado(Empleado emp) {
		EmpleadoDao dao = new EmpleadoDao();
		try {
			dao.delete(emp);
			listar();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
