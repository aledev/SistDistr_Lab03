/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.objects;

/**
 *
 * @author alejandro
 */
public class UsuarioObj {
    //<editor-fold defaultstate="collapsed" desc="propiedades privadas">
    private String username;
    private String password;
    private String nombre;
    private String role;
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="constructores">
    public UsuarioObj(){
        
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="propiedades publicas">
    public String getUsername(){
        return this.username;
    }
    
    public void setUsername(String username){
        this.username = username;
    }
    
    public String getPassword(){
        return this.password;
    }
    
    public void setPassword(String password){
        this.password = password;
    }
    
    public String getNombre(){
        return this.nombre;
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public String getRole(){
        return this.role;
    }
    
    public void setRole(String role){
        this.role = role;
    } 
    //</editor-fold>
}
