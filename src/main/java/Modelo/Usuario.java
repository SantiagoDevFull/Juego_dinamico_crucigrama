package Modelo;

public class Usuario {

    private int idUsu;
    private String correoUsu;
    private String nomUsu;
    private String patUsu;
    private String matUsu;
    private Nota nota;

    public Usuario() {
    }

    public Usuario(int idUsu, String correoUsu, String nomUsu, String patUsu, String matUsu) {
        this.idUsu = idUsu;
        this.correoUsu = correoUsu;
        this.nomUsu = nomUsu;
        this.patUsu = patUsu;
        this.matUsu = matUsu;
    }

    public String getMatUsu() {
        return matUsu;
    }

    public void setMatUsu(String matUsu) {
        this.matUsu = matUsu;
    }

    public int getIdUsu() {
        return idUsu;
    }

    public void setIdUsu(int idUsu) {
        this.idUsu = idUsu;
    }

    public String getCorreoUsu() {
        return correoUsu;
    }

    public void setCorreoUsu(String correoUsu) {
        this.correoUsu = correoUsu;
    }

    public String getNomUsu() {
        return nomUsu;
    }

    public void setNomUsu(String nomUsu) {
        this.nomUsu = nomUsu;
    }

    public String getPatUsu() {
        return patUsu;
    }

    public void setPatUsu(String patUsu) {
        this.patUsu = patUsu;
    }

    public Nota getNota() {
        return nota;
    }

    public void setNota(Nota nota) {
        this.nota = nota;
    }

}
