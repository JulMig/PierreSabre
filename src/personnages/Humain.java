package personnages;

public class Humain {
	private String nom;
	private String boisson;
	private int argent;
	
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
	
	public void gagnerArgent(int gain) {
		argent += gain;
	}
	
	public void perdreArgent(int perte) {
		if(argent < perte) {
			argent = 0;
		} else {
		argent -= perte;
		}
	}
	
	protected void parler(String texte){
		System.out.println("(" + getNom() + ") - " + texte);
		
	}
}