/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entite;

/**
 *
 * @author alban
 */
public class formateur {
    
    private static int count = 0; 
    private int id;
    private String nomForm;
    private String prenomForm;
    private String enseignement;
    private String DateN;

    public formateur(String nomForm, String prenomForm, String enseignement, String DateN) {
        this.id = ++count;
        this.nomForm = nomForm;
        this.prenomForm = prenomForm;
        this.enseignement = enseignement;
        this.DateN = DateN;
    }
    
     public formateur(int id,String nomForm, String prenomForm, String enseignement, String DateN) {
        this.id = id;
        this.nomForm = nomForm;
        this.prenomForm = prenomForm;
        this.enseignement = enseignement;
        this.DateN = DateN;
    }
    
    

    public int getId() {
        return id;
    }

    public String getNomForm() {
        return nomForm;
    }

    public String getPrenomForm() {
        return prenomForm;
    }

    public String getEnseignement() {
        return enseignement;
    }

    public String getDateN() {
        return DateN;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNomForm(String nomForm) {
        this.nomForm = nomForm;
    }

    public void setPrenomForm(String prenomForm) {
        this.prenomForm = prenomForm;
    }

    public void setEnseignement(String enseignement) {
        this.enseignement = enseignement;
    }

    public void setDateN(String DateN) {
        this.DateN = DateN;
    }

    @Override
    public String toString() {
        return "formateur{" + "id=" + id + ", nomForm=" + nomForm + ", prenomForm=" + prenomForm + ", enseignement=" + enseignement + ", DateN=" + DateN + '}';
    }
    
    
    
    
    
}
