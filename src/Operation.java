
public class Operation {

	private String dateCreation;
	private double montant; 
	private int numero;
	private int type;
	private double solde;
	private static final int CREATION = 1;
	private static final int DEPOT = 2;
	private static final int RETRAIT = 3;
	private static final int VIREMENT_DONNEUR = 4;
	private static final int VIREMENT_RECEVEUR = 5;
	private static final int CLOTURE = 6;
	
	
	public Operation(String dateCreation, double montant, int numero,
			int type, double solde) {
		
		this.dateCreation = dateCreation;
		this.montant = montant;
		this.numero = numero;
		this.type = type;
		this.solde = solde;
	}
	/// GETTER & SETTER
	
	public String getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(String dateCreation) {
		this.dateCreation = dateCreation;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public double getMontant() {
		return montant;
	}
	public int getType() {
		return type;
	}
	public double getSolde() {
		return solde;
	}
	
	
}
