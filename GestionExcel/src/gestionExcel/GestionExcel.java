package gestionExcel;

import Controlador.ControladorExcel;
import Modelo.ModeloExcel;
import Vista.VistaExcel;

public class GestionExcel {
        public static void main(String[] args) {
        ModeloExcel modeloE = new ModeloExcel();
        VistaExcel vistaE = new VistaExcel();
        ControladorExcel contraControladorExcel = new ControladorExcel(vistaE, modeloE);
        vistaE.setVisible(true);
        vistaE.setLocationRelativeTo(null);
    }
}
