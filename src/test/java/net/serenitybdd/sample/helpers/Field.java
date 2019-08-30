package net.serenitybdd.sample.helpers;

public enum Field {
    FIRST_NAME("user_first_name"),
    LAST_NAME("user_last_name"),
    SUFFIX("user_suffix"),
    TITLE("user_title"),
    EMAIL("user_email"),
    PHONE_NUMBER("user_phone_number"),
    BUSINESS_NAME("user_business_name"),
    ADDRESS_LINE_1("user_address_1"),
    ADDRESS_LINE_2("user_address_2"),
    CITY("user_city"),
    STATE("user_state"),
    ZIP("user_zip");

    private final String id;

    Field(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
