/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m;

import java.sql.ResultSet;
import java.sql.SQLException;
import koneksiDb.koneksiDB;

/**
 *
 * @author Rangora
 */
public class m_function {

    koneksiDB con;

    public m_function() throws SQLException {
        con = new koneksiDB();
    }

    protected int checkId(String query) throws SQLException {
        int id = 0;
        ResultSet hasil;
        do {
            id++;
            hasil = con.getResult(query + id);
        } while (hasil.next());
        return id;
    }

    public boolean getStatusQuery(String query) {
        boolean succesInput = false;
        try {
            con.executeQuery(query);
            succesInput = true;
        } catch (SQLException ex) {
            succesInput = false;
        }
        return succesInput;
    }

    public int getDataInt(String query) throws SQLException {
        ResultSet hasil = con.getResult(query);
        hasil.next();
        int data = hasil.getInt(1);
        return data;
    }
    public String getDataString (String query) throws SQLException{
        ResultSet hasil = con.getResult(query);
        hasil.next();
        String data = hasil.getString(1).toUpperCase();
        return data;
    }
}
