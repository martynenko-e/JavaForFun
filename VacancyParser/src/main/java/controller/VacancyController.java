package controller;

import dao.VacancyJDBCTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import valueobject.Vacancy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Martynenko on 10.02.2016.
 */

@Controller
@RequestMapping("/vacancy")
public class VacancyController {
//    ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
//    VacancyJDBCTemplate vacancyJDBCTemplate = (VacancyJDBCTemplate)context.getBean("vacancyJDBCTemplate");
//    Vacancy vacancy = vacancyJDBCTemplate.getVacancy(1);

//    @RequestMapping()
//    public String sentVacancy(ModelMap model) {
//        model.addAttribute("message", "Hello My=ooooooooooooooooo");
//        return "vacancy";
//    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView doStuff() {
        ModelAndView mav = new ModelAndView();

        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
        VacancyJDBCTemplate vacancyJDBCTemplate = (VacancyJDBCTemplate)context.getBean("vacancyJDBCTemplate");
        List<Vacancy> vacancies = vacancyJDBCTemplate.listVacancies();

//        Map<String, String> message = new HashMap<>();
//        message.put("message", "Hello World");
//        message.put("vad", "Hello World");
//        message.put("fdsfds", "Hello World");
        mav.setViewName("vacancy");
        mav.addObject("message", vacancies);
        return mav;
    }

}
