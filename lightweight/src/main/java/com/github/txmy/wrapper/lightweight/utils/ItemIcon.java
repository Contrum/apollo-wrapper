package com.github.txmy.wrapper.lightweight.utils;

import com.google.common.base.Preconditions;
import com.google.gson.JsonObject;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class ItemIcon extends Icon {

    private final String itemName;
    private final int id;
    private final int customModelData;

    private ItemIcon(String itemName, int id, int customModelData) {
        this.itemName = itemName;
        this.id = id;
        this.customModelData = customModelData;
    }

    public static ItemIcon of(ItemStack stack, int customModelData) {
        return new ItemIcon(stack.getType().name(), stack.getTypeId(), customModelData);
    }

    public static ItemIcon of(ItemStack stack) {
        return of(stack, 0);
    }

    public static ItemIcon of(String itemName, int customModelData) {
        Material material = Material.matchMaterial(itemName);
        Preconditions.checkNotNull(material, "Material '" + itemName + "' doesn't exist!");

        return new ItemIcon(itemName, 0, customModelData);
    }

    public static ItemIcon of(String itemName) {
        return of(itemName, 0);
    }

    @Override
    public void add(JsonObject mainObject) {
        JsonObject wrapper = new JsonObject();
        JsonObject object = new JsonObject();
        object.addProperty("item_name", itemName);
        if (itemName == null)
            object.addProperty("item_id", id);
        object.addProperty("custom_model_data", customModelData);
        wrapper.add("item_stack", object);

        mainObject.add("icon", wrapper);
    }
}
