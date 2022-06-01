package requests;

import dao.MyDAO;
import model.SortMethod;

import java.sql.*;
import java.util.ArrayList;

public class SortRequest {
    private final Connection connection;

    public SortRequest() throws SQLException {
        MyDAO dao = new MyDAO();
        connection = dao.getConnection();
    }

    public ArrayList<SortMethod> selectSorts() throws SQLException {
        ArrayList<SortMethod> methods = new ArrayList<>();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from sort_methods");
        while (resultSet.next()) {
            String name = resultSet.getString("name");
            String speed = resultSet.getString("speed");
            methods.add(new SortMethod(name, speed));
        }
        return methods;
    }
}
