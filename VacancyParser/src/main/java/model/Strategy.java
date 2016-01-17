package model;

import java.util.List;
import vo.Vacancy;

/**
 * Created by Martynenko on 14.01.2016.
 */
public interface Strategy
{
    List<Vacancy> getVacancies(String searchString);
}
