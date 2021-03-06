/*
 * Copyright (c) Shadow client, Saturn5VFive and contributors 2022. All rights reserved.
 */

package net.shadow.client.feature.config;

import java.util.function.Consumer;

public class StringSetting extends SettingBase<String> {

    public StringSetting(String defaultValue, String name, String description, Consumer<String> onChange) {
        super(defaultValue, name, description, onChange);
    }

    @Override
    public String parse(String value) {
        return value;
    }

    public static class Builder extends SettingBase.Builder<Builder, String, StringSetting> {

        public Builder(String defaultValue) {
            super(defaultValue);
        }

        @Override
        public StringSetting get() {
            return new StringSetting(defaultValue, name, description, changed);
        }
    }
}
