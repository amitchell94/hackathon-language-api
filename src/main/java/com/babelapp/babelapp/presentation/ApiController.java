package com.babelapp.babelapp.presentation;

import com.babelapp.babelapp.logic.TranslateService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/api")
public class ApiController {

    @Resource
    TranslateService translateService;

    @CrossOrigin
    @PostMapping("/translate")
        public String translate (@RequestParam(name = "sourcelanguage") String sourceLanguage, @RequestBody String text) {
        return translateService.translateText(text, sourceLanguage);
    }
}
