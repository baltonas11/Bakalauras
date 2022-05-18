package Ligis_searchprot;

public class LIGIS_Web_Items {

 String komn;
 
public LIGIS_Web_Items(String komen){
    this.komn = komen;
} 

    public String getKomn() {
        return komn;
    }

    public void setKomn(String komen) {
        this.komn = komen;
    }    
    
@Override
    public String toString() {
        return "Rasta: " + komn;
    }    
    
}
