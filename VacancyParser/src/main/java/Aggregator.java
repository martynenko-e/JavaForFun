import model.HHStrategy;
import model.Provider;
import model.ReadFromFile;
import vo.Vacancy;

/**
 * Created by Martynenko on 14.01.2016.
 */
public class Aggregator {
    public static void main(String[] args){
//        Provider provider = new Provider(new HHStrategy());
//        Controller controller = new Controller(provider);
//        controller.scan();
        ReadFromFile readFromFile = new ReadFromFile();
        Vacancy[] vacancies = readFromFile.getData();
        for (Vacancy vacancy: vacancies) {
            System.out.println(vacancy.getCompanyName());
        }
    }
}