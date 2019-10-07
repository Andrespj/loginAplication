/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidad;

/**
 *
 * @author usuario
 */
public class Usuario {
    private String nombre;
    private String password;
    private String passwordVal;
    
    public Usuario(){
        
    }
   /* public Usuario(String nombre, String password,String passwordVal){
        
    }*/

    
    public  String getNombre(){
        return nombre;
    }
    public void setNombre(String nombre){
        this.nombre=nombre;
    }
       public String getPassword(){
        return password;
    }
    public void setPassword(String password){
        this.password=password;
    }
    public String getPasswordVal(){
        return passwordVal;
    }
    public void setPasswordVal(String passwordVal){
        this.passwordVal=passwordVal;
    }

}
