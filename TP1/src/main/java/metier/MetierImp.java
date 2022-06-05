package metier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import dao.Dao;
@Component
public class MetierImp implements Metier{
    //Couplage Faible
    @Autowired
    private Dao dao=null;
   /* public MetierImp(Dao dao) {
        this.dao = dao;
    }*/
    @Override
    public double calcul() {
        double data=dao.getData();
        double res=data*223*Math.cos(data);
        return res;
    }
    //pour injecter dans la variable dao un objet d'une clase qui impliment l' interface Dao
    public void setDao(Dao dao) {
        this.dao = dao;
    }
}
