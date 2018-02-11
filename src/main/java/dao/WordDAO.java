package dao;

import entity.Word;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by ANTON DUKHANIN on 06.02.2018.
 */

public class WordDAO {
    private static final String SELECT_BY_ENG = "SELECT rus from words WHERE eng = ?";
    private static final String SELECT_BY_RUS = "SELECT eng from words WHERE rus = ?";
    private PreparedStatement preparedStatement;

    public Word translateInRus(Word word) {
        try {
            Connection con = DataSource.getInstance().getConnection();
            preparedStatement = con.prepareStatement(SELECT_BY_ENG);
            preparedStatement.setString(1, word.getEng());
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                word.setRus(rs.getString("rus"));
            }
            con.close();
        } catch (SQLException e) {
            System.err.println("word not found");
            word.setRus("word not found");
            return word;
        }
        if (word.getRus() == null) {
            word.setRus("word not found");
        }
        return word;

    }

    public Word translateInEng(Word word) {
        try {
            Connection con = DataSource.getInstance().getConnection();
            preparedStatement = con.prepareStatement(SELECT_BY_RUS);
            preparedStatement.setString(1, word.getRus());
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                word.setEng(rs.getString("eng"));
            }
            con.close();
        } catch (SQLException e) {
            System.err.println("word not found");
            word.setEng("word not found");
            return word;
        }
        if (word.getRus() == null) {
            word.setEng("word not found");
        }
        return word;

    }
}
