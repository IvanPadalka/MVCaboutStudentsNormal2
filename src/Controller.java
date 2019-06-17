import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Controller {
    private static List<EmployerModel> list=new ArrayList<>();
    public static List<EmployerModel> getList() {
        return list;
    }
    static void readEmployersFromFile(){
        String mass[];
        try {
            String content = new String(Files.readAllBytes(Paths.get("employers.csv")));
            mass=content.split(" ");
            for (int i = 0; i < mass.length;) {
                int tempID=Integer.parseInt(mass[i++]);
                String tempName=mass[i++];
                int tempHourlyRateOrSallary=Integer.parseInt(mass[i++]);
                if(i<=10){list.add(new HourlyWageEmployee(tempID,tempName, tempHourlyRateOrSallary));}
                else {list.add(new FixedWageEmployee(tempID,tempName, tempHourlyRateOrSallary));}
            }
        } catch (IOException ioe){
            System.out.println("File is not open");
        }
    }
        static void comparingEmployersFromSallary(){
            list.sort((o1, o2) -> {
                if(o1.Sallary==o2.Sallary){
                    return o1.name.compareTo(o2.name);
            }
            else {
                return (int)(o2.Sallary-o1.Sallary);
            }});
    }
        static void menuForChooseViewEmployersList() {
                Scanner in = new Scanner(System.in);
                int num = in.nextInt();
                switch (num) {
                    case 1: {
                        new ConsoleView().viewListAllEmployers();
                        break;
                    }
                    case 2: {
                        new ConsoleView().viewFirstFiveEmployers();
                        break;
                    }
                    case 3: {
                        new ConsoleView().viewLastThreeEmployers();
                        break;
                    }
                    default:
                        new ConsoleView().badInput();
            }
        }

}
