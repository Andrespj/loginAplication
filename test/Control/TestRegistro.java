/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import Entidad.*;
import static Frontera.FramePrincipal.sistema;
import java.util.ArrayList;


/**
 *
 * @author ACER
 */
public class TestRegistro {

    private static ValidarRegistro validarRegistro = new ValidarRegistro();

    private String LONG_NOMBRE_INCORRECTA = "longitud nombre incorrecto";
    private String LONG_PASSWORD_INCORRECTA = "longitud contraseña incorrecto";
    private String USUARIO_EXISTENTE = "Usuario ya existe";
    private String CONTRASEÑAS_DIFERENTES = "contraseñas no coinciden";
    private String DATOS_VALIDOS = "Usuario registrado";


    public TestRegistro() {

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
        u.setPasswordVal("123456");
        assertEquals(validarRegistro.verificarRegistro(u), LONG_NOMBRE_INCORRECTA);


        u.setNombre("Roberto");
        u.setPassword("123456");
        u.setPasswordVal("123456");
        assertEquals(validarRegistro.verificarRegistro(u), LONG_NOMBRE_INCORRECTA);

    }
    @Test
    public void testLongitudContrasenia() {
        Usuario u = new Usuario();
        u.setNombre("Pepe");
        u.setPassword("12");
        u.setPasswordVal("12");
        //setPassword==setPasswordVal
        assertEquals(validarRegistro.verificarRegistro(u), LONG_PASSWORD_INCORRECTA);

        u.setNombre("Pepe");
        u.setPassword("123456");
        u.setPasswordVal("123456");
        //setPassword==setPasswordVal
        assertEquals(validarRegistro.verificarRegistro(u), LONG_PASSWORD_INCORRECTA);

    }
    
    @Test
    public void testUsuarioExistente(){
        Usuario u = new Usuario();
        u.setNombre("Juan");
        u.setPassword("123");
        u.setPasswordVal("123");
        assertEquals(validarRegistro.verificarRegistro(u), USUARIO_EXISTENTE);

        u.setNombre("Pedro");
        u.setPassword("123");
        u.setPasswordVal("123");
        assertEquals(validarRegistro.verificarRegistro(u), USUARIO_EXISTENTE);
    }
    
    @Test
    public void testCoincidenciaContraseña(){
        Usuario u = new Usuario();
        u.setNombre("Juan");
        u.setPassword("3222");
        u.setPasswordVal("321");
        assertEquals(validarRegistro.verificarRegistro(u), CONTRASEÑAS_DIFERENTES);

        u.setNombre("Nel");
        u.setPassword("abce");
        u.setPasswordVal("abcd");
        assertEquals(validarRegistro.verificarRegistro(u), CONTRASEÑAS_DIFERENTES);
    }

    @Test
    public void testTodoCorrecto() {

        Usuario u = new Usuario();
        Usuario n = new Usuario();
        Usuario b = new Usuario();
        u.setNombre("Harold");
        u.setPassword("123");
        u.setPasswordVal("123");
        assertEquals(validarRegistro.verificarRegistro(u), DATOS_VALIDOS);

        n.setNombre("Andres");
        n.setPassword("abc");
        n.setPasswordVal("abc");
        assertEquals(validarRegistro.verificarRegistro(n), DATOS_VALIDOS);

        b.setNombre("Nel");
        b.setPassword("a1b2");
        b.setPasswordVal("a1b2");
        assertEquals(validarRegistro.verificarRegistro(b), DATOS_VALIDOS);

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
