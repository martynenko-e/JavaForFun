import dao.VacancyDao;
import model.HHStrategy;
import model.Provider;

/**
 * Created by Martynenko on 14.01.2016.
 */
public class Aggregator {
    public static void main(String[] args) {

        Provider provider = new Provider(new HHStrategy());
        Controller controller = new Controller(provider);
        controller.scan();
        controller.addVacanciesToDb();

    }
}