package com.example.Testeando.javaclass;

public class CreaPreguntasHandler {

    String asignatura,pregunta,resp1,resp2,resp3,resp4,correcta;


    public CreaPreguntasHandler() {

    }

    public CreaPreguntasHandler(String asignatura,String pregunta, String resp1, String resp2, String resp3,String resp4, String correcta ) {
        this.asignatura=asignatura;
        this.pregunta = pregunta;
        this.resp1 = resp1;
        this.resp2 = resp2;
        this.resp3 = resp3;
        this.resp4 = resp4;
        this.correcta = correcta;


    }

    public String getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(String asignatura) {
        this.asignatura = asignatura;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public String getResp1() {
        return resp1;
    }

    public void setResp1(String resp1) {
        this.resp1 = resp1;
    }

    public String getResp2() {
        return resp2;
    }

    public void setResp2(String resp2) {
        this.resp2 = resp2;
    }

    public String getResp3() {
        return resp3;
    }

    public void setResp3(String resp3) {
        this.resp3 = resp3;
    }

    public String getCorrecta() {
        return correcta;
    }

    public void setCorrecta(String correcta) {
        this.correcta = correcta;
    }


    public String getResp4() {
        return resp4;
    }

    public void setResp4(String resp4) {
        this.resp4 = resp4;
    }
}
