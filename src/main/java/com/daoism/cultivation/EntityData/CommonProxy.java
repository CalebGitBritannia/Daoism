package com.daoism.cultivation.EntityData;

import com.daoism.cultivation.EventsClass;
import com.daoism.cultivation.Registration.BlockBase;
import com.daoism.cultivation.Registration.ItemBase;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import java.util.Objects;

public class CommonProxy {
    public void preInit(FMLPreInitializationEvent event) {
    }
    public void init(FMLInitializationEvent event) {
    }

    public void postInit(FMLPostInitializationEvent event) {
    }

    /**
     * Register the textures for items
     * @param item The item data
     * @param meta The item meta
     * @param id The location ID (Eg inventories)
     */
    public void registerItemRenderer(Item item, int meta, String id) {
        ModelLoader.setCustomModelResourceLocation(item,meta, new ModelResourceLocation(Objects.requireNonNull(item.getRegistryName()), id));
    }

}
