package ru.sbrf.example.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.sbrf.example.models.Analyzer;
import ru.sbrf.example.implementations.AnalyzerImpl;
import ru.sbrf.example.implementations.ParserTxT;
import ru.sbrf.example.implementations.ReportBuilderImpl;
import ru.sbrf.example.models.Parser;
import ru.sbrf.example.models.ReportBuilder;

@Configuration
public class AppConfig {

    @Bean
    public Parser parser(){
        return new ParserTxT("G:\\JavaProjects\\sber2023\\TestBeans\\test.txt");
    }

    @Bean
    public Analyzer analyzer(){
        return new AnalyzerImpl(parser());
    }

    @Bean
    public ReportBuilder reportBuilder(){
        return new ReportBuilderImpl(analyzer());
    }
}
