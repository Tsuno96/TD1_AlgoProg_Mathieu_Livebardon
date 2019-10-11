import java.net.URL;
import java.time.LocalDate;

public class PhotoNews extends News {

   private String strPhoto;
   private String strFormat;
   private Vector2 vec2Resolution;
   private boolean bColored;

    public PhotoNews(String strTitre, LocalDate ldDate, String strAuteur, URL urlSource,
                     String strPhoto, String strFormat, Vector2 vec2Resolution, boolean bColored) {
        super(strTitre, ldDate, strAuteur, urlSource);
        this.strPhoto = strPhoto;
        this.strFormat = strFormat;
        this.vec2Resolution = vec2Resolution;
        this.bColored = bColored;
    }

    @Override
    public String toString()
    {
        return super.toString()+"\nPhoto : "+strPhoto+"\nFormat : "+strFormat+"\nResolution : "+vec2Resolution.x +"*"+vec2Resolution.y+"\nImage coloree : "+bColored;
    }

    public String getStrPhoto() {
        return strPhoto;
    }

    public void setStrPhoto(String strPhoto) {
        this.strPhoto = strPhoto;
    }

    public String getStrFormat() {
        return strFormat;
    }

    public void setStrFormat(String strFormat) {
        this.strFormat = strFormat;
    }

    public Vector2 getVec2Resolution() {
        return vec2Resolution;
    }

    public void setVec2Resolution(Vector2 vec2Resolution) {
        this.vec2Resolution = vec2Resolution;
    }

    public boolean isbColored() {
        return bColored;
    }

    public void setbColored(boolean bColored) {
        this.bColored = bColored;
    }
}
