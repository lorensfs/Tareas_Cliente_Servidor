package io.github.lorensfs.repositories;

import java.sql.*;

public class ConnectionBD {
    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private final String url = "jdbc:mysql://localhost:3306/figures_funko";
    private final String username = "root";
    private final String password = "root";

    public void dataBaseConnection() {
        try {
            this.connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void setPreparedStatement(String consult) {
        try {
            this.preparedStatement = connection.prepareStatement(consult);
        } catch (SQLException error) {
            error.printStackTrace();
        }
    }

    public ResultSet getResultSet() {
        try {
            return preparedStatement.executeQuery();
        } catch (SQLException error) {
            error.printStackTrace();
            return null;
        }
    }

    public PreparedStatement getPreparedStatement() {
        return preparedStatement;
    }

    public void closeConnection() {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException error) {
                error.printStackTrace();
            }
        }
        if (preparedStatement != null) {
            try {
                preparedStatement.close();
            } catch (SQLException error) {
                error.printStackTrace();
            }
        }
        if (connection != null) {
            try {
                this.connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
