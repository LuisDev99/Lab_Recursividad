package recursivePackagexD;

import java.util.ArrayList;

public class Archivo {
	
	private String nombre, extension;
	private int tamaño;
	private ArrayList<Archivo> arch;
	
	public ArrayList<Archivo> getArch() {
		return arch;
	}



	public void setArch(ArrayList<Archivo> arch) {
		this.arch = arch;
	}



	public String getNombre() {
		return nombre;
	}
	
	

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getExtension() {
		return extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}

	public int getTamaño() {
		return tamaño;
	}

	public void setTamaño(int tamaño) {
		this.tamaño = tamaño;
	}

	public Archivo(String nombre, String extension, int tamaño) {
		
		this.nombre = nombre;
		this.extension = extension;
		this.tamaño = tamaño;
		
	}
	
	

}
