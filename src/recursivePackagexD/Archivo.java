package recursivePackagexD;

import java.util.ArrayList;

public class Archivo {
	
	private String nombre, extension;
	private int tama�o;
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

	public int getTama�o() {
		return tama�o;
	}

	public void setTama�o(int tama�o) {
		this.tama�o = tama�o;
	}

	public Archivo(String nombre, String extension, int tama�o) {
		
		this.nombre = nombre;
		this.extension = extension;
		this.tama�o = tama�o;
		
	}
	
	

}
