package com.babelapp.babelapp.logic;

import com.babelapp.babelapp.data.GoogleApiRepository;
import com.babelapp.babelapp.logic.exceptions.InvalidSourceLanguageException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TranslateService {

    GoogleApiRepository googleApiRepository;

    @Autowired
    public TranslateService(GoogleApiRepository googleApiRepository) {
        this.googleApiRepository = googleApiRepository;
    }

    public String translateText(String text, String baseLanguage) {

        if (!"en".equals(baseLanguage) && !"zh".equals(baseLanguage) && !"es".equals(baseLanguage)) {
            throw new InvalidSourceLanguageException(baseLanguage + " is not a valid source language.");
        }

        String englishTranslation;
        String chineseTranslation;
        String spanishTranslation;

        if ("zh".equals(baseLanguage)) {
            chineseTranslation = text;
            baseLanguage = "zh-CN";
        } else {
            chineseTranslation = googleApiRepository.translateText(text,baseLanguage,"zh-CN");
        }

        if ("en".equals(baseLanguage)) {
            englishTranslation = text;
        } else {
            englishTranslation = googleApiRepository.translateText(text,baseLanguage,"en");
        }

        if ("es".equals(baseLanguage)) {
            spanishTranslation = text;
        } else {
            spanishTranslation = googleApiRepository.translateText(text,baseLanguage,"es");
        }

        return  "{\n" +
                "    \"en\":\"" + englishTranslation + "\",\n"
                + "    \"zh\":\"" + chineseTranslation + "\",\n"
                + "    \"es\":\"" + spanishTranslation + "\"" +
                "\n}";
    }
}
