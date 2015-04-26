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
	
	private int userId;					//1
	private String fecha;			
	private int ritmoCardiaco;			//2
	private int tensionArterialMax;		//3
	private int tensionArterialMin;		//4
	private int nivelGlucosa;			//5	
	private boolean acelerometro;		//6
	private double latitud;				//7
	private double longitud;			//8
	private boolean incrGas;			//9
	private boolean incrTemperatura;	//10
	private int nivelTemperatura;		//11
	private int nivelCO2;				//12
	private int idEvento;				//13
	
	public Evento(int userId, String fecha, int ritmoCardiaco,  int tensionArterialMax,  int tensionArterialMin, int nivelGlucosa,
	boolean acelerometro, double latitud, double longitud, boolean incrGas, boolean incrTemperatura,
	int nivelTemperatura, int nivelCO2, int idEvento){
		this.setUserId(userId);
		this.setAcelerometro(acelerometro);
		this.setFecha(fecha);
		
		this.setIncrGas(incrGas);

		this.setIncrTemperatura(incrTemperatura);
		this.setLatitud(latitud);
		this.setLongitud(longitud);
		this.setNivelCO2(nivelCO2);
		this.setNivelGlucosa(nivelGlucosa);
		
		this.setNivelTemperatura(nivelTemperatura);
		this.setRitmoCardiaco(ritmoCardiaco);
		this.setTensionArterialMax(tensionArterialMax);
		this.setTensionArterialMin(tensionArterialMin);
		this.setIdEvento(idEvento);
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

	

	public int getTensionArterialMax() {
		return tensionArterialMax;
	}

	public void setTensionArterialMax(int tensionArterialMax) {
		this.tensionArterialMax = tensionArterialMax;
	}

	public int getTensionArterialMin() {
		return tensionArterialMin;
	}

	public void setTensionArterialMin(int tensionArterialMin) {
		this.tensionArterialMin = tensionArterialMin;
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


	public int getNivelCO2() {
		return nivelCO2;
	}

	public void setNivelCO2(int nivelCO2) {
		this.nivelCO2 = nivelCO2;
	}
	
	public int getIdEvento() {
		return idEvento;
	}

	public void setIdEvento(int idEvento) {
		this.idEvento = idEvento;
	}
	
	
}
