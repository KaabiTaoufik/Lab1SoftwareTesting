package junit.monprojet;

import java.util.HashMap;
import java.util.Iterator;

public class PorteMonnaie {
    private HashMap<String, Integer> contenu;
    public HashMap<String, Integer> getContenu() {
        return contenu;
    }
    public PorteMonnaie() {
        contenu = new HashMap<String, Integer>();
    }
    public void ajouteSomme(SommeArgent sa) {
        contenu.merge(sa.getUnite(), sa.getQuantite(), Integer::sum);
    }
    public String toString(){
        Iterator<String> iterKeys = contenu.keySet().iterator();
        Iterator<Integer> iterValues = contenu.values().iterator();
        StringBuilder sb = new StringBuilder();
        if (iterValues.hasNext()) {
            sb.append(iterKeys.next() + iterValues.next() + "\n");
            while (iterValues.hasNext()) {
                sb.append(iterKeys.next() + iterValues.next() + "\n");
            }
        }
        return "porteMonnaie : \n" + sb.toString();
    }
    public boolean equals(Object porteMonnaie){
        if(porteMonnaie == null){
            return false;
        }
        if(porteMonnaie instanceof PorteMonnaie){
            if(((PorteMonnaie) porteMonnaie).getContenu().size() != this.contenu.size()){
                return  false;
            }
            Iterator<String> iterKeys = ((PorteMonnaie) porteMonnaie).getContenu().keySet().iterator();
            Iterator<Integer> iterValues = ((PorteMonnaie) porteMonnaie).getContenu().values().iterator();
            if (iterValues.hasNext()) {
                if(!this.contenu.get(iterKeys.next()).equals(iterValues.next())){
                    return false;
                }
                while (iterValues.hasNext()) {
                    if(!this.contenu.get(iterKeys.next()).equals(iterValues.next())){
                        return false;
                    }
                }
            }
            return true;
        }
        return false;
    }
}