package model;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import valueobject.Vacancy;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class CiklumStrategy implements Strategy {

    @Override
    public List<Vacancy> getVacancies(String searchCity, String searchLanguage) {
        Document doc = null;
        ArrayList<Vacancy> listOfVacancies = new ArrayList<>();
        try {
            doc = Jsoup.connect("http://jobs.ciklum.com/?s=" +
                    "Java+Developer&location=&location=" +
                    "Kyiv&job_cat=&ptype=job_listing&latitude=&longitude=&full_address=&north_east_lng=&south_west_lng=&north_east_lat=&south_west_lat=").get();

            Elements elements = doc.select("ol.jobs.searchapply .row .position-name a");  // проверено

            for (Element element : elements) {

                Document vacancySite = Jsoup.connect(element.attr("href")).get();

                Elements title = vacancySite.select(".section_header h1");
                Elements description = vacancySite.select(".section_content p");
                Elements dateOfPublication = vacancySite.select("p.section-name");

                String vacancyLink = element.attr("href");
                String vacancyTitle = title.text();
                String vacancyDescription = description.text();
                String vacancyDateOfPublication = dateOfPublication.text();
                String vacancyCompanyName = "Ciklum";
                String vacancyCity = "Kiev";
                String vacancyTypeOfEmployment = "full time";
                String vacancyWorkExperince = "There is no working experience needed!";

                try {
                    vacancyWorkExperince = "WTF";
                } catch (NullPointerException e) {
                    System.out.println("There is no working exp needed");
                }
                Vacancy vacancyObject = new Vacancy(vacancyLink, vacancyTitle, vacancyCity, vacancyDescription, vacancyDateOfPublication, vacancyTypeOfEmployment, vacancyCompanyName, vacancyWorkExperince, true, "");
                listOfVacancies.add(vacancyObject);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listOfVacancies;
    }
}
