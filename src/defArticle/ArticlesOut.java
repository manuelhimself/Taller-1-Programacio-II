/**Coder: Manuel Peña Llull
 */
package defArticle;

/**
 *
 * @author manue
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class ArticlesOut {

    private static File arxiu;
    private final RandomAccessFile raf;
    private static final int tamanyObjectes = 45;
    private static final int longExacta = 20;

    //Mètode constructor on per paràmetres indicam el nom del fitxer físic
    public ArticlesOut(String nom) throws FileNotFoundException {
        arxiu = new File(nom);
        raf = new RandomAccessFile(arxiu, "rw");
    }

    //Mètode que permet l'escriptura d'un article passat per paràmetres al final del fitxer
    public void escriure(Article a) throws IOException {
        //posam l'apuntador al final del fitxer
        raf.seek(raf.length());
        raf.writeInt(a.getCodi());
        raf.writeChars(a.nomMaxim());
        raf.writeBoolean(a.isBorrat());

    }

    //Mètode que permet donar de baixa, només necesitam la posició de l'objecte dins la seqüència
    //ja que el valor que ha d'escriure sempre es borrat = true;
    public void donarBaixa(long logitud) throws IOException {
        long longit = logitud;
        long posicio = (longit * tamanyObjectes) - 1;
        Boolean borrat;
        raf.seek(posicio);                              //Ens colocam al boleà del darrer element de la pila
        borrat = raf.readBoolean();                     //El llegim
        while (borrat == true) {                        //Si està borrat
            longit = longit - 1;                        //Ens anam al seguent element de la pila
            posicio = (longit * tamanyObjectes) - 1;    //Actualitzam la posició per col·locar-nos
            raf.seek(posicio);                          //amb el raf.seek al següent element
            borrat = raf.readBoolean();                 //miram  si està o no borrat
        }
        raf.seek(posicio);                              //Ens col·locam al darrer element no esborrat
        raf.writeBoolean(true);                         //i l'esborram
    }

    //Mètode per tancar el fitxer ArticlesOut
    public void close() throws IOException {
        raf.close();

    }

}
