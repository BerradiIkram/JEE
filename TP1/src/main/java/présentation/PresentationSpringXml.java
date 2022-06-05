package présentation;

import metier.Metier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PresentationSpringXml {
    public static void main(String[] args)  {
        ApplicationContext context=new ClassPathXmlApplicationContext("config.xml");
        Metier metier=(Metier) context.getBean("metier");
        System.out.println("SpringVersion-XML=>"+metier.calcul());

    }
}
