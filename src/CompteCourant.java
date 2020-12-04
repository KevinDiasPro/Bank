public class CompteCourant implements CompteEnBanque{

	private int numero;
	private double solde;
	private double decouvertMaxAut;
	private boolean cloture;
	private Client titulaire;
	
	private int numOperation = 0;

	public CompteCourant(int numero, double solde, double decouvertMax,
			boolean cloture) {
		this.numero = numero;
		this.solde = solde;
		this.decouvertMaxAut = decouvertMaxAut;
		this.cloture = false;

	}

	public void deposer(double montant) throws ArgumentInvalideException {
		if (montant <= 0)
			throw new ArgumentInvalideException(
					"Le montant ne peut pas être négatif");
		if (this.isCloture())
			throw new CompteCloturerException("Le compte est cloturé");
		solde += montant;
		numOperation++;
	}

	public void retirer(double montant) throws ArgumentInvalideException {

		if (montant <= 0)
			throw new ArgumentInvalideException(
					"Le montant ne peut pas être négatif");
		if (this.solde <= decouvertMaxAut)
			throw new DecouvertMaximumAtteintException(
					"Vous ne pouvez plus retirer solde insuffisant");
		if (this.isCloture())
			throw new CompteCloturerException("Le compte est cloturer");
		solde -= montant;
		numOperation++;

	}

	public boolean estEgalA(double montant) throws ArgumentInvalideException {

		if (montant <= 0)
			throw new ArgumentInvalideException(
					"Le montant ne peut pas être négatif");
		if (this.solde != montant)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CompteCourant [numero=" + numero + ", solde=" + solde
				+ ", decouvertMaxAut=" + decouvertMaxAut + ", cloture="
				+ cloture + "]";
	}

	public void faireDesVirements(double montant, CompteEnBanque compte)
			throws ArgumentInvalideException {

		if (montant <= 0)
			throw new ArgumentInvalideException(
					"Le montant ne peut pas être négatif");
		if (solde <= decouvertMaxAut)
			throw new ArgumentInvalideException(
					"Vous ne pouvez plus retirer solde insuffisant");
		if (this.isCloture())
			throw new ArgumentInvalideException("Le compte est cloturer");
		if (solde - montant < decouvertMaxAut * -1)
			throw new ArgumentInvalideException(
					"Le découvert max a été dépassé");

		compte.deposer(montant);
		this.retirer(montant);

		numOperation++;

	}

	// GETTER ET SETTER
	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public double getSolde() {
		return solde;
	}

	public void setSolde(double solde) {
		this.solde = solde;
	}

	public double getDecouvertMaxAut() {
		return decouvertMaxAut;
	}

	public void setDecouvertMaxAut(int decouvertMaxAut) {
		this.decouvertMaxAut = decouvertMaxAut;
	}

	public boolean isCloture() {
		return cloture;
	}

	public void setCloture(boolean cloture) {
		this.cloture = cloture;
	}
	
	// CompareTo

	@Override
	public int compareTo(CompteEnBanque o) {
		return (int) (this.numero - o.getNumero());
		
	}
}
