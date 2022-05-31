package application;

import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class ControllerApplication implements Initializable {

	@FXML
	private TextField nom;

	@FXML
	private TextField Mat;

	@FXML
	private TextField email;

	@FXML
	private TextField Rec;

	@FXML
	private TextField Vent;

	@FXML
	private TextField Sal;

	@FXML
	private Button Ajout;

	@FXML
	private Button Modif;

	@FXML
	private Button Supp;

	@FXML
	private Button Lister;

	@FXML
	private RadioButton employee;

	@FXML
	private RadioButton vandeur;

	@FXML
	private TableView<Salarié> table;

	@FXML
	private TableColumn<Salarié, Integer> matc;

	@FXML
	private TableColumn<Salarié, String> nomc;

	@FXML
	private TableColumn<Salarié, String> emailc;

	@FXML
	private TableColumn<Salarié, String> type;

	@FXML
	private TableColumn<Salarié, Double> Salc;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		matc.setCellValueFactory(new PropertyValueFactory<>("Matricule"));

		nomc.setCellValueFactory(new PropertyValueFactory<>("Nom"));

		emailc.setCellValueFactory(new PropertyValueFactory<>("Email"));

		Salc.setCellValueFactory(new PropertyValueFactory<>("salaire"));

		type.setCellValueFactory(new PropertyValueFactory<>("cat"));

	}

	
	/////ajouter entreprise ///////////////////////////
	
	public boolean AjouterE(Entreprise e) {
		try {
			Statement st = connexion.getCon().createStatement();
			int res = st.executeUpdate("INSERT INTO entreprise(nom)VALUES('" + e.getNomE() + "')");
			if (res != 0) {
				System.out.println("1 ligne ajouter");
				return true;
			}
		} catch (SQLException exp) {
			// TODO Auto-generated catch block
			exp.printStackTrace();
		}
		return false;
	}
	
	
	
	///////////////////////////////////supprmier employee///////////////////////////////
	

	public boolean SupprimerE(Entreprise e) {
		try {
			PreparedStatement pst = connexion.getCon().prepareStatement("DELETE  FROM entreprise WHERE ident=?");
			pst.setLong(1, e.getIdE());
			int res = pst.executeUpdate();
			if (res != 0) {
				System.out.println("1 ligne supprimer");
				return true;
			}
		} catch (SQLException exp) {
			// TODO Auto-generated catch block
			exp.printStackTrace();
		}
		return false;
	}

	
	////////////////////////modifier entreprise///////////////////////////
	
	
	
	public boolean ModifE(Entreprise e) {
		try {
			PreparedStatement statement = connexion.getCon()
					.prepareStatement("update Entreprise set nom ='eya'  where ident = 1");

			// statement.setString(3, e.getNomE());

			statement.executeUpdate();
			System.out.println("1 ligne Modifier");

			return true;
		} catch (SQLException ex) {
			System.out.println("Erreur");
		}
		return false;
	}

	/////////////////////// crud Employes///////////// ///////////////////////////////////////////
	//////////////////ajouter employees/////////////////////
	public boolean AjouterEmp(Employes emp) {
		try {
			Statement st = connexion.getCon().createStatement();
			int res = st
					.executeUpdate("INSERT INTO Employes(Recrutement,Matricule,Nom,Email,salaire,Hsupp,PHsupp)VALUES('"
							+ emp.getRecrutement() + "','" + emp.getMatricule() + "','" + emp.getNom() + "','"
							+ emp.getEmail() + "','" + emp.getSalaire() + "','" + emp.getHsupp() + "','"
							+ emp.getPHsupp() + "')");
			if (res != 0) {
				System.out.println("1 ligne ajouter dun employee");
				return true;
			}
		} catch (SQLException exp) {
			// TODO Auto-generated catch block
			exp.printStackTrace();
		}
		return false;
	}

	
	//////////////supprimer employees///////////////////////////////
	public boolean SupprimerEmp(int e) {
		try {
			PreparedStatement pst = connexion.getCon().prepareStatement("DELETE  FROM employes WHERE Matricule=?");
			pst.setLong(1, e);
			int res = pst.executeUpdate();
			if (res != 0) {
				System.out.println("Un employe supprimer");
				return true;
			}
		} catch (SQLException exp) {
			// TODO Auto-generated catch block
			exp.printStackTrace();
		}
		return false;

	}
	
	////////////////////modifier employees///////////////////////
	

	public boolean ModifEmp(Employes emp) {
		try {
			PreparedStatement statement = connexion.getCon()
					.prepareStatement("update Employes set nom ='Ibtihel'  where Matricule = 11");

			// statement.setString(3, e.getNomE());

			statement.executeUpdate();
			System.out.println("1 ligne Modifier dun salarié");

			return true;
		} catch (SQLException ex) {
			System.out.println("Erreur");
		}
		return false;
	}

	/////////////////////// crud Vendeur ///////////////////////////////////////////
	//////////////////ajouter vendeur///////////////////////////////////////
	
	public boolean AjouterV(Vendeur s) {
		try {
			Statement st = connexion.getCon().createStatement();
			if(s.getRecrutement() > 2005) {
				s.setSalaire(280);
			} else {
				s.setSalaire(400);
			}
			int res = st.executeUpdate(
					"INSERT INTO Vendeur(Recrutement,Matricule,Nom,Email,salaire,vente,pourcentage)VALUES('"
							+ s.getRecrutement() + "','" + s.getMatricule() + "','" + s.getNom() + "','" + s.getEmail()
							+ "','" + s.getSalaire() + "','" + s.getVente() + "','" + s.getPourcentage() + "')");
			if (res != 0) {
				System.out.println("1 ajout dun vendeur");
				return true;
			}
		} catch (SQLException exp) {
			// TODO Auto-generated catch block
			exp.printStackTrace();
		}
		return false;
	}

	
	
	///////////////////////////////////supprimer vendeur /////////////////////////////////
	
	public boolean SupprimerV(int s) {
		try {
			PreparedStatement pst = connexion.getCon().prepareStatement("DELETE  FROM Vendeur WHERE Matricule=?");
			pst.setLong(1, s);
			int res = pst.executeUpdate();
			if (res != 0) {
				System.out.println("Un Vendeur supprimer");
				return true;
			}
		} catch (SQLException exp) {
			// TODO Auto-generated catch block
			exp.printStackTrace();
		}
		return false;
	}

	
	
	
	//////////////////////ajouter un salarie//////////////////////////////////////////
	

	public boolean AjouterS(Salarié emp) {
		try {
			Statement st = connexion.getCon().createStatement();
			int res = st.executeUpdate("INSERT INTO salarié(Recrutement,Matricule,Nom,Email,salaire,cat)VALUES('"
					+ emp.getRecrutement() + "','" + emp.getMatricule() + "','" + emp.getNom() + "','" + emp.getEmail()
					+ "','" + emp.getSalaire() + "','" + emp.getCat() + "')");
			if (res != 0) {
				System.out.println("1 ligne ajouter dun salarié");
				return true;
			}
		} catch (SQLException exp) {
			// TODO Auto-generated catch block
			exp.printStackTrace();
		}
		return false;
	}
	
	
	///////////////modifier un salarié////////////////////////
	
	 public boolean ModifS(Salarié s){
		  try { 
		  PreparedStatement statement =
	  connexion.getCon().
	  prepareStatement("update Salarié set nom ='Ibtihel'  where Matricule = 1");
	  statement.executeUpdate();
	  System.out.println("1 ligne Modifier dun salarié");
	  
	  return true; } catch (SQLException ex) { System.out.println("Erreur"); }
	  return false; }
	 
	
	///////////////////////////supprimer salarié////////////////////////////////

	public boolean SupprimerS(int id) {
		try {
			PreparedStatement pst = connexion.getCon().prepareStatement("DELETE  FROM Salarié WHERE Matricule=?");
			pst.setLong(1, id);
			int res = pst.executeUpdate();
			if (res != 0) {
				System.out.println("Un Vendeur salarié");
				return true;
			}
		} catch (SQLException exp) {
			// TODO Auto-generated catch block
			exp.printStackTrace();
		}
		return false;
	}
	
	
	/////////////////////////// function addSalarie dun javafx sur la bouton ajouter///////////////
	

	public void AddSalarie() {
		double salar;
		if(Double.parseDouble(Rec.getText()) > 2005) {
			salar= 280;
		} else {
			salar=400;
		}//if le salarié est un employees on ajouter un salarié (employe)
		if (employee.isSelected()) {
			Employes emp = new Employes(Double.parseDouble(Rec.getText()), Integer.parseInt(Mat.getText()),
					nom.getText(), email.getText(), salar, "Employe", Double.parseDouble(Vent.getText()),
					Double.parseDouble(Sal.getText()));
			Salarié s = new Salarié(Double.parseDouble(Rec.getText()), Integer.parseInt(Mat.getText()), nom.getText(),
					email.getText(), salar, "Employe");
			//ajouter un salarié (employe)
			AjouterS(s);
			AjouterEmp(emp);
			table.getItems().add(s);
			
		//if le salarié est un vendeur on ajouter un salarié (vendeur)

		} else if (vandeur.isSelected()) {
			Vendeur ven = new Vendeur(Double.parseDouble(Rec.getText()), Integer.parseInt(Mat.getText()), nom.getText(),
					email.getText(), salar, "Vendeur", Double.parseDouble(Vent.getText()),
					Double.parseDouble(Sal.getText()));
			Salarié s1 = new Salarié(Double.parseDouble(Rec.getText()), Integer.parseInt(Mat.getText()), nom.getText(),
					email.getText(), salar, "Vendeur");
			//ajouter un salarié (vendeur)

			AjouterS(s1);
			AjouterV(ven);
			table.getItems().add(s1);

		}
	}

	
	/////////////////////////////function suppsalairie dun javafx sur la bouton supprimer////////////////////
	
	public void SuppSalarie() {

		if (table.getSelectionModel().getSelectedItem().getCat().equals("Vendeur")) {
			
			SupprimerV(table.getSelectionModel().getSelectedItem().getMatricule());
			table.getItems().remove(table.getSelectionModel().getSelectedItem());
			SupprimerS(table.getSelectionModel().getSelectedItem().getMatricule());
		} else {
			SupprimerEmp(table.getSelectionModel().getSelectedItem().getMatricule());
			table.getItems().remove(table.getSelectionModel().getSelectedItem());
			SupprimerS(table.getSelectionModel().getSelectedItem().getMatricule());
		}
	}

	/////////////////////////////// liste des salarier ////////////////////////////
	
	
	///////////////////////lister les vendeur////////////////////////////////
	

	public List<Salarié> listerVendeur() {
		List<Salarié> s = new ArrayList<>();
		try {
			Statement st = connexion.getCon().createStatement();

			String reqV = "SELECT  Recrutement , Matricule, Nom, Email, (salaire + Vente * Pourcentage)"
					+ " as salaireTotal from  Vendeur;";
			ResultSet req = st.executeQuery(reqV);

			while (req.next()) {
				s.add(new Salarié(req.getDouble(1), req.getInt(2), req.getString(3), req.getString(4), req.getDouble(5),
						"Vendeur"));

			}
			return s;
		} catch (SQLException ex) {
			System.out.println("Erreur SQL" + ex);
		}

		return null;

	}

	/////////////////////lister les employees/////////////////////////////

	public List<Salarié> listerEmployes() {
		List<Salarié> s = new ArrayList<>();
		try {
			Statement st = connexion.getCon().createStatement();

			String reqV = "SELECT  Recrutement , Matricule, Nom, Email," + " (salaire + Hsupp * PHsupp)"
					+ " as salaireTotal from  Employes;";
			ResultSet req = st.executeQuery(reqV);

			while (req.next()) {
				s.add(new Salarié(req.getDouble(1), req.getInt(2), req.getString(3), req.getString(4), req.getDouble(5),
						"Employes"));

			}
			return s;
		} catch (SQLException ex) {
			System.out.println("Erreur SQL" + ex);
		}

		return null;

	}
	
	
	/////////////////////////////lister tous les salariés/////////////////////////////////

	public void Lister() {
		table.getItems().clear();
		table.getItems().addAll(listerEmployes());
		table.getItems().addAll(listerVendeur());
	}
///////////////////test/////////////////////////
	/*
	 * public static void main(String args[]) { ControllerApplication c=new
	 * ControllerApplication(); List<Salarié> s = c.listerEmployes(); for (Salarié
	 * x:s) System.out.println(x.toString()); }
	 */

}
