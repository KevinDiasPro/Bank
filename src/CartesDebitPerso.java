
public class CartesDebitPerso extends CarteDebit{
private String image;

	public CartesDebitPerso(String image, Client titulaire) {
		super(titulaire);
		this.image=image;
	}

	public String getImage() {
		return image;
	}

	@Override
	public String toString(){
		
		return "Votre image est " + image;
	}

	
	
}
