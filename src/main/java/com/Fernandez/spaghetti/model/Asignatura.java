package com.Fernandez.spaghetti.model;

public class Asignatura {

    private int id;
    private String nombre;
    private String codigo;
    private int creditos;
    private String docente;

    public Asignatura() {}

    public Asignatura(int id, String nombre, String codigo, int creditos, String docente) {
        this.id = id;
        this.nombre = nombre;
        this.codigo = codigo;
        this.creditos = creditos;
        this.docente = docente;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }

    public int getCreditos() { return creditos; }
    public void setCreditos(int creditos) { this.creditos = creditos; }

    public String getDocente() { return docente; }
    public void setDocente(String docente) { this.docente = docente; }
}