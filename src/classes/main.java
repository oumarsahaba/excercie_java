package classes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import Tables.*;

public class  main {
    private BaseDeDonnee bd=new BaseDeDonnee();
    public  void menu() throws ParseException {
        System.out.println("Bonjour,\nSoyeez le bienvenu dans le système de gestion de l''hopital moderne de Thiès");
        System.out.println("veuillez sélectionner l'action que vous voudriez exécuter");
        System.out.println("1.Remplir une table\t\t\t\t\t2.Supprimer\t\t\t\t\t3.Opérations");
        Scanner objet=new Scanner(System.in);
        Integer option=Integer.parseInt(objet.nextLine());
        switch (option){
            case 1:
                menuAddColonne();
                break;
            case 2:
                menuSupprimerColonne();
                break;
            case 3:
                menuOperation();
                break;
            default:
                menu();
                break;
        }
    }

    private void menuOperation() throws ParseException {
        System.out.println("Voyons voirrr!!!!,\nIci vous pourrez apprécier l'ensemble des opportunités de ce système d'information");
        System.out.println("veuillez sélectionner l'opération que vous voudriez exécuter");
        System.out.println("1.Afficher la liste des consultations pour un patient\n2.Afficher la liste des patients consultés à une date donnée\n3.Afficher Le médecin et son patient pour une consultation précise\n4.La liste des consultations effectuées par un médecin.\n5.La liste des patients consultés par un médecin." +
                "\n6.La liste des médecins qui ont consulté un patient\n7.La liste des médecins qui ont effectué des consultations à une date donnée.\n8.Le nombre de consultations\n9.Liste des médicaments prescrit lors d’une consultation\n10.La liste des médicaments prescrit par un médecin à un patient à une date donnée" +
                "\n11.La liste des médicaments prescrit par un médecin à un patient\n12.La liste des médicaments prescrit au moins par deux médecins\n13.Pour chaque médicament fournir le nombre total de prescription");
        Scanner objet=new Scanner(System.in);
        Integer option=Integer.parseInt(objet.nextLine());
        switch (option){
            case 1:
                System.out.println("Saisir le numéro de sécurité social du patient:");
                Scanner objet2=new Scanner(System.in);
                String noss=objet2.nextLine();
                bd.listeConsultation(noss);
                menu();
                break;
            case 2:
                System.out.println("Saisir la date de consultation:");
                Scanner objet1=new Scanner(System.in);
                Date date=new SimpleDateFormat("dd/MM/yyyy").parse(objet1.nextLine());;
                bd.listePatients( date);
                menu();
                break;
            case 3:
                System.out.println("Saisir le numéro de la consultation:");
                Scanner objet3=new Scanner(System.in);
                int numero=Integer.parseInt(objet3.nextLine());;
                bd.medecinEtPatient(numero);
                menu();
                break;
            case 4:
                System.out.println("Saisir le matricule du médecin:");
                Scanner objet4=new Scanner(System.in);
                String matricule=objet4.nextLine();
                bd.consultationMedecin(matricule);
                menu();
                break;
            case 5:
                System.out.println("Saisir le matricule du médecin:");
                Scanner objet5=new Scanner(System.in);
                String matriculemed=objet5.nextLine();
                bd.patienstConsultes(matriculemed);
                menu();
                break;
            case 6:
                System.out.println("Saisir le numéro de sécurité social:");
                Scanner objet6=new Scanner(System.in);
                String nossp=objet6.nextLine();
                bd.medecinsConsultes(nossp);
                menu();
                break;
            case 7:
                System.out.println("Saisir la date:");
                Scanner objet7=new Scanner(System.in);
                Date datecons=new SimpleDateFormat("dd/MM/yyyy").parse(objet7.nextLine());
                bd.consultants(datecons);
                menu();
                break;
            case 8:
                bd.nombreConsultation();
                menu();
                break;
            case 9:
                System.out.println("Saisir le numéro de la consultation:");
                Scanner objet8=new Scanner(System.in);
                int num=Integer.parseInt(objet8.nextLine());
                bd.medicamentPrescrit(num);
                menu();
                break;
            case 10:
                System.out.println("Saisir le matricule du médecin:");
                Scanner objet9=new Scanner(System.in);
                String mat=objet9.nextLine();
                System.out.println("Saisir la date de consultation:");
                Scanner objet10=new Scanner(System.in);
                Date dateconsultation=new SimpleDateFormat("dd/MM/yyyy").parse(objet10.nextLine());
                bd.prescription(mat,dateconsultation);
                menu();
                break;
            case 11:
                bd.medicamentsPrescrits();
                menu();
                break;
            case 12:
                bd.medicamentsPrescritsbis();
                menu();
                break;
            case 13:
                bd.totalprescriptionMedicament1();
                menu();
                break;
        }
    }

