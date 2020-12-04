import java.util.Iterator;

public class CarteCredit extends CarteBancaire {
	private double plafond;
	HistoriqueOperations historiqueCarteCredit;
	private int numOperation = 0;

	public CarteCredit(double plafond, Client titulaire) {
		super(titulaire);
		this.plafond = plafond;
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

	public boolean effectuerLesVirements(CompteEnBanque compte) {
		// Prend tout et additionne tous les montants a payer
		// si assez d'argent on paye tout sinon que 10% de la somme

		Iterator<Operation> it = historiqueCarteCredit.iterator();
		int montantAPayer = 0;
		while (it.hasNext()) {
			Operation ope = it.next();
			montantAPayer += ope.getMontant();
		}
		if (montantAPayer <= 0)
			throw new IllegalArgumentException();
		if (getTitulaire().compteCourant.getSolde() - montantAPayer < getTitulaire().compteCourant
				.getDecouvertMaxAut() * -1)
			throw new UnsupportedOperationException();
		if (montantAPayer < plafond) {
			// Si assez d'argent :
			try {
				compte.deposer(montantAPayer);
				getTitulaire().compteCourant.retirer(montantAPayer);
				return true;
			} catch (ArgumentInvalideException e) {
			}
		} else {
			// Sinon que 10% :
			try {
				compte.deposer(montantAPayer * 0.1);
				getTitulaire().compteCourant.retirer(montantAPayer * 0.1);
				return false;
			} catch (ArgumentInvalideException e) {
			}
		}
		return false;
	}

	public String toString() {

		return "Carte de crédit de " + getTitulaire();
	}

}
