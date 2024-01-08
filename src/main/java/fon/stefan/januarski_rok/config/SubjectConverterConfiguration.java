package fon.stefan.januarski_rok.config;

import fon.stefan.januarski_rok.converter.impl.SubjectConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SubjectConverterConfiguration {
    @Bean
    public SubjectConverter createSubjectConverter(){
        return new SubjectConverter();
    }
}
