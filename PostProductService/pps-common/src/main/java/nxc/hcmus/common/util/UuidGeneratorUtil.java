package nxc.hcmus.common.util;

import org.springframework.stereotype.Component;

@Component
public class UuidGeneratorUtil {
    public String generateUuid() {
        return java.util.UUID.randomUUID().toString();
    }
}
