import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class MesNews {

	public static void main(String[] args) throws MalformedURLException {
		BaseDeNews bdn = new BaseDeNews();
		int i;
		do {
			i = afficher_menu();
			switch (i) {
			case 1:
				creer(bdn);
				break;
			case 2:
				ouvrir();
				break;
			case 3:
				sauvegarder();
				break;
			case 4:
				inserer(bdn);
				break;
			case 5:
				supprimer();
				break;
			case 6:
				afficher(bdn);
				break;
			case 7:
				rechercher(bdn);
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

	public static int afficher_menu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Veuillez saisir un nombre : \n 1 - Creer\n 2 - Ouvrir\n 3 - Sauvegarder\n 4 - Inserer\n 5 - Supprimer \n 6 - Afficher\n 7 - Rechercher\n 8 - Quitter");
		int choix = sc.nextInt();
		System.out.println("Vous avez saisi : "+ choix);
		return choix;
	}

	public static void quitter() {
		System.out.println("Quitte l'application");

	}

	public static void rechercher(BaseDeNews bdn) throws MalformedURLException {
		System.out.println("Recherche dans la base");
		creer(bdn);
		bdn.ajoute(new News("un",LocalDate.parse("2005-05-05"),"1m80",new URL("http://g.fr")));
		bdn.ajoute(new News("deux",LocalDate.parse("2005-05-05"),"1m80",new URL("http://g.fr")));
		bdn.ajoute(new News("trois",LocalDate.parse("2005-05-05"),"1m80",new URL("http://g.fr")));
		bdn.ajoute(new News("quatre",LocalDate.parse("2005-05-05"),"1m80",new URL("http://g.fr")));

	}

	public static void afficher(BaseDeNews bdn) {
		System.out.println("Affichage total de la base");
		bdn.afficher_collection();
	}

	public static void supprimer() {
		System.out.println("Suppression d'une base");

	}

	public static void inserer(BaseDeNews bdn) throws MalformedURLException {
		System.out.println("Insere une nouvelle actualite dans la base");

		Scanner sc = new Scanner(System.in);
		System.out.println("Veulliez saisir le titre de la news");
		String strTitre = sc.nextLine();
		System.out.println("Vous avez saisi : "+ strTitre);

		System.out.println("Veulliez saisir la date de la news format yyyy-mm-dd");
		DateTimeFormatter dtfFormatDate = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate ldDate = LocalDate.parse(sc.nextLine(),dtfFormatDate);
		System.out.println("Vous avez saisi : "+ ldDate);

		System.out.println("Veulliez saisir l'auteur de la news");
		String strAuteur = sc.nextLine();
		System.out.println("Vous avez saisi : "+ strAuteur);

		System.out.println("Veulliez saisir l'url de la news");
		URL urlSource = new URL(sc.nextLine());
		System.out.println("Vous avez saisi : "+ urlSource);

		News n = new News(strTitre, ldDate, strAuteur, urlSource);
		bdn.ajoute(n);
	}

	public static void sauvegarder() {
		System.out.println("Sauvergarde de la base d'actualité");

	}

	public static void ouvrir() {
		System.out.println("Chargement d'une base d'actualité");

	}

	public static void creer(BaseDeNews bdn) {

		System.out.println("Vous avez crée une nouvelle base d'actulalité.");
		bdn.initialise();
	} 

}
