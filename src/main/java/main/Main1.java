package main;

import dao.Airport;
import dao.AirportDao;
import java.util.List;

public class Main1 {

  public static void main(String[] args) {
    try {
      Class.forName("org.postgresql.Driver");
    } catch (ClassNotFoundException e) {
      throw new RuntimeException("проверь имя драйвера!!!", e);
    }

    AirportDao airportDao = new AirportDao();

    List<Airport> airports = airportDao.getAllAirports();

    for(Airport airport : airports) {
      System.out.println(airport.toString());
    }

    Airport airport_1 = airportDao.getAirport("SVX");
    System.out.println(airport_1.toString());
  }
}
