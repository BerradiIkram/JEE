package ext;
import dao.Dao;
import org.springframework.stereotype.Component;
@Component("dao2")
public class DaoImpV2 implements Dao {
    @Override
    public double getData() {
        System.out.println("version-2");

        double temp= Math.random()*40;

        return temp;    }
}
