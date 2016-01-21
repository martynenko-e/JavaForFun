import dao.VacancyDao;
import model.Provider;
import valueobject.Vacancy;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Martynenko on 14.01.2016.
 */
public class Controller {
    private Provider[] providers;
    private ArrayList<Vacancy> vacs = new ArrayList<Vacancy>();

    public Controller(Provider... providers) {
        if (providers == null || providers.length == 0) {
            throw new IllegalArgumentException();
        }
        this.providers = providers;
    }

    @Override
    public java.lang.String toString() {
        return "Controller{" +
                "providers=" + java.util.Arrays.toString(providers) +
                '}';
    }

    public void scan() {
        try {
            for (Provider provider : providers) {
                for (Vacancy vacancy : provider.getJavaVacancies("kiev", "java")) {
                    vacs.add(vacancy);
                }
            }
        } catch (NullPointerException e) {/*NOP*/}
        System.out.println(vacs.size());
    }

    public void addVacanciesToDb() {
        for (Vacancy vacancy : vacs) {
            VacancyDao.getInstance().addVacancy(vacancy.getLink(),
                    vacancy.getTitle(),
                    vacancy.getCity(),
                    vacancy.getDescription(),
                    vacancy.getDateOfPublication(),
                    vacancy.getTypeOfEmployment(),
                    vacancy.getCompanyName(),
                    vacancy.getExperienceOfWork(),
                    vacancy.isShow(),
                    vacancy.getKeyWord());
        }
    }


}
