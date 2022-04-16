package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    private static final String db_user = "postgres";
    private static final String password = "1234";
    private static final String url = "jdbc:postgresql://localhost:5432/lamantan";
    private static final String driverName = "org.postgresql.Driver";

    private CompanyDAO companyDAO;

    public UserDAO(CompanyDAO companyDAO) {
        this.companyDAO = companyDAO;
    }

    public List<User> findAll() {
        Connection connection = null;
        List<User> users = new ArrayList<>();

        try {
            Class.forName(driverName);
            connection = DriverManager.getConnection(url, db_user, password);
            PreparedStatement statement =
                connection.prepareStatement("SELECT * FROM users;");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                users.add(
                    new User()
                        .id(resultSet.getInt("id"))
                        .firstName(resultSet.getString("first_name"))
                        .lastName(resultSet.getString("last_name"))
                        .company(companyDAO.geyById(resultSet.getInt("company_id")))
                );
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.out.println("Ошибка подключения");
            }
        }

        return users;
    }
}
