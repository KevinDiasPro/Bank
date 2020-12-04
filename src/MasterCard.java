
public class MasterCard extends CarteCredit {

	public MasterCard(double plafond, Client titulaire) {
		super(plafond, titulaire);
		
	}
	
	public String toString(){
		
		return "La carte de Mastercard de " + getTitulaire();
	}
}
