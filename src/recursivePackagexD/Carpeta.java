package recursivePackagexD;

import java.util.ArrayList;
import java.util.Scanner;

public class Carpeta {

	private String nombre;
	private int tama�o;
	private ArrayList<Carpeta> arch;
	private ArrayList<Archivo> archivos;
	
	

	public Carpeta(String nombre, int tama�o) {
		this.nombre = nombre;
		this.tama�o = tama�o;
		this.arch = new ArrayList<>();
		this.archivos = new ArrayList<>();
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public int getTama�o() {
		return tama�o;
	}
	
	public void addElement(Carpeta c){
		this.arch.add(c);
	}


	public void setTama�o(int tama�o) {
		this.tama�o = tama�o;
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
				System.out.println(d.tama�o);
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
			
			System.out.print("Ingrese el tama�o de la carpeta nueva: ");
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
			
			System.out.print("Ingrese el tama�o del arhivo nuevo: ");
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
	
	
	public static Carpeta FolderBrowser(String nombre, Carpeta carpeta, int n, int tama�o){

		if(carpeta.getNombre().equals(nombre)){
			return carpeta;
		}else{
			if(n > carpeta.getCarpeta().size()-1){
				n = 0;
				if(carpeta.getCarpeta().size() > 0){
					return FolderBrowser(nombre, carpeta.getCarpeta().get(n), n+1, tama�o);
				}else{
					carpeta.addElement(new Carpeta(nombre, tama�o));
					return null;
				}
			}
			else
				return FolderBrowser(nombre, carpeta.getCarpeta().get(n), n+1, tama�o);

		}
	}
	
	public static Archivo FileBrowser(String nombre, Archivo arch, int n, int tama�o){
		
		if (arch.getNombre().equals(nombre)) {
			return arch;
		} else {
			if (n > arch.getArch().size() - 1) {
				n = 0;
				if (arch.getArch().size() > 0) {
					return FileBrowser(nombre, arch.getArch().get(n), n + 1, tama�o);
				} else {
					arch.getArch().add(new Archivo(nombre, "random.txt", tama�o));
					return null;
				}
			} else
				return FileBrowser(nombre, arch.getArch().get(n), n + 1, tama�o);

		}
	}

	public static boolean ingresarCarpeta(String nombre, int tama�o, String nombre2){
	
		Carpeta c = FolderBrowser(nombre, raiz, 0, tama�o);
		
		if(c != null){
			c.addElement(new Carpeta(nombre, tama�o));
			return true;
			
		}else{
			Carpeta newCarpeta = new Carpeta("Piso", 200);
			return false;
		}
		
		
	}
	
	

}
