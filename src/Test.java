import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List list= new ArrayList();
        String mass[];
        try {
            String content = new String(Files.readAllBytes(Paths.get("testFile.txt")));
            mass=content.split(" ");
            for (int i = 0; i < mass.length; i++) {
                /*int tempID=Integer.parseInt(mass[i++]);
                String tempName=mass[i++];
                int tempHourlyRateOrSallary=Integer.parseInt(mass[i++]);
                if(i<=10){list.add(new HourlyWageEmployee(tempID,tempName, tempHourlyRateOrSallary));}
                else {list.add(new FixedWageEmployee(tempID,tempName, tempHourlyRateOrSallary));}*/
                list.add(mass[i]);
            }

            System.out.println(list);
            BufferedWriter bufferedWriter=new BufferedWriter(new FileWriter("testOutputFile.txt"));
            for(Object o:list){
                bufferedWriter.write((String) o);
            }
        } catch (IOException ioe){
            System.out.println("File is not open");
        }
    }
}
