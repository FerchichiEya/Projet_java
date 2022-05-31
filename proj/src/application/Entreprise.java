package application;

import java.util.*;


public class Entreprise {
	int idE;
	String nomE;
	double Salaire;
	Map<Integer, Salarié> salari;
	
	
	
	public int getIdE() {
		return idE;
	}
	public void setIdE(int idE) {
		this.idE = idE;
	}
	public String getNomE() {
		return nomE;
	}
	public void setNomE(String nomE) {
		this.nomE = nomE;
	}
	
	public double getSalaire() {
		return Salaire;
	}
	public void setSalaire(double salaire) {
		Salaire = salaire;
	}
	public Map<Integer, Salarié> getSalari() {
		return salari;
	}
	public void setSalari(Map<Integer, Salarié> salari) {
		this.salari = salari;
	}
	public Entreprise(String nomE) {
		super();
		this.nomE = nomE;
		this.salari = new HashMap<Integer,Salarié>();
	}
	public long getIdE1() {
		return idE;
	}  

}

