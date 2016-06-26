/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 *
 * @author alejandro
 */
public class JRequestLib {
    //<editor-fold defaultstate="collapsed" desc="propiedades privadas">
    private static String CPREFIX = "src.core.JRequestLib";
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="constructores">
    public JRequestLib(){
        
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="metodos publicos">
    
    //<editor-fold defaultstate="collapsed" desc="getRequest">   
    public String getRequest(String p_Url) throws Exception {
        String MPREFIX = "getRequest(String)";
        String jsonResult = "";
        
        try {
            URL url = new URL(p_Url);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            if (conn.getResponseCode() != 200) {
                throw new Exception("Failed : HTTP error code : " + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(
                (conn.getInputStream())));

            String output;
            System.out.println("Output from Server .... \n");

            while ((output = br.readLine()) != null) {
                System.out.println(output);
                jsonResult += output;
            }
            
            conn.disconnect();
        } 
        //catch (MalformedURLException e) {
        //    e.printStackTrace();
        //} 
        //catch (IOException e) {
        //    e.printStackTrace();
        //}
        catch(Exception e){
            throw e;
        }
        
        return jsonResult;
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="postRequest">
    public String postRequest(String p_Url, String p_JsonData) throws Exception {
        String MPREFIX = "getRequest(String)";
        String jsonResult = "";
        
        try {
            URL url = new URL(p_Url);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");

            String input = p_JsonData;

            OutputStream os = conn.getOutputStream();
            os.write(input.getBytes());
            os.flush();

            if (conn.getResponseCode() != HttpURLConnection.HTTP_CREATED) {
                throw new Exception("Failed : HTTP error code : " + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(
                (conn.getInputStream())));

            String output;
            System.out.println("Output from Server .... \n");

            while ((output = br.readLine()) != null) {
                System.out.println(output);
                jsonResult += output;
            }

            conn.disconnect();
        } 
        //catch (MalformedURLException e) {
        //    e.printStackTrace();
        //} 
        //catch (IOException e) {
        //    e.printStackTrace();
        //}
        catch(Exception e){
            throw e;
        }
        
        return jsonResult;
    }
    //</editor-fold>
    
    
    
    //</editor-fold>
}
