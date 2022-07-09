package study.heechlog.server.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController {

    @GetMapping(value = "/posts")
    public String get() {
        return "Hello World";
    }


}
