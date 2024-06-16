package Modelo;

import java.io.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.ss.usermodel.Workbook;

import org.apache.poi.ss.usermodel.*;

public class TablaParticipantes {

    Workbook wb; // Objeto Workbook para manejar el libro de Excel
    // Método para importar datos desde un archivo Excel a una tabla JTable

    public String Importar(File archivo, JTable tablaD) {
        String respuesta = "No se pudo realizar la importacion";

        // Definir un modelo de tabla personalizado que no permita edición
        DefaultTableModel modeloT = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; //las celdas no serán editables
            }
        };
        tablaD.setModel(modeloT); // Asignar el modelo a la tabla

        try {
            // Crear un Workbook a partir del archivo Excel
            wb = WorkbookFactory.create(new FileInputStream(archivo));
            Sheet hoja = wb.getSheetAt(0); // Obtener la primera hoja del libro
            Iterator filaIterator = hoja.rowIterator(); // Iterador para las filas
            int indiceFila = -1;

            while (filaIterator.hasNext()) { // Recorrer las filas
                indiceFila++;
                Row fila = (Row) filaIterator.next(); // Obtener la fila actual
                Iterator columnaIterator = fila.cellIterator(); // Iterador para las celdas
                Object[] listaColumna = new Object[5]; // Array para almacenar los datos de cada fila
                int indiceColumna = -1;
                while (columnaIterator.hasNext()) { // Recorrer las celdas de la fila
                    indiceColumna++;
                    Cell celda = (Cell) columnaIterator.next(); // Obtener la celda actual

                    if (indiceFila == 0) { // Si es la primera fila (encabezados)
                        modeloT.addColumn(celda.getStringCellValue()); // Agregar encabezado a la tabla
                    } else { // Si no es la primera fila (datos)
                        if (celda != null) { // Verificar si la celda no es nula
                            switch (celda.getCellType()) { // Obtener el tipo de celda
                                case Cell.CELL_TYPE_NUMERIC: // Si es numérico
                                    listaColumna[indiceColumna] = (int) Math.round(celda.getNumericCellValue());
                                    break;
                                case Cell.CELL_TYPE_STRING: // Si es texto
                                    listaColumna[indiceColumna] = celda.getStringCellValue();
                                    break;
                                case Cell.CELL_TYPE_BOOLEAN: // Si es booleano
                                    listaColumna[indiceColumna] = celda.getBooleanCellValue();
                                    break;
                                default: // Si es otro tipo (fecha u otro)
                                    listaColumna[indiceColumna] = celda.getDateCellValue();
                                    break;
                            }
                        }
                    }
                }

                if (indiceFila != 0) { // Agregar fila a la tabla si no es la primera
                    modeloT.addRow(listaColumna);
                }
            }
            respuesta = "Importacion Exitosa";

        } catch (Exception e) {
            System.out.println("Error " + e);
        }
        return respuesta;
    }

}
