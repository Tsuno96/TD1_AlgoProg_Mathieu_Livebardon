import java.util.Scanner;

public class MesNews {

	public static void main(String[] args) {
		

		System.out.println(" premier jour " ); 
		Scanner sc = new Scanner(System.in);
		System.out.println("Veuillez saisir un nombre : \n 1 - Creer\n 2 - Ouvrir\n 3 - Sauvegarder\n 4 - Afficher\n 5 - Inserer \n 6 - Supprimer\n 7 - Rechercher\n 8 - Quitter");
		int i = sc.nextInt();
		System.out.println("Vous avez saisi : "+ i);
		switch (i) {
		case 1:
			creer();
			break;
		case 2:
			ouvrir();
			break;
		case 3:
			sauvegarder();
			break;
		case 4:
			inserer();
			break;
		case 5:
			supprimer();
			break;
		case 6:
			afficher();
			break;
		case 7:
			rechercher();
			break;
		case 8:
			quitter();
			break;
		default:
			System.out.println("Vous n'avez pas choisi un nombre faisant parti du menu");
			break;
		} 

	}

	private static void quitter() {
		System.out.println("Quitte l'application");
		
	}

	private static void rechercher() {
		System.out.println("Recherche dans la base");
		
	}

	private static void afficher() {
		System.out.println("Affichage total de la base");
		
	}

	private static void supprimer() {
		System.out.println("Suppression d'une base");
		
	}

	private static void inserer() {
		System.out.println("Insere une nouvelle actualite dans la base");
		
	}

	public static void sauvegarder() {
		System.out.println("Sauvergarde de la base d'actualité");
		
	}

	public static void ouvrir() {
		System.out.println("Chargement d'une base d'actualité");
		
	}

	public static void creer() {
		System.out.println("Vous avez crée une nouvelle base d'actulalité.");
	} 

}
