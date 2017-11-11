package recursivePackagexD;

import java.util.ArrayList;
import java.util.Scanner;

public class Carpeta {

	private String nombre;
	private int tamaño;
	private ArrayList<Carpeta> arch;
	private ArrayList<Archivo> archivos;
	
	

	public Carpeta(String nombre, int tamaño) {
		this.nombre = nombre;
		this.tamaño = tamaño;
		this.arch = new ArrayList<>();
		this.archivos = new ArrayList<>();
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public int getTamaño() {
		return tamaño;
	}
	
	public void addElement(Carpeta c){
		this.arch.add(c);
	}


	public void setTamaño(int tamaño) {
		this.tamaño = tamaño;
	}


	public ArrayList<Carpeta> getCarpeta() {
		return arch;
	}


	public void setCarpeta(ArrayList<Carpeta> carpeta) {
		this.arch = carpeta;
	}


	public ArrayList<Archivo> getArchivos() {
		return archivos;
	}


	public void setArchivos(ArrayList<Archivo> archivos) {
		this.archivos = archivos;
	}
	
	static Carpeta raiz = new Carpeta("Raiz", 200);
	
	

	public static void main(String[] args){
		raiz.getCarpeta().add(new Carpeta("Raiz", 20));
		int x = 0, j = 0, z = 0;
		String nombreCarpeta, n2, nombreArchivo;
		Scanner scn = new Scanner(System.in);
		
		do{
		System.out.print("***Menu***\n"
				+ "1. Buscar Carpeta\n"
				+ "2. Ingresar/Crear Carpetas\n"
				+ "3. Ingresar/Crear Archivos\n"
				+ "4. Salir\n"
				+ "Ingrese lo que quiere hacer: ");
		x = scn.nextInt();
		
		switch(x){
		case 1:
			System.out.println("Solo ingrese el nombre de la carpeta: ");
			nombreCarpeta = scn.next();
			Carpeta v = FolderBrowser(nombreCarpeta, raiz,0, 2091);
			if( v != null){
			for(Carpeta d : v.arch){
				System.out.println(d.nombre);
				System.out.println(d.tamaño);
			}
			}else{
				System.out.println("nelson");
			}
			
			for(Carpeta c: raiz.arch){
				System.out.println(c.getNombre());
			}
			
			break;
			
		case 2:
			
			System.out.print("Ingrese el nombre de la carpeta a buscar: ");
			nombreCarpeta = scn.next();
			
			System.out.print("Ingrese el nombre de la carpeta a crear: ");
			n2 = scn.next();
			
			System.out.print("Ingrese el tamaño de la carpeta nueva: ");
			j = scn.nextInt();
			boolean result = ingresarCarpeta(nombreCarpeta, j, n2);
			
			if(result)System.out.println("Carpeta Agregada exitosamente!");
			else System.out.println("No se encontro la carpeta que usted especifico!");
			
			break;
		
		case 3:
			
			System.out.print("Ingrese el nombre de la carpeta a buscar: ");
			nombreArchivo = scn.next();
			
			System.out.print("Ingrese el nombre del archivo a crear: ");
			n2 = scn.next();
			
			System.out.print("Ingrese el tamaño del arhivo nuevo: ");
			j = scn.nextInt();
			boolean result1 = ingresarCarpeta(nombreArchivo, j, n2);
			
			if(result1)System.out.println("Archivo Agregada exitosamente!");
			else System.out.println("No se encontro la carpeta que usted especifico!");
			
			break;
		
		case 4:
			System.out.println("Has salido del menu!");
			break;
			
		
			}
						
		}while(x != 4);
		scn.close();
	}
	
	
	
	public static Carpeta  buscarCarpeta(String nombre){
		
		for(Carpeta c : raiz.getCarpeta()){
			if(c != null){
			if(nombre.equals(c.getNombre()))
				return c;
			else return null;
			}
		}
		
		return null;
		
	}
	
	
	public static Carpeta FolderBrowser(String nombre, Carpeta carpeta, int n, int tamaño){

		if(carpeta.getNombre().equals(nombre)){
			return carpeta;
		}else{
			if(n > carpeta.getCarpeta().size()-1){
				n = 0;
				if(carpeta.getCarpeta().size() > 0){
					return FolderBrowser(nombre, carpeta.getCarpeta().get(n), n+1, tamaño);
				}else{
					carpeta.addElement(new Carpeta(nombre, tamaño));
					return null;
				}
			}
			else
				return FolderBrowser(nombre, carpeta.getCarpeta().get(n), n+1, tamaño);

		}
	}
	
	public static Archivo FileBrowser(String nombre, Archivo arch, int n, int tamaño){
		
		if (arch.getNombre().equals(nombre)) {
			return arch;
		} else {
			if (n > arch.getArch().size() - 1) {
				n = 0;
				if (arch.getArch().size() > 0) {
					return FileBrowser(nombre, arch.getArch().get(n), n + 1, tamaño);
				} else {
					arch.getArch().add(new Archivo(nombre, "random.txt", tamaño));
					return null;
				}
			} else
				return FileBrowser(nombre, arch.getArch().get(n), n + 1, tamaño);

		}
	}

	public static boolean ingresarCarpeta(String nombre, int tamaño, String nombre2){
	
		Carpeta c = FolderBrowser(nombre, raiz, 0, tamaño);
		
		if(c != null){
			c.addElement(new Carpeta(nombre, tamaño));
			return true;
			
		}else{
			Carpeta newCarpeta = new Carpeta("Piso", 200);
			return false;
		}
		
		
	}
	
	

}
