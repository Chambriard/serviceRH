/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import javax.ejb.Local;

/**
 *
 * @author alban
 */
@Local
public interface ServiceRHLocal {
    
    
    public String ajouterForma(String content);
    
    public String changerDate(String content);
    
    public String SupprimerForma(int id);
    
    public String RenvoisPlan();
     
    public String ajouterFormaPlan(String content);
    
    public String SupprimerFormaPlan(int id);
    
    public String RenvoisForma();
    
    
     
    
}
