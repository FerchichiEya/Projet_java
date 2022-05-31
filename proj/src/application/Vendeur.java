package application;

public class Vendeur extends Salarié {
	private Double Vente;
	private Double Pourcentage;
	
	
	

	

	
	public Vendeur(Double recrutement, int matricule, String nom, String email, double salaire, String cat,
			Double vente, Double pourcentage) {
		super(recrutement, matricule, nom, email, salaire, cat);
		Vente = vente;
		Pourcentage = pourcentage;
	}



	public void setSalaire () {
		if (this.getRecrutement()<=2005) {
			this.salaire = 400 + this.Pourcentage;
		}else {
			this.salaire = 280 + this.Pourcentage;
		}
	}
	
	
	
	public Double getVente() {
		return Vente;
	}
	public void setVente(Double vente) {
		Vente = vente;
	}
	public Double getPourcentage() {
		return Pourcentage;
	}
	public void setPourcentage(Double pourcentage) {
		Pourcentage = pourcentage;
	}



	@Override
	public String toString() {
		return "Vendeur [Vente=" + Vente + ", Pourcentage=" + Pourcentage + "]";
	}



	

}

