package kongkin.bbu.edu.webapideploy.controllers.language;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@RestController
@RequestMapping("/api/translations")
public class TranslationController {
    @Autowired
    private MessageSource messageSource;

    @GetMapping("/{lang}")
    public ResponseEntity<Map<String, String>> getTranslations(@PathVariable("lang") String lang) {
        Locale locale = new Locale(lang);
        Map<String, String> translations = new HashMap<>();
        translations.put("greeting", messageSource.getMessage("greeting.message", null, locale));
        return ResponseEntity.ok(translations);
    }
}
