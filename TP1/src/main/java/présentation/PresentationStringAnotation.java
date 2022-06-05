package présentation;

import metier.Metier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class PresentationStringAnotation {
    public static void main(String[] args) {
    ApplicationContext context=new AnnotationConfigApplicationContext("dao2","metier","ext");
    Metier metier=context.getBean(Metier.class);
    System.out.println("SpringVersion Annotation=>"+metier.calcul());
}}