    private void menuSupprimerColonne() throws ParseException {
        System.out.println("OHHHH,Miiince\nDes données en moins");
        System.out.println("Tant pis\nSelectionnez la table que vous allez malheurheusement mettre à jour");
        System.out.println("1.Medecin\t\t\t\t\t2.Medicament\t\t\t\t\t3.Patient\n4.Consultation\t\t\t\t\t5.Prescription");
        Scanner objet=new Scanner(System.in);
        Integer option=Integer.parseInt(objet.nextLine());
        switch (option){
            case 1:
                System.out.println("Saisir le matricule du medecin:");
                Scanner objet2=new Scanner(System.in);
                String matricule=objet2.nextLine();
                bd.supprimerMedecin(matricule);
                System.out.println("C'est avec un grand regret que je vous annonce que la suppression a été une réuissite");
                menu();
                break;
            case 2:
                System.out.println("Saisir le code du medicament:");
                Scanner objet1=new Scanner(System.in);
                String code=objet1.nextLine();
                bd.supprimerMedicament(code);
                System.out.println("C'est avec un grand regret que je vous annonce que la suppression a été une réuissite");
                menu();
                break;
            case 3:
                System.out.println("Saisir le numéro de sécurité social du patient:");
                Scanner objet3=new Scanner(System.in);
                String noss=objet3.nextLine();
                bd.supprimerMedecin(noss);
                System.out.println("C'est avec un grand regret que je vous annonce que la suppression a été une réuissite");
                menu();
                break;
            case 4:
                System.out.println("Saisir le numéro de la consultation:");
                Scanner objet4=new Scanner(System.in);
                int numero=Integer.parseInt(objet4.nextLine());
                bd.supprimerConsultation(numero);
                System.out.println("C'est avec un grand regret que je vous annonce que la suppression a été une réuissite");
                menu();
                break;
            case 5:
                System.out.println("Saisir l'index de la prescription:");
                Scanner objet5=new Scanner(System.in);
                int index=Integer.parseInt(objet5.nextLine());
                bd.supprimerPrescription(index);
                System.out.println("C'est avec un grand regret que je vous annonce que la suppression a été une réuissite");
                menu();
                break;

    }
    }

