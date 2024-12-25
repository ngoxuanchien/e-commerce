package nxc.hcmus.common.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;

import java.text.SimpleDateFormat;

@ApplicationScoped
public class ObjectMapperConfig {

    @Produces
    public ObjectMapper objectMapper() {
        var objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());

        var dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        objectMapper.setDateFormat(dateFormat);
        return objectMapper;
    }
}
