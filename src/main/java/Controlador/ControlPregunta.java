package Controlador;

import Interface.Ipregunta;
import Modelo.Pregunta;
import config.MySQLConexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControlPregunta implements Ipregunta {

    private Connection cn = null;
    private PreparedStatement st = null;
    private ResultSet rs = null;

    @Override
    public ArrayList<Pregunta> ListarPreguntas(int numero) {

        ArrayList<Pregunta> lista = new ArrayList();

        cn = MySQLConexion.getConexion();
        String consulta = "SELECT*FROM pregunta WHERE numPre=?";
        try {
            st = cn.prepareStatement(consulta);
            st.setInt(1, numero);
            rs = st.executeQuery();

            while (rs.next()) {
                Pregunta p = new Pregunta();
                p.setIdPre(rs.getInt(1));
                p.setPregunta(rs.getString(2));
                p.setRespuesta(rs.getString(3));
                p.setNumPre(rs.getInt(4));
                lista.add(p);
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

}
