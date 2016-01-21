package model;

import java.util.List;
import valueobject.Vacancy;

/**
 * Created by Martynenko on 14.01.2016.
 */
public interface Strategy
{
    List<Vacancy> getVacancies(String searchCity, String searchLanguage);
}
