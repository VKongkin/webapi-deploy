package kongkin.bbu.edu.webapideploy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class WebApiDeployApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebApiDeployApplication.class, args);
    }
    @GetMapping("")
    public String test(){
        return "Welcome to spring boot api";
    }
}
