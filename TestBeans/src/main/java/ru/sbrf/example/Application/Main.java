package ru.sbrf.example.Application;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.sbrf.example.Configuration.AppConfig;
import ru.sbrf.example.Models.ReportBuilder;

public class Main {
    public static void main(String[] args)  {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        ReportBuilder reportBuilder = applicationContext.getBean(ReportBuilder.class);
        reportBuilder.createReport();
    }

}
