package application;

import application.Salarié;

public class Salarié implements  Comparable<Salarié>  {
	protected Double Recrutement;
	protected int Matricule;
	protected String Nom;
	protected String Email;
	protected double salaire;
	protected String cat;
	public Double getRecrutement() {
		return Recrutement;
	}
	public void setRecrutement(Double recrutement) {
		Recrutement = recrutement;
	}
	public int getMatricule() {
		return Matricule;
	}
	
	
	public String getCat() {
		return cat;
	}
	public void setCat(String cat) {
		this.cat = cat;
	}
	public void setMatricule(int matricule) {
		Matricule = matricule;
	}
	public String getNom() {
		return Nom;
	}
	public void setNom(String nom) {
		Nom = nom;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	

	public double getSalaire() {
		return salaire;
	}
	public void setSalaire(double salaire) {
		this.salaire = salaire;
	}
	
	public Salarié(Double recrutement, int matricule, String nom, String email, double salaire,String cat) {
		super();
		Recrutement = recrutement;
		Matricule = matricule;
		Nom = nom;
		Email = email;
		this.salaire = salaire;
		this.cat=cat;
	}
	
	@Override
	public String toString() {
		return "Salarié [Recrutement=" + Recrutement + ", Matricule=" + Matricule + ", Nom=" + Nom + ", Email=" + Email
				+ ", salaire=" + salaire + ", cat" + cat + "]";
	}
	
	public void setSalaireF(Double salaire) {
		if (this.getRecrutement()<=2005) {
			this.salaire = 400;
		}else {
			this.salaire = 280;
		}
	}


	@Override
	public int compareTo(Salarié o) {
		 if(this.getSalaire() ==o.getSalaire()) return 0;
	        else if (this.getSalaire()>o.getSalaire()) return 1;
	        else return -1;
	}
}
	



