package Logica;

import java.sql.*;

public class Conexion {
    public static Connection Conectar() {

        try {
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/bd_datasystem", "root", "");
            return cn;

        } catch (Exception e) {
            System.out.println("Error en la conexion local " + e);
        }

        return (null);
    }

}



