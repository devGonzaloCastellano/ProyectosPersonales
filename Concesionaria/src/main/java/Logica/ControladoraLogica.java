package Logica;

import Persistencia.ControladoraPersistencia;
import java.util.List;



public class ControladoraLogica {

    ControladoraPersistencia controlP = new ControladoraPersistencia();
    
    public void agregarAuto(String modelo, String marca, String motor, String color, String patente, int cantPuertas) {      
        //Se crea el objeto de auto con sus parametros
        Automovil auto = new Automovil();
        auto.setModelo(modelo);
        auto.setMarca(marca);
        auto.setMotor(motor);
        auto.setColor(color);
        auto.setPatente(patente);
        auto.setCantPuertas(cantPuertas);
        //Pasa el objeto a la controladora de persistencia
        controlP.agregarAutoP(auto);
    }

    public List<Automovil> traerAutosL() {
        
        return controlP.traerAutosP();  

    }

    public void borrarAutoL(int idAuto) {
        controlP.borrarAutoP(idAuto);
    }

    public Automovil traerAutoL(int idAuto) {
      return controlP.traerAutoP(idAuto);
    }

    public void editarAutoL(Automovil auto, String modelo, String marca, String motor, String color, String patente, int cantPuertas) {
        
        auto.setModelo(modelo);
        auto.setMarca(marca);
        auto.setMotor(motor);
        auto.setColor(color);
        auto.setPatente(patente);
        auto.setCantPuertas(cantPuertas);
        
        controlP.editarAutoP(auto);

    }
    
}
