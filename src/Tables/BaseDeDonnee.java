package Tables;
import classes.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class BaseDeDonnee {
    private Map<Integer, consultation> tableConsultation;
    private Map<String, medecin> tableMedecin;
    private Map<String, medicament>tableMedicament ;
    private Map<String, patient> tablePatient;
    private Map<Integer, prescription> tablePrescription;


    //constructeur
    public BaseDeDonnee(){
        this.tableConsultation=new HashMap<>();
        this.tableMedecin=new HashMap<>();
        this.tableMedicament=new HashMap<>();
        this.tablePatient=new HashMap<>();
        this.tablePrescription=new HashMap<>();
    }

    public BaseDeDonnee(Map<Integer, consultation> tConsultation,Map<String, medecin> tMedecin,Map<String, medicament> tMedicament,Map<String, patient> tPatient,Map<Integer, prescription> tPrescription){
        this.tableConsultation=new HashMap<>(tConsultation);
        this.tableMedecin=new HashMap<>(tMedecin);
        this.tableMedicament=new HashMap<>(tMedicament);
        this.tablePatient=new HashMap<>(tPatient);
        this.tablePrescription=new HashMap<>(tPrescription);
    }

    public BaseDeDonnee(BaseDeDonnee copie){
        this.tableConsultation=new HashMap<>(copie.tableConsultation);
        this.tableMedecin=new HashMap<>(copie.tableMedecin);
        this.tableMedicament=new HashMap<>(copie.tableMedicament);
        this.tablePatient=new HashMap<>(copie.tablePatient);
        this.tablePrescription=new HashMap<>(copie.tablePrescription);
    }


    //accesseurs


    public Map<Integer, consultation> getTableConsultation() {
        return tableConsultation;
    }

    public Map<Integer, prescription> getTablePrescription() {
        return tablePrescription;
    }

    public Map<String, medecin> getTableMedecin() {
        return tableMedecin;
    }

    public Map<String, medicament> getTableMedicament() {
        return tableMedicament;
    }

    public Map<String, patient> getTablePatient() {
        return tablePatient;
    }

    public void setTableConsultation(Map<Integer, consultation> tableConsultation) {
        this.tableConsultation = tableConsultation;
    }

    public void setTableMedecin(Map<String, medecin> tableMedecin) {
        this.tableMedecin = tableMedecin;
    }

    public void setTableMedicament(Map<String, medicament> tableMedicament) {
        this.tableMedicament = tableMedicament;
    }

    public void setTablePatient(Map<String, patient> tablePatient) {
        this.tablePatient = tablePatient;
    }

    public void setTablePrescription(Map<Integer, prescription> tablePrescription) {
        this.tablePrescription = tablePrescription;
    }



    //remplir un tableau
    /*public void addcolonne(int i ) throws ParseException {
        switch (i){
            //à gérer les exceptions
            case 1:
                Scanner date=new Scanner(System.in);
                System.out.println("Veuillez entrer la Date");
                Date formatter=new SimpleDateFormat("dd/MM/yyyy").parse(date.nextLine());
                System.out.println("Veuillez entrer la Matricule");
                Scanner objet=new Scanner(System.in);
                String matricule=objet.nextLine();
                System.out.println("Veuillez entrer le numéro");
                Scanner objetn=new Scanner(System.in);
                String num1=objetn.nextLine();
                Integer num=Integer.parseInt(num1);
                System.out.println("Veuillez entrer le numéro de sécurité social");
                Scanner objet2=new Scanner(System.in);
                String noSS=objet.nextLine();
                consultation cons=new consultation(formatter,matricule,noSS);
                this.tableConsultation.put(num,cons);
                System.out.println(tableConsultation);

                break;
            case 2:
                System.out.println("Veuillez entrer le nom du medecin");
                Scanner objet3=new Scanner(System.in);
                String nom=objet3.nextLine();
                medecin med=new medecin(nom);
                break;
            case 3:
                System.out.println("Veuillez entrer le libellé du médicament");
                Scanner objet4=new Scanner(System.in);
                String libelle=objet4.nextLine();
                medicament medi=new medicament(libelle);
                break;
            case 4:
                System.out.println("Veuillez entrer le numero de sécurité social");
                Scanner objet9=new Scanner(System.in);
                String noss=objet9.nextLine();
                System.out.println("Veuillez entrer le nom du patient");
                Scanner objet5=new Scanner(System.in);
                String nomp=objet5.nextLine();
                patient patient=new patient(nomp);
                this.tablePatient.put(noss,patient);
                break;
            case 5:
                System.out.println("Veuillez entrer le nombre de prise");
                Scanner objet6=new Scanner(System.in);
                String nn_p=objet6.nextLine();
                System.out.println("Veuillez entrer le nombre de prise");
                Scanner objet7=new Scanner(System.in);
                /*String nn_p=objet6.nextLine();
                medecin med=new medecin(nom);
                break;




        }
    }*/
    //à prendre en compte dans le menu :
    //si le médecin n'existe pas faudra d'abord le creer (user)
    //si le patient n'existe pas il est auto généré
    public void ajouterConsultation(int numero,Date date,String matricule,String noss){
        consultation cons =new consultation(date,matricule,noss);
        if(tablePatient.containsKey(noss)){

            tableConsultation.put(numero,cons);
        }
        else {
            System.out.println("Ce patient n'est pas enregistré veuillez l'enregistrer avant de continuer");
            Scanner objet=new Scanner(System.in);
            String nom=objet.nextLine();
            patient patient=new patient(nom);
            tablePatient.put(noss,patient);
            tableConsultation.put(numero,cons);
        }
    }
    //à prendre en compte dans le menu
    //si la consultation n'existe pas elle doit etre crée(user)
    //si le médicament n'existe pas il doit etre crée
    public void ajouterPrescription(int cle,int nbPrise,String code,int numerocons){
        prescription pres=new prescription(nbPrise,code,numerocons);
        tablePrescription.put(cle,pres);
    }
    public void ajouterMedecin(String matricule,String nom){
        medecin med=new medecin(nom);
        tableMedecin.put(matricule,med);
    }
    public void ajouterMedicament(String code,String libelle){
        medicament medi=new medicament(libelle);
        tableMedicament.put(code,medi);
    }
    public void ajouterPatient(String noss,String nom){
        patient pat=new patient(noss);
        tablePatient.put(noss,pat);
    }
    //supression des tableau
    public void supprimerConsultation(Integer numero) {
        if (tableConsultation.containsKey(numero)) {
            tableConsultation.remove(numero);
        }
        else
            System.out.println("Cette consultation n'existe pas");
    }
    public void supprimerPrescription(Integer index){
        if(tablePrescription.containsKey(index)){
            tablePrescription.remove(index);
        }
        else
            System.out.println("Cette prescription n'existe pas");
    }
    public void supprimerMedicament(String code){
        if (tableMedicament.containsKey(code)){
            tableMedicament.remove(code);
        }
        else
            System.out.println("Ce médicament n'existe pas");
    }
    public void supprimerMedecin(String matricule) {
        if (tableMedecin.containsKey(matricule)) {
            tableMedecin.remove(matricule);
        } else
            System.out.println("Ce medecin n'exerce pas ici");
    }
    public void supprimerPatient(String noss) {
        if (tablePatient.containsKey(noss)) {
            tablePatient.remove(noss);
        } else
            System.out.println("Ce patient n'est pas enregistré");
    }

    //fonctions à implémenter
    //liste des consultations pour un patient donné
    public void listeConsultation(String noSS){
        if (this.tablePatient.containsKey(noSS)){
            ArrayList<consultation> cons = new ArrayList<>();
            for (Integer i:this.tableConsultation.keySet()){
                if(tableConsultation.get(i).getNo_ss().equals(noSS)){
                    cons.add(tableConsultation.get(i));
                }
            }
            System.out.println(cons);
        }
        else
            System.out.println("Ceci n'est pas un numéro valide");

    }
    //liste des patients consultés à une date donnée
    public void listePatients(Date date){
        ArrayList<String> cons = new ArrayList<>();
        String noss;
        for (Integer i:this.tableConsultation.keySet()){
            if(tableConsultation.get(i).getDateConsultation().equals(date)){
                noss=tableConsultation.get(i).getNo_ss();
                cons.add(tablePatient.get(noss).getNom());
            }
        }
        System.out.println(cons);
    }
    //pour une consultation afficher le medecin et son patient
    public void medecinEtPatient(Integer numero){
        if (this.tableConsultation.containsKey(numero)) {
            String matricule = tableConsultation.get(numero).getMatricule();
            String noss = tableConsultation.get(numero).getNo_ss();
            System.out.println("Medecin:" + tableMedecin.get(matricule).getNom() + "\n" + "Patient" + tablePatient.get(noss).getNom());
        }
        else
            System.out.println("Cette consultation n'existe pas");
    }
    //la liste des consultations effectuées par un medecin
    public void consultationMedecin(String matricule){
        if (this.tableMedecin.containsKey(matricule)){
            ArrayList<consultation> cons = new ArrayList<>();
            for (Integer i:this.tableConsultation.keySet()){
                if(tableConsultation.get(i).getMatricule().equals(matricule)){
                    cons.add(tableConsultation.get(i));
                }
            }
            System.out.println(cons);
        }
        else
            System.out.println("Ce médecin n'est pas répertorié");

    }
    //liste des patients consulté par un médecin
    public void patienstConsultes(String matricule){
        if (this.tableMedecin.containsKey(matricule)){
            ArrayList<patient> cons = new ArrayList<>();
            for (Integer i:this.tableConsultation.keySet()){
                if(tableConsultation.get(i).getMatricule().equals(matricule)){
                    String noss=tableConsultation.get(i).getNo_ss();
                    cons.add(tablePatient.get(noss));
                }
            }
            System.out.println(cons);
        }
        else
            System.out.println("Ce médecin n'est pas répertorié");

    }
    //liste des médecins qui ont consulté un patient
    public void medecinsConsultes(String noss){
        if (this.tablePatient.containsKey(noss)){
            ArrayList<medecin> cons = new ArrayList<>();
            for (Integer i:this.tableConsultation.keySet()){
                if(tableConsultation.get(i).getNo_ss().equals(noss)){
                    String matricule=tableConsultation.get(i).getMatricule();
                    cons.add(tableMedecin.get(matricule));
                }
            }
            System.out.println(cons);
        }
        else
            System.out.println("Ce patient n'est pas enregistré");

    }
    //liste des médecins qui ont effectué des consultations à une date donnée
   public void consultants(Date date){
       ArrayList<medecin> cons = new ArrayList<>();
       for (Integer i:this.tableConsultation.keySet()){
           if(tableConsultation.get(i).getDateConsultation().equals(date)){
               String matricule=tableConsultation.get(i).getMatricule();
               cons.add(tableMedecin.get(matricule));
           }
       }
       System.out.println(cons);

   }
    //le nombre de consultation
    public void nombreConsultation(){
         System.out.println(tableConsultation.size());
    }
    //liste des médicaments préscrit lors d'une consultation
    public void medicamentPrescrit(int numeroConsultation){
        if (this.tableConsultation.containsKey(numeroConsultation)){
            ArrayList<medicament> cons = new ArrayList<>();
            for (Integer i:this.tablePrescription.keySet()){
                if(tablePrescription.get(i).getNumero()==numeroConsultation){
                    String code=tablePrescription.get(i).getCode();
                    cons.add(tableMedicament.get(code));
                }
            }
            System.out.println(cons);
        }
        else
            System.out.println("Cette consultation n'a pas lieu");

    }
    //liste des médicaments prescrit par un médecin à un patient à une date donnée
    public void prescription(String matricule,Date date){
        if (this.tableMedecin.containsKey(matricule)){
            ArrayList<medicament> cons = new ArrayList<>();
            for (Integer i:this.tablePrescription.keySet()){
                if(tableConsultation.get(tablePrescription.get(i).getNumero()).getMatricule().equals(matricule) && tableConsultation.get(tablePrescription.get(i).getNumero()).getDateConsultation().equals(date)){
                    String code=tablePrescription.get(i).getCode();
                    cons.add(tableMedicament.get(code));
                }
            }
            System.out.println(cons);
        }
        else
            System.out.println("Ce médecin n'est pas répertorier");

    }
    //liste des médicaments prescrit au moins par un médecin à un patient
    public void medicamentsPrescrits(){
        ArrayList<medicament> prescrit=new ArrayList<>();
        for (Integer i:this.tablePrescription.keySet()){
            if(tableMedecin.containsKey(tableConsultation.get(tablePrescription.get(i).getNumero()).getMatricule()) && tablePatient.containsKey(tableConsultation.get(tablePrescription.get(i).getNumero()).getNo_ss())){
                String code=tablePrescription.get(i).getCode();
                prescrit.add(tableMedicament.get(code));
            }
        }
        System.out.println(prescrit);
    }
    //liste des médicaments prescrit au moins par deux médecins
    public void medicamentsPrescritsbis(){
        ArrayList<medicament> prescritbis=new ArrayList<>();
        ArrayList<String> mat=new ArrayList<>();
        for (Integer i:this.tablePrescription.keySet()){
            if(tableMedecin.containsKey(tableConsultation.get(tablePrescription.get(i).getNumero()).getMatricule())){
                String code=tablePrescription.get(i).getCode();
                String matricule=tableConsultation.get(tablePrescription.get(i).getNumero()).getMatricule();

                //
                if(mat.contains(matricule)){
                    prescritbis.add(tableMedicament.get(code));
                }
                mat.add(matricule);

            }

        }
        System.out.println(prescritbis);

    }
    //nombre total de prescription pour chaque médicament:méthode1
    public void totalprescriptionMedicament1(){
        HashMap<String,Integer> nombrePrescription=new HashMap<>();
        for(String i:this.tableMedicament.keySet()){
            int value=0;
            for(Integer j:this.tablePrescription.keySet()){
                if(tablePrescription.get(j).getCode().equals(tableMedicament.keySet())){
                    value++;
                    nombrePrescription.put(tableMedicament.get(i).getLibelle(),value);

                }
            }
        }
        System.out.println(nombrePrescription);
    }
    //nombre total de prescription pour chaque médicament:méthode2
    public void totalprescritionMedicament2(){
        //
    }
}
