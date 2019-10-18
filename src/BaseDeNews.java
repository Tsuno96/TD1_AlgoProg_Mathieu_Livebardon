import java.io.*;
import java.util.Comparator;
import java.util.TreeSet;

public class BaseDeNews {

    TreeSet<News> tsCollection;

    public TreeSet<News> getTsCollection()
    {
        return tsCollection;
    }
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
            System.out.println("\n"+n);
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

//        FileOutputStream f = new FileOutputStream(new File(fileName));
//        ObjectOutputStream o = new ObjectOutputStream(f);
//        o.writeObject(tsCollection);
//        o.close();
//        f.flush();
//        f.close();
        File file = new File(fileName);
        try (FileOutputStream fop = new FileOutputStream(file))
        {
            // if file doesn't exists, then create it
            if (!file.exists()) {
                file.createNewFile();
            }
            ObjectOutputStream o =new ObjectOutputStream(fop);
            System.out.println("object créé");
            o.writeObject(tsCollection);
            o.close();
            fop.flush();
            fop.close();
            System.out.println("Done");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }





}

