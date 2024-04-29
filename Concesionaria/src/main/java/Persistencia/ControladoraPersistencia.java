package Persistencia;

import Logica.Automovil;
import Persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControladoraPersistencia {

    AutomovilJpaController autoJPA = new AutomovilJpaController();

    public void agregarAutoP(Automovil auto) {
        autoJPA.create(auto);
    }

    public List<Automovil> traerAutosP() {
        //Trae todos los registros de autos de la BD
        return autoJPA.findAutomovilEntities();

    }

    public void borrarAutoP(int idAuto) {
        try {
            autoJPA.destroy(idAuto);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Automovil traerAutoP(int idAuto) {
        return autoJPA.findAutomovil(idAuto);
    }

    public void editarAutoP(Automovil auto) {
        try {
            autoJPA.edit(auto);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
