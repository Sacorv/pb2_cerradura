package ar.edu.unlam.pb2.cerradura;

public class PruebaCerradura {

	public static void main(String[] args) {
		Cerradura miCerradura = new Cerradura(23, 2);
		
		//System.out.println(miCerradura.abrir(23));
		
		
		//System.out.println(miCerradura.estaAbierta());
		
		System.out.println(miCerradura.abrir(15));
		System.out.println(miCerradura.abrir(21));
		//System.out.println(miCerradura.abrir(10));
		//System.out.println(miCerradura.abrir(24));
		
		
		System.out.println(miCerradura.estaAbierta());
		System.out.println(miCerradura.fueBloqueada());
		
		
		System.out.println(miCerradura.abrir(10));
		System.out.println(miCerradura.fueBloqueada());
	}

}
