package personnages;

public class Humain {
	private String nom;
	private String boisson;
	private int argent;
	private int tailleMemoire = 30;
	private Humain[] memoire = new Humain[tailleMemoire];
	
	protected int nbConnaissance;
	
	public Humain(String nom, String boisson, int argent) {
		this.nom = nom;
		this.boisson = boisson;
		this.argent = argent;
	}

	public String getNom() {
		return nom;
	}

	public int getArgent() {
		return argent;
	}

	public void direBonjour() {
		parler("Bonjour ! Je m'appelle " + getNom() + " et j'aime boire du " + boisson);
	}
	
	public void boire() {
		parler("Mmmm, un bon verre de " + boisson + " ! GLOUPS !");
	}
	
	public void acheter(String bien, int prix) {
		if (prix <= getArgent()){
			parler("J'ai " + getArgent() + " sous en poche. Je vais pouvoir m'offrir " + bien + " à " + prix + " sous.");
			argent -= prix;
		} else {
			parler("Je n'ai plus que " + getArgent() + " sous en poche. Je ne peux même pas m'offrir " + bien + " à " + prix +" sous.");
		}
	}
	
	protected void gagnerArgent(int gain) {
		argent += gain;
	}
	
	protected void perdreArgent(int perte) {
		if(argent < perte) {
			argent = 0;
		} else {
		argent -= perte;
		}
	}
	
	protected void parler(String texte){
		System.out.println("(" + getNom() + ") - " + texte);
		
	}
	
	
	public void faireConnaissanceAvec(Humain humain) {
		direBonjour();
		humain.repondre(this);
		memoriser(humain);
	}
	
	private void memoriser(Humain humain) {
		if (nbConnaissance < tailleMemoire) {
			memoire[nbConnaissance] = humain;
			nbConnaissance += 1;
		} else {
			for (int i = 1; i < nbConnaissance; i += 1) {
				memoire[i-1] = memoire[i];}
			memoire[nbConnaissance - 1] = humain;
		}
		
	}
	
	private void repondre(Humain humain) {
		direBonjour();
		memoriser(humain);
		
	}
	
	public void listerConnaissance() {
		if (nbConnaissance != 0) {
			String nomConnaissance = memoire[0].getNom();
			for (int i = 1; i < nbConnaissance; i++) {
				nomConnaissance += ", " + memoire[i].getNom();
			}
		
			parler("Je connais beaucoup de monde dont:" + nomConnaissance);
		
		}
	}
}