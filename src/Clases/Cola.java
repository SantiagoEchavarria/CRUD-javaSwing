package Clases;


public class Cola implements Cloneable {
	private Medicamento frente;
    private Medicamento fin;
    ManipulacionArchivos datos = new ManipulacionArchivos();
    

    
    public Cola() {
        frente = null;
        fin = null;
    }
    
    public boolean estaVacia() {
        return frente == null;
    }
    
    public void encolar(String nombre,
						String presentacion,
						String composicion,
						String compraFecha,
						String vencimientoFecha,
						boolean actualizar) {
    	
        Medicamento nuevoNodo = new Medicamento(nombre, presentacion, composicion,compraFecha,vencimientoFecha);
        if (estaVacia()) {
            frente = nuevoNodo;
            fin = nuevoNodo;
        } else {
            fin.siguiente = nuevoNodo;
            fin = nuevoNodo;
            
        }
        System.out.println("Elemento encolado: " + nombre);
        if(actualizar==false) {
        	 this.actualizarCola2();
        }
       
    }
    
    public Medicamento desencolar() {
    	Medicamento med = new Medicamento("-1");
        if (estaVacia()) {
            System.out.println("La cola está vacía. No se puede desencolar un elemento.");
            return med;
        }
        
        Medicamento nombre = frente;
        frente = frente.siguiente;
        
        if (frente == null) {
            fin = null;
        }
        
        System.out.println("Elemento desencolado: " + nombre);
        return nombre;
    }
    public void actualizarCola2() {
        if (estaVacia()) {
            System.out.println("La cola está vacía.");
            return;
        }
        
        Medicamento actual = frente;
        System.out.print("Actualizando archivos desde cola: ");
        String datos="";
        String anterior="";
        int i=0;
        while (actual != null) {
        	datos="\n"
    				+actual.nombre + "\n"+
   				 actual.presentacion + "\n"+
   				 actual.composicion+ "\n"+
   				 actual.compraFecha+ "\n"+
   				 actual.vencimientoFecha;
        	if(i!=0) {
        		anterior=anterior+"\n"+datos;
        	}else {
        		anterior=anterior+datos;
        	}
        	anterior=anterior+datos;
        	
            System.out.print("\n"
            				+actual.nombre + "\n"+
            				 actual.presentacion + "\n"+
            				 actual.composicion+ "\n"+
            				 actual.compraFecha+ "\n"+
            				 actual.vencimientoFecha
            				);
            actual = actual.siguiente;
        }
        this.datos.actualizarSoloDato("Inventario", datos);
        System.out.println();
    }
    
    
    public void actualizarCola() {
        if (estaVacia()) {
            System.out.println("La cola está vacía.");
            return;
        }
        
        Medicamento actual = frente;
        System.out.print("Actualizando archivos desde cola: ");
        String datos="";
        String anterior="";
        while (actual != null) {
        	datos="\n"
    				+actual.nombre + "\n"+
   				 actual.presentacion + "\n"+
   				 actual.composicion+ "\n"+
   				 actual.compraFecha+ "\n"+
   				 actual.vencimientoFecha;
        	
        	anterior=anterior+datos;
        	
            System.out.print("\n"
            				+actual.nombre + "\n"+
            				 actual.presentacion + "\n"+
            				 actual.composicion+ "\n"+
            				 actual.compraFecha+ "\n"+
            				 actual.vencimientoFecha
            				);
            actual = actual.siguiente;
        }
        this.datos.actualizarConNuevoDato("Inventario", anterior);
        System.out.println();
    }
    
    
    
    public String imprimirCola() {
        if (estaVacia()) {
            System.out.println("La cola está vacía.");
            return"-1";
        }
        String datos="";
        String anterior="";
        Medicamento actual = frente;
        System.out.print("Elementos de la cola: ");
        int i=0;
        while (actual != null) {
        	datos="\n"+
        		 actual.nombre + "\n"+
   				 actual.presentacion + "\n"+
   				 actual.composicion+ "\n"+
   				 actual.compraFecha+ "\n"+
   				 actual.vencimientoFecha;
        	if(i!=0) {
        		anterior=anterior+"\n"+datos;
        	}else {
        		anterior=anterior+datos;
        	}
        	
            System.out.print("\n"
            				+actual.nombre + "\n"+
            				 actual.presentacion + "\n"+
            				 actual.composicion+ "\n"+
            				 actual.compraFecha+ "\n"+
            				 actual.vencimientoFecha
            				);
            actual = actual.siguiente;
            i=i+1;
        }
       
        System.out.println();
		return anterior;
    }
    
    
    
    public Pila convertirPila(Cola cola) {
    	Pila pila = new Pila();
    	Medicamento med = cola.desencolar();
    	
    	while(med.nombre!="-1"){
    	pila.apilar(med.nombre, med.presentacion, med.composicion, med.compraFecha, med.vencimientoFecha,true);
    	med = cola.desencolar();
    	}
		return pila;
    }
    
    
    
    public boolean desencolarElementoEspecifico(String elemento) {
        if (estaVacia()) {
            System.out.println("La cola está vacía. No se puede desencolar un elemento.");
            return false;
        }
        
        if (frente.nombre.equals(elemento)) {
            frente = frente.siguiente;
            if (frente == null) {
                fin = null;
            }
            System.out.println("Elemento desencolado: " + elemento);
            return true;
        }
        
        Medicamento anterior = frente;
        Medicamento actual = frente.siguiente;
        
        while (actual != null) {
            if (actual.nombre.equals(elemento)) {
                anterior.siguiente = actual.siguiente;
                if (actual == fin) {
                    fin = anterior;
                }
                System.out.println("Elemento desencolado: " + elemento);
                return true;
            }
            
            anterior = actual;
            actual = actual.siguiente;
        }
        
        System.out.println("No se encontró el elemento en la cola.");
        return false;
    }
    
    
    public void actualizarNodo(String nombre,
			String presentacion,
			String composicion,
			String compraFecha,
			String vencimientoFecha) {
    	
        if (estaVacia()) {
            System.out.println("La cola está vacía. No se puede actualizar un nodo.");
            return;
        }

        Medicamento actual = frente;
        int contador = 0;
        
        while (actual != null) {
            if (nombre.equals(actual.nombre)) {
                actual.nombre = nombre;
                actual.presentacion=presentacion;
                actual.composicion=composicion;
                actual.compraFecha=compraFecha;
                actual.vencimientoFecha=vencimientoFecha;
              
                
              
                return;
            }

            actual = actual.siguiente;
            contador++;
        }

       
    }
    
    
    
   
    @Override
    public Cola clone() {
        try {
            Cola colaClonada = (Cola) super.clone();
            if (!estaVacia()) {
                Medicamento actual = frente;
                Medicamento nuevoFrente = new Medicamento(actual.nombre, actual.presentacion, actual.composicion, actual.compraFecha, actual.vencimientoFecha);
                colaClonada.frente = nuevoFrente;
                Medicamento nuevoActual = nuevoFrente;

                while (actual.siguiente != null) {
                    actual = actual.siguiente;
                    Medicamento nuevoNodo = new Medicamento(actual.nombre, actual.presentacion, actual.composicion, actual.compraFecha, actual.vencimientoFecha);
                    nuevoActual.siguiente = nuevoNodo;
                    nuevoActual = nuevoNodo;
                }

                colaClonada.fin = nuevoActual;
            }

            return colaClonada;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

}
