package model;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import valueobject.Vacancy;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 05.01.2016.
 */
public class LuxoftStrategy implements Strategy {

    @Override
    public List<Vacancy> getVacancies(String searchCity, String searchLanguage) {
        ArrayList<Vacancy> listOfVacancies = new ArrayList<Vacancy>();
        Document doc;
        try {
            doc = Jsoup.connect("http://www.luxoft.com/job-opportunities/?arrFilter_ff%5BNAME%5D=" +
                    "java+developer&arrFilter_pf%5Bcities%5D=11&arrFilter_pf%5Bcategories%5D=95&set_filter=Y#filter-form").get();

            int pagination = doc.select(".show-for-small div[class=pagination hide-for-small] .numbers a").size();

            for (int j = 1; j <= pagination; j++) {

                String html = "http://www.luxoft.com/job-opportunities/?arrFilter_ff%5BNAME%5D=java+developer&arrFilter_pf%5Bcities%5D=11&arrFilter_pf%5Bcategories%5D=95&set_filter=Y&PAGEN_6=" + j;
                doc = Jsoup.connect(html).get();
                Elements elementsFirst = doc.select(".hide-for-small tbody tr"); // мы должны искать ссылку на вакансии(содержащее вакансии)

                for (int i = 0; i < elementsFirst.size(); i++) {

                    Elements elementsSecond = elementsFirst.select("td a[itemprop=url]");
                    Document vacancySite = Jsoup.connect("http://www.luxoft.com" + elementsSecond.get(i).attr("href")).get();
                    Elements description = vacancySite.select(".row .four .p-style p");
                    Elements title = vacancySite.select(".row .six .row .four #lux-main-content-divider h2");
                    Elements dateOfPublication = elementsFirst.get(i).select("td span[itemprop=datePosted]");
                    Elements city = vacancySite.select(".row .six .row .four #lux-main-content-divider .row .two .case-study-details .row .six span");
                    Elements workExperience = vacancySite.select(".row .six .row .four #lux-main-content-divider .row .four .p-style[itemprop=responsibilities] ul li");

                    String vacancyLink = "http://www.luxoft.com" + elementsSecond.get(i).attr("href");
                    String vacancyTitle = title.first().text();
                    String vacancyDescription = description.text();
                    String vacancyDateOfPublication = dateOfPublication.text();
                    String vacancyCompanyName = "Luxoft";
                    String vacancyCity = city.get(2).text();
                    String vacancyTypeOfEmployment = "Full Time";
                    String vacancyExperienceOfWork = "There is no working experience needed!!";

                    try {
                        vacancyExperienceOfWork = workExperience.first().text();
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
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listOfVacancies;
    }
}
