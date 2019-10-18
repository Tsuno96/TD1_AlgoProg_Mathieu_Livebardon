import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

public abstract class News implements Serializable {

	private String strTitre;
	private LocalDate ldDate;
	private String strAuteur;
	private URL urlSource;

	public News() throws MalformedURLException {
		this.strTitre = "";
		this.ldDate = LocalDate.now();
		this.strAuteur = "";
		this.urlSource = new URL("http://fake.url");
	}

	public News(String strTitre, LocalDate ldDate, String strAuteur, URL urlSource) {
		this.strTitre = strTitre;
		this.ldDate = ldDate;
		this.strAuteur = strAuteur;
		this.urlSource = urlSource;
	}


	public String toString()
	{
	return	"Titre : "+ strTitre+"\nDate :"+ ldDate+"\nAuteur : "+ strAuteur+"\nSource : "+urlSource;
	}

//	public void afficher() {
//		System.out.println("Titre : "+ strTitre+"\nDate :"+ ldDate+"\nAuteur : "+ strAuteur+"\nSource : "+urlSource);
//	}


//	public void saisir() throws MalformedURLException {
//		Scanner sc = new Scanner(System.in);
//		System.out.println("Veulliez saisir le titre de la news");
//		strTitre = sc.nextLine();
//		System.out.println("Vous avez saisi : "+ strTitre);
//
//		System.out.println("Veulliez saisir la date de la news format yyyy-mm-dd");
//		DateTimeFormatter dtfFormatDate = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//		ldDate = LocalDate.parse(sc.nextLine(),dtfFormatDate);
//		System.out.println("Vous avez saisi : "+ ldDate);
//
//		System.out.println("Veulliez saisir l'auteur de la news");
//		strAuteur = sc.nextLine();
//		System.out.println("Vous avez saisi : "+ strAuteur);
//
//		System.out.println("Veulliez saisir l'url de la news");
//		urlSource = new URL(sc.nextLine());
//		System.out.println("Vous avez saisi : "+ urlSource);
//	}


	public String getStrTitre() {
		return strTitre;
	}

	public void setStrTitre(String strTitre) {
		this.strTitre = strTitre;
	}

	public LocalDate getLdDate() {
		return ldDate;
	}

	public void setLdDate(LocalDate ldDate) {
		this.ldDate = ldDate;
	}

	public String getStrAuteur() {
		return strAuteur;
	}

	public void setStrAuteur(String strAuteur) {
		this.strAuteur = strAuteur;
	}

	public URL getUrlSource() {
		return urlSource;
	}

	public void setUrlSource(URL urlSource) {
		this.urlSource = urlSource;
	}

}
