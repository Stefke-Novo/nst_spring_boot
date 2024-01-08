package fon.stefan.januarski_rok.config;

import fon.stefan.januarski_rok.converter.impl.DepartmentConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DepartmentConverterConfiguration {

    @Bean
    public DepartmentConverter createDepartmentConverter(){
        return new DepartmentConverter();
    }
}
