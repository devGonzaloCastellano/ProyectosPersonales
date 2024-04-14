package com.devproyect.pelucanina.Logica;

import com.devproyect.pelucanina.Persistencia.ControladoraPersistencia;
import java.util.List;

public class ControladoraLogica {

    ControladoraPersistencia controlPersis = new ControladoraPersistencia();

    public void GuardarL(String nomMasco, String raza, String color, String observaciones, String nomAmo, String celular, String alergico, String atEspecial) {

        //Creamos el amo y asignamos sus valores
        Amo amo = new Amo();
        amo.setNombre(nomAmo);
        amo.setCelular(celular);

        //Creamos mascotas y asignamos sus valores
        Mascota masco = new Mascota();
        masco.setNombre(nomMasco);
        masco.setRaza(raza);
        masco.setColor(color);
        masco.setAlergico(alergico);
        masco.setAtEspecial(atEspecial);
        masco.setObservaciones(observaciones);
        masco.setUnAmo(amo);
        
        controlPersis.GuardarP(amo, masco);
        
        
    }

    public List<Mascota> traerMascotasL() {

        return controlPersis.traerMascotasP();
    }

    public void EliminarMascotaL(int numCliente) {
        controlPersis.EliminarMascotaP(numCliente);
    }

    public Mascota traerMascotaL(int numCliente) {
        return controlPersis.traerMascotaP(numCliente);
    }

    public void EditarMascotaL(Mascota masco, String nomMasco, String raza, String color, String observaciones, String alergico, String atEspecial, String nomAmo, String celular) {
        
        masco.setNombre(nomMasco);
        masco.setRaza(raza);
        masco.setColor(color);
        masco.setAlergico(alergico);
        masco.setAtEspecial(atEspecial);
        masco.setObservaciones(observaciones);
       
        //Modificar Mascota
        controlPersis.EditarMascotaP(masco);
        
        //Seteo de nuevos valores al dueño
        Amo amo = this.buscarAmoL(masco.getUnAmo().getIdAmo());
        amo.setNombre(nomAmo);
        amo.setCelular(celular);
        
        //
        this.EditarAmoL(amo);
    }

    private Amo buscarAmoL(int idAmo) {
        return controlPersis.traerAmoP(idAmo);
    }

    private void EditarAmoL(Amo amo) {
        controlPersis.EditarAmoP(amo);
    }
}