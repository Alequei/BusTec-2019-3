package com.example.bustec.Clases;

public class Horarios {
    private Integer id;
    private String tiempo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTiempo() {
        return tiempo;
    }

    public void setTiempo(String tiempo) {
        this.tiempo = tiempo;
    }

    @Override
    public String toString() {
        return "Horarios{" +
                "id=" + id +
                ", tiempo='" + tiempo + '\'' +
                '}';
    }
}
