package com.iredko.sql;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ItsEasy on 09.08.2017.
 */
public class CitiesRepository {
    public List<City> findAll() {
        List<City> result = new ArrayList<>();
        try (Connection conn = getConnection()) {

            PreparedStatement statement = conn.prepareStatement("select * from city");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");

                City city = new City(id, name);
                result.add(city);
            }

            return result;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public City findByName(String name) {
        try (Connection connection = getConnection()) {

            PreparedStatement statement = connection.prepareStatement("select * from city where name = ?");
            statement.setString(1, name);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return new City(resultSet.getInt("id"), resultSet.getString("name"));
            } else {
                return null;
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    void updatePopularity(String name, int newPopularity) {
        try (Connection connection = getConnection()) {

            PreparedStatement statement = connection.prepareStatement("update city set population = ? where name = ?");
            statement.setInt(1, newPopularity);
            statement.setString(2, name);

            statement.executeUpdate();
            connection.commit();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    private Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/world", "root", "power13");
    }
}
