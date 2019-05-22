/*Coder: Manuel Peña Llull
 */
package taller1_2;

import defArticle.Article;
import defArticle.PilaBuidaException;
import defArticle.pilaArticles;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javafx.application.Platform.exit;

/**
 *
 * @author manue
 */
public class Taller1_2 {

    private static final String nomFitxer = "stackArticles.dat";
    private static final pilaArticles pila = new pilaArticles(nomFitxer);
    //Instanciació d'un buffer per fer lectures desde el teclat
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Menu();
    }

    //Mètode que pinta les opcions del menú
    private static void visualitzaMenu() {
        System.out.println("\t 1. INSEREIX ARTICLE (push)");
        System.out.println("\t 2. ESBORRA ARTICLE (pop)");
        System.out.println("\t 3. MOSTRA PILA D'ARTICLES");
        System.out.println("\t 4. SORTIR");
    }

    //Menú d'opcions
    private static void Menu() {
        String opcio = "";

        visualitzaMenu();
        try {
            opcio = br.readLine();

            switch (opcio) {
                case "1":
                    insereixArticle();
                    Thread.sleep(100);
                    Menu();
                    break;
                case "2":
                    esborraArticle();
                    Thread.sleep(100);
                    Menu();
                    break;
                case "3":
                    mostraPila();
                    Thread.sleep(100);
                    Menu();
                    break;
                case "4":
                    exit();
                    break;
                default:
                    System.err.print("Opció no vàlida \n");
                     {
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(Taller1_2.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    Thread.sleep(100);
                    Menu();
            }
        } catch (IOException | InterruptedException ex) {
            Logger.getLogger(Taller1_2.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    //Mètode que insereix un article
    private static void insereixArticle() throws IOException {
        String nom;
        int codi;
        Article a = new Article();
        System.out.println("Tria un nom (maxim 20 caràcters)");
        nom = br.readLine();
        if (nom.length() > 20) {
            System.err.print("El nom no té tamany 3");
            Menu();
        }
        System.out.println("Tria un codi (entre 100 i 998)");
        codi = Integer.parseInt(br.readLine());
        if (codi < 100 || codi > 998) {
            System.err.print("El codi no està dins el rang permès");
            Menu();
        }
        a = new Article(codi, nom, false);
        pila.push(a);
        System.out.println("Article inserit correctament");
    }

    //Mètode que esborra un article (fa un pop)
    private static void esborraArticle() {
        try {
            pila.pop();
            System.out.println("Article esborrat correctament");
        } catch (PilaBuidaException ex) {
            try {
                System.err.println(ex.getMessage());
                Thread.sleep(100);
                Menu();
            } catch (InterruptedException ex1) {
                Logger.getLogger(Taller1_2.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }

    }

    //Mètode que mostra la pila
    private static void mostraPila() {
        try {
            pila.mostraPila();
        } catch (PilaBuidaException ex) {
            System.err.println(ex.getMessage());
        }
    }

}
