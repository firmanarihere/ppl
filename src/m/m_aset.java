/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Rangora
 */
public class m_aset extends m_function {

    public m_aset() throws SQLException {
    }

    public String cekIdPlayer(String username) throws SQLException {
        String query = "SELECT `IdPlayer` FROM `player` WHERE `Username` = '" + username + "'";
        ResultSet hasil = con.getResult(query);
        hasil.next();
        String data = hasil.getString(1).toUpperCase();
        return data;
    }

    public int getJumlahKoin(String username) throws SQLException {
        String query = "SELECT `JumlahKoin` FROM aset a JOIN player p on a.IdPlayer = p.IdPlayer WHERE `Username` = '" + username + "'";
        return getDataInt(query);
    }

    public int getJumlahSapi(String username) throws SQLException {
        String query = "SELECT count(*) FROM `sapiplayer` s join player p on s.`IdPlayer` = p.IdPlayer WHERE p.Username = '" + username + "'";
        return getDataInt(query);
    }

    public int getJumlahRumput(String username) throws SQLException {
        String query = "SELECT `JumlahRumput` FROM `aset` a join `player` p on a.IdPlayer= p.IdPlayer WHERE `username` = '" + username + "'";
        return getDataInt(query);
    }

    public int getJumlahNutrisi(String username) throws SQLException {
        String query = "SELECT `JumlahNutrisi` FROM `aset` a join `player` p on a.IdPlayer= p.IdPlayer WHERE `username` = '" + username + "'";
        return getDataInt(query);
    }

    public int getJumlahSuntikan(String username) throws SQLException {
        String query = "SELECT `JumlahSuntik` FROM `aset` a join `player` p on a.IdPlayer= p.IdPlayer WHERE `username` = '" + username + "'";
        return getDataInt(query);
    }

    public int getJumlahObat(String username) throws SQLException {
        String query = "SELECT `JumlahObat` FROM `aset` a join `player` p on a.IdPlayer= p.IdPlayer WHERE `username` = '" + username + "'";
        return getDataInt(query);
    }

    public int getJumlahSusu(String username) throws SQLException {
        String query = "SELECT `JumlahSusu` FROM `aset` a join `player` p on a.IdPlayer= p.IdPlayer WHERE `username` = '" + username + "'";
        return getDataInt(query);
    }

    public int getJumlahKandang(String idPlaye) throws SQLException {
        String query = "SELECT `JumlahKandang` FROM `aset` WHERE `IdPlayer` = " + idPlaye;
        return getDataInt(query);
    }

    public int getStatusKenyang(int idSapiPlayer, int idPlayer) throws SQLException {
        String query = "select statusKenyang from sapiplayer where IdSapiPlayer = " + idSapiPlayer + " and IdPlayer = " + idPlayer;
        return getDataInt(query);
    }

    public int getIdSapi(String idPlyer) throws SQLException {
        String query = "SELECT IdSapiPlayer FROM `sapiplayer` WHERE IdPlayer = " + idPlyer + " LIMIT 1";
        return getDataInt(query);
    }

    public int cekIdSapi() throws SQLException {
        String query = "select IdSapiPlayer from sapiplayer where IdSapiPlayer = ";
        return checkId(query);
    }

    public int cekIdAset() throws SQLException {
        String query = "select IdAset from aset where IdAset = ";
        return checkId(query);
    }

    public boolean insertDataAsetPlayerBaru(int idAset, int idPlayer) {
        String query = "INSERT INTO `aset` (`IdAset`, `IdPlayer`, `JumlahKandang`, `JumlahKoin`, `JumlahAir`, `JumlahRumput`, `JumlahSusu`, `JumlahNutrisi`, `JumlahObat`, `JumlahSuntik`, `playTime`) VALUES ('"
                + idAset + "', '" + idPlayer + "', '1', '2000', '10', '10', '0', '0', '0', '0', '0')";
        return getStatusQuery(query);
    }

    public boolean updateDataKoin(int koin, String idPlayer) throws SQLException {
        String query = "UPDATE `aset` SET `JumlahKoin` = '" + (koin + "") + "' WHERE `aset`.`IdAset` = '" + idPlayer + "';";
        return getStatusQuery(query);
    }

    public boolean insertDataSapi(int idSapi, String idPlayer) throws SQLException {
        String query = "INSERT INTO `sapiplayer` (`IdSapiPlayer`, `IdPlayer`, `IdJenisSapi`, `statusKenyang`, `statusHaus`, `statusNutrisi`, `statusKesehatan`, `statusHamil`) VALUES ('" + idSapi + "','" + idPlayer + "', 1, 100, 100,100,100,0)";
        return getStatusQuery(query);
    }

    public boolean deleteSapi(int idSapi, String idPlayer) {
        String query = "DELETE FROM `sapiplayer` WHERE `IdSapiPlayer` = " + idSapi + " and `IdPlayer` = " + idPlayer;
        return getStatusQuery(query);
    }

    public boolean updateDataKandang(int kandang, String idPlayer) throws SQLException {
        String query = "UPDATE `aset` SET `JumlahKandang` = '" + kandang + "' WHERE `IdAset` = " + idPlayer + "";
        return getStatusQuery(query);
    }

    public boolean updateDataRumput(int rumput, String idPlayer) throws SQLException {
        String query = "UPDATE `aset` SET `JumlahRumput` = '" + (rumput + "") + "' WHERE `aset`.`IdAset` = '" + idPlayer + "'";
        return getStatusQuery(query);
    }

    public boolean updateDataNutisi(int nutrisi, String idPlayer) throws SQLException {
        String query = "UPDATE `aset` SET `JumlahNutrisi` = '" + (nutrisi + "") + "' WHERE `aset`.`IdAset` = '" + idPlayer + "'";
        return getStatusQuery(query);
    }

    public boolean updateDataSuntikan(int suntikan, String idPlayer) throws SQLException {
        String query = "UPDATE `aset` SET `JumlahSuntik` = '" + (suntikan + "") + "' WHERE `aset`.`IdAset` = '" + idPlayer + "'";
        return getStatusQuery(query);
    }

    public boolean updateDataObat(int obat, String idPlayer) throws SQLException {
        String query = "UPDATE `aset` SET `JumlahObat` = '" + (obat + "") + "' WHERE `aset`.`IdAset` = '" + idPlayer + "'";
        return getStatusQuery(query);
    }

    public boolean updateDataSusu(int susu, String idPlayer) throws SQLException {
        String query = "UPDATE `aset` SET `JumlahSusu` = '" + (susu + "") + "' WHERE `aset`.`IdAset` = '" + idPlayer + "'";
        return getStatusQuery(query);
    }

}
