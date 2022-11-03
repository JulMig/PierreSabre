package personnages;

public class Ronin extends Humain{
	private int honneur = 1;

	public Ronin(String nom, String boisson, int argent) {
		super(nom, boisson, argent);
	}
	
	public void donner(Commercant beneficiaire) {
		int don = (getArgent() * 10)/100;
		if(don != 0){
			parler(beneficiaire.getNom() + " prend ces " + don + " sous.");
			perdreArgent(don);
			beneficiaire.recevoir(don);
		}
	}
	
	public void provoquer(Yakuza adversaire) {
		parler("Je t'ai retrouvé vermine, tu vas payer pour ce que tu as fait à ce pauvre marchand!");
		
		if (adversaire.getReputation() < 2*honneur) {
			honneur += 1;
			parler("Je t’ai eu petit yakusa!");
			gagnerArgent(adversaire.perdre());
			
		} else {
			honneur -= 1;
			int perte = getArgent();
			perdreArgent(perte);
			parler("J'ai perdu contre ce yakuza, mon honneur et ma bourse ont en pris un coup.");
			adversaire.gagner(perte);
			
		}
	}
	

}
