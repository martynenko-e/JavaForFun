import dao.VacancyDao;
import model.CiklumStrategy;
import model.HHStrategy;
import model.Provider;

/**
 * Created by Martynenko on 14.01.2016.
 */
public class Aggregator {
    public static void main(String[] args) {

        Provider provider = new Provider(new HHStrategy());
        Provider provider2 = new Provider(new CiklumStrategy());
        Controller controller = new Controller(provider, provider2);
        controller.scan();
        controller.addVacanciesToDb();

    }
}