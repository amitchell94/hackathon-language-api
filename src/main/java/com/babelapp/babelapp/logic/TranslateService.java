package com.babelapp.babelapp.logic;

import com.babelapp.babelapp.data.GoogleApiRepository;
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

        if (!"en".equals(baseLanguage) && !"zh-CN".equals(baseLanguage) && !"es".equals(baseLanguage)) {
            throw new InvalidSourceLanguageException(baseLanguage + " is not a valid source language.");
        }

//        String baseLanguage = googleApiRepository.getLanguage(text);
        String englishTranslation;
        String chineseTranslation;
        String spanishTranslation;

        if ("en".equals(baseLanguage)) {
            englishTranslation = text;
        } else {
            englishTranslation = googleApiRepository.translateText(text,baseLanguage,"en");
        }

        if ("zh-CN".equals(baseLanguage)) {
            chineseTranslation = text;
        } else {
            chineseTranslation = googleApiRepository.translateText(text,baseLanguage,"zh-CN");
        }

        if ("es".equals(baseLanguage)) {
            spanishTranslation = text;
        } else {
            spanishTranslation = googleApiRepository.translateText(text,baseLanguage,"es");
        }
        return  "{\n" +
                "  \"en\": '" + englishTranslation + "',\n"
                + "  \"zh-CN\": '" + chineseTranslation + "',\n"
                + "  \"es\": '" + spanishTranslation + "'" +
                "\n}";
//        return  "{" +
//                "\"en\": '" + englishTranslation + "',"
//                + "\"zh-CN\": '" + chineseTranslation + "', "
//                + "\"es\": '" + spanishTranslation + "'}";
    }
}
