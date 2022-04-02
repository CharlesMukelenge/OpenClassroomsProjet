package partieserveur;

import java.io.IOException;
import java.net.ServeurSocket;
import java.util.ArrayList;

public class Serveur{
    private ServeurSocket ss;
    public static ArrayList<SocketCommunicationClient> listeSocketClient;

    public Serveur(int port){
        try{
            this.ss = new ServeurSocket(port);
            Serveur.listeSocketClient = new ArrayList<>();
        }
        catch(IOException ex){
            System.out.println("Un autre serveur s'exécute sur la même adresse et le même port !!! ");
            System.exit(0);
        }
        }
        public void demarrer(){
            System.out.println("Le serveur vient de démarrer...");
            while(true){
                Socket nouvelleConnexion = this.ss.accept();
                SocketCommunicationClient scc = new SocketCommunicationClient(nouvelleConnexion);
                serveur.listeSocketClient.add(scc);
                new Thred(scc).start();
                System.out.println("une nouvelle personne s'est connectée");   
            }catch(IOException ex){
                System.out.println("Une tentative de connexion a échoué !!!");  
            }
        }
    }
}