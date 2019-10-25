import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;

public class PressArticle extends News  {

    private String strText;
    private URL urlVersionLongue;
    private boolean bVersionPapier;


    public PressArticle(String strTitre, LocalDate ldDate, String strAuteur, URL urlSource,
                        String strText, URL urlVersionLongue, boolean bVersionPapier) throws MalformedURLException {
        super(strTitre,ldDate,strAuteur,urlSource);
        this.strText = strText;
        this.urlVersionLongue = urlVersionLongue;
        this.bVersionPapier = bVersionPapier;
    }

    @Override
    public String toString() {
        return super.toString()+"\nContenu textuel : "+strText+"\nVersion Longue : "+urlVersionLongue+"\nVersion papier : "+bVersionPapier;
    }

    public String getStrText() {
        return strText;
    }

    public void setStrText(String strText) {
        this.strText = strText;
    }

    public URL getUrlVersionLongue() {
        return urlVersionLongue;
    }

    public void setUrlVersionLongue(URL urlVersionLongue) {
        this.urlVersionLongue = urlVersionLongue;
    }

    public boolean isbVersionPapier() {
        return bVersionPapier;
    }

    public void setbVersionPapier(boolean bVersionPapier) {
        this.bVersionPapier = bVersionPapier;
    }

    public int compareTo(Object arg0) {
       return super.compareTo(arg0);
    }

}
