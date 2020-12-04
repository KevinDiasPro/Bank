public class CompteEpargne implements CompteEnBanque{

	private double solde;
	private int numero;
	private static final double DECOUVERT_MAX_AUT = 0;
	private boolean cloture;
	private Client titulaire;
	private int numOperation = 0;
	

	public CompteEpargne(double solde, int numero, boolean cloture) {
		this.solde = 0;
		this.numero = numero;
		this.cloture = false;
	}

	public double getSolde() {
		return solde;
	}

	public int getNumero() {
		return numero;
	}

	

	public boolean isCloture() {
		return cloture;
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
		if (this.solde <= DECOUVERT_MAX_AUT)
			throw new DecouvertMaximumAtteintException(
					"Vous ne pouvez plus retirer solde insuffisant");
		if (this.isCloture())
			throw new CompteCloturerException("Le compte est cloturer");
		if (solde - montant < DECOUVERT_MAX_AUT)
			throw new DecouvertMaximumAtteintException(
					"Le découvert max a été dépassé");

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
	
	public void faireDesVirements(double montant, CompteEnBanque compte)
			throws ArgumentInvalideException {

		if(montant <= 0) throw new ArgumentInvalideException("Le montant ne peut pas être négatif");
		if(solde <= DECOUVERT_MAX_AUT) throw new ArgumentInvalideException("Vous ne pouvez plus retirer solde insuffisant");
		if(solde - montant < DECOUVERT_MAX_AUT) throw new ArgumentInvalideException("Le découvert max a été dépassé");	
		if(!compte.equals(titulaire.compteCourant)) throw new ArgumentInvalideException("Le virement ne se fait que vers le compte courant du titulaire de ce compte");
		
		compte.deposer(montant);
		this.retirer(montant);
		numOperation++;

	}

	@Override
	public String toString() {
		return "CompteEpargne [numero=" + numero + ", cloture=" + cloture + "]";
	}
	

			@Override
			public int compareTo(CompteEnBanque o) {
				return (int) (this.numero - o.getNumero());
			}


			@Override
			public double getDecouvertMaxAut() {
					return DECOUVERT_MAX_AUT;
				}

			@Override
			public void setCloture(boolean cloture) {
				this.cloture=cloture;
				
			}


}
