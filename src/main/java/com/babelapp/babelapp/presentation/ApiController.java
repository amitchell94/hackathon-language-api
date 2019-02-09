package com.babelapp.babelapp.presentation;

import com.babelapp.babelapp.logic.TranslateService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/api")
public class ApiController {

    @Resource
    TranslateService translateService;

    @PostMapping("/translate")
        public String translate (@RequestParam(name = "text") String text, @RequestParam(name = "sourcelanguage") String sourceLanguage) {
        return translateService.translateText(text, sourceLanguage);
    }
}
