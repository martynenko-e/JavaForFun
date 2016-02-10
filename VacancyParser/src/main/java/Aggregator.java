

import dao.VacancyDao;
import dao.VacancyJDBCTemplate;
import model.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import tools.HtmlToFile;
import valueobject.Vacancy;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Martynenko on 14.01.2016.
 */
public class Aggregator {
    public static void main(String[] args) {


        Provider provider = new Provider(new HHStrategy());
        Provider providerCiklum = new Provider(new CiklumStrategy());
        Provider providerGL = new Provider(new GlobalLogicStrategy());
        Provider providerLux = new Provider(new LuxoftStrategy());
        Provider providerAst = new Provider(new AstoundStrategy());
        Provider providerWork = new Provider(new WorkUAStrategy());
//        Controller controller = new Controller(providerLux, provider, providerCiklum, providerAst, providerGL, providerWork);
//        controller.scan();

        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");

        VacancyJDBCTemplate vacancyJDBCTemplate =
                (VacancyJDBCTemplate)context.getBean("vacancyJDBCTemplate");

        System.out.println(vacancyJDBCTemplate.listVacancies());
        System.out.println("------Records Creation--------" );
//        ArrayList<Vacancy> vacancies = controller.getVacs();
//        for (Vacancy vacancy: vacancies) {
//
//            vacancyJDBCTemplate.create(
//                    vacancy.getLink(),
//                    vacancy.getTitle(),
//                    vacancy.getCity(),
//                    vacancy.getDescription(),
//                    vacancy.getDateOfPublication(),
//                    vacancy.getTypeOfEmployment(),
//                    vacancy.getCompanyName(),
//                    vacancy.getExperienceOfWork(),
//                    vacancy.isShow(),
//                    vacancy.getKeyWord());
//
//        }


    }
}