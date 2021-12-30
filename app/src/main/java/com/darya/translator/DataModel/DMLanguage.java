package com.darya.translator.DataModel;

public class DMLanguage {

    private String id;
    private String name;

    public DMLanguage() {
    }

    public DMLanguage(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
