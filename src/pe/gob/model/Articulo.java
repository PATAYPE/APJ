package pe.gob.model;

public class Articulo {
	
	private int idarticulo;
    private int idcategoria;
    private String nombre;
    private String descripcion;
    private double precio;
    private String foto;
    private int estado;
    
    
	public int getIdarticulo() {
		return idarticulo;
	}
	public void setIdarticulo(int idarticulo) {
		this.idarticulo = idarticulo;
	}
	public int getIdcategoria() {
		return idcategoria;
	}
	public void setIdcategoria(int idcategoria) {
		this.idcategoria = idcategoria;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
    
	
    
}
