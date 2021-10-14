package com.testmesoft.common.builder;

import com.testmesoft.common.entity.LanguageEntity;

public class LanguageBuilder {
    private String code;
    private String name;

    private LanguageBuilder() {

    }

    public static LanguageBuilder builder() {
        return new LanguageBuilder();
    }

    public LanguageBuilder code(String code) {
        this.code = code;
        return this;
    }

    public LanguageBuilder name(String name) {
        this.name = name;
        return this;
    }

    public LanguageEntity build() {
        return new LanguageEntity(this.code, this.name);
    }
}
