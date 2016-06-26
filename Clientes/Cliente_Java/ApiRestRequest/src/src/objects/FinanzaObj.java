/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.objects;

import java.util.Date;

/**
 *
 * @author alejandro
 */
public class FinanzaObj {
    //<editor-fold defaultstate="collapsed" desc="propiedades privadas">
    private String nombrePersona;
    private Date fechaMovimiento;
    private int saldoMovimiento;
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="constructores">   
    public FinanzaObj(){
        
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="propiedades publicas">   
    public String getNombrePersona(){
        return this.nombrePersona;
    }
    
    public void setNombrePersona(String nombrePersona){
        this.nombrePersona = nombrePersona;
    }
    
    public Date getFechaMovimiento(){
        return this.fechaMovimiento;
    }
    
    public void setFechaMovimiento(Date fechaMovimiento){
        this.fechaMovimiento = fechaMovimiento;
    }
    
    public int getSaldoMovimiento(){
        return this.saldoMovimiento;
    }
    
    public void setSaldoMovimiento(int saldoMovimiento){
        this.saldoMovimiento = saldoMovimiento;
    }
    //</editor-fold>
}
