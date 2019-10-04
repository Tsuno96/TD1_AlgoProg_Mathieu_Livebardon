import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class MesNews {
	public static BaseDeNews bdn = new BaseDeNews();
	public static void main(String[] args) throws MalformedURLException {

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

	public static void rechercher() throws MalformedURLException {
		System.out.println("Recherche dans la base");
		creer();
		bdn.ajoute(new News("un",LocalDate.parse("2005-05-05"),"1m80",new URL("http://g.fr")));
		bdn.ajoute(new News("deux",LocalDate.parse("2005-05-05"),"1m80",new URL("http://g.fr")));
		bdn.ajoute(new News("trois",LocalDate.parse("2005-05-05"),"1m80",new URL("http://g.fr")));
		bdn.ajoute(new News("quatre",LocalDate.parse("2005-05-05"),"1m80",new URL("http://g.fr")));

	}

	public static void afficher() {
		System.out.println("Affichage total de la base");
		bdn.afficher_collection();
	}

	public static void supprimer() throws MalformedURLException {
		System.out.println("Suppression d'une base");
		int i = 0;
		for (News n : bdn.getTsCollection()
			 ) {
			System.out.println(++i);
			System.out.println(n);
		}

		Scanner sc = new Scanner(System.in);
		System.out.println("Veulliez saisir le numero de la news � supprimer");
		int nNewstodelete = sc.nextInt();
		i = 1;

		News n_toremove = new News();
		for (News n : bdn.getTsCollection()
		) {

			if (i == nNewstodelete)
			{
				n_toremove = n;
			}
			i++;
		}

		System.out.println(n_toremove);
		bdn.getTsCollection().remove(n_toremove);
		System.out.println("news supprim�e");
	}

	public static void inserer() throws MalformedURLException {
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
		System.out.println("Sauvergarde de la base d'actualit�");

	}

	public static void ouvrir() {
		System.out.println("Chargement d'une base d'actualit�");

	}

	public static void creer() {

		System.out.println("Vous avez cr�e une nouvelle base d'actulalit�.");
		bdn.initialise();
	} 

}
