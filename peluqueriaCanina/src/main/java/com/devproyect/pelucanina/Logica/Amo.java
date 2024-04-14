package com.devproyect.pelucanina.Logica;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Amo implements Serializable{
    
    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int idAmo;
    private String nombre;
    private  String celular;
   
    //Constructores
    public Amo() {
    }

    public Amo(int idAmo, String nombre, String celular) {
        this.idAmo = idAmo;
        this.nombre = nombre;
        this.celular = celular;
    }
    
    //Getter & Setter
    public int getIdAmo() {
        return idAmo;
    }

    public void setIdAmo(int idAmo) {
        this.idAmo = idAmo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }  
}