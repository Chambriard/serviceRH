/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import javax.ejb.Local;

/**
 *
 * @author alban
 */
@Local
public interface gestionRHLocal {
    
    
    public String ajouterForma(String content);
    
    public String changerDate(String content);
    
    public String SupprimerFormaPlan(int id);
    
    public String SupprimerForma(int id);
    
    public String ajouterFormaPlan(String content);
    
    String RenvoisPlan();
    
    public String RenvoisForma();
}