    private void menuAddColonne() throws ParseException {
        System.out.println("Youpiiii,\nDes données j'aiiime");
        System.out.println("Allez à vous de jouer\nSelectionnez la table que vous voulez mettre à jour");
        System.out.println("1.Medecin\t\t\t\t\t2.Medicament\t\t\t\t\t3.Patient\n4.Consultation\t\t\t\t\t5.Prescription");
        Scanner objet=new Scanner(System.in);
        Integer option=Integer.parseInt(objet.nextLine());
        switch (option){
            case 1:
                System.out.println("Saisir le nom du médecin:");
                Scanner objet1=new Scanner(System.in);
                String nom=objet1.nextLine();
                System.out.println("Saisir le matricule du medecin:");
                Scanner objet2=new Scanner(System.in);
                String matricule=objet2.nextLine();
                bd.ajouterMedecin(matricule,nom);
                System.out.println("Félicitation!!!!!!!!!!!Vos informations seront à l'abri");
                menu();
                break;
            case 2:
                System.out.println("Saisir le code du médicament:");
                Scanner objet3=new Scanner(System.in);
                String code=objet3.nextLine();
                System.out.println("Saisir le libelle du mmédicament:");
                Scanner objet4=new Scanner(System.in);
                String libelle=objet4.nextLine();
                bd.ajouterMedicament(code,libelle);
                System.out.println("Félicitation!!!!!!!!!!!Vos informations seront à l'abri");
                menu();
                break;
            case 3:
                System.out.println("Saisir le nom du patient:");
                Scanner objet6=new Scanner(System.in);
                String nomPatient=objet6.nextLine();
                System.out.println("Saisir le  numéro social du patient:");
                Scanner objet7=new Scanner(System.in);
                String noss=objet7.nextLine();
                bd.ajouterPatient(noss,nomPatient);
                System.out.println("Félicitation!!!!!!!!!!!Vos informations seront à l'abri");
                menu();
                break;
            case 4:
                System.out.println("Saisir le numero de la consultation:");
                Scanner objet8=new Scanner(System.in);
                int numeroConsultation=Integer.parseInt(objet8.nextLine());
                System.out.println("Saisir la date de consultation(dd/mm/yyyy):");
                Scanner objet9=new Scanner(System.in);
                Date dateConsultation=new SimpleDateFormat("dd/MM/yyyy").parse(objet9.nextLine());
                System.out.println("Saisir le matricule du medecin qui a consulté:");
                Scanner objet10=new Scanner(System.in);
                String matriculeMedecin=objet10.nextLine();
                System.out.println("Saisir le matricule le numéro de sécurité social du patient à consulter:");
                Scanner objet11=new Scanner(System.in);
                String nossPatient=objet11.nextLine();
                if (bd.getTableMedecin().containsKey(matriculeMedecin)){
                    bd.ajouterConsultation(numeroConsultation,dateConsultation,matriculeMedecin,nossPatient);
                    System.out.println("Félicitation!!!!!!!!!!!Vos informations seront à l'abri");
                }
                else{
                    System.out.println("OOHHHH!Cet action ne peut continuer du fait que le medecin renseigné\nenregistré essayer après l'avoir enregistré ");
                    menuAddColonne();

                }
                menu();
                break;
            case 5:
                System.out.println("Saisir le numero de la prescription:");
                Scanner objet12=new Scanner(System.in);
                int numeroPrescription=Integer.parseInt(objet12.nextLine());
                System.out.println("Saisir le nombre de prise:");
                Scanner objet13=new Scanner(System.in);
                int nombrePrise=Integer.parseInt(objet13.nextLine());
                System.out.println("Saisir le code du medicament prescrit:");
                Scanner objet14=new Scanner(System.in);
                String codeMedicamentPrescrit=objet14.nextLine();
                System.out.println("Saisir le numero de la consultation:");
                Scanner objet15=new Scanner(System.in);
                int numeroConsultationP=Integer.parseInt(objet15.nextLine());

                if (bd.getTableMedicament().containsKey(codeMedicamentPrescrit)) {
                    if (bd.getTableConsultation().containsKey(numeroConsultationP)) {
                        bd.ajouterPrescription(numeroPrescription,nombrePrise,codeMedicamentPrescrit,numeroConsultationP);
                    }
                    else{
                        System.out.println("OOOOHHHHH!La consultation n'est pas enregistré veuillez le faire avant de continuer");
                        menuAddColonne();
                    }
                    System.out.println("Félicitation!!!!!!!!!!!Vos informations seront à l'abri");
                }
                else{
                    System.out.println("OOHHHH!Cet action ne peut continuer du fait que le medicament prescrit\nn'est pas enregistré. ");
                    menuAddColonne();

                }
                menu();
                break;
            default:
                menu();
                break;
        }
    }

    public  static void main(String[] args) throws ParseException {
        /*BaseDeDonnee bd=new BaseDeDonnee();
        bd.addcolonne(1);
        bd.addcolonne(1);
        bd.addcolonne(4);
        bd.listeConsultation("1");
    }*/
        main start =new main();
        start.menu();
}
}
