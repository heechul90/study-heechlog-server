package study.heechlog.server.api.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import study.heechlog.server.api.request.PostCreateRequest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
public class PostController {

    @PostMapping(value = "/posts")
    public Map<String, String> post(@RequestBody @Validated PostCreateRequest request) {

        /*if (bindingResult.hasErrors()) {
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            FieldError fieldError = fieldErrors.get(0);
            Map<String, String> error = new HashMap<>();
            error.put(fieldError.getField(), fieldError.getDefaultMessage());
            return error;
        }*/

        log.info("request = {}", request.toString());
        return Map.of();
    }


}
