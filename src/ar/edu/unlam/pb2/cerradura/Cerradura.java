package ar.edu.unlam.pb2.cerradura;

public class Cerradura {
	
	private Integer claveDeApertura;
	private Integer cantidadDeFallosConsecutivosQueLaBloquean;
	
	private Boolean cerraduraAbierta = false;
	private Boolean cerraduraBloqueada = false;
	
	private Integer cantidadDeIngresosDeClaveErronea = 0;
	private Integer aperturaExitosa = 0;
	
	
	
	public Cerradura(Integer claveDeApertura, Integer cantidadDeFallosConsecutivosQueLaBloquean){
		this.claveDeApertura = claveDeApertura;
		this.cantidadDeFallosConsecutivosQueLaBloquean = cantidadDeFallosConsecutivosQueLaBloquean;
		
	}
	
	
	public Boolean abrir(Integer clave) {
		if(cerraduraAbierta==false) {
			if(cantidadDeIngresosDeClaveErronea.compareTo(cantidadDeFallosConsecutivosQueLaBloquean)<0 && claveDeApertura.compareTo(clave)==0) {
					cerraduraAbierta = true;
					aperturaExitosa++;
					//Agregar el reseteo de cantidadDeIngresosDeClaveErronea = 0;
					cantidadDeIngresosDeClaveErronea = 0; //Reseteo del contador de ingresos erróneos de la clave
			}
			else {
				cantidadDeIngresosDeClaveErronea++;
			}
			if(fueBloqueada()==true) {
				
			}
		}
		return cerraduraAbierta;
		
	}
	
	
	public void cerrar() {
		if(cerraduraAbierta == true) {
			cerraduraAbierta = false;
		}
		
	}
	
	
	public Boolean estaAbierta() {
		if(cerraduraAbierta==true) {
			return true;
		}
		return false;
		
	}
	
	
	public Boolean estaCerrada() {
		if(estaAbierta()==false) {
			return true;
		}
		return false;
	}
	
	
	public Boolean fueBloqueada() {
		if(cantidadDeIngresosDeClaveErronea.compareTo(cantidadDeFallosConsecutivosQueLaBloquean)==0) { //Cuando haga 2 intentos erroneos se bloquea
			cerraduraBloqueada = true;
		}
		return cerraduraBloqueada;
	}
	
	
	public Integer contarAperturasExitosas() {
		return aperturaExitosa;
		
	}
	
	
	public Integer contarAperturasFallidas() {
		
		return cantidadDeIngresosDeClaveErronea;
	}
	
	
	
}
