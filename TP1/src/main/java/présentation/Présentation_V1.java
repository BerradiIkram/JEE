package présentation;
import dao.DaoImp;
import metier.MetierImp;
public class Présentation_V1 {
        public static void main(String[] args) {
            // injection des dependense par instaciation statique =>new
            //en utiliser setr
            MetierImp metier=new MetierImp();
            DaoImp dao=new DaoImp();
            metier.setDao(dao); //metierImp-->DaoImp
            System.out.println("instaciation statique=>"+metier.calcul());}
}
