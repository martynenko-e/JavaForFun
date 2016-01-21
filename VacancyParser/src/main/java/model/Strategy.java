package model;

import valueobject.Vacancy;

import java.util.List;

/**
 * Created by Martynenko on 21.01.16.
 */
public interface Strategy {
    List<Vacancy> getVacancies(String searchCity, String searchLanguage);
}
