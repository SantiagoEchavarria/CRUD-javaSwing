package Clases;

public class Pila implements Cloneable {
	 private Medicamento tope;
	 static ManipulacionArchivos datos = new ManipulacionArchivos();
																		
	    
	    public Pila() {
	        tope = null;
	    }
	    
	    public boolean estaVacia() {
	        return tope == null;
	    }
	    
	    public void apilar(String nombre,
				String presentacion,
				String composicion,
				String compraFecha,
				String vencimientoFecha, boolean actualizar) {
	    	
	    	Medicamento nuevoNodo = new Medicamento(nombre, presentacion, composicion,compraFecha,vencimientoFecha);
	        nuevoNodo.siguiente = tope;
	        tope = nuevoNodo;
	        if(actualizar==false) {
	        	 this.actualizarPila();
	        }
	       
	        System.out.println("Elemento apilado: " + nombre);
	    }
	    
	    
	    public Medicamento desapilar() {
	    	Medicamento med= new Medicamento("-1");
	        if (estaVacia()) {
	            System.out.println("La pila est� vac�a. No se puede desapilar un elemento.");
	            return med;
	        }
	        
	        Medicamento nombre = tope;
	        tope = tope.siguiente;
	        System.out.println("Elemento desapilado: " + nombre);
	        return nombre;
	    }
	    
	    public void imprimirPila() {
	        if (estaVacia()) {
	            System.out.println("La Pila est� vac�a.");
	            return;
	        }
	        
	        Medicamento actual = tope;
	        System.out.print("Elementos de la pila: ");
	       
	        while (actual != null) {	        	
	            System.out.print("\n"
	            				+actual.nombre + "\n"+
	            				 actual.presentacion + "\n"+
	            				 actual.composicion+ "\n"+
	            				 actual.compraFecha+ "\n"+
	            				 actual.vencimientoFecha
	            				);
	            actual = actual.siguiente;
	        }
	       
	        System.out.println();
	    }
	    
	    public void actualizarPila() {
	        if (estaVacia()) {
	            System.out.println("La Pila est� vac�a.");
	            return;
	        }
	        
	        Medicamento actual = tope;
	        System.out.print("Actualizando de la pila: ");
	        
	        String anterior="";
	        String dato="";
	        int i=0;
	        while (actual != null) {
	        	 dato="\n"
        				+actual.nombre + "\n"+
       				 actual.presentacion + "\n"+
       				 actual.composicion+ "\n"+
       				 actual.compraFecha+ "\n"+
       				 actual.vencimientoFecha;
	        	
	        	if(i!=0) {
	        		anterior=anterior+"\n"+dato;
	        	}else {
	        		anterior=anterior+dato;
	        	}
	        	i=i+1;
	            System.out.print("\n"
	            				+actual.nombre + "\n"+
	            				 actual.presentacion + "\n"+
	            				 actual.composicion+ "\n"+
	            				 actual.compraFecha+ "\n"+
	            				 actual.vencimientoFecha
	            				);
	            actual = actual.siguiente;
	        }
	        datos.actualizarConNuevoDato("Historial", anterior);
	       // datos.actualizarSoloDato("Historial", dato);
	        System.out.println();
	    }
	    
	    public Pila convertirPila(Pila pila) {
    	
	    	Pila pila2 = new Pila();
	    	Medicamento med = pila.desapilar();
	    	
	    	while(med.nombre!="-1"){
	    	pila2.apilar(med.nombre, med.presentacion, med.composicion, med.compraFecha, med.vencimientoFecha,true);
	    	med = pila.desapilar();
	    	}
			return pila2;
	    }
	    
	    @Override
	    public Pila clone() {
	        try {
	            Pila colaClonada = (Pila) super.clone();
	            if (!estaVacia()) {
	                Medicamento actual = tope;
	                Medicamento nuevoFrente = new Medicamento(actual.nombre, actual.presentacion, actual.composicion, actual.compraFecha, actual.vencimientoFecha);
	                colaClonada.tope = nuevoFrente;
	                Medicamento nuevoActual = nuevoFrente;

	                while (actual.siguiente != null) {
	                    actual = actual.siguiente;
	                    Medicamento nuevoNodo = new Medicamento(actual.nombre, actual.presentacion, actual.composicion, actual.compraFecha, actual.vencimientoFecha);
	                    nuevoActual.siguiente = nuevoNodo;
	                    nuevoActual = nuevoNodo;
	                }
	            }

	            return colaClonada;
	        } catch (CloneNotSupportedException e) {
	            throw new AssertionError(e);
	        }
	    }

}
