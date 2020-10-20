package ar.edu.unlam.pb2.cerradura;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class CerraduraTest {

	/*
	 * Cuando se crea una cerradura tiene que estar cerrada
	 */
	@Test
	public void queUnaCerraduraNuevaEstaCerrada(){
		//1. Preparación
		Cerradura miCerradura = new Cerradura(1234, 3);
		
		//2. Ejecución
		Boolean estadoCerradura = miCerradura.estaAbierta();
		
		//3. Contrastación
		Assert.assertFalse("", estadoCerradura);
	}
	
	
	@Test
	public void queCuandoIngresoClaveCorrectaSeAbra(){
		//preparacion
		Cerradura miCerradura = new Cerradura(4321, 2);
		
		//ejecucion
		miCerradura.abrir(4321);
		Boolean estadoCerradura = miCerradura.estaAbierta();
		
		//contrastacion
		Assert.assertTrue("", estadoCerradura);
	}
	
	
	
	@Test
	public void queCuandoIngresoClaveIncorrectaNoSeAbra(){
		//Preparacion
		Cerradura miCerradura = new Cerradura(4321, 3);
		
		//ejecucion
		miCerradura.abrir(1234);
		Boolean estadoCerradura = miCerradura.estaAbierta();
		
		//Contrastacion
		Assert.assertFalse("", estadoCerradura);
	}
	
	
	
	@Test
	public void queSePuedaCerrarLaCerradura() {
		//Preparacion
		Cerradura miCerradura = new Cerradura(563, 2);
		
		//Ejecucion
		miCerradura.abrir(563);
		miCerradura.cerrar();
		Boolean estadoCerradura = miCerradura.estaCerrada();
		
		//Contrastacion
		Assert.assertTrue("", estadoCerradura);
	}
	
	
	
	@Test 
	public void queSeBloqueeLaCerradura() {
		//Preparacion
		Cerradura miCerradura = new Cerradura(21, 2);
		
		//Ejecucion
		miCerradura.abrir(54);
		miCerradura.abrir(22); //Solo hay dos intentos para abrir la cerradura, si falla el segundo se bloquea la misma
		
		Boolean estadoCerradura = miCerradura.fueBloqueada();
		
		//Contrastacion
		Assert.assertTrue("", estadoCerradura);
	}
	
	
	@Test 
	public void queNoSePuedaAbrirUnaCerraduraBloqueada() {
		Cerradura miCerradura = new Cerradura(55, 3);
		
		miCerradura.abrir(65);
		miCerradura.abrir(65);
		miCerradura.abrir(65);//Aca se bloquea 
		miCerradura.abrir(55);//Intentamos abrir la cerradura. No debe poder abrirse si ya está bloqueada
		Boolean estadoCerradura = miCerradura.estaAbierta();
		
		assertFalse(estadoCerradura);
	}
	
	
	@Test
	public void queUnaVezAbiertaNoSePuedaBloquear() {
		Cerradura miCerradura = new Cerradura(190, 3);
		
		miCerradura.abrir(10);
		//miCerradura.abrir(35);
		miCerradura.abrir(190);//Aca se abre
		miCerradura.abrir(265);
		miCerradura.abrir(10);
		miCerradura.abrir(10);//No deberia bloquearse porque ya esta abierta
		Boolean estadoCerradura = miCerradura.fueBloqueada();
		
		assertFalse(estadoCerradura);
		
	}
	
}
