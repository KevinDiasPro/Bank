
public class Visa extends CarteCredit{

	public Visa(double plafond, Client titulaire) {
		super(plafond, titulaire);
		
	}
	
	public String toString(){
		
		return "La carte Visa de " + getTitulaire();
		
	}
	

}
