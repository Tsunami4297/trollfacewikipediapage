/*
 * Copyright (c) Shadow client, Saturn5VFive and contributors 2022. All rights reserved.
 */

package net.shadow.client.feature.addon;

import net.minecraft.util.Identifier;
import net.shadow.client.feature.command.Command;
import net.shadow.client.feature.module.AddonModule;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

@SuppressWarnings("unused")
public abstract class Addon {
    public final String name;
    public final String description;
    public final String[] developers;
    private final AtomicBoolean isEnabled = new AtomicBoolean(false);

    public Addon(String name, String description, String[] developers) {
        this.name = name;
        this.description = description;
        this.developers = developers;
    }

    public abstract Identifier getIcon();

    public abstract List<AddonModule> getAdditionalModules();

    public abstract List<Command> getAdditionalCommands();

    public final void onEnable() {
        isEnabled.set(true);
        enabled();
    }

    public final void onDisable() {
        isEnabled.set(false);
        disabled();
    }

    public final boolean isEnabled() {
        return isEnabled.get();
    }

    public abstract void enabled();

    public abstract void disabled();

    public abstract void reloaded();
}
