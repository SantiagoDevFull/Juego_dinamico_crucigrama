package Modelo;

public class Nota {

    private int idNota;
    private double nota;
    private String tiempo;
    private String fecha;
    private Usuario usuario;

    public Nota() {
    }

    public Nota(int idNota, double nota, String tiempo, String fecha, Usuario usuario) {
        this.idNota = idNota;
        this.nota = nota;
        this.tiempo = tiempo;
        this.fecha = fecha;
        this.usuario = usuario;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getIdNota() {
        return idNota;
    }

    public void setIdNota(int idNota) {
        this.idNota = idNota;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public String getTiempo() {
        return tiempo;
    }

    public void setTiempo(String tiempo) {
        this.tiempo = tiempo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}
