/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import com.google.gson.Gson;
import entite.Formateur;
import entite.Planning;
import java.util.ArrayList;
import java.util.HashMap;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import metier.GestionRHLocal;

/**
 *
 * @author alban
 */
@Stateless
public class ServiceRH implements ServiceRHLocal {

    @EJB
    private GestionRHLocal gestionRH;
    /**
     * Convertisseur Objet JSON et inversement)
     */
    private Gson gson;
    
    
    public ServiceRH() {
        this.gson = new Gson();
    }
    
    
    @Override
    public Formateur ajouterForma(String content){
        return this.gestionRH.ajouterForma(content);
    }
    
    @Override
    public Planning ajouterFormaPlan(String content){
        return this.gestionRH.ajouterFormaPlan(content);
    }
    
    
    @Override
    public Planning changerDate(String content){
        return this.gestionRH.changerDate(content);
    }
    
    @Override
    public String supprimerForma(int id) {
        return this.gestionRH.supprimerForma(id);
    }
    
    @Override
    public String supprimerFormaPlan(int id){
        return this.gestionRH.supprimerFormaPlan(id);
    }
    
    
    @Override
    public ArrayList<Planning> renvoiPlan() {
        return this.gestionRH.renvoiPlan();
    }
    
    @Override
    public HashMap<Integer, Formateur> renvoiForma(){
         return this.gestionRH.renvoiForma();
    }

    @Override
    public ArrayList<Planning> renvoiFormateurs() {
        return this.gestionRH.renvoiFormateurs();
    }
    
    
    
    
}
