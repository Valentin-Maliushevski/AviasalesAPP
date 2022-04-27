package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AirportDao {

  private Connection getConnection () throws SQLException {
    return DriverManager.getConnection("jdbc:postgresql://localhost:5432/demo",
        "postgres",
        "postgres");
  }

  private Airport map(ResultSet resultSet) throws SQLException {
    return new Airport(resultSet.getString("airport_code"),
        resultSet.getString("city"),
        resultSet.getString("airport_name"),
        resultSet.getString("coordinates"),
        resultSet.getString("timezone"));
  }

  public Airport getAirport(String code) {
    try (Connection connection = getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(
            "SELECT airport_code,\n" +
                "city,\n" +
                "airport_name,\n" +
                "coordinates,\n" +
                "timezone\n" +
                "FROM bookings.airports\n" +
                "WHERE airport_code = '" + code + "';"
        )
    ) {
      while (resultSet.next()) {
        return map(resultSet);
      }
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
    return null;
  }

  public List<Airport> getAllAirports() {

    List<Airport> airports = new ArrayList<>();

    try (Connection connection = getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(
            "SELECT airport_code,\n" +
                "city,\n" +
                "airport_name,\n" +
                "coordinates,\n" +
                "timezone\n" +
                "FROM bookings.airports"
        )
    ) {
      while (resultSet.next()) {
        airports.add(map(resultSet));
      }
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
    return airports;
  }

}
