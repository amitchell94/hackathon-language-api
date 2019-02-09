package com.babelapp.babelapp.data;

import com.babelapp.babelapp.presentation.TranslationErrorException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;

import java.net.URI;

@Repository
public class GoogleApiRepository {

    private static final String QUERY = "q";
    private static final String SOURCE = "source";
    private static final String TARGET = "target";
    private static final String FORMAT = "format";
    @Value("https://translation.googleapis.com/language/translate/v2/detect")
    private String DETECT_BASE_URL;
    @Value("https://translation.googleapis.com/language/translate/v2")
    private String TRANSLATE_BASE_URL;
    @Value("key")
    private String APPID;
    @Value("AIzaSyAnx6jVTG_aeIk5nTG1Soe1h35F9OZoPaM")
    private String API_KEY;
    private RestTemplate restTemplate;

    @Autowired
    public GoogleApiRepository(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String getLanguage(String text) {
        String language = "";
        text = text.replace("\\s","%20");
        try {
        URI uri = new DefaultUriBuilderFactory()
                .uriString(DETECT_BASE_URL)
                .queryParam(APPID, API_KEY)
                .queryParam(QUERY, text)
                .build();


            ResponseEntity<String> response = restTemplate.getForEntity(uri, String.class);

            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(response.getBody());
            language = root.findPath("data").findPath("detections").get(0).findPath("language").asText();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return language;
    }

    public String translateText(String text, String baseLanguage, String targetLanguage) throws TranslationErrorException {
        String translation = "";
        text = text.replace("\\s","%20");
        try {
            URI uri = new DefaultUriBuilderFactory()
                    .uriString(TRANSLATE_BASE_URL)
                    .queryParam(APPID, API_KEY)
                    .queryParam(QUERY, text)
                    .queryParam(SOURCE, baseLanguage)
                    .queryParam(TARGET, targetLanguage)
                    .queryParam(FORMAT, "text")
                    .build();


            ResponseEntity<String> response = restTemplate.getForEntity(uri, String.class);

            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(response.getBody());
            translation = root.findPath("data").findPath("translations").get(0).findPath("translatedText").asText();
        } catch (Exception e) {
            throw new TranslationErrorException();
        }

        return translation;
    }
}