package model;

import org.codehaus.jackson.map.ObjectMapper;
import vo.Vacancy;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by Martynenko on 16.01.2016.
 */
public class ReadFromFile {
    Vacancy[] vacancies = null;
    public Vacancy[] getData() {

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            File file = new File("C:\\_files\\apache-tomcat-7.0.67\\webapps\\VacancyParser-0.1\\vacancy.json");
            vacancies = objectMapper.readValue(file, Vacancy[].class);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return vacancies;
    }

    public void sortByTitle(String type){
        if (type.equals("title"))
            Arrays.sort(vacancies, new Comparator<Vacancy>() {
                @Override
                public int compare(Vacancy o1, Vacancy o2) {
                    return o1.getTitle().compareTo(o2.getTitle());
                }
            });
        if (type.equals("data"))
            Arrays.sort(vacancies, new Comparator<Vacancy>() {
                @Override
                public int compare(Vacancy o1, Vacancy o2) {
                    return o1.getDateOfPublication().compareTo(o2.getDateOfPublication());
                }
            });
        if (type.equals("company"))
            Arrays.sort(vacancies, new Comparator<Vacancy>() {
                @Override
                public int compare(Vacancy o1, Vacancy o2) {
                    return o1.getCompanyName().compareTo(o2.getCompanyName());
                }
            });
        if (type.equals("description"))
            Arrays.sort(vacancies, new Comparator<Vacancy>() {
                @Override
                public int compare(Vacancy o1, Vacancy o2) {
                    return o1.getDescription().compareTo(o2.getDescription());
                }
            });
        if (type.equals("city"))
            Arrays.sort(vacancies, new Comparator<Vacancy>() {
                @Override
                public int compare(Vacancy o1, Vacancy o2) {
                    return o1.getCity().compareTo(o2.getCity());
                }
            });
        if ("bla-bla" != "")
            Arrays.sort(vacancies, new Comparator<Vacancy>() {
                @Override
                public int compare(Vacancy o1, Vacancy o2) {
                    return o2.getCity().compareTo(o1.getCity());
                }
            });
    }
}
