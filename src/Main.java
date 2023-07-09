import ro.mycode.user.services.UserController;
import ro.mycode.view.ViewLogIn;

public class Main {
    public static void main(String[] args) {


        UserController userController = new UserController();
        userController.load();
        userController.afisareUser();


    }
}