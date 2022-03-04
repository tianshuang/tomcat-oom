package me.tianshuang.tomcat.oom;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class TomcatOomApplication {

    public static void main(String[] args) {
        SpringApplication.run(TomcatOomApplication.class, args);
    }

    @PostMapping("/upload")
    public String upload(@RequestBody String body) {
        return "OK";
    }

}
