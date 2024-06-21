package Clases;

public class Fecha {
	 private String fechaString;

	    public Fecha(String fechaString) {
	        this.fechaString = fechaString;
	    }

	    public String obtenerDia() {
	        String[] partes = fechaString.split("/");
	        return partes[0];
	    }

	    public String obtenerMes() {
	        String[] partes = fechaString.split("/");
	        return partes[1];
	    }

	    public String obtenerAnio() {
	        String[] partes = fechaString.split("/");
	        return partes[2];
	    }

}
