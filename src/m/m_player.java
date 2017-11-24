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
public class m_player extends m_function {

    ResultSet rs;

    public m_player() throws SQLException {
        this.con = new koneksiDB();
        con = new koneksiDB();
    }
    public int cekId() throws SQLException {
        String query = "select IdPlayer from sapiplayer where IdPlayer = ";
        return checkId(query);
    }

    public boolean insertDataPlayer(int idPlayer, String username, String password) {
        String query = "INSERT INTO `player` (`IdPlayer`, `Username`, `Password`, `DateCreate`) VALUES ('" + idPlayer + "', '" + username
                + "', '" + password + "', CURRENT_TIMESTAMP)";
        return getStatusQuery(query);
    }

    public boolean getPlayer(String username, String password) throws SQLException {
        String query = "SELECT * FROM `player` WHERE Username = '" + username + "' AND Password ='" + password + "'";
        boolean status = false;
        try {
            rs = con.getResult(query);
            if (rs.next()) {
                status = true;
            }
        } catch (SQLException e) {
            System.out.println("Salah");
        }
        return status;
    }

    public String getIdPlayer(String username) throws SQLException {
        String query = "SELECT `IdPlayer` FROM `player` WHERE `Username` = '" + username + "'";
        return getDataString(query);
    }
    public String getUsername(String username) throws SQLException{
        String query = "SELECT `Username` FROM  `player` where `Username` = '"+ username +"'";
        return getDataString(query);
    }
}
