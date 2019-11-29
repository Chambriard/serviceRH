/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import entite.planning;
import java.util.ArrayList;
import javax.ejb.Stateless;
import com.google.gson.Gson;
import entite.formateur;

/**
 *
 * @author alban
 */
@Stateless
public class gestionRH implements gestionRHLocal {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    
    private Gson gson;
    private ArrayList<planning> monPlanning ;
    private ArrayList<formateur> mesForms ;
    
    public gestionRH() {
        this.gson = new Gson();
        monPlanning = initPlan();
        mesForms = initForma();
    }

    
    
    private ArrayList<planning> initPlan(){
        ArrayList<planning> monPlanning = new ArrayList<planning>();
        planning pla1 = new planning(1,1,"affecté","01/01/2019","07/01/2020");
        planning pla2 = new planning(2,2,"affecté","01/01/2019","03/01/2020");
        planning pla3 = new planning(3,3,"affecté","01/01/2019","12/01/2020");
        planning pla4 = new planning(4,4,"affecté","01/01/2019","10/01/2020");
        
        planning pla5 = new planning(1,"indisponible","08/01/2020","26/02/2020");
        planning pla6 = new planning(2,"indisponible","04/01/2020","27/02/2020");
        planning pla7 = new planning(3,"indisponible","13/01/2020","12/02/2020");
        planning pla8 = new planning(4,"indisponible","11/01/2020","17/04/2020");
        monPlanning.add(pla1);
        monPlanning.add(pla2);
        monPlanning.add(pla3);
        monPlanning.add(pla4);
        
        monPlanning.add(pla5);
        monPlanning.add(pla6);
        monPlanning.add(pla7);
        monPlanning.add(pla8);
         
         return monPlanning;
    }
    
    private ArrayList<formateur> initForma(){
        ArrayList<formateur> mesForma = new ArrayList<formateur>();
        formateur forma1 = new formateur("Dupont","Charle","audit","25/08/1989");
        formateur forma2 = new formateur("Occupé","Bonpart","EAI","23/09/1991");
        formateur forma3 = new formateur("Chatelain","Louis","Securité","20/09/1991");
        formateur forma4 = new formateur("Laroche","Maximilien","Expression","10/09/1980");
     
        mesForma.add(forma1);
        mesForma.add(forma2);
        mesForma.add(forma3);
        mesForma.add(forma4);
         
         return mesForma;
    }
    
    @Override
    public String ajouterForma(String content)  {
       
            formateur forma = this.gson.fromJson(content, formateur.class);
            formateur forma2 = new formateur(mesForms.size()+1, forma.getNomForm(),forma.getPrenomForm(),forma.getEnseignement(),forma.getDateN());
            System.out.println(forma.toString());
            mesForms.add(forma2);
            return forma2.toString();
    }
    
    @Override
    public String ajouterFormaPlan(String content)  {
       
            planning pla = this.gson.fromJson(content, planning.class);
            System.out.println(pla.toString());
            monPlanning.add(pla);
            return pla.toString();
    }
    
    @Override
    public String changerDate(String content) {
        System.out.println("changer statut" + content);
        //content = gson.toJson(content);
        planning pla = this.gson.fromJson(content, planning.class);
        
        System.out.println(pla.toString());
        String res = "";
        for(int i = 0; i<monPlanning.size();i++){
            if(monPlanning.get(i).getIdForm() == pla.getIdForm() && monPlanning.get(i).getIdFormation() == pla.getIdFormation()){
                monPlanning.get(i).setStatut(pla.getStatut());
                monPlanning.get(i).setDateDeb(pla.getDateDeb());
                monPlanning.get(i).setDateFin(pla.getDateFin());
                res = monPlanning.get(i).toString();
            }
            if(monPlanning.get(i).getIdForm() == pla.getIdForm() && monPlanning.get(i).getIdFormation() == pla.getIdFormation() && pla.getStatut().equals("indisponible") ){
                monPlanning.get(i).setStatut(pla.getStatut());
                monPlanning.get(i).setDateDeb(pla.getDateDeb());
                monPlanning.get(i).setDateFin(pla.getDateFin());
                monPlanning.get(i).setIdFormation(0);
                res = monPlanning.get(i).toString();
            }
        }
        return res;
    }
    
    @Override
    public String SupprimerFormaPlan(int id){
        for(int i = 0; i<monPlanning.size();i++){
            if (monPlanning.get(i).getIdForm() == id){
                monPlanning.remove(i);
            }
        }
        return "Formateur enlevé du planning";
    }
    
    @Override
    public String SupprimerForma(int id){
   
        for(int i = 0; i<mesForms.size();i++){
            if (mesForms.get(i).getId() == id){
                
                mesForms.remove(i);
      
            }
        }
        
        return "Formateur bien supprimé";
    }
    
    @Override
    public String RenvoisPlan(){
        String res = "";
        String Newligne=System.getProperty("line.separator"); 
        for(int i = 0; i<monPlanning.size();i++){
                res = res + monPlanning.get(i).toString() + Newligne;
            }
        return res;
    }
    
    @Override
    public String RenvoisForma(){
        String res = "";
        String Newligne=System.getProperty("line.separator"); 
        for(int i = 0; i<mesForms.size();i++){
                res = res + mesForms.get(i).toString() + Newligne;
            }
        return res;
    }
}
