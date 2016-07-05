/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author alejandro
 */
public class FinanzaDTO implements  Serializable{
    // <editor-fold defaultstate="collapsed" desc="propiedades privadas">
    // ***
    // propiedades privadas
    private String _id;
    private int id;
    private String nombrePersona;
    private Date fchMovimiento;
    private Double saldoMovimiento;
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="constructores">
    // ***
    // constructores
    public FinanzaDTO(){
        this.id = 0;
        this.nombrePersona = null;
        this.fchMovimiento = null;
        this.saldoMovimiento = null;
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="metodos accesores">
    // ***
    // metodos accesores
    public int getId(){
        return this.id;
    }
    
    public String get_Id(){
        return this._id;
    }
    
    public String getNombrePersona(){
        return this.nombrePersona;
    }
    
    public Date getFchMovimiento(){
        return this.fchMovimiento;
    }
    
    public Double getSaldoMovimiento(){
        return this.saldoMovimiento;
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="metodos mutadores">
    // ***
    // metodos mutadores
    public void set_Id(String _id){
        this._id = _id;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public void setNombrePersona(String nombrePersona){
        this.nombrePersona = nombrePersona;
    }
    
    public void setFchMovimiento(Date fchMovimiento){
        this.fchMovimiento = fchMovimiento;
    }
    
    public void setSaldoMovimiento(Double saldoMovimiento){
        this.saldoMovimiento = saldoMovimiento;
    }
    // </editor-fold>
}
