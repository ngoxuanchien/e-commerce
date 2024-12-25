package nxc.hcmus.common.util;


import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import lombok.RequiredArgsConstructor;

@ApplicationScoped
@RequiredArgsConstructor
public class JsonUtil {

    @Inject
    ObjectMapper objectMapper;

    public <T> T convertJsonToObject(String json, Class<T> clazz) {
        try {
            return objectMapper.readValue(json, clazz);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public <T> T convertToObject(Object object, Class<T> clazz) {
        try {
            return objectMapper.convertValue(object, clazz);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public String convertObjectToJson(Object object) {
        try {
            return objectMapper.writeValueAsString(object);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
