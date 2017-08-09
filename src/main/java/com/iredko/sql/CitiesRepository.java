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
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/world",
                    "root","power13");

            PreparedStatement statement = conn.prepareStatement("select * from city");
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()) {
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
}
