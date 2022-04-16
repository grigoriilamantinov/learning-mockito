//import dao.User;
//import dao.UserDAO;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import service.UserService;
//
//import java.lang.reflect.AccessibleObject;
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class AppTest {
//
//    UserDAO dao = Mockito.mock(UserDAO.class);
//    UserService userService = new UserService(dao);
//
//    @Test
//    void shouldUsersWithShortName() {
//
//        List<User> preparedData = new ArrayList<>() {{
//            add(new User(1, "Grigorii", "Lamantan"));
//            add(new User(2, "Egor", "Anchutin"));
//            add(new User(3, "Alexey", "Petrovich"));
//            add(new User(4, "Ilya", "Maddyson"));
//            add(new User(5, "Igor", "Guitman"));
//            add(new User(6, "Strimer", "73"));
//            add(new User(7, "Volodimir", "Oleksandrovich"));
//        }};
//
//        List<User> exceptedResult = new ArrayList<>() {{
//            add(new User(2, "Egor", "Anchutin"));
//            add(new User(4, "Ilya", "Maddyson"));
//            add(new User(5, "Igor", "Guitman"));
//        }};
//
//        Mockito.when(dao.findAll()).thenReturn(preparedData);
//        List<User> actualResult = userService.getUsersWithShortName();
//
//        Assertions.assertEquals(exceptedResult.size(),actualResult.size());
//        Assertions.assertTrue(actualResult.containsAll(exceptedResult));
//        Assertions.assertIterableEquals(exceptedResult,actualResult);
//
//        Mockito.verify(dao).findAll();
//        Mockito.verifyNoMoreInteractions(dao);
//    }
//
//}