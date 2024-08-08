package io.github.lorensfs.controllers;

import io.github.lorensfs.models.Funkos;
import io.github.lorensfs.repositories.ConnectionBD;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FunkosController {

    private final ConnectionBD connectionBD = new ConnectionBD();
    private ResultSet resultSet;

    public Funkos consultFunkoByName(String funkoName) {
        try {
            connectionBD.dataBaseConnection();
            connectionBD.setPreparedStatement((String.format("Select *\n" +
                    "FROM funkos\n" +
                    "Where funko_name = '%s'", funkoName)));
            resultSet = connectionBD.getResultSet();

            Funkos funko = new Funkos();

            while (resultSet.next()) {
                funko.setName(resultSet.getString("funko_name"));
                funko.setDescription(resultSet.getString("description"));
                funko.setVaulted(resultSet.getBoolean("vaulted"));
            }

            connectionBD.closeConnection();

            return funko;
        } catch (SQLException error) {
            error.printStackTrace();
        }
        return null;
    }

    public Boolean insertFunko(String name, String description) {
        try {
            connectionBD.dataBaseConnection();
            connectionBD.setPreparedStatement(String.format(("INSERT INTO figures_funko.funkos(funko_name, description)\n" +
                    "VALUE \n" +
                    "\t('%s', '%s')"), name, description));
            return connectionBD.getPreparedStatement().executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Boolean modifyFunko(String name, String description) {
        try {
            connectionBD.dataBaseConnection();
            connectionBD.setPreparedStatement(String.format(("UPDATE figures_funko.funkos\n" +
                    "SET description = '%s'\n" +
                    "WHERE funko_name = '%s'"), description, name));
            return connectionBD.getPreparedStatement().executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Boolean softDeleteFunko(String name) {
        try {
            connectionBD.dataBaseConnection();
            connectionBD.setPreparedStatement(String.format(("UPDATE figures_funko.funkos\n" +
                    "SET vaulted = TRUE\n" +
                    "WHERE funko_name = '%s'"), name));
            return connectionBD.getPreparedStatement().executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
