package Controlador;

import Interface.Iusuario;
import Modelo.Nota;
import Modelo.Usuario;
import config.MySQLConexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControlUsuario implements Iusuario {

    private Connection cn = null;
    private PreparedStatement st = null;
    private ResultSet rs = null;

    @Override
    public ArrayList<Usuario> ListarUsuarios() {

        ArrayList<Usuario> lista = new ArrayList();

        cn = MySQLConexion.getConexion();
        String consulta = "SELECT*FROM usuario";
        try {
            st = cn.prepareStatement(consulta);
            rs = st.executeQuery();

            while (rs.next()) {
                Usuario u = new Usuario();
                u.setIdUsu(rs.getInt(1));
                u.setCorreoUsu(rs.getString(2));
                u.setNomUsu(rs.getString(3));
                u.setPatUsu(rs.getString(4));
                u.setMatUsu(rs.getString(5));
                lista.add(u);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {

                if (cn != null) {
                    cn.close();
                }
                if (st != null) {
                    st.close();
                }
                if (rs != null) {
                    rs.close();
                }

            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return lista;
    }

    @Override
    public Usuario IniciarSesionUsuario(String correo) {

        Usuario u = null;

        cn = MySQLConexion.getConexion();
        String consulta = "SELECT u.idUsu,u.correoUsu,u.nomUsu,u.patUsu,u.matUsu,n.fecha FROM usuario u\n"
                + "INNER JOIN nota n ON (u.idUsu=n.idUsu)\n"
                + "WHERE correoUsu=?\n"
                + "ORDER BY n.fecha DESC";

        try {
            st = cn.prepareStatement(consulta);
            st.setString(1, correo);
            rs = st.executeQuery();

            if (rs.next()) {
                u = new Usuario();
                u.setIdUsu(rs.getInt(1));
                u.setCorreoUsu(rs.getString(2));
                u.setNomUsu(rs.getString(3));
                u.setPatUsu(rs.getString(4));
                u.setMatUsu(rs.getString(5));

                Nota nota = new Nota();
                nota.setFecha(rs.getString(6));

                u.setNota(nota);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {

                if (cn != null) {
                    cn.close();
                }
                if (st != null) {
                    st.close();
                }
                if (rs != null) {
                    rs.close();
                }

            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return u;
    }

    @Override
    public Usuario Login(String correo) {

        Usuario u = null;

        cn = MySQLConexion.getConexion();
        String consulta = "SELECT *from usuario WHERE correoUsu=?";

        try {
            st = cn.prepareStatement(consulta);
            st.setString(1, correo);
            rs = st.executeQuery();

            if (rs.next()) {
                u = new Usuario();
                u.setIdUsu(rs.getInt(1));
                u.setCorreoUsu(rs.getString(2));
                u.setNomUsu(rs.getString(3));
                u.setPatUsu(rs.getString(4));
                u.setMatUsu(rs.getString(5));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {

                if (cn != null) {
                    cn.close();
                }
                if (st != null) {
                    st.close();
                }
                if (rs != null) {
                    rs.close();
                }

            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return u;

    }

}
