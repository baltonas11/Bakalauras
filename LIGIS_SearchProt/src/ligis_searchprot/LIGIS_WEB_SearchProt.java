package Ligis_searchprot;

import java.io.PrintWriter;
import java.util.ArrayList;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class LIGIS_WEB_SearchProt {

    private static ArrayList<LIGIS_Web_Items> LIGIS_Web_ItemsList = new ArrayList();

    public static void main(String[] args) {
    int keyid;
    
    }
        
        public static void WebSearch(String raktas){
            
        ArrayList<LIGIS_Web_Items> rezultz = new ArrayList();
     
        //String raktas = "namas";
        String url = "https://www.google.com/search" + "?q=" + raktas + "&num=200";
        
        try{
            
            
            
            
            Document doc = Jsoup.connect(url).get();
            Elements sak = doc.select("div.VwiC3b.yXK7lf.MUxGbd.yDYNvb.lyLwlc.lEBKkf");
            //System.out.println(sak);
            for(Element saks : sak)
            {
                
                String ats = saks.select("span").text();
                
                //System.out.println(ats);

                System.out.println(raktas);
               // System.out.println(saks.text());               
               
                

                LIGIS_Web_Items naujas = new LIGIS_Web_Items(ats);
                LIGIS_Web_ItemsList.add(naujas);
                
               

            }
    

           }
        catch (Exception e){
            e.printStackTrace();
        }
    }
        
        
    public static ArrayList<LIGIS_Web_Items> GetWebWords() {
    System.out.println("Gauta");
    return LIGIS_Web_ItemsList;
    }
        
        
        
    

    
}
