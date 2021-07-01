package classes;
import java.util.Date;


public class medicament {
    private String libelle;

    public medicament(String libelle){
        this.libelle=libelle;
    }

    //accessors


    public void setLibelle(String libelle){
        this.libelle=libelle;
    }



    public String getLibelle(){
        return this.libelle;
    }


    //afficheur
    public String toString(){
        return this.libelle;
    }
}

