
public class Test {

	public static void main(String[] args) {
		
	
	CompteEnBanque ce1 = new CompteEpargne(1000, 01234, false);
	CompteEnBanque cc1 = new CompteCourant(0124, 2000, -500, false);
	CompteEnBanque cc2 = new CompteCourant(0125, 2500, 2000, false);
	Client c1 = new Client("lol", "lolilol", "SDF", "inconnu", "sans tel", ce1, cc1);
	Client c2 = new Client("Jean", "aimarre", "IPL", "25fevrier", "telephone rose", ce1, cc2);
	
	HistoriqueOperations HO = new HistoriqueOperations();
	Operation o1=new Operation("25fervier", 500, 1, 2, 500);
	Operation o2=new Operation("26fervier", 100, 11, 22, 510);
	Operation o3=new Operation("27fervier", 200, 12, 244, 100);
	Operation o4=new Operation("28fervier", 300, 14, 235, 500);
	
	
	try {
		cc1.deposer(1500);
		cc1.retirer(500);
		ce1.deposer(500);
		ce1.retirer(15);
		ce1.compareTo(cc1);
		cc1.compareTo(cc2);
		HO.add(o1);
		HO.add(o2);
		HO.add(o3);
		
		
	} catch (ArgumentInvalideException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	System.out.println(c1.toString());
	System.out.println(c2.toString());
	System.out.println(c1.estEgalA(c2));
	System.out.println(c1.estEgalA(c1));
	System.out.println("type : " +o1.getType());
	System.out.println("taille : " + HO.size());
	System.out.println(HO.contains(o3));
	}
}
