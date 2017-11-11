package recursivePackagexD;

public class Calculos_Matematicos {
	
	  public static int calculadora(int x,int y, int z){
	       if(z == 0){
	           return x;
	       }
	       if(y == 0){
	           return calculadora(z,y,x%z);
	       }
	       else{
	           return calculadora(y,x%y,z);
	       }
	    }
	
	public static void main(String[] args){
		
		int y = calculadora(89 , 55, 34);
		
		System.out.println(y);
		
		
		
	}
}
