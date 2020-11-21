package com.gaston.ejercicioparcial2020;

public class Alumno {
    private String nombre;
    private String apellido;
    private int legajo;
    private String turnoElegido;


    public Alumno(String nombre, String apellido, int legajo, String turnoElegido) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.legajo = legajo;
        this.turnoElegido = turnoElegido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getLegajo() {
        return legajo;
    }

    public void setLegajo(int legajo) {
        this.legajo = legajo;
    }

    public String getTurnoElegido() {
        return turnoElegido;
    }

    public void setTurnoElegido(String turnoElegido) {
        this.turnoElegido = turnoElegido;
    }
}
