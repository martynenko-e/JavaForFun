import model.Provider;
import vo.Vacancy;

import java.util.ArrayList;


/**
 * Created by Martynenko on 14.01.2016.
 */
public class Controller
{
    private Provider[] providers;

    public Controller(Provider...providers){
        if (providers==null||providers.length==0){throw new IllegalArgumentException();}
        this.providers = providers;
    }

    @Override
    public java.lang.String toString()
    {
        return "Controller{" +
                "providers=" + java.util.Arrays.toString(providers) +
                '}';
    }

    public void scan()
    {
        ArrayList<Vacancy> vacs = new ArrayList<Vacancy>();
        try{
            for (Provider provider : providers){
                for (Vacancy vacancy:provider.getJavaVacancies("SOME TEXT")){
                    vacs.add(vacancy);
                }
            }
        }catch(NullPointerException e){/*NOP*/}
        System.out.println(vacs.size());
    }


}
