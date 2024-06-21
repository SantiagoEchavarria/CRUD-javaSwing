package Clases;

public class Prueba {

	public static void main(String[] args) {
		Cola inventario = new Cola();
		Pila historial = new Pila();
		
		//Al Ingresar al inventario:
		inventario.encolar("Hivermectina", "Rojo", "5ml", "24/05/2023", "24/05/2025",false);
		inventario.encolar("AguaOxigenada", "Azul", "10ml", "24/05/2023", "24/05/2025",false);
		inventario.encolar("Negubon", "Papeleta", "50ml", "24/05/2023", "24/05/2029",false);
		
		//Al vender
		historial.apilar("Hivermectina", "Rojo", "5ml", "24/05/2023", "24/05/2025",false);
		historial.apilar("AguaOxigenada", "Azul", "10ml", "24/05/2023", "24/05/2025",false);
		
		
		inventario.imprimirCola();
		System.out.println("");
		historial.imprimirPila();
		
		
		inventario.desencolarElementoEspecifico("AguaOxigenada");
		inventario.imprimirCola();
	}

}
