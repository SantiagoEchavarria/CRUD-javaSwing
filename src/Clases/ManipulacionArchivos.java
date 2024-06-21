package Clases;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ManipulacionArchivos {
	
	 public void createFile(String fileName,
			 	String nombre,
			 	String anterior,
				String presentacion,
				String composicion,
				String compraFecha,
				String vencimientoFecha) {
	      
	        boolean fileCreated = false;
	        
	        if(anterior.equals(null)) {
	        	anterior="";
	        }
	    
	        File file = new File(fileName);
	        try {
	            fileCreated = file.createNewFile();
	            FileWriter fileWriter = new FileWriter(file);
	            fileWriter.write(anterior+nombre + "\n" +nombre + "\n" + presentacion + "\n" + composicion +
	            		"\n" + compraFecha + "\n" + vencimientoFecha+ "\n");
	            
	            fileWriter.close();
	            if(fileCreated) {
	                System.out.println("=== El archivo se creo correctamente ===");
	            } else {
	                System.out.println("=== El archivo ya existe ===");
	            }
	        } catch (IOException e) {
	            System.out.println("=== Excepcion al crear el archivo " + e);
	        }
	    }
	 
	 public void createFileSoloDato(String fileName, String datos) {
	      
	        boolean fileCreated = false;
	       
	    
	        File file = new File(fileName);
	        try {
	            fileCreated = file.createNewFile();
	            FileWriter fileWriter = new FileWriter(file);
	            fileWriter.write(datos);
	            
	            fileWriter.close();
	            if(fileCreated) {
	                System.out.println("=== El archivo se creo correctamente ===");
	            } else {
	                System.out.println("=== El archivo ya existe ===");
	            }
	        } catch (IOException e) {
	            System.out.println("=== Excepcion al crear el archivo " + e);
	        }
	    }


	    public String readFile(String fileName) {
	        System.out.println("=== Leyendo el archivo " + fileName + " ===");
	        File file = new File(fileName);
	        String data = "no existe ";
	        String anterior="";
	        try {
	            Scanner sc = new Scanner(file);
	            
	            while (sc.hasNextLine()) {
	                data = sc.nextLine();
	            
	                anterior = anterior + data+"\n";
	                
	                System.out.println(data);
	            }
	            
	            sc.close();
	        } catch (FileNotFoundException e) {
	            System.out.println(" === Hubo un error al abrir el archivo " + e);
	        }
	       
			return anterior;
	    }

	    
	    public void deleteFile(String codigo) {
	        System.out.println("=== Borrando el archivo " + codigo + " ===");
	        File file = new File(codigo);
	        if (file.delete()) {
	            System.out.println("=== El archivo se borro correctamente ===");
	        } else {
	            System.out.println("=== No se pudo borrar el archivo ===");
	        }
	    }
	    
	  
	    
	    public void actualizarSoloDato(String fileName,String datos) {
	    	String anterior=this.readFile(fileName);
	       this.deleteFile(fileName);
	       this.createFile1(fileName, datos, anterior);
	    }
	    
	    public void actualizarConNuevoDato(String fileName,String datos) {
	       this.deleteFile(fileName);
	       this.createFileSoloDato(fileName, datos);
	    }
	    
	    public void createFile1(String fileName, String datos, String anterior) {
	    	
	    	if(anterior.equals(null)) {
	        	anterior="";
	        } 
	        boolean fileCreated = false;
	    
	        File file = new File(fileName);
	        try {
	            fileCreated = file.createNewFile();
	            FileWriter fileWriter = new FileWriter(file);
	            fileWriter.write(anterior+datos);
	            fileWriter.close();
	            if(fileCreated) {
	                System.out.println("=== El archivo se creo correctamente ===");
	            } else {
	                System.out.println("=== El archivo ya existe ===");
	            }
	        } catch (IOException e) {
	            System.out.println("=== Excepcion al crear el archivo " + e);
	        }
	    }
	    
	    
	    public void createFile2(String fileName, String datos, String anterior) {
	    	
	    	if(anterior.equals(null)) {
	        	anterior="";
	        } 
	        boolean fileCreated = false;
	    
	        File file = new File(fileName);
	        try {
	            fileCreated = file.createNewFile();
	            FileWriter fileWriter = new FileWriter(file);
	            fileWriter.write(datos+anterior);
	            fileWriter.close();
	            if(fileCreated) {
	                System.out.println("=== El archivo se creo correctamente ===");
	            } else {
	                System.out.println("=== El archivo ya existe ===");
	            }
	        } catch (IOException e) {
	            System.out.println("=== Excepcion al crear el archivo " + e);
	        }
	    }

	    
	    
	  

	    public Cola actualizarCola(String fileName, Cola cola) {
	    	
	    	String nombre;
	    	String presentacion;
	    	String composicion;
	    	String vence;
	    	String compra;
	    	
	        System.out.println("===Actualizando Cola " + fileName + " ===");
	        File file = new File(fileName);
	        String data = "no existe ";
	       
	        try {
	            Scanner sc = new Scanner(file);
	            
	            while (sc.hasNextLine()) {
	                data = sc.nextLine();
	                // && sc.hasNextLine() && !sc.nextLine().equals("") 
	                if(data.equals("")) {
	                	nombre = sc.nextLine();
	                	presentacion = sc.nextLine();
	                	composicion = sc.nextLine();
	                	vence = sc.nextLine();
	                	compra = sc.nextLine();
	                	
	                	cola.encolar(nombre, presentacion, composicion, compra, vence,true);
	                }
	                
	            }
	            
	            sc.close();
	        } catch (FileNotFoundException e) {
	            System.out.println(" === Hubo un error al abrir el archivo " + e);
	        }
	       
			return cola;
	    }
	    
	    
	    public Pila actualizarPila(String fileName ) {
	    	Cola cola = new Cola();
	    	Pila pila =new Pila();
	    	String nombre;
	    	String presentacion;
	    	String composicion;
	    	String vence;
	    	String compra;
	    	
	        System.out.println("===Actualizando Pila " + fileName + " ===");
	        File file = new File(fileName);
	        String data = "no existe ";
	        
	        try {
	            Scanner sc = new Scanner(file);
	            
	            while (sc.hasNextLine()) {
	                data = sc.nextLine();
	                
	                if(data.equals("")) {
	                	nombre = sc.nextLine();
	                	presentacion = sc.nextLine();
	                	composicion = sc.nextLine();
	                	vence = sc.nextLine();
	                	compra = sc.nextLine();
	                	
	                	pila.apilar(nombre, presentacion, composicion, compra, vence, true);
	                	cola.encolar(nombre, presentacion, composicion, compra, vence, true);
	                }
	                
	            }
	            
	            sc.close();
	        } catch (FileNotFoundException e) {
	            System.out.println(" === Hubo un error al abrir el archivo " + e);
	        }
	       
			return pila.convertirPila(pila);
	    }
	    
	    
	    

}
