package co.edu.unisabana.usuario.controller;

import lombok.AllArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class HealthyController {

    private ApplicationContext context;

    @GetMapping(path = "/ping")
    public String pong() {
        return "Pong";
    }


    @GetMapping(path = "/destroy")
    public void destroy() {
        ((ConfigurableApplicationContext) context).close();
    }
}
