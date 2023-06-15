package ru.sbrf.example.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.sbrf.example.Models.Analyzer;
import ru.sbrf.example.Implementations.AnalyzerImpl;
import ru.sbrf.example.Implementations.ParserTxT;
import ru.sbrf.example.Implementations.ReportBuilderImpl;
import ru.sbrf.example.Models.Parser;
import ru.sbrf.example.Models.ReportBuilder;

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
