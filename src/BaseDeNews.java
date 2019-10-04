import java.util.Comparator;
import java.util.TreeSet;

public class BaseDeNews {

    TreeSet<News> tsCollection;

    public void initialise()
    {
        tsCollection = new TreeSet<News>(new Comparator<News>() {
            @Override
            public int compare(News n1, News n2) {
                return n1.getStrTitre().compareTo(n2.getStrTitre());
            }
        });
    }

    public void ajoute(News n)
    {
        tsCollection.add(n);
    }

    public void afficher_collection(){
        for (News n: tsCollection
             ) {
            System.out.println(n);
        }
    }

    



}

