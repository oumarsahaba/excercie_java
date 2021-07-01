package classes;
import java.util.Date;


public class prescription {
    private  int nb_prises;
    private String code;
    private int numero;

    public prescription(int nb_prises,String code,int numero){
        this.nb_prises=nb_prises;
        this.code=code;
        this.numero=numero;
    }

    //accessors


    public void setNb_prises(int nb_prises){
        this.nb_prises=nb_prises;
    }

    public void setCode(String code){
        this.code=code;
    }

    public void setNumero(int numero){
        this.numero=numero;
    }



    public int getNb_prises(){
        return this.nb_prises;
    }

    public String getCode(){
        return this.code;
    }

    public int getNumero(){
        return this.numero;
    }


    //afficheur
    public String toString(){
        return "nb_prises:"+this.nb_prises+",\t"+"code:"+this.code+",\t"+"numero:"+this.numero;
    }
}

