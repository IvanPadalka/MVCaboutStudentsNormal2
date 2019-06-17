
import java.util.List;

public class ConsoleView {
    void menuForChooseViewEmployers(){
        System.out.println("Main menu");
        System.out.println("Write 1, for see all employers");
        System.out.println("Write 2, for see first 5 employers");
        System.out.println("Write 3, for see last 3 employers");
        System.out.print("Input a number: ");
    }
    void viewFirstFiveEmployers(){
        List<EmployerModel> temp=Controller.getList();
        int tempIterator= 0;
        for (Object o:temp){
            tempIterator++;
            System.out.println(o);
            if (tempIterator == 5) {
                break;
            }
        }
        /* Можна було ще так зробити через простий for
        for (int i = 0; i < 5; i++) {
            System.out.println(list.get(i));
        }
        */

    }
    void viewLastThreeEmployers(){
        List<EmployerModel> temp=Controller.getList();
        for (int i = temp.size()-3; i <temp.size(); i++) {
            System.out.println(temp.get(i));
        }
    }
    void viewListAllEmployers(){
        List<EmployerModel> temp=Controller.getList();
        for (Object o:temp){
            System.out.println(o);
        }
    }
    void badInput(){
        System.out.println("Write only 1-3");
    }

}
