package Modelo;

public class Pregunta {

    private int idPre;
    private String pregunta;
    private String respuesta;
    private int numPre;

    public Pregunta() {
    }

    public Pregunta(int idPre, String pregunta, String respuesta, int numPre) {
        this.idPre = idPre;
        this.pregunta = pregunta;
        this.respuesta = respuesta;
        this.numPre = numPre;
    }

    public int getNumPre() {
        return numPre;
    }

    public void setNumPre(int numPre) {
        this.numPre = numPre;
    }

    public int getIdPre() {
        return idPre;
    }

    public void setIdPre(int idPre) {
        this.idPre = idPre;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

}
