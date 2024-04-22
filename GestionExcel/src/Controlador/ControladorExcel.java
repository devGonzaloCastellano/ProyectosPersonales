package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import Vista.VistaExcel;
import Modelo.ModeloExcel;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class ControladorExcel implements ActionListener {

    ModeloExcel modeloE = new ModeloExcel(); // Instancia del modelo que maneja la lógica de importación/exportación
    VistaExcel vistaE = new VistaExcel(); // Instancia de la vista que contiene los elementos gráficos
    // Componente Selector de archivos
    JFileChooser selectArchivo = new JFileChooser(); // Selector de archivos para abrir o guardar
    File archivo; // Archivo seleccionado
    int contAccion = 0; // Contador de acciones realizadas

    // Constructor que recibe la vista y el modelo como parámetros
    public ControladorExcel(VistaExcel vistaE, ModeloExcel modeloE) {
        this.vistaE = vistaE;
        this.modeloE = modeloE;
        this.vistaE.btnImportar.addActionListener(this); // Agregar el controlador de eventos al botón de importación
        this.vistaE.btnExportar.addActionListener(this); // Agregar el controlador de eventos al botón de exportación
    }

    // Método para agregar filtros al selector de archivos
    public void AgregarFiltro() {
        // Agregar filtro para archivos de Excel (.xls)
        selectArchivo.setFileFilter(new FileNameExtensionFilter("Excel (*.xls)", "xls"));
        // Agregar filtro para archivos de Excel (.xlsx)
        selectArchivo.setFileFilter(new FileNameExtensionFilter("Excel (*.xls)", "xlsx"));
    }

    // Método que maneja los eventos de los botones
    @Override
    public void actionPerformed(ActionEvent e) {
        contAccion++; // Incrementar el contador de acciones

        // Llamar al método para agregar filtro en la primera acción
        if (contAccion == 1) {
            AgregarFiltro();
        }

        // Método para importar archivos
        if (e.getSource() == vistaE.btnImportar) { // Si se hace clic en el botón de importar
            if (selectArchivo.showDialog(null, "Seleccionar archivo") == JFileChooser.APPROVE_OPTION) { // Si se selecciona un archivo
                archivo = selectArchivo.getSelectedFile(); // Obtener el archivo seleccionado
                if (archivo.getName().endsWith("xls") || archivo.getName().endsWith("xlsx")) { // Verificar el formato del archivo
                    JOptionPane.showMessageDialog(null, modeloE.Importar(archivo, vistaE.tbDatos)); // Importar y mostrar mensaje
                } else {
                    JOptionPane.showMessageDialog(null, "Elija un formato valido"); // Mostrar mensaje de error si el formato no es válido
                }
            }
        }

        // Método para exportar archivos
        if (e.getSource() == vistaE.btnExportar) { // Si se hace clic en el botón de exportar
            if (selectArchivo.showDialog(null, "Exportar") == JFileChooser.APPROVE_OPTION) { // Si se selecciona un archivo
                archivo = selectArchivo.getSelectedFile(); // Obtener el archivo seleccionado
                if (archivo.getName().endsWith("xls") || archivo.getName().endsWith("xlsx")) { // Verificar el formato del archivo
                    JOptionPane.showMessageDialog(null, modeloE.Exportar(archivo, vistaE.tbDatos)); // Exportar y mostrar mensaje
                } else {
                    JOptionPane.showMessageDialog(null, "Elija un formato valido"); // Mostrar mensaje de error si el formato no es válido
                }
            }
        }
    }
}
