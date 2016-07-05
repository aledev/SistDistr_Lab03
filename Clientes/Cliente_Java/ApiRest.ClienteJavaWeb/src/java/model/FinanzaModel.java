/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.util.List;
import dto.FinanzaDTO;
import java.lang.ProcessBuilder.Redirect.Type;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import src.core.JRequestLib;

/**
 *
 * @author aialiagam
 */
public class FinanzaModel {
    // <editor-fold defaultstate="collapsed" desc="propiedades privadas">
    //private ConexionCliente conexionRMI;
    private static FinanzaModel instance = null;
    //private IFinanzaRMI finanzaRMI;
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="constructores">
    
    // constructor privado
    private FinanzaModel(){
        //this.conexionRMI = new ConexionCliente();
    }
    
    // metodo para obtener la instancia del singleton
    public static FinanzaModel GetInstance(){
        if(FinanzaModel.instance == null){
            FinanzaModel.instance = new FinanzaModel();
        }
    
        return FinanzaModel.instance;
    }
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="buscarAll">
    public List<FinanzaDTO> buscarAll() throws Exception{
        FinanzaDTO objResult = null;
        List<FinanzaDTO> lista = new ArrayList<FinanzaDTO>();
        try{
            JRequestLib request = new JRequestLib();
            Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").create();
            String jsonResult = request.getRequest(conf.Parameters.PARAM_URL_GET_LISTA_FINANZA);
            java.lang.reflect.Type finanzasListType = new TypeToken<Collection<FinanzaDTO>>(){}.getType();
            List<FinanzaDTO> finanzaObj = gson.fromJson(jsonResult, finanzasListType);
            lista = finanzaObj;
        }
        catch(Exception ex){
            throw ex;
        }
        
        return lista;
    }
    // </editor-fold>
    
    
    // <editor-fold defaultstate="collapsed" desc="metodos publicos">
    public FinanzaDTO buscarById(String id) throws Exception{
        FinanzaDTO objResult = null;
        try{
            JRequestLib request = new JRequestLib();
            Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").create();
            String content = "id=" + URLEncoder.encode(id);
            String jsonResult = request.getRequest(conf.Parameters.PARAM_URL_GET_DETALLE_FINANZA + "?id=" + id);
            java.lang.reflect.Type finanzaType = new TypeToken<List<FinanzaDTO>>(){}.getType();
            List<FinanzaDTO> finanzaObj = gson.fromJson(jsonResult, finanzaType);
            
            objResult = finanzaObj.get(0);
        }
        catch(Exception ex){
            throw ex;
        }
        
        return objResult;
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="metodos publicos">
    public boolean borrarFinanza( FinanzaDTO fin) throws Exception{
        boolean salida=false;
        try{
            JRequestLib request = new JRequestLib();
            Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").create();
            String content = "id=" + URLEncoder.encode(fin.get_Id());
            String jsonResult = request.deleteRequest(conf.Parameters.PARAM_URL_DELETE_ELIMINAR_FINANZA, content);
            boolean resultObj = gson.fromJson(jsonResult, boolean.class);
            // Iniciamos el registro del RMI
            //if(this.conexionRMI.iniciarRegistro(Parameters.PARAM_IP_SERVER_RMI, Parameters.PARAM_PORT_SERVER_RMI)){
            //    this.finanzaRMI = this.conexionRMI.getServidorFinanza();
            //}    
            
            //salida = this.finanzaRMI.deleteFinanza(fin);
            salida = resultObj;
        }
        catch(Exception ex){
            throw ex;
        }
        
        return salida;
    }
    // </editor-fold> 
    
     public boolean insertarFinanza(FinanzaDTO fin) throws Exception{
        boolean salida=false;
        try{
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            JRequestLib request = new JRequestLib();
            Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").create();
            String content = "nombrePersona=" + URLEncoder.encode(fin.getNombrePersona()) + 
                             "&fchMovimiento=" + URLEncoder.encode(df.format(fin.getFchMovimiento()) + "T00:00:00.000Z") +
                             "&saldoMovimiento=" + URLEncoder.encode(String.valueOf(fin.getSaldoMovimiento()));
            String jsonResult = request.postRequest(conf.Parameters.PARAM_URL_POST_CREAR_FINANZA, content);
            boolean resultObj = gson.fromJson(jsonResult, boolean.class);
            
            salida = resultObj;
        }
        catch(Exception ex){
            throw ex;
        }
        
        return salida;
    }
    // </editor-fold> 
    
     public boolean update(FinanzaDTO fin) throws Exception{
        boolean salida=false;
        try{
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            JRequestLib request = new JRequestLib();
            Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").create();
            String content = "id=" + URLEncoder.encode(fin.get_Id()) + 
                             "&nombrePersona=" + URLEncoder.encode(fin.getNombrePersona()) + 
                             "&fchMovimiento=" + URLEncoder.encode(df.format(fin.getFchMovimiento()) + "T00:00:00.000Z") +
                             "&saldoMovimiento=" + URLEncoder.encode(String.valueOf(fin.getSaldoMovimiento()));
            String jsonResult = request.putRequest(conf.Parameters.PARAM_URL_PUT_EDITAR_FINANZA, content);
            boolean resultObj = gson.fromJson(jsonResult, boolean.class);
            
            salida = resultObj;
        }
        catch(Exception ex){
            throw ex;
        }
        
        return salida;
    }
    // </editor-fold> 
}
