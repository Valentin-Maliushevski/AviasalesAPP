package dao;

public class Airport {

  private String airport_code;
  private String airport_name;
  private String city;
  private String coordinates;
  private String timezone;


  public Airport(String airport_code, String airport_name, String city, String coordinates,
      String timezone) {
    this.airport_code = airport_code;
    this.airport_name = airport_name;
    this.city = city;
    this.coordinates = coordinates;
    this.timezone = timezone;
  }

  @Override
  public String toString() {
    return "Airport{" +
        "airport_code='" + airport_code + '\'' +
        ", airport_name='" + airport_name + '\'' +
        ", city='" + city + '\'' +
        ", coordinates='" + coordinates + '\'' +
        ", timezone='" + timezone + '\'' +
        '}';
  }
}
