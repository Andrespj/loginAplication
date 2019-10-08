/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;
import Entidad.Usuario;
import Frontera.FramePrincipal;
import Entidad.Sistema;

/**
 *
 * @author usuario
 */
public class ValidarLogin {
    private Sistema sistema=FramePrincipal.sistema;
    
    public ValidarLogin(){
        
    }
    public String verificarLogin(Usuario usuario){
        if(!ValidarLongitudNombre(usuario.getNombre()))
            return ("longitud nombre incorrecto");
        if(!ValidarLogitudPassword(usuario.getPassword()))
            return ("longitud contraseña incorrecto");
        for(Usuario u: sistema.getUsuarios()){
            if(u.getNombre().equals(usuario.getNombre())&&
                    u.getPassword().equals(usuario.getPassword()))
                return ("bienvenido");
            
        }
            return ("datos incorrectos");
        
    
    }
    public boolean ValidarLongitudNombre(String nombre){
        return (nombre.length()>1 && nombre.length()<=6);
    }
    public boolean ValidarLogitudPassword(String password){
        return (password.length()>=3 && password.length()<6);
    }
}
