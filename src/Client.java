public class Client {
	private String nom;
	private String prenom;
	private String adresse;
	private String dateDeNaissance;
	private String numTel;
	CompteEnBanque compteEpargne;
	CompteEnBanque compteCourant;

	public Client(String nom, String prenom, String adresse,
			String dateDeNaissance, String numTel,
			CompteEnBanque compteEpargne, CompteEnBanque compteCourant) {
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.dateDeNaissance = dateDeNaissance;
		this.numTel = numTel;
		this.compteCourant = compteCourant;
		this.compteEpargne = compteEpargne;
	}

	// GETTER SETTER
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getDateDeNaissance() {
		return dateDeNaissance;
	}

	public void setDateDeNaissance(String dateDeNaissance) {
		this.dateDeNaissance = dateDeNaissance;
	}

	public String getNumTel() {
		return numTel;
	}

	public void setNumeroTel(String numTel) {
		this.numTel = numTel;
	}

	public CompteEnBanque getCompteCourant() {
		return compteCourant;
	}

	public void setCompteCourant(CompteCourant compteCourant) {
		this.compteCourant = compteCourant;
	}

	public CompteEnBanque getCompteEpargne() {
		return compteEpargne;
	}

	public void setCompteEpargne(CompteEpargne compteEpargne) {
		this.compteEpargne = compteEpargne;
	}

	public boolean estEgalA(Client client) {

		if (this.nom == client.getNom() && this.prenom == client.getPrenom())
			return true;

		return false;
	}

	@Override
	public String toString() {
		return "Client : " + getNom() +" "+ getPrenom() + ", adresse : " + getAdresse()+
				", date de naissance : " + getDateDeNaissance() + " et son num de tel " + getNumTel()
				+ " Compte Courant : " + getCompteCourant() + ", Compte Epargne : " + getCompteEpargne();
	}
}