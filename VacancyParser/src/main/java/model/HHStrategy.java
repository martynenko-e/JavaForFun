package model;

import java.io.IOException;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import vo.Vacancy;

/**
 * Created by cleri_000 on 03.07.2015.
 */
public class HHStrategy implements Strategy
{
    private static final String URL_FORMAT = "http://hh.ua/search/vacancy?text=java+%s&page=%d";

    @java.lang.Override
    public List<Vacancy> getVacancies(String searchString)
    {
        try {
			Document doc = Jsoup.connect(searchString).get();
            //fdsdsfdsf
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        return null;
    }
}
