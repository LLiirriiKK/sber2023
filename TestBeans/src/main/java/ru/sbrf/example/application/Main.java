package ru.sbrf.example.application;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.sbrf.example.configuration.AppConfig;
import ru.sbrf.example.models.ReportBuilder;

public class Main {
    public static void main(String[] args)  {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        ReportBuilder reportBuilder = applicationContext.getBean(ReportBuilder.class);
        reportBuilder.createReport();
    }

}
