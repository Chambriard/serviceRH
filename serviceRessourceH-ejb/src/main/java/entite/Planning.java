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
public class Planning {

    private Integer idForm;
    private Integer idFormation;
    private String statut;
    private String dateDeb;
    private String dateFin;

    public Planning(Integer idForm, Integer idFormation, String statut, String dateDeb, String dateFin) {
        this.idForm = idForm;
        this.idFormation = idFormation;
        this.statut = statut;
        this.dateDeb = dateDeb;
        this.dateFin = dateFin;
    }

    public Planning(Integer idForm, String statut, String dateDeb, String dateFin) {
        this.idForm = idForm;
        this.statut = statut;
        this.dateDeb = dateDeb;
        this.dateFin = dateFin;
    }

    
    public Integer getIdFormation() {
        return idFormation;
    }

    public void setIdFormation(Integer idFormation) {
        this.idFormation = idFormation;
    }

    

    public Integer getIdForm() {
        return idForm;
    }

    public String getStatut() {
        return statut;
    }

    public String getDateDeb() {
        return dateDeb;
    }

    public String getDateFin() {
        return dateFin;
    }

    public void setIdForm(Integer idForm) {
        this.idForm = idForm;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public void setDateDeb(String dateDeb) {
        this.dateDeb = dateDeb;
    }

    public void setDateFin(String dateFin) {
        this.dateFin = dateFin;
    }

    
    
    @Override
    public String toString() {
        return "planning{" + "idForm=" + idForm + ", idFormation=" + idFormation + ", statut=" + statut + ", dateDeb=" + dateDeb + ", dateFin=" + dateFin + '}';
    }

    

   

    
}
