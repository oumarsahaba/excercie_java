package classes;
import java.util.Date;


public class medecin {
    private String nom;

    public medecin(String nom){
        this.nom=nom;
    }

    //accessors


    public void setNom(String nom){
        this.nom=nom;
    }



    public String getNom(){
        return this.nom;
    }


    //afficheur
    public String toString(){
        return this.nom;
    }
}

