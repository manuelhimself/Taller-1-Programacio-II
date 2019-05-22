/**Coder: Manuel Peña Llull
 */
package defArticle;

/**
 *
 * @author manue
 */
public class PilaBuidaException extends Exception{
    
    public PilaBuidaException(){
        
    }

    @Override
    public String getMessage(){
        return "La pila està buida \n";
    }
    
    
}
