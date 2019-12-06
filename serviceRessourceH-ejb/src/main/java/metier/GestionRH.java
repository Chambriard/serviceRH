/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import entite.Planning;
import java.util.ArrayList;
import javax.ejb.Stateless;
import com.google.gson.Gson;
import entite.Formateur;
import java.util.HashMap;

/**
 *
 * @author alban
 */
@Stateless
public class GestionRH implements GestionRHLocal {
    
    private Gson gson;
    private ArrayList<Planning> monPlanning ;
    private HashMap<Integer, Formateur> mesForms ;
    
    public GestionRH() {
        this.gson = new Gson();
        monPlanning = initPlan();
        mesForms = initForma();
    }

    
    private ArrayList<Planning> initPlan(){
        ArrayList<Planning> monPlanning = new ArrayList<Planning>();
        Planning pla1 = new Planning(1,1,"affecte","01/01/2020","04/01/2020");
        Planning pla2 = new Planning(2,2,"pressenti","11/02/2020","16/02/2020");
        Planning pla3 = new Planning(3,3,"affecte","01/01/2020","12/01/2020");
        Planning pla4 = new Planning(4,4,"affecte","25/10/2020","30/10/2020");
        Planning pla5 = new Planning(4,"indisponible","11/01/2020","17/04/2020");
        monPlanning.add(pla1);
        monPlanning.add(pla2);
        monPlanning.add(pla3);
        monPlanning.add(pla4);
        monPlanning.add(pla5);
         
         return monPlanning;
    }
    
    private HashMap<Integer, Formateur> initForma(){
        HashMap<Integer, Formateur>  mesForma = new HashMap<> ();
        Formateur forma1 = new Formateur("Dupont","Charle","audit","25/08/1989");
        Formateur forma2 = new Formateur("Occupé","Bonpart","EAI","23/09/1991");
        Formateur forma3 = new Formateur("Chatelain","Louis","Securité","20/09/1991");
        Formateur forma4 = new Formateur("Laroche","Maximilien","Expression","10/09/1980");
        Formateur forma5 = new Formateur("Cari","Aurélien","Mobilité","02/09/2019");
     
        mesForma.put(forma1.getId(), forma1);
        mesForma.put(forma2.getId(), forma2);
        mesForma.put(forma3.getId(), forma3);
        mesForma.put(forma4.getId(), forma4);
        mesForma.put(forma5.getId(), forma5);
         
         return mesForma;
    }
    
    @Override
    public Formateur ajouterForma(String content)  {
        Formateur forma = this.gson.fromJson(content, Formateur.class);
        Formateur forma2 = new Formateur(mesForms.size()+1, forma.getNomForm(),forma.getPrenomForm(),forma.getEnseignement(),forma.getDateN());
        System.out.println(forma.toString());
        mesForms.put(forma2.getId(), forma2);
        return forma2;
    }
    
    @Override
    public Planning ajouterFormaPlan(String content)  {
        Planning pla = this.gson.fromJson(content, Planning.class);
        System.out.println(pla.toString());
        monPlanning.add(pla);
        return pla;
    }
    
    @Override
    public String changerStatut(String content) {        
        Planning pla = this.gson.fromJson(content, Planning.class);  
        String res = null;
        Integer formateur = null;
        System.out.println("formateur :" + pla.getIdForm());
        for(int i = 0; i<monPlanning.size();i++){
            
                System.out.println("ID :" + monPlanning.get(i).getIdForm());
            if(monPlanning.get(i).getIdForm()== pla.getIdForm()) {
                formateur = pla.getIdForm();
                if(monPlanning.get(i).getDateDeb().equals(pla.getDateDeb())){
                   monPlanning.get(i).setStatut(pla.getStatut());
                   monPlanning.get(i).setIdFormation(pla.getIdFormation());
                   monPlanning.get(i).setDateFin(pla.getDateFin());

                   if(pla.getStatut().equals("indisponible"))
                       monPlanning.get(i).setIdFormation(null);

                   res = "Mise a jour du formateur reussi.";
               }
            }     
        }
        
        if(formateur == null)
            res = "Formateur non existant dans le planning";
        else if(formateur != null && res == null)
            res = "Reservation non existante dans le planning";
        
        return res;
    }
    
    @Override
    public String supprimerFormaPlan(int idFormateur, String dateDeb){
        String res = "Formateur non existant dans le planning";
        for(int i = 0; i<monPlanning.size();i++){
            if (monPlanning.get(i).getIdForm()== idFormateur && monPlanning.get(i).getDateDeb().equals(dateDeb)){
                monPlanning.remove(i);
                res = "Formateur bien enleve du planning";
            }
        }
        return res;
    }
    
    @Override
    public String supprimerForma(int id){
        String res = "Formateur bien supprimé";
        if(!this.mesForms.containsKey(id))
            res = "Formateur inexistant";
        else 
            this.mesForms.remove(id);
        return res;
    }
    
    /*@Override
    public String renvoiPlan(){
        String res = "";
        String Newligne=System.getProperty("line.separator"); 
        for(int i = 0; i<monPlanning.size();i++){
                res = res + monPlanning.get(i).toString() + Newligne;
            }
        return res;
    }
    
    @Override
    public String renvoiForma(){
        String res = "";
        String Newligne=System.getProperty("line.separator"); 
        for(int i = 0; i<mesForms.size();i++){
                res = res + mesForms.get(i).toString() + Newligne;
            }
        return res;
    }*/
    
    @Override
    public ArrayList<Planning> renvoiPlan(){
        return this.monPlanning;
    }
    
    @Override
    public HashMap<Integer, Formateur> renvoiForma(){
        return this.mesForms;
    }
    
    

    @Override
    public ArrayList<Planning> renvoiPlannningFormateurs() {
        ArrayList<Planning> planning = new ArrayList<>();
        Planning plan = null;
        for(Formateur f : this.mesForms.values()) {
            for(Planning p : this.monPlanning) {
                if(p.getIdForm()== f.getId()) {
                    plan = p;
                    planning.add(plan);
                }
            }
            if(plan == null) {
                Planning p = new Planning(f.getId(), "disponible", null, null);
                planning.add(p);
            }
            plan = null;
        }
        return planning;

    }
    
    
}
