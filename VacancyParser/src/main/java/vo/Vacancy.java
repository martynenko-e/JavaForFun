package vo;

/**
 * Created by Martynenko on 14.01.2016.
 */
public class Vacancy
{
    private String link;
    private String title;
    private String city;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    private String description;
    private String dateOfPublication;
    private String companyName;
    private String typeOfEmployment;
    private String experienceOfWork;
    private Boolean show;

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDateOfPublication() {
        return dateOfPublication;
    }

    public void setDateOfPublication(String dateOfPublication) {
        this.dateOfPublication = dateOfPublication;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getTypeOfEmployment() {
        return typeOfEmployment;
    }

    public void setTypeOfEmployment(String typeOfEmployment) {
        this.typeOfEmployment = typeOfEmployment;
    }

    public String getExperienceOfWork() {
        return experienceOfWork;
    }

    public void setExperienceOfWork(String experienceOfWork) {
        this.experienceOfWork = experienceOfWork;
    }

    public Boolean getShow() {
        return show;
    }

    public void setShow(Boolean show) {
        this.show = show;
    }
}
