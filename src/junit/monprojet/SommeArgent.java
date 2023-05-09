package junit.monprojet;

public class SommeArgent {
    private int quantite;
    private String unite;
    public SommeArgent(int amount, String currency) {
        quantite = amount;
        unite = currency;
    }
    public int getQuantite() {
        return quantite;
    }
    public String getUnite() {
        return unite;
    }
    public SommeArgent add(SommeArgent m) throws UniteDistincteException {
        if (!m.getUnite().equals(this.getUnite())) {
            throw new UniteDistincteException(this, m);
        }

        return new SommeArgent(getQuantite() + m.getQuantite(), getUnite());
    }
    public boolean equals(Object sommeArgent){
        if(sommeArgent == null)
            return false;

        if(sommeArgent instanceof SommeArgent)
        {
            if(((SommeArgent) sommeArgent).getQuantite() == this.quantite
            && ((SommeArgent) sommeArgent).getUnite() == this.unite)
                return true;
        }
        else{
            return false;
        }
        return false;
    }
    public String toString(){
        return getQuantite() + getUnite();
    }
}
