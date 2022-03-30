package DAO;

import java.security.spec.RSAOtherPrimeInfo;
import java.sql.*;

public class DAORequests {
    private final Connection connection;

    public DAORequests(Connection connection) {
        this.connection = connection;
    }

    public void getWeatherInRome() throws SQLException {
        System.out.println("-------------------------------------------------------");
        System.out.println("\t\t\tWeather information in Rome:");
        String sql = "select date, temperature, precipitation, name\n" +
                "\t\tfrom weather, region\n" +
                "\t\twhere weather.weather_id = region.weather_id and region.name like 'Rome';";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {

            Date date = resultSet.getDate(1);
            int temperature = resultSet.getInt(2);
            int precipitation = resultSet.getInt(3);
            String name = resultSet.getString(4);

            System.out.println("Date: "+date+" \nTemperature: "+temperature+" degrees\n" +
                    "Precipitation: "+precipitation+" mm\nRegion: "+name);
            System.out.println("-------------------------------------------------------");
        }
    }


    public void getWeatherInMinskWithTempAndPreciper() throws SQLException {
        System.out.println("\t\tWeather information in Minsk where temperature <0  and precipitation >10:");
        String sql = "select date, temperature, precipitation, name\n" +
                "\t\tfrom weather, region\n" +
                "\t\twhere weather.weather_id = region.weather_id and (temperature <0  and precipitation >10);";
        Statement statement = connection.createStatement();
        ResultSet resultSet1 = statement.executeQuery(sql);
        while (resultSet1.next()) {

            Date date = resultSet1.getDate(1);
            int temperature = resultSet1.getInt(2);
            int precipitation = resultSet1.getInt(3);
            String name = resultSet1.getString(4);

            System.out.println("Date: " + date + " \nTemperature: " + temperature + " degrees\n" +
                    "Precipitation: " + precipitation + " mm\nRegion: " + name);
            System.out.println("-------------------------------------------------------");
        }
    }

    public void getWeatherOverThePastWeek() throws SQLException {
        System.out.println("\t\tInformation about the weather over the past week in the regions whose inhabitants communicate in French:");
        String sql = "select date, temperature, precipitation, name, language\n" +
                "\t\tfrom weather, region, inhabitant_type\n" +
                "\t\twhere weather.weather_id = region.weather_id and region.id_type = inhabitant_type.id_type\n" +
                "\t\tand language like 'French' and date > '2022-02-10';";
        Statement statement = connection.createStatement();
        ResultSet resultSet2 = statement.executeQuery(sql);
        while (resultSet2.next()) {

            Date date = resultSet2.getDate(1);
            int temperature = resultSet2.getInt(2);
            int precipitation = resultSet2.getInt(3);
            String name = resultSet2.getString(4);
            String language = resultSet2.getString(5);

            System.out.println("Date: " + date + " \nTemperature: " + temperature + " degrees\n" +
                    "Precipitation: " + precipitation + " mm\nRegion: " + name+ "\nLanguage: " + language);
            System.out.println("-------------------------------------------------------");
        }
    }


    public void getWeatherAverageTemperatureOverThePastWeekInRegionsWithArea() throws SQLException {
        System.out.println("\t\tAverage temperature in regions with area of more than 350:");
        String sql = "select avg(temperature), name, area, date\n" +
                "\t\tfrom weather, region\n" +
                "\t\twhere weather.weather_id = region.weather_id and area > '350' and date > '2022-02-10'" +
                "\t\tgroup by name, area, date;";
        Statement statement = connection.createStatement();
        ResultSet resultSet3 = statement.executeQuery(sql);
        while (resultSet3.next()) {

            int temperature = resultSet3.getInt(1);
            String name = resultSet3.getString(2);
            String area = resultSet3.getString(3);
            Date date = resultSet3.getDate(4);

            System.out.println("\nTemperature: " + temperature + " degrees" + "\nRegion:" + name + "\nArea:" + area + "\nDate:" + date);
            System.out.println("-------------------------------------------------------");
        }
    }
}
