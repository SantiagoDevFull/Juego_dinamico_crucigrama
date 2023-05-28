package Controlador;

import Interface.Inota;
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

public class ControlNota implements Inota {

    private Connection cn = null;
    private PreparedStatement st = null;
    private ResultSet rs = null;

    @Override
    public ArrayList<Nota> ListarNotas() {

        ArrayList<Nota> lista = new ArrayList();

        cn = MySQLConexion.getConexion();
        String consulta = "SELECT u.idUsu,u.nomUsu,u.patUsu,u.matUsu,n.nota,n.tiempo,n.fecha FROM nota n\n"
                + "INNER JOIN usuario u ON (n.idUsu=u.idUsu) order by n.fecha DESC";
        try {
            st = cn.prepareStatement(consulta);
            rs = st.executeQuery();

            while (rs.next()) {
                Usuario u = new Usuario();
                u.setIdUsu(rs.getInt(1));
                u.setNomUsu(rs.getString(2));
                u.setPatUsu(rs.getString(3));
                u.setMatUsu(rs.getString(4));

                Nota n = new Nota();
                n.setNota(rs.getDouble(5));
                n.setTiempo(rs.getString(6));
                n.setFecha(rs.getString(7));
                n.setUsuario(u);

                lista.add(n);
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
    public int RegistrarNota(Nota nota) {

        int res = 0;

        cn = MySQLConexion.getConexion();
        String consulta = "INSERT INTO nota VALUES (?,?,?,?,?);";
        try {
            st = cn.prepareStatement(consulta);

            st.setInt(1, 0);
            st.setDouble(2, nota.getNota());
            st.setString(3, nota.getTiempo());
            st.setString(4, nota.getFecha());
            st.setInt(5, nota.getUsuario().getIdUsu());

            res = st.executeUpdate();
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
        return res;
    }

}
