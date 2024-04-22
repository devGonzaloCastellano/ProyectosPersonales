package Modelo;

import java.io.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

public class ModeloExcel {

    Workbook wb; // Objeto Workbook para manejar el libro de Excel

    // Método para importar datos desde un archivo Excel a una tabla JTable
    public String Importar(File archivo, JTable tablaD) {
        String respuesta = "No se pudo realizar la importacion";

        DefaultTableModel modeloT = new DefaultTableModel(); // Modelo de tabla por defecto
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
            // Manejo de excepciones
        }
        return respuesta;
    }

    // Método para exportar datos desde una tabla JTable a un archivo Excel
    public String Exportar(File archivo, JTable tablaD) {
        String respuesta = "No se pudo Exportar";

        int numFila = tablaD.getRowCount(), numColumna = tablaD.getColumnCount(); // Obtener número de filas y columnas de la tabla

        // Crear Workbook según la extensión del archivo
        if (archivo.getName().endsWith("xls")) {
            wb = new HSSFWorkbook(); // Para archivos Excel antiguos (.xls)
        } else {
            wb = new XSSFWorkbook(); // Para archivos Excel nuevos (.xlsx)
        }

        Sheet hoja = wb.createSheet("Hoja"); // Crear una hoja en el libro
        try {
            for (int f = -1; f < numFila; f++) { // Recorrer las filas
                Row fila = hoja.createRow(f + 1); // Crear una fila en la hoja
                for (int c = 0; c < numColumna; c++) { // Recorrer las columnas
                    Cell celda = fila.createCell(c); // Crear una celda en la fila

                    if (f == -1) { // Si es la primera fila (encabezados)
                        celda.setCellValue(String.valueOf(tablaD.getColumnName(c))); // Obtener y asignar el encabezado
                    } else { // Si no es la primera fila (datos)
                        celda.setCellValue(String.valueOf(tablaD.getValueAt(f, c))); // Obtener y asignar el dato de la tabla
                    }

                    wb.write(new FileOutputStream(archivo)); // Escribir el libro en el archivo
                }
            }
            respuesta = "Exportacion Exitosa";

        } catch (Exception e) {
            // Manejo de excepciones
        }

        return respuesta;
    }  
}
