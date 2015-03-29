package es.upm.dit.isst.tacc.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Evento implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private int userId;
	private String fecha;
	private int ritmoCardiaco;
	private int IMC;
	private int tensionArterial;
	private int nivelGlucosa;
	private boolean acelerometro;
	private double latitud;
	private double longitud;
	private boolean incrGas;
	private boolean incrHumedad;
	private boolean incrTemperatura;
	private int nivelTemperatura;
	private int nivelHumedad;
	private int nivelCO2;
	
	public Evento(int userId, String fecha, int ritmoCardiaco, int IMC, int tensionArterial, int nivelGlucosa,
	boolean acelerometro, double latitud, double longitud, boolean incrGas, boolean incrHumedad, boolean incrTemperatura,
	int nivelTemperatura, int nivelHumedad, int nivelCO2){
		this.setUserId(userId);
		this.setAcelerometro(acelerometro);
		this.setFecha(fecha);
		this.setIMC(IMC);
		this.setIncrGas(incrGas);
		this.setIncrHumedad(incrHumedad);
		this.setIncrTemperatura(incrTemperatura);
		this.setLatitud(latitud);
		this.setLongitud(longitud);
		this.setNivelCO2(nivelCO2);
		this.setNivelGlucosa(nivelGlucosa);
		this.setNivelHumedad(nivelHumedad);
		this.setNivelTemperatura(nivelTemperatura);
		this.setRitmoCardiaco(ritmoCardiaco);
		this.setTensionArterial(tensionArterial);
	}
	
	public Long getId() {
		return id;
	}
	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public int getRitmoCardiaco() {
		return ritmoCardiaco;
	}

	public void setRitmoCardiaco(int ritmoCardiaco) {
		this.ritmoCardiaco = ritmoCardiaco;
	}

	public int getIMC() {
		return IMC;
	}

	public void setIMC(int iMC) {
		IMC = iMC;
	}

	public int getTensionArterial() {
		return tensionArterial;
	}

	public void setTensionArterial(int tensionArterial) {
		this.tensionArterial = tensionArterial;
	}

	public int getNivelGlucosa() {
		return nivelGlucosa;
	}

	public void setNivelGlucosa(int nivelGlucosa) {
		this.nivelGlucosa = nivelGlucosa;
	}

	public boolean isAcelerometro() {
		return acelerometro;
	}

	public void setAcelerometro(boolean acelerometro) {
		this.acelerometro = acelerometro;
	}

	public double getLatitud() {
		return latitud;
	}

	public void setLatitud(double latitud) {
		this.latitud = latitud;
	}

	public double getLongitud() {
		return longitud;
	}

	public void setLongitud(double longitud) {
		this.longitud = longitud;
	}

	public boolean isIncrGas() {
		return incrGas;
	}

	public void setIncrGas(boolean incrGas) {
		this.incrGas = incrGas;
	}

	public boolean isIncrHumedad() {
		return incrHumedad;
	}

	public void setIncrHumedad(boolean incrHumedad) {
		this.incrHumedad = incrHumedad;
	}

	public boolean isIncrTemperatura() {
		return incrTemperatura;
	}

	public void setIncrTemperatura(boolean incrTemperatura) {
		this.incrTemperatura = incrTemperatura;
	}

	public int getNivelTemperatura() {
		return nivelTemperatura;
	}

	public void setNivelTemperatura(int nivelTemperatura) {
		this.nivelTemperatura = nivelTemperatura;
	}

	public int getNivelHumedad() {
		return nivelHumedad;
	}

	public void setNivelHumedad(int nivelHumedad) {
		this.nivelHumedad = nivelHumedad;
	}

	public int getNivelCO2() {
		return nivelCO2;
	}

	public void setNivelCO2(int nivelCO2) {
		this.nivelCO2 = nivelCO2;
	}
	
}
