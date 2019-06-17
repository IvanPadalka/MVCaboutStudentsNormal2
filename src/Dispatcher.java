
public class Dispatcher {
    public static void main(String[] args) {
        Controller.readEmployersFromFile();
        Controller.comparingEmployersFromSallary();
        JavaFXView.launch(JavaFXView.class);
    }
}
//Viev viev = new Viev();
        /*while (true) {
            viev.menuForChooseViewEmployers();
            Controller.menuForChooseViewEmployersList();
        }*/