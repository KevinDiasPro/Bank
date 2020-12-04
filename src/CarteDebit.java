public class CarteDebit extends CarteBancaire {

	private int numOperation = 0;

	public CarteDebit(Client titulaire) {
		super(titulaire);
	}

	public void payer(CompteEnBanque compte, double montant) {

		if (compte == null)
			throw new IllegalArgumentException();
		if (compte.isCloture())
			throw new IllegalArgumentException();
		if (getTitulaire().getCompteCourant().isCloture())
			throw new IllegalArgumentException();
		if (montant <= 0)
			throw new IllegalArgumentException();
		if (getTitulaire().compteCourant.getSolde() - montant < getTitulaire().compteCourant
				.getDecouvertMaxAut() * -1)
			throw new UnsupportedOperationException();

		try {
			compte.deposer(montant);
			getTitulaire().compteCourant.retirer(montant);
			numOperation++;
		} catch (ArgumentInvalideException e) {
		}
	}

	public String toString() {

		return "Carte de débit de" + getTitulaire();
	}

}
