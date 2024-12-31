package nxc.hcmus.application.event;

import lombok.Getter;

@Getter
public enum EventType {
    CREATE_CATEGORY("CREATE_CATEGORY"),
    CREATE_PRODUCT("CREATE_PRODUCT");

    private final String value;

    EventType(String value) {
        this.value = value;
    }
}
