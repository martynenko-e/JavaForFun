package dao;

import valueobject.Vacancy;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by Martynenko on 20.01.2016.
 */
public interface VacancyDao {
    /**
     * This is the method to be used to initialize
     * database resources ie. connection.
     */
    public void setDataSource(DataSource ds);
    /**
     * This is the method to be used to create
     * a record in the Student table.
     */
    public void create(String link, String title, String city, String description, String dateOfPublication, String typeOfEmployment, String companyName, String experienceOfWork, boolean show, String keyWord);
    /**
     * This is the method to be used to list down
     * a record from the Student table corresponding
     * to a passed student id.
     */
    public Vacancy getVacancy(Integer id);
    /**
     * This is the method to be used to list down
     * all the records from the Student table.
     */
    public List<Vacancy> listVacancies();

}
