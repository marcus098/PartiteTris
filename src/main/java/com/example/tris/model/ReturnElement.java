package com.example.tris.model;

public class ReturnElement {
    Tris tris;
    String message;

    public ReturnElement(Tris tris, String message){
        this.tris = tris;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public Tris getTris() {
        return tris;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setTris(Tris tris) {
        this.tris = tris;
    }

    @Override
    public String toString() {
        return "ReturnElement{" +
                "tris=" + tris +
                ", message='" + message + '\'' +
                '}';
    }
}
