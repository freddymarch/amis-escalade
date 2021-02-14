package com.openclassrooms.amisescalade.enums;

public enum EnumRole {

    MEMBER("MEMBER"),
    ADMIN("ADMIN");

    private String code;

    EnumRole(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

}
