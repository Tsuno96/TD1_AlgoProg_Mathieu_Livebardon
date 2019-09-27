import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

public class News {

	public String strTitre;
	public LocalDate ldDate;
	public String strAuteur;
	public URL urlSource;
	
	
	private void afficher() {
		System.out.println("Titre : "+ strTitre+"\nDate :"+ ldDate+"\nAuteur : "+ strAuteur+"\nSource : "+urlSource);
	}
	private void saisir() throws MalformedURLException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Veulliez saisir le titre de la news");
		strTitre = sc.nextLine();
		System.out.println("Vous avez saisi : "+ strTitre);
		System.out.println("Veulliez saisir la date de la news format yyyy-mm-dd");
		DateTimeFormatter dtfFormatDate = DateTimeFormatter.ofPattern("yyyy-mm-dd");
		ldDate = LocalDate.parse(sc.next(),dtfFormatDate);
		System.out.println("Vous avez saisi : "+ ldDate);
		System.out.println("Veulliez saisir l'auteur de la news");
		strAuteur = sc.nextLine();
		System.out.println("Vous avez saisi : "+ strAuteur);
		System.out.println("Veulliez saisir l'auteur de la news");
		urlSource = new URL(sc.nextLine());
		System.out.println("Vous avez saisi : "+ urlSource);
	}
}
