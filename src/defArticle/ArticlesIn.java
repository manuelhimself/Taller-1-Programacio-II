/**Coder: Manuel Peña Llull
 */
package defArticle;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class ArticlesIn {

    private static File arxiu;
    private final RandomAccessFile raf;
    private static final long tamanyObjectes = 45;
    private static final int longExacta = 20;
    private static long numReg;

    //Mètode constructor i cridada a nombreRegistres()
    public ArticlesIn(String nom) throws FileNotFoundException, IOException {
        arxiu = new File(nom);
        raf = new RandomAccessFile(arxiu, "r");
        numReg = raf.length() / tamanyObjectes;
    }

    //Mètode  que transforma la cadena de bytes en un objecte Article
    public Article llegir() throws IOException {
        int codi = raf.readInt();
        String nom = "";
        for (int i = 0; i < longExacta; i++) {
            nom += raf.readChar();
        }
        boolean borrat = raf.readBoolean();
        Article a = new Article(codi, nom, borrat);
        return a;
    }

    //Mètode que retorna un String amb tots els articles que no estàn borrats
    public String contingut() throws IOException {
        raf.seek(0);
        String articles = "";
        Article a;
        for (int i = 0; i < numReg; i++) {
            a = llegir();
            if (!a.isBorrat()) {        //Si es borrat
                articles += a + "\n";   //no l'afegim a l'string
            }
        }
        return articles;
    }

    //Getter del número de registres
    public long getNumReg() throws IOException {
        return numReg;
    }

    //Tancam l'arxiu d'ArticlesIn
    public void close() throws IOException {
        raf.close();
    }

}
