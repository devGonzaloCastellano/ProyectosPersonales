package com.devproyect.pelucanina.Persistencia;

import com.devproyect.pelucanina.Logica.Amo;
import com.devproyect.pelucanina.Logica.Mascota;
import com.devproyect.pelucanina.Persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControladoraPersistencia {
    
    AmoJpaController amoJPA = new AmoJpaController();
    MascotaJpaController mascoJPA = new MascotaJpaController();

    public void GuardarP(Amo amo, Mascota masco) {
        
        //Crea en la BD al Dueño
        amoJPA.create(amo);
        
        //Crea en la BD a la mascota
        mascoJPA.create(masco);
    }

    public List<Mascota> traerMascotasP() {
        return mascoJPA.findMascotaEntities();
    }

    public void EliminarMascotaP(int numCliente) {
        try {
            mascoJPA.destroy(numCliente);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Mascota traerMascotaP(int numCliente) {
        return mascoJPA.findMascota(numCliente);
    }

    public void EditarMascotaP(Mascota masco) {
        try {
            mascoJPA.edit(masco);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Amo traerAmoP(int idAmo) {
        return amoJPA.findAmo(idAmo);
    }

    public void EditarAmoP(Amo amo) {
        try {
            amoJPA.edit(amo);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
                
    }
    
    
}
