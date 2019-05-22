/**Coder: Manuel Peña Llull
 */
package defArticle;

import java.io.IOException;

/**
 *
 * @author manue
 */
public class pilaArticles {

    static String nomFitxer;
    static ArticlesOut out;
    static ArticlesIn in;

    public pilaArticles(String nom) {
        pilaArticles.nomFitxer = nom;
    }

    //Mètode que ens permet inserir un article al final del fitxer
    //de pila d'articles
    public void push(Article a) throws IOException {
        out = new ArticlesOut(nomFitxer);
        out.escriure(a);
        out.close();
    }

    //Mètode que ens permet eliminar un article al final del fitxer
    //de pila d'articles 
    public void pop() throws PilaBuidaException {
        try {
            in = new ArticlesIn(nomFitxer);
            out = new ArticlesOut(nomFitxer);
            if (esBuida()) {                    //Si la pila es buida
                throw new PilaBuidaException(); //botam a l'excepció PilaBuidaException
            }
            out.donarBaixa(in.getNumReg());
            out.close();
            in.close();
        } catch (IOException ex) {
            throw new PilaBuidaException();     //Si no podem llegir la pila també indicarà que està buida
        }

    }

    public void mostraPila() throws PilaBuidaException {
        try {
            in = new ArticlesIn(nomFitxer);
            String contingut = in.contingut();
            if (contingut.length() == 0) {          //Si l'string que conté els elements de la pila es buid
                throw new PilaBuidaException();     //treim l'excepció PilaBuidaExeption
            }
            System.out.println(contingut);          //Imprimim els articles de la pila
            in.close();                             //Tancam el fitxer
        } catch (IOException ex) {
            throw new PilaBuidaException();
        }
    }

    //mètode que ens mira si la pila està buida
    private static boolean esBuida() throws PilaBuidaException {
        boolean buida = true;
        try {
            in = new ArticlesIn(nomFitxer);
            Article a;
            for (long i = in.getNumReg(); i > 0; i--) {
                a = in.llegir();
                if (!a.isBorrat()) {
                    buida = false;
                }
            }
            in.close();
        } catch (IOException ex) {
            throw new PilaBuidaException();
        }
        return buida;
    }

}
