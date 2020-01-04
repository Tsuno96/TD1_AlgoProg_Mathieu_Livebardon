import java.io.*;
import java.util.Comparator;
import java.util.TreeSet;

public class BaseDeNews {

    TreeSet<News> tsCollection;

    public void initialise() {
        tsCollection = new TreeSet<News>();
    }

    public void ajoute(News n) {

        tsCollection.add(n);
    }

    public TreeSet<News> getTsCollection() {
        return tsCollection;
    }

    public void afficher_collection() {
        for (News n : tsCollection
        ) {
            System.out.println("\n" + n);
        }
    }

    public void lire(String fileName) throws IOException, ClassNotFoundException {
        FileInputStream r = new FileInputStream(fileName);
        ObjectInputStream o = new ObjectInputStream(r);
        Object lu = o.readObject();
        tsCollection = (TreeSet<News>) lu;
        o.close();
        r.close();
    }

    public void sauvegarder(String fileName) throws IOException {

        FileOutputStream f = new FileOutputStream(new File(fileName));
        ObjectOutputStream o = new ObjectOutputStream(f);
        o.writeObject(tsCollection);
        o.close();
        f.flush();
        f.close();

    }


}

