package dao;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import valueobject.Vacancy;
import valueobject.VacancyMapper;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Martynenko on 10.02.2016.
 */
public class VacancyJDBCTemplate implements VacancyDao {
    private DataSource dataSource;
    private SimpleJdbcCall jdbcCall;
    private JdbcTemplate jdbcTemplateObject;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcCall =  new SimpleJdbcCall(dataSource).
                withProcedureName("getRecord");
    }

    @Override
    public void create(String link, String title, String city, String description, String dateOfPublication, String typeOfEmployment, String companyName, String experienceOfWork, boolean show, String keyWord) {
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
        String SQL = "INSERT INTO `test`.`vacancy` (`link`, `title`, `city`, `description`, `dateOfPublication`, `typeOfEmployment`, `companyName`, `experienceOfWork`, `show`, `keyWord`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
        jdbcTemplateObject.update( SQL, link, title, city, description, dateOfPublication, typeOfEmployment, companyName, experienceOfWork, show, keyWord);
        System.out.println("Created Record Link = " + link);
        } catch (Exception e) {
            System.out.println("exception in VacancyJDBCTemplate, create method");
        }

    }

    @Override
    public Vacancy getVacancy(Integer id) {
        SqlParameterSource in = new MapSqlParameterSource().addValue("in_id", id);
        Map<String, Object> out = jdbcCall.execute(in);

        Vacancy vacancy = new Vacancy();
        vacancy.setId(id);
        vacancy.setLink((String) out.get("out_link"));
        vacancy.setTitle((String) out.get("out_title"));
        vacancy.setCity((String) out.get("out_city"));
        vacancy.setDescription((String) out.get("out_description"));
        vacancy.setDateOfPublication((String) out.get("out_dateOfPublication"));
        vacancy.setCompanyName((String) out.get("out_company"));
        vacancy.setTypeOfEmployment((String) out.get("out_typeOfEmployment"));
        vacancy.setExperienceOfWork((String) out.get("out_experience"));
        vacancy.setKeyWord((String) out.get("out_keyWord"));
        vacancy.setShow((Boolean) out.get("out_show"));

        return vacancy;
    }

    @Override
    public List<Vacancy> listVacancies() {
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
        String SQL = "SELECT * FROM `test`.`vacancy`";
        List <Vacancy> vacancies = jdbcTemplateObject.query(SQL,
                new VacancyMapper());
        return vacancies;
    }
}
