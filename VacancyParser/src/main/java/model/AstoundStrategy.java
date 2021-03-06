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
 * Created by vladimir on 21.01.16.
 */
public class AstoundStrategy implements Strategy{

    @Override
    public List<Vacancy> getVacancies(String searchCity, String searchPrLanguage) {
        List<Vacancy> vacancyArrayList = new ArrayList<>();
        Document doc;
        try {
            doc = Jsoup.connect("http://astoundcommerce.com/category/careers/?directions=3&location=1&level=0").get();
            Elements elements = doc.select("#content .row .article_title");
            for (Element element : elements) {

                Document vacancySite = Jsoup.connect(element.attr("href")).get();

                Elements description = vacancySite.select("div.entry-content.single_empty_p");

                String vacancyLink = element.attr("href");
                String vacancyTitle = element.text();
                String vacancyDescription = description.text();
                String vacancyDateOfPublication = "nema";
                String vacancyCompanyName = "Astound Commerce";
                String vacancyCity = "Kiev";
                String vacancyTypeOfEmployment = "full";
                String vacancyExperienceOfWork = "hz";
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
                vacancyArrayList.add(vacancyObject);
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
        return vacancyArrayList;
    }
}


