package Clases;


public class Medicamento {
	public String nombre;
	public String presentacion;
	public String composicion;
	public String compraFecha;
	public String vencimientoFecha;
	
	Medicamento siguiente;
	
	public Medicamento(String nombre) {
		this.nombre = nombre;
	}
	
	public Medicamento(String nombre,
						String presentacion,
						String composicion,
						String compraFecha,
						String vencimientoFecha) {
		
        this.nombre = nombre;
        this.presentacion = presentacion;
        this.composicion = composicion;
        this.compraFecha = compraFecha;
        this.vencimientoFecha = vencimientoFecha;
        this.siguiente = null;
    }
	
	

}
