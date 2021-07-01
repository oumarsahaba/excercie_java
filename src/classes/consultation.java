package classes;
import java.util.Date;


public class consultation {
    //private int numero;
    private Date dateConsultation;
    private String matricule;
    private String no_ss;

    public consultation(Date dateConsultation,String matricule,String no_ss){
        //this.numero=numero;
        this.dateConsultation=dateConsultation;
        this.matricule=matricule;
        this.no_ss=no_ss;
    }

    //accessors
    /*public void setNumero(char numero){
            this.numero=numero;
    }*/

    public void setDate(Date date){
        this.dateConsultation=date;
    }

    public void setMatricule(String matricule){
        this.matricule=matricule;
    }

    public void setNo_ss(String no_ss){
        this.no_ss=no_ss;
    }

   /* public int getNumero(){
        return this.numero;
    }*/

    public Date getDateConsultation(){
        return this.dateConsultation;
    }

    public String getMatricule(){
        return this.matricule;
    }

    public String getNo_ss(){
        return this.no_ss;
    }


    //afficheur
    public String toString(){
        return "Date consultation:"+this.dateConsultation+",\t"+"matricule:"+this.matricule+",\t"+"no_ss:"+this.no_ss;
    }
}
