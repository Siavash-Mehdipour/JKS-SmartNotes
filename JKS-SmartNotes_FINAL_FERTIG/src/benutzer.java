
import org.mindrot.jbcrypt.BCrypt;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author krisar
 */
public class benutzer {

    
    
    private String Passwort;
    
    private String Nutzername;

    public benutzer(String Passwort,String Nutzername) {
        
       
        this.Passwort = Passwort;
       
        this.Nutzername = Nutzername;
    }

    private String hashPasswort(String passwort) {
        System.out.println(BCrypt.hashpw(passwort, BCrypt.gensalt()));
        return BCrypt.hashpw(passwort, BCrypt.gensalt());
    }

    

}
