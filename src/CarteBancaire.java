

public class CarteBancaire{

	private Client titulaire;

	public CarteBancaire(Client titulaire) {
		this.titulaire = titulaire;
	}

	public void payer(CompteEnBanque compte, int montant)
			throws ArgumentInvalideException {

		if (compte == null)
			throw new IllegalArgumentException();
		if (compte.isCloture())
			throw new IllegalArgumentException();
		if (titulaire.getCompteCourant().isCloture())
			throw new IllegalArgumentException();
		if (montant <= 0)
			throw new IllegalArgumentException();
		if (titulaire.compteCourant.getSolde() - montant < getTitulaire().compteCourant
				.getDecouvertMaxAut() * -1)
			throw new UnsupportedOperationException();

		try {
			compte.deposer(montant);
			titulaire.compteCourant.retirer(montant);

		} catch (ArgumentInvalideException e) {

		}

	}

	public String toString() {

		return "La carte de" + titulaire;

	}

	public Client getTitulaire() {
		return titulaire;
	}


}
