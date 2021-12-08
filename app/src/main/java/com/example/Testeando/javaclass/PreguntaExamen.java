package com.example.Testeando.javaclass;

import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class PreguntaExamen {

    String pregunta;
    String resp1;
    String resp2;
    String resp3;
    String resp4;
    String correcta;
    int selctedId;


    public PreguntaExamen(){}

    public PreguntaExamen(String pregunta, String resp1, String resp2, String resp3, String resp4, String correcta, int selctedId) {
        this.pregunta = pregunta;
        this.resp1 = resp1;
        this.resp2 = resp2;
        this.resp3 = resp3;
        this.resp4 = resp4;
        this.correcta = correcta;
        this.selctedId = selctedId;
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

    public String getResp4() {
        return resp4;
    }

    public void setResp4(String resp4) {
        this.resp4 = resp4;
    }

    public String getCorrecta() {
        return correcta;
    }

    public void setCorrecta(String correcta) {
        this.correcta = correcta;
    }

    public int getSelctedId() {
        return selctedId;
    }

    public void setSelctedId(int selctedId) {
        this.selctedId = selctedId;
    }
}

