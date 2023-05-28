package Interface;

import Modelo.Usuario;
import java.util.ArrayList;

public interface Iusuario {
   
    
    public ArrayList<Usuario>ListarUsuarios();
    public Usuario IniciarSesionUsuario(String correo);
    public Usuario Login(String correo);
    
}
