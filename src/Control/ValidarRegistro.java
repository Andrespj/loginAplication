/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Entidad.Sistema;
import Entidad.Usuario;
import Frontera.FramePrincipal;
import static Frontera.FramePrincipal.sistema;
import java.util.ArrayList;

/**
 *
 * @author ACER
 */
public class ValidarRegistro {
    private Sistema sistema=FramePrincipal.sistema;
    
    public ValidarRegistro(){
        
    }
    public String verificarRegistro(Usuario usuario){
        if(!ValidarLongitudNombre(usuario.getNombre()))
            return ("longitud nombre incorrecto");
        if(!ValidarLogitudPassword(usuario.getPassword()))
            return ("longitud contraseña incorrecto");
       
        if(!usuario.getPassword().equals(usuario.getPasswordVal()))
           return ("contraseñas no coinciden");
       
        for(Usuario u: sistema.getUsuarios()){
            if(u.getNombre().equals(usuario.getNombre()))
            return ("Usuario ya existe");
            
        }
                ArrayList <Usuario> usuarios = sistema.getUsuarios();
                usuarios.add(usuario);
                sistema.setUsuarios(usuarios);  
        
        return ("Usuario registrado");
        
    }
    public boolean ValidarLongitudNombre(String nombre){
        return (nombre.length()>1 && nombre.length()<=6);
    }
    public boolean ValidarLogitudPassword(String password){
        return (password.length()>=3 && password.length()<=6);
    }
    
}
