package dao;
import org.springframework.stereotype.Component;
@Component("dao")
public class DaoImp implements Dao {

    @Override
    public double getData() {
        //dévlopeur
        //se coecter a la bd pour récuperer la donnée
        System.out.println("version-1");
        double temp= Math.random()*40;

        return temp;
    }
}
