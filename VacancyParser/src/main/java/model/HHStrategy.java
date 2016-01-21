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
        ArrayList<Vacancy> vacancies = new ArrayList<>();
        try {
			Document doc = Jsoup.connect(String.format(URL_FORMAT, searchCity, searchLanguage, 1)).get();
            new HtmlToFile().writeHtmlToLocalFile(doc);
            Elements elements = doc.select("li[data-qa=search-vacancy-item]");
            for (Element element: elements) {
                String link = element.select("a").first().attr("href");
                String title = element.select("div[data-qa=vacancy-name]").first().text();
                String city = element.select("div[class=vacancy-list-item__city]").first().text();
                String dateOfPublication = element.select("span[data-qa=vacancy-pubdate]").first().text();
                String company = element.select("div[class=vacancy-list-item__company]").first().text();
                Vacancy vacancy = new Vacancy(link, title, city, "", dateOfPublication, "", company, "", true, "");
                vacancies.add(vacancy);
            }
		} catch (IOException e) {
			e.printStackTrace();
		}
        return vacancies;
    }


}
