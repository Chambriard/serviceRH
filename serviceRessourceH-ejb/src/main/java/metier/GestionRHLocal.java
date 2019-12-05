/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import entite.Formateur;
import entite.Planning;
import java.util.ArrayList;
import java.util.HashMap;
import javax.ejb.Local;

/**
 *
 * @author alban
 */
@Local
public interface GestionRHLocal {
    
    
    public Formateur ajouterForma(String content);
    
    public String changerStatut(String content);
    
    public String supprimerFormaPlan(int id);
    
    public String supprimerForma(int id);
    
    public Planning ajouterFormaPlan(String content);
    
    public ArrayList<Planning> renvoiPlan();
    
    public HashMap<Integer, Formateur> renvoiForma();

    public ArrayList<Planning> renvoiPlannningFormateurs();
}
