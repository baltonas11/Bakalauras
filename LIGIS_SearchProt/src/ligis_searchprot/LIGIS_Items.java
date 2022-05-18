package Ligis_searchprot;

public class LIGIS_Items {

 String zodid, zodpav, semtipas, kod, kom;
 
public LIGIS_Items(String id, String zod, String kd/*, String km*/){
    this.zodid = id;
    zodpav = zod;
    kod = kd;
   // kom = km;
} 

    public String getZodID() {
        return zodid;
    }

    public void setZodID(String zodid) {
        this.zodid = zodid;
    }
    
     public String getZod() {
        return zodpav;
    }

    public void setZod(String zodpav) {
        this.zodpav = zodpav;
    }   
    
    public String getKod() {
        return kod;
    }

    public void setKod(String kod) {
        this.kod = kod;
    }    
    
    public String getKom() {
        return kom;
    }

    public void setKom(String kom) {
        this.kom = kom;
    }    
    
@Override
    public String toString() {
        return "Rezultatai: " + zodid + " " + zodpav + " " + kod/* + " " + kom*/;
    }    
    
}
