package nxc.hcmus.domain.model.enums;

public enum EventType {
    CREATE_PRODUCT("CREATE_PRODUCT"),
    CREATE_CATEGORY("CREATE_CATEGORY");

    private String eventType;

    EventType(String eventType) {
        this.eventType = eventType;
    }
}
