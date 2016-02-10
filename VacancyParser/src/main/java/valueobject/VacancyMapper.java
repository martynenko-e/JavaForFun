package valueobject;

/**
 * Created by Martynenko on 10.02.2016.
 */
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class VacancyMapper implements RowMapper<Vacancy> {
    public Vacancy mapRow(ResultSet rs, int rowNum) throws SQLException {
        Vacancy vacancy = new Vacancy();
        vacancy.setId(rs.getInt("id"));
        vacancy.setLink(rs.getString("link"));
        vacancy.setTitle(rs.getString("title"));
        vacancy.setCity(rs.getString("city"));
        vacancy.setDescription(rs.getString("description"));
        vacancy.setDateOfPublication(rs.getString("dateOfPublication"));
        vacancy.setCompanyName(rs.getString("companyName"));
        vacancy.setTypeOfEmployment(rs.getString("typeOfEmployment"));
        vacancy.setExperienceOfWork(rs.getString("experienceOfWork"));
        vacancy.setKeyWord(rs.getString("keyWord"));
        vacancy.setShow(rs.getBoolean("show"));
        return vacancy;
    }
}

//    private String link;
//    private String title;
//    private String city;
//    private String description;
//    private String dateOfPublication;
//    private String companyName;
//    private String typeOfEmployment;
//    private String experienceOfWork;
//    private String keyWord;
//    private boolean show;
//    private Integer id;