/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package koneksiDb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Your name
 */
public class koneksiDB {
    Connection con;
    Statement stm;
    public koneksiDB() throws SQLException{
        String url = "jdbc:mysql://localhost:3306/gamepplagro";
        String username = "root";
        String pass = "";
        
        this.con = (Connection) DriverManager.getConnection(url, username, pass);
        this.stm = (Statement) this.con.createStatement();
    }
    
    public void executeQuery(String query)throws SQLException{
        this.stm.execute(query);
    }
    public ResultSet getResult(String query)throws SQLException{
        ResultSet rs = stm.executeQuery(query);
        return rs;
    }
}
