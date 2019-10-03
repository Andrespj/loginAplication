/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidad;
import java.util.ArrayList;

/**
 *
 * @author usuario
 */
public class Sistema {
    private ArrayList <Usuario> usuarios;
    
    public Sistema(){
        
    }
    
    public ArrayList<Usuario> getUsuarios(){
        return usuarios;
    }
    public void setUsuarios(ArrayList<Usuario> usuarios){
        this.usuarios=usuarios;
        
    }
    
    
}
