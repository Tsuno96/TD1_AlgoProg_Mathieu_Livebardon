import java.util.Scanner;

public class MesNews {

	public static void main(String[] args) {


		System.out.println(" premier jour " ); 

		int i;
		do {
			i = afficher_menu();
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
		}while(i != 8);

	}

	private static int afficher_menu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Veuillez saisir un nombre : \n 1 - Creer\n 2 - Ouvrir\n 3 - Sauvegarder\n 4 - Inserer\n 5 - Supprimer \n 6 - Afficher\n 7 - Rechercher\n 8 - Quitter");
		int choix = sc.nextInt();
		System.out.println("Vous avez saisi : "+ choix);
		return choix;
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
