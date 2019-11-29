/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import com.google.gson.Gson;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import metier.gestionRHLocal;

/**
 *
 * @author alban
 */
@Stateless
public class ServiceRH implements ServiceRHLocal {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    
    @EJB
    private gestionRHLocal gestionRH;
    /**
     * Convertisseur Objet JSON et inversement)
     */
    private Gson gson;
    
    
    public ServiceRH() {
        this.gson = new Gson();
    }
    
    
    @Override
    public String ajouterForma(String content){
        
        
        return this.gestionRH.ajouterForma(content);
   
    }
    
    @Override
    public String ajouterFormaPlan(String content){
        return this.gestionRH.ajouterFormaPlan(content);
    }
    
    
    @Override
    public String changerDate(String content){
      
      
        return this.gestionRH.changerDate(content);
        


    }
    
    @Override
    public String SupprimerForma(int id) {
       
        return this.gestionRH.SupprimerForma(id);
        
    
    }
    
    @Override
    public String SupprimerFormaPlan(int id){
        return this.gestionRH.SupprimerFormaPlan(id);
    }
    
    
     @Override
    public String RenvoisPlan() {
       
        //System.out.print("coucou 2" + id_Sal);
        return this.gestionRH.RenvoisPlan();
        
    
    }
    
    @Override
    public String RenvoisForma(){
         return this.gestionRH.RenvoisForma();
    }
    
    
}
