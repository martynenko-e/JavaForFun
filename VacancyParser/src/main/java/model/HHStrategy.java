package model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import tools.HtmlToFile;
import valueobject.Vacancy;

/**
 * Created by Martynenko on 21.01.2016.
 */
public class HHStrategy implements Strategy
{
    private static final String URL_FORMAT = "https://hh.ua/search/vacancy?text=%s+%s&page=%d";

    @java.lang.Override
    public List<Vacancy> getVacancies(String searchCity, String searchLanguage)
    {
        ArrayList<Vacancy> listOfVacancies = new ArrayList<>();
        try {
			Document doc = Jsoup.connect(String.format(URL_FORMAT, searchCity, searchLanguage, 1)).get();
            new HtmlToFile().writeHtmlToLocalFile(doc);
            Elements elements = doc.select("li[data-qa=search-vacancy-item]");
            for (Element element: elements) {
                String vacancyLink = element.select("a").first().attr("href");
                String vacancyTitle = element.select("div[data-qa=vacancy-name]").first().text();
                String vacancyCity = element.select("div[class=vacancy-list-item__city]").first().text();
                String vacancyDateOfPublication = element.select("span[data-qa=vacancy-pubdate]").first().text();
                String vacancyCompanyName = element.select("div[class=vacancy-list-item__company]").first().text();
                Vacancy vacancyObject = new Vacancy();
                vacancyObject.setLink(vacancyLink);
                vacancyObject.setTitle(vacancyTitle);
                vacancyObject.setCity(vacancyCity);
                vacancyObject.setDescription("");
                vacancyObject.setDateOfPublication(vacancyDateOfPublication);
                vacancyObject.setTypeOfEmployment("");
                vacancyObject.setCompanyName(vacancyCompanyName);
                vacancyObject.setExperienceOfWork("");
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
