/**Coder: Manuel Peña Llull
 */
package defArticle;

/**
 *
 * @author manue
 */
public class Article {

    private int codi;
    private String nom;
    private boolean borrat;
    private static final int longExacta = 20;

    public Article() {

    }

    public Article(int codi, String nom) {
        this.codi = codi;
        this.nom = nom;
        borrat = false;
    }

    public Article(int codi, String nom, boolean borrat) {
        this.codi = codi;
        this.nom = nom;
        this.borrat = borrat;
    }

    @Override
    public String toString() {
        return "Article{" + "nom= " + nom + ", codi=" + codi + " borrat = " + borrat + '}';
    }

    //Métode que retorna el nom de l'article de tal manera tengui exacament la 
    //longitud definida per la constant longExacta
    public String nomMaxim() {
        //se podria anomenar getNomMaxim o els getters no fan cap tractament??

        if (nom.length() <= longExacta) {
            for (int i = nom.length(); i < longExacta; i++) {
                nom = nom + " ";
            }
        } else {
            nom = nom.substring(0, longExacta - 1);
        }

        return nom;
    }

    //Mètode que verifica si dos Articles son iguals, entenem que dos articles son iguals
    //si tenen el mateix codi. Suposam que el codi de cada article és exclusiu i no es pot repetir
    public boolean esIgual(Article art) {
        //return (nom.equals(art.getNom()) && (codi == art.getCodi()) && (borrat == art.isBorrat()));
        return codi == art.getCodi();
    }

    public int getCodi() {
        return codi;
    }

    public String getNom() {
        return nom;
    }

    public boolean isBorrat() {
        return borrat;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setBorrat(boolean borrat) {
        this.borrat = borrat;
    }

}
