package model;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import valueobject.Vacancy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class WorkUAStrategy implements Strategy{

    @Override
    public List<Vacancy> getVacancies(String searchCity, String searchLanguage) {
        Document doc;
        ArrayList<Vacancy> listOfVacancies = new ArrayList<Vacancy>();
        try {
            String link = String.format("http://www.work.ua/jobs-%s-%s/", searchCity, searchLanguage);
            doc = Jsoup.connect(link).get();
            Elements elements = doc.select(".card h2 a");

            for (Element e : elements) {
                Document vacancySite = Jsoup.connect("http://www.work.ua/" + e.attr("href")).get();
                Elements description = vacancySite.select(".card .overflow");
                Elements dateOfPublication = vacancySite.select(".card .text-muted");
                Elements companyName = vacancySite.select(".card .dl-horizontal a");
                Elements otherDescription = vacancySite.select(".card .dl-horizontal dd");

                String vacancyLink = "http://www.work.ua" + e.attr("href");
                String vacancyTitle = e.attr("title");
                String vacancyDescription = description.first().text();
                String vacancyDateOfPublication = dateOfPublication.first().text();
                String vacancyCompanyName = companyName.first().text();
                String vacancyCity = otherDescription.get(1).text();
                String vacancyTypeOfEmployment = otherDescription.get(2).text();
                String vacancyWorkExperience = "There is no working experience needed"; // конструктор может выебываться

                try {
                    vacancyWorkExperience = otherDescription.get(3).text();
                } catch (IndexOutOfBoundsException e1) {
                    System.out.println("There is no working experience needed");
                }
                Vacancy vacancyObject = new Vacancy(vacancyLink, vacancyTitle, vacancyCity, vacancyDescription, vacancyDateOfPublication, vacancyTypeOfEmployment, vacancyCompanyName, vacancyWorkExperience, true, "");
                listOfVacancies.add(vacancyObject);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listOfVacancies;
    }
}
