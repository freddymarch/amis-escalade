package com.openclassrooms.amisescalade.enums;

public enum StatusTopo {

    IN_PROGRESS("In progress"),
    VALIDATE("Validate"),
    refuse("refuse");

    private String label;

    StatusTopo(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

}
