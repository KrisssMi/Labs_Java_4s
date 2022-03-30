import DAO.DAORequests;
import DAO.MyDAO;
import org.apache.log4j.xml.DOMConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

public class Main {
    static {
        new DOMConfigurator().doConfigure("log/log4j.xml", LogManager.getLoggerRepository());
    }
    private static final Logger LOG = Logger.getLogger(Main.class);

    public static void main(String[] args) throws UnsupportedEncodingException {
        LOG.info("Starting program.");
        MyDAO dao = new MyDAO();
        try {
            ///Connection connection = dao.getConnection();                             /// проверка соединения с бд
            System.out.println("Connection to Weather database is succesfull!");
            LOG.info("Connection to Weather database is succesfull!");
            var connection = dao.getConnection();
            var requests = new DAORequests(connection);

            LOG.info("> The first request: weather information in Rome.");
            requests.getWeatherInRome();

            LOG.info("> The second request: weather information in Minsk where temperature <0  and precipitation >10.");
            requests.getWeatherInMinskWithTempAndPreciper();

            LOG.info("> The third request: information about the weather over the past week in the regions whose inhabitants communicate in French.");
            requests.getWeatherOverThePastWeek();

            LOG.info("> The fourth request: average temperature in regions with area of more than 350.");
            requests.getWeatherAverageTemperatureOverThePastWeekInRegionsWithArea();

            LOG.info("The end of program.");
        }
        catch (SQLException e)
        {
            LOG.info("Connection failed...");
            System.out.println("Connection failed...");
            e.printStackTrace();
        }
    }
}
