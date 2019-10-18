import java.io.IOException;
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
                case 9:
                    lireBD();
                    break;
                default:
                    System.out.println("Vous n'avez pas choisi un nombre faisant parti du menu");
                    break;
            }
        } while (i != 8);

    }

    private static void lireBD() {
        try {
            String fileName = new String("file.dat");
            bdn.lire(fileName);
        } catch (ClassNotFoundException | IOException e) {
            System.out.println("Erreur d'entree-sortie");
        }
    }

    public static int afficher_menu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Veuillez saisir un nombre : \n 1 - Creer\n 2 - Ouvrir\n 3 - Sauvegarder\n 4 - Inserer" +
                "\n 5 - Supprimer \n 6 - Afficher\n 7 - Rechercher\n 8 - Quitter\n 9 - Lire BD");
        int choix = sc.nextInt();
        System.out.println("Vous avez saisi : " + choix);
        return choix;
    }

    public static void quitter() {
        System.out.println("Quitte l'application");

    }

    public static void rechercher() throws MalformedURLException {
        System.out.println("Recherche dans la base");
        creer();
        bdn.ajoute(new PressArticle("un", LocalDate.parse("2005-05-05"), "1m80", new URL("http://g.fr"),
                "Le lama est le meilleur des animaux", new URL("http://y.fr"), false));
        bdn.ajoute(new PressArticle("deux", LocalDate.parse("2005-05-05"), "1m80", new URL("http://g.fr"),
                "Pourquoi mon roi est un lama ?", new URL("http://lama.fr"), true));
        bdn.ajoute(new PhotoNews("trois", LocalDate.parse("2005-05-05"), "1m80", new URL("http://g.fr")
                , "lama.jpg", "JPG", new Vector2(200, 500), true));
        bdn.ajoute(new PhotoNews("quatre", LocalDate.parse("2005-05-05"), "1m80", new URL("http://g.fr")
                , "lama.png", "PNG", new Vector2(250, 5000), false));

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
        System.out.println("Veulliez saisir le numero de la news à supprimer");
        int nNewstodelete = sc.nextInt();
        i = 1;

        News n_toremove = null;
        for (News n : bdn.getTsCollection()
        ) {

            if (i == nNewstodelete) {
                n_toremove = n;
            }
            i++;
        }

        System.out.println(n_toremove);
        bdn.getTsCollection().remove(n_toremove);
        System.out.println("news supprimée");
    }

    public static void inserer() throws MalformedURLException {
        System.out.println("Insere une nouvelle actualite dans la base");

        Scanner sc = new Scanner(System.in);
        int choix;
        do {
            System.out.println("De quel type est votre arcticle\n0 - Aricle de presse\n1 - Photo");
            choix = sc.nextInt();
        } while (choix != 0 || choix != 1);
        System.out.println("Vous avez saisi : " + choix);

        System.out.println("Veulliez saisir le titre de la news");
        String strTitre = sc.nextLine();
        System.out.println("Vous avez saisi : " + strTitre);

        System.out.println("Veulliez saisir la date de la news format yyyy-mm-dd");
        DateTimeFormatter dtfFormatDate = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate ldDate = LocalDate.parse(sc.nextLine(), dtfFormatDate);
        System.out.println("Vous avez saisi : " + ldDate);

        System.out.println("Veulliez saisir l'auteur de la news");
        String strAuteur = sc.nextLine();
        System.out.println("Vous avez saisi : " + strAuteur);

        System.out.println("Veulliez saisir l'url de la news");
        URL urlSource = new URL(sc.nextLine());
        System.out.println("Vous avez saisi : " + urlSource);


        if (choix == 0) {
            System.out.println("Veulliez saisir le contenu textuel");
            String strText = sc.nextLine();
            System.out.println("Vous avez saisi : " + strText);

            System.out.println("Veulliez saisir l'url de la version longue de la news");
            URL urlVersionLongue = new URL(sc.nextLine());
            System.out.println("Vous avez saisi : " + urlVersionLongue);

            System.out.println("Veulliez indiquer si l'article existe ne format papier (0 = faux et 1 = vrai)");
            int b;
            boolean bVersionPapier = false;
            do {
                b = sc.nextInt();
                switch (b) {
                    case 0:
                        bVersionPapier = false;
                        break;
                    case 1:
                        bVersionPapier = true;
                        break;
                    default:
                        System.out.println("Le choix n'est pas valide veuillez recommencer (0 = faux et 1 = vrai)");
                }
            } while (b != 0 || b != 1);

            System.out.println("Vous avez saisi : " + b);

            News n = new PressArticle(strTitre, ldDate, strAuteur, urlSource, strText, urlVersionLongue, bVersionPapier);

            bdn.ajoute(n);

        } else {
            System.out.println("Veulliez saisir l'arborescence ou ce trouve votre photo");
            String strPhoto = sc.nextLine();
            System.out.println("Vous avez saisi : " + strPhoto);

            System.out.println("Veulliez saisir le format de votre photo");
            String strFormat = sc.nextLine();
            System.out.println("Vous avez saisi : " + strFormat);

            System.out.println("Veulliez saisir la resolution de votre image\nlongueur :");
            int x = sc.nextInt();
            System.out.println("\nlargeur :");
            int y = sc.nextInt();
            Vector2 vec2Resolution = new Vector2(x, y);
            System.out.println("Vous avez saisi : " + x + "*" + y);

            System.out.println("Veulliez indiquer si la photo est en couleur (0 = faux et 1 = vrai)");
            int b;
            boolean bColored = false;
            do {
                b = sc.nextInt();
                switch (b) {
                    case 0:
                        bColored = false;
                        break;
                    case 1:
                        bColored = true;
                        break;
                    default:
                        System.out.println("Le choix n'est pas valide veuillez recommencer (0 = faux et 1 = vrai)");
                }
            } while (b != 0 || b != 1);

            System.out.println("Vous avez saisi : " + bColored);

            News n = new PhotoNews(strTitre, ldDate, strAuteur, urlSource, strPhoto, strFormat, vec2Resolution, bColored);
            bdn.ajoute(n);
        }

    }

    public static void sauvegarder() {
        System.out.println("Sauvegarde de la base d'actualité");
        try {
            bdn.sauvegarder("file.dat");
        } catch (IOException e) {
            System.out.println("Erreur d'entree-sortie");
        }

    }

    public static void ouvrir() {
        System.out.println("Chargement d'une base d'actualité");

    }

    public static void creer() {

        System.out.println("Vous avez crée une nouvelle base d'actulalité.");
        bdn.initialise();
    }

}
