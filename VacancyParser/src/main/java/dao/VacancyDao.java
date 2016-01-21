package dao;

import tools.Configuration;
import valueobject.Vacancy;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Martynenko on 20.01.2016.
 */
public class VacancyDao {
    private static final String CONNECTION_URL = Configuration.getInstance().getParameter("URL");
    private static final String CONNECTION_USER = Configuration.getInstance().getParameter("USER");
    private static final String CONNECTION_PASSWORD = Configuration.getInstance().getParameter("PASSWORD");

    private static VacancyDao instance = null;

    private VacancyDao() {
        super();
    }

    public static VacancyDao getInstance() {
        if (instance == null)
            instance = new VacancyDao();
        return instance;
    }

    public void createTable() {
        try (Connection con = DriverManager.getConnection(CONNECTION_URL, CONNECTION_USER, CONNECTION_PASSWORD)) {

            String sql = "CREATE TABLE `vacancies` (\n" +
                    "  `id` int(11) NOT NULL AUTO_INCREMENT,\n" +
                    "  `link` varchar(500) DEFAULT NULL,\n" +
                    "  `title` varchar(500) DEFAULT NULL,\n" +
                    "  `city` varchar(500) DEFAULT NULL,\n" +
                    "  `description` text,\n" +
                    "  `dateOfPublication` varchar(45) DEFAULT NULL,\n" +
                    "  `typeOfEmployment` varchar(45) DEFAULT NULL,\n" +
                    "  `companyName` varchar(45) DEFAULT NULL,\n" +
                    "  `experienceOfWork` varchar(45) DEFAULT NULL,\n" +
                    "  `show` tinyint(4) DEFAULT NULL,\n" +
                    "  `keyWord` varchar(10000) DEFAULT NULL,\n" +
                    "  PRIMARY KEY (`id`),\n" +
                    "  UNIQUE KEY `link_UNIQUE` (`link`)\n" +
                    ") ENGINE=InnoDB DEFAULT CHARSET=utf8;\n";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.execute();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void addVacancy(String link,
                           String title,
                           String city,
                           String description,
                           String dateOfPublication,
                           String typeOfEmployment,
                           String companyName,
                           String experienceOfWork,
                           boolean show,
                           String keyWord) {
        Vacancy vacancy = new Vacancy(link, title, city, description, dateOfPublication, typeOfEmployment, companyName, experienceOfWork, show, keyWord);
        try (Connection con = DriverManager.getConnection(CONNECTION_URL, CONNECTION_USER, CONNECTION_PASSWORD)) {

            String sql = "INSERT INTO vacancy_db (link, title, city, description, dateOfPublication, typeOfEmployment, companyName, experienceOfWork, show, keyWord) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, vacancy.getLink());
            ps.setString(2, vacancy.getTitle());
            ps.setString(3, vacancy.getCity());
            ps.setString(4, vacancy.getDescription());
            ps.setString(5, vacancy.getDateOfPublication());
            ps.setString(6, vacancy.getTypeOfEmployment());
            ps.setString(7, vacancy.getCompanyName());
            ps.setString(8, vacancy.getExperienceOfWork());
            ps.setBoolean(9, vacancy.isShow());
            ps.setString(10, vacancy.getKeyWord());
            ps.execute();
            System.out.printf("added new vacancy to db, %s \n", title);


        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public List<Vacancy> getVacancyFromDB(){
        ArrayList<Vacancy> vacancies = new ArrayList<>();
        Statement stmt = null;
        try (Connection con = DriverManager.getConnection(CONNECTION_URL, CONNECTION_USER, CONNECTION_PASSWORD)) {
            stmt = con.createStatement();
            // select
            String sql = "SELECT * FROM vacations.vacancies";
            ResultSet rs = stmt.executeQuery(sql);
            // Extract data from result set
            while(rs.next()){
                String link  = rs.getString("link");
                String title  = rs.getString("title");
                String city  = rs.getString("city");
                String description  = rs.getString("description");
                String experienceOfWork  = rs.getString("experienceOfWork");
                String dateOfPublication  = rs.getString("dateOfPublication");
                String typeOfEmployment  = rs.getString("typeOfEmployment");
                String companyName  = rs.getString("companyName");
                String keyWord  = rs.getString("keyWord");
                boolean show  = rs.getBoolean("show");
                Vacancy vacancy = new Vacancy(link, title, city, description, dateOfPublication, typeOfEmployment, companyName, experienceOfWork, show, keyWord);
                vacancies.add(vacancy);
            }
            rs.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return vacancies;
    }
}
