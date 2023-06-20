package com.test.task.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import static com.test.task.data.Constants.*;

@Controller
public class DefaultController {



    @GetMapping(HOME_URL)
    public String redirectToSwagger(){
      return REDIRECT_SWAGGER_UI_INDEX_HTML;
    }
}
