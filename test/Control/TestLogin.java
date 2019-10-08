/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Entidad.Usuario;
import static Frontera.FramePrincipal.sistema;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author usuario
 */
public class TestLogin {

    private static ValidarLogin ValidarLogin = new ValidarLogin();

    private String LONG_NOMBRE_INCORRECTA = "longitud nombre incorrecto";
    private String LONG_PASSWORD_INCORRECTA = "longitud contraseña incorrecto";
    private String DATOS_INCORRECTOS = "datos incorrectos";
    private String USUARIO_AUTORIZADO = "bienvenido";

    public TestLogin() {

    }

    @BeforeClass
    public static void setUpClass() throws Exception {

        ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
        Usuario a = new Usuario();
        Usuario b = new Usuario();
        Usuario c = new Usuario();

        a.setNombre("Juan");
        a.setPassword("1234");
        b.setNombre("Pedro");
        b.setPassword("123");
        c.setNombre("Maria");
        c.setPassword("12345");

        usuarios.add(a);
        usuarios.add(b);
        usuarios.add(c);

        sistema.setUsuarios(usuarios);

    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @Test
    public void testLongitudNombre() {
        Usuario u = new Usuario();
        u.setNombre("R");
        u.setPassword("123456");
        assertEquals(ValidarLogin.verificarLogin(u), LONG_NOMBRE_INCORRECTA);

        u.setNombre("Roberto");
        u.setPassword("123456");
        assertEquals(ValidarLogin.verificarLogin(u), LONG_NOMBRE_INCORRECTA);

    }

    @Test
    public void testLongitudContrasenia() {
        Usuario u = new Usuario();
        u.setNombre("Pepe");
        u.setPassword("12");
        assertEquals(ValidarLogin.verificarLogin(u), LONG_PASSWORD_INCORRECTA);

      u.setNombre("Pepe");
        u.setPassword("123456");
        assertEquals(ValidarLogin.verificarLogin(u), LONG_PASSWORD_INCORRECTA);

    }
    @Test
    public void testNombre(){
        Usuario u = new Usuario();
        u.setNombre("Henry");
        u.setPassword("12345");
        assertEquals(ValidarLogin.verificarLogin(u), DATOS_INCORRECTOS);

        
    }
    
        @Test
    public void testContrasenia(){
        Usuario u = new Usuario();
        u.setNombre("Maria");
        u.setPassword("1234");
        assertEquals(ValidarLogin.verificarLogin(u), DATOS_INCORRECTOS);

        
    }
    
            @Test
    public void testDatos(){
        Usuario u = new Usuario();
        u.setNombre("Henry");
        u.setPassword("A234");
        assertEquals(ValidarLogin.verificarLogin(u), DATOS_INCORRECTOS);

        
    }
    
     @Test
    public void testTodoCorrecto(){
       Usuario u = new Usuario();
       u.setNombre("Juan");
        u.setPassword("1234");
        assertEquals(ValidarLogin.verificarLogin(u), USUARIO_AUTORIZADO);

       u.setNombre("Pedro");
        u.setPassword("123");
        assertEquals(ValidarLogin.verificarLogin(u), USUARIO_AUTORIZADO);

        u.setNombre("Maria");
        u.setPassword("12345");
        assertEquals(ValidarLogin.verificarLogin(u), USUARIO_AUTORIZADO);

        
    }

    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
