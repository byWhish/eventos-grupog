package unq.tpi.desapp.runners;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import unq.tpi.desapp.model.Template;
import unq.tpi.desapp.service.ProductService;
import unq.tpi.desapp.webservice.GuestWebService;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Component
@Order(4)
public class TemplateRunner implements CommandLineRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(TemplateRunner.class);

    @Autowired
    ProductService productService;

    @Override
    public void run(String... args) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
            TypeReference<List<Template>> typeReference = new TypeReference<List<Template>>(){};
            InputStream inputStream = TypeReference.class.getResourceAsStream("/json/templates.json");
            try {
                List<Template> templates = mapper.readValue(inputStream,typeReference);
                productService.createTemplates(templates);
                LOGGER.info("Template Saved!");
            } catch (IOException e){
                LOGGER.error("Unable to save templates: " + e.getMessage());
            }
    }
}
