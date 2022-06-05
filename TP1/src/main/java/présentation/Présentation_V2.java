package présentation;

import dao.Dao;
import metier.Metier;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;
public class Présentation_V2 {
    public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
       /*ovrire une ficher*/
        Scanner scanner=new Scanner(new File("src/config.txt"));
      /* /*lire premier line de fichier txt*/
       String daoClassName=scanner.nextLine();
        /* chercher si la classe  il existe et charger au mémoire si non un erreue class not fonde exeption  */
       Class cDao=Class.forName(daoClassName);
        //cherche un constrecteur son parametre =erreur INstasiatuionexseption
       Dao dao= (Dao) cDao.newInstance();//demader de crées un object
        String metierClassName=scanner.nextLine();
        Class cMetier=Class.forName(metierClassName);
        Metier metier=(Metier)cMetier.newInstance();
//creé un objet métthode pur stoker dans laquelle  l'objet de la class dao
        Method methode=cMetier.getMethod("setDao",Dao.class);
        //executer la méthode
        methode.invoke(metier,dao);
        System.out.println("instaciation dynamique=>"+metier.calcul());
    }}
