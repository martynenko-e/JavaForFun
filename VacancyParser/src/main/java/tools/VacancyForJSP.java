package tools;

import dao.VacancyDao;
import valueobject.Vacancy;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Martynenko on 16.01.2016.
 */
public class VacancyForJSP {
    private List<Vacancy> vacancies = null;
    public VacancyForJSP(){
        setVacancyList();
    }
    public List<Vacancy> getVacancyList(){
        return VacancyDao.getInstance().getVacancyFromDB();
    }
    private void setVacancyList(){
        vacancies = getVacancyList();
    }
    public void sortByTitle(String type){
        if (type.equals("title"))
            Collections.sort(vacancies, new Comparator<Vacancy>() {
                @Override
                public int compare(Vacancy o1, Vacancy o2) {
                    return o1.getTitle().compareTo(o2.getTitle());
                }
            });
        if (type.equals("data"))
            Collections.sort(vacancies, new Comparator<Vacancy>() {
                @Override
                public int compare(Vacancy o1, Vacancy o2) {
                    return o1.getDateOfPublication().compareTo(o2.getDateOfPublication());
                }
            });
        if (type.equals("company"))
            Collections.sort(vacancies, new Comparator<Vacancy>() {
                @Override
                public int compare(Vacancy o1, Vacancy o2) {
                    return o1.getCompanyName().compareTo(o2.getCompanyName());
                }
            });
        if (type.equals("description"))
            Collections.sort(vacancies, new Comparator<Vacancy>() {
                @Override
                public int compare(Vacancy o1, Vacancy o2) {
                    return o1.getDescription().compareTo(o2.getDescription());
                }
            });
        if (type.equals("city"))
            Collections.sort(vacancies, new Comparator<Vacancy>() {
                @Override
                public int compare(Vacancy o1, Vacancy o2) {
                    return o1.getCity().compareTo(o2.getCity());
                }
            });
    }
}
