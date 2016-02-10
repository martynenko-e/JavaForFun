package model;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import valueobject.Vacancy;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 14.01.2016.
 */
public class GlobalLogicStrategy implements Strategy {

    @Override
    public List<Vacancy> getVacancies(String searchCity, String searchLanguage) {
        Document doc;
        ArrayList<Vacancy> listOfVacancies = new ArrayList<Vacancy>();
        try {
            doc = Jsoup.connect("https://globallogic.com.ua/positions/kyiv/java/").timeout(5 * 1000).get();
            Elements elements = doc.select(".cl-link");

            for (Element element : elements) {

                Document vacancySite = Jsoup.connect(element.attr("href")).timeout(5 * 1000).get();

                Elements description = vacancySite.select(".job-description");
                Elements dateOfPublication = element.select("time[itemprop=datePublished]");
                Elements title = vacancySite.select(".content-title");

                String vacancyLink = element.attr("href");
                String vacancyTitle = title.text();
                String vacancyDescription = description.text();
                String vacancyDateOfPublication = dateOfPublication.text();
                String vacancyCompanyName = "Global Logic";
                String vacancyCity = "Kyiv";
                String vacancyTypeOfEmployment = "full Time";
                String vacancyExperienceOfWork = "There is no working experience needed!!";

                try {
                    vacancyExperienceOfWork = null;
                } catch (NullPointerException e) {
                    System.out.println("There is no working experience needed!!   " +
                            "APPLY NOW!!!!");
                }
                Vacancy vacancyObject = new Vacancy();
                vacancyObject.setLink(vacancyLink);
                vacancyObject.setTitle(vacancyTitle);
                vacancyObject.setCity(vacancyCity);
                vacancyObject.setDescription(vacancyDescription);
                vacancyObject.setDateOfPublication(vacancyDateOfPublication);
                vacancyObject.setTypeOfEmployment(vacancyTypeOfEmployment);
                vacancyObject.setCompanyName(vacancyCompanyName);
                vacancyObject.setExperienceOfWork(vacancyExperienceOfWork);
                vacancyObject.setShow(true);
                vacancyObject.setKeyWord("");
                listOfVacancies.add(vacancyObject);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listOfVacancies;
    }
}
