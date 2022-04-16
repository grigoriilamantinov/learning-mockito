package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CompanyDAO {
    private static final String db_user = "postgres";
    private static final String password = "1234";
    private static final String url = "jdbc:postgresql://localhost:5432/lamantan";
    private static final String driverName = "org.postgresql.Driver";

    public List<User> geyCompanyEmployees(int companyId) {
        Connection connection = null;
        List<User> users = new ArrayList<>();
        Company company = this.geyById(companyId);

        try {
            Class.forName(driverName);
            connection = DriverManager.getConnection(url, db_user, password);
            PreparedStatement statement =
                connection.prepareStatement(
                    String.format(
                        "SELECT " +
                            "users.id AS идентификатор_пользователя, users.last_name " +
                            "AS фамилия, users.first_name AS имя FROM company " +
                            "LEFT JOIN users ON company.id = users.company_id " +
                            "WHERE company.id = %d",
                        companyId
                    )
                );

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                users.add(
                    new User()
                        .id(resultSet.getInt("идентификатор_пользователя"))
                        .firstName(resultSet.getString("имя"))
                        .lastName(resultSet.getString("фамилия"))
                        .company(company)
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

    public Company geyById(int id) {
        Connection connection = null;
        Company company = null;

        try {
            Class.forName(driverName);
            connection = DriverManager.getConnection(url, db_user, password);
            PreparedStatement statement =
                connection.prepareStatement(String.format("SELECT * FROM company WHERE id = %d;", id));
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();

            company = Company.builder()
                .id(resultSet.getInt("id"))
                .companyName(resultSet.getString("company_name"))
                .build();

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

        return company;
    }
}
