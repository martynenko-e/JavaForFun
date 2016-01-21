package model;

import java.util.List;
import valueobject.Vacancy;

/**
 * Created by Martynenko on 14.01.2016.
 */
public class Provider
{
    private Strategy strategy;

    public Provider(Strategy strategy)
    {
        setStrategy(strategy);
    }

    public void setStrategy(Strategy strategy)
    {
        this.strategy = strategy;
    }

    public List<Vacancy> getJavaVacancies(String searchCity, String searchLanguage){return strategy.getVacancies(searchCity, searchLanguage);}
}
