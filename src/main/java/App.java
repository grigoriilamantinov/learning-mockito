import dao.CompanyDAO;

public class App {
    public static void main(String[] args) {
        CompanyDAO companyDAO = new CompanyDAO();

        companyDAO.geyCompanyEmployees(1)
            .forEach(user -> System.out.println(user));



//        UserDAO dao = new UserDAO();
//        UserService service  = new UserService(dao);
//        service.getUsersWithShortName()
//            .forEach(user -> System.out.println(user));

    }
}
