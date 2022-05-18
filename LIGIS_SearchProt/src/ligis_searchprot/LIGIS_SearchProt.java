package Ligis_searchprot;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.sql.ResultSet;

public class LIGIS_SearchProt {

    private static ArrayList<LIGIS_Items> LIGIS_ItemsList = new ArrayList();
    
    public static void main(String[] args) {
        String raktas = "";
       SearchWordDB(raktas); 
       
    }
    
    static Connection conn;
    static Statement stm;
    static PreparedStatement prepStmt;
    static String Rowno;
    
    public static void connectDB() {
        try {
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=ligis2;", "abc", "abc");
            stm = conn.createStatement();
            System.out.println("prisijungta");
        } catch (Exception e) {
            System.out.println("neprisijungta");
        }
    }

    public static void disconnectDB() {
        if (stm != null && conn != null) {
            try {
                stm.close();
                conn.close();
            } catch (Exception e) {

            }
        }
    }
    
    
public static void SearchWordDB(String raktas){


        //String raktas = "bėgti";
    
    
        int i = 0;
        
        ArrayList<LIGIS_Items> rezult = new ArrayList();
        try {

            connectDB();
            String sql = "SELECT zodis.zod_id, zodis.z_pavad, zodis.koduote FROM zodis WHERE zodis.z_pavad = '" + raktas + "' ";

            ResultSet rs = stm.executeQuery(sql);

            while (rs.next()) {
                
                i++;


                
                int zodId = rs.getInt(1);
                
                String zodis = rs.getString("z_pavad");


                String kodas = rs.getString("koduote");



               // Rowno = Integer.toString(i);

                

                LIGIS_Items naujas = new LIGIS_Items(Integer.toString(zodId), zodis, kodas);
                LIGIS_ItemsList.add(naujas);

                

            }
            rs.close();
            disconnectDB();
            
        } catch (Exception e) {
            System.out.println("Klaida");
        }     
    }
    
    public static ArrayList<LIGIS_Items> GetDBWords() {
    System.out.println("Gauta");
    return LIGIS_ItemsList;
    }
    
    public static void SaveDBWords(String zid, String sak) throws Exception{
               
        int sID = Integer.parseInt(zid); 
        
            connectDB();

            String insertSql = "INSERT INTO semantika([zod_id], [sem_tipas], [komentaras]) OUTPUT Inserted.zod_id VALUES (?,?,?)";
            PreparedStatement prepStmt = conn.prepareStatement(insertSql, Statement.RETURN_GENERATED_KEYS);
            prepStmt.setInt(1, sID);
            prepStmt.setString(2, "P");
            prepStmt.setString(3, sak);
            prepStmt.execute();
            ResultSet rs = prepStmt.getGeneratedKeys();
            int generatedKey = 0;
            if (rs.next()) {
                generatedKey = rs.getInt(1);
                System.out.println(generatedKey);
            }
            disconnectDB();
        }
        

    
    
       public static int getZodId(String zpavad) throws Exception {
        int zid = 0;
        connectDB();
        String sql = "SELECT zodis.zod_id FROM zodis WHERE zodis.z_pavad = '" + zpavad + "'";
        ResultSet rs = stm.executeQuery(sql);
        while (rs.next()) {
            zid = rs.getInt(1);
        }
        rs.close();
        disconnectDB();
        return zid;
    }





}


    

