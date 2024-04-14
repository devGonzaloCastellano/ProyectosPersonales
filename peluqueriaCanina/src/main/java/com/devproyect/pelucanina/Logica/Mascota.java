package com.devproyect.pelucanina.Logica;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Mascota implements Serializable {

    //Atributos
   @Id
   @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int numCliente;
    private String nombre;
    private String raza;
    private String color;
    private String alergico;
    private String atEspecial;
    private String Observaciones;

    //Relacion 1 a 1 con AMO
    @OneToOne
    private Amo unAmo;

    //Constructores
    public Mascota() {
    }

    public Mascota(int numCliente, String nombre, String raza, String color, String alergico, String atEspecial, String Observaciones, Amo unAmo) {
        this.numCliente = numCliente;
        this.nombre = nombre;
        this.raza = raza;
        this.color = color;
        this.alergico = alergico;
        this.atEspecial = atEspecial;
        this.Observaciones = Observaciones;
        this.unAmo = unAmo;
    }

    //Getter & Setter
    public int getNumCliente() {
        return numCliente;
    }

    public void setNumCliente(int numCliente) {
        this.numCliente = numCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getAlergico() {
        return alergico;
    }

    public void setAlergico(String alergico) {
        this.alergico = alergico;
    }

    public String getAtEspecial() {
        return atEspecial;
    }

    public void setAtEspecial(String atEspecial) {
        this.atEspecial = atEspecial;
    }

    public String getObservaciones() {
        return Observaciones;
    }

    public void setObservaciones(String Observaciones) {
        this.Observaciones = Observaciones;
    }

    public Amo getUnAmo() {
        return unAmo;
    }

    public void setUnAmo(Amo unAmo) {
        this.unAmo = unAmo;
    }
}
