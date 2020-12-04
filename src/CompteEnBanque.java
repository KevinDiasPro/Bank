
public interface CompteEnBanque extends Comparable<CompteEnBanque> {

	public void setCloture(boolean cloture);
	public boolean isCloture();
	void deposer(double montant) throws ArgumentInvalideException;
	void retirer(double montant) throws ArgumentInvalideException;
	boolean estEgalA(double montant) throws ArgumentInvalideException;
	void faireDesVirements(double montant, CompteEnBanque compte) throws ArgumentInvalideException;
	int getNumero();
	double getSolde();
	double getDecouvertMaxAut();

}
