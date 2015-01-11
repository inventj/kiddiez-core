package be.inventj.kiddiez.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"be.inventj.kiddiez.controllers",
        "be.inventj.kiddiez.service", "be.inventj.kiddiez.aspect"})
@EnableAspectJAutoProxy
public class WebConfig {
}
