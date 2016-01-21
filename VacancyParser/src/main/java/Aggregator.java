import dao.VacancyDao;
import model.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import tools.HtmlToFile;
import valueobject.Vacancy;

import java.io.IOException;

/**
 * Created by Martynenko on 14.01.2016.
 */
public class Aggregator {
    public static void main(String[] args) {

        VacancyDao.getInstance().createTable();

        Provider provider = new Provider(new HHStrategy());
        Provider providerCiklum = new Provider(new CiklumStrategy());
        Provider providerGL = new Provider(new GlobalLogicStrategy());
        Provider providerLux = new Provider(new LuxoftStrategy());
        Provider providerAst = new Provider(new AstoundStrategy());
        Provider providerWork = new Provider(new WorkUAStrategy());
        Controller controller = new Controller(providerGL);

        controller.scan();
        controller.addVacanciesToDb();
        System.out.println(controller);

    }
}