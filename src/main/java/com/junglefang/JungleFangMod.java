package com.junglefang;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JungleFangMod implements ModInitializer {
    public static final String MOD_ID = "junglefang";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    public static final Item JUNGLE_FANG = new JungleFangItem(
            new Item.Settings().maxCount(1).maxDamage(512)
    );

    @Override
    public void onInitialize() {
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "jungle_fang"), JUNGLE_FANG);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(entries -> entries.add(JUNGLE_FANG));

        LOGGER.info("Jungle Fang mod initialized.");
    }
}