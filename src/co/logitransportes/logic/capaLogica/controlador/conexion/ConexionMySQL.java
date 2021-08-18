/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.logitransportes.logic.capaLogica.controlador.conexion;

import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author contr
 */
public class ConexionMySQL {

    private final String ip;
    private final int port;
    private final String user;
    private final String db;
    private final String password;
    private com.mysql.jdbc.Connection con;

    public ConexionMySQL(String ip, int port, String db, String user, String password) {
        this.ip = ip;
        this.port = port;
        this.db = db;
        this.user = user;
        this.password = password;
    }

    public boolean conectar() {
        String path
                = "jdbc:mysql://" + this.ip
                + ":" + this.port
                + "/" + this.db
                + "?user=" + this.user
                + "&password=" + this.password;
        //System.out.println(path);
        try {
            this.con = (com.mysql.jdbc.Connection) DriverManager.getConnection(path);
            if (this.con != null) {
                System.out.println("Conecto");

                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public com.mysql.jdbc.Connection getCon() {
        return con;
    }

    public void disconnect() {
        con = null;
        if (con == null) {
            System.out.println("Conexion terminada");
        }
    }
}
