package com.daoism.cultivation;

import com.daoism.cultivation.API.ItemMethods;
import com.daoism.cultivation.API.PlayerMethods;
import com.daoism.cultivation.ReadWrite.Entity.CultivationCapability;
import com.daoism.cultivation.ReadWrite.Entity.CultivationHandler;
import com.daoism.cultivation.ReadWrite.item.CoreHandler;
import com.daoism.cultivation.Registration.ItemInit;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.entity.player.PlayerSleepInBedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

/**
 * This class is the listener for all the events of the mod
 */
public class EventsClass {

    /**
     * This method is important, it ensures that whenever a player logs out/dies/changes dimension the NBT data is
     * copied over and not lost
      * @param e The event data
     */
    @SubscribeEvent
    public void onClone(PlayerEvent.Clone e) {
            EntityPlayer player = e.getEntityPlayer();
            CultivationCapability cult = player.getCapability(CultivationHandler.CULTIVATION_CAPABILITY, null);
            CultivationCapability oldCult = e.getOriginal().getCapability(CultivationHandler.CULTIVATION_CAPABILITY, null);
            cult.setCultivate(oldCult.canCultivate());
            cult.setCultivationLevel(oldCult.getCultivationLevel());
    }

    /**
     * This method ties the entity data to the player
     * @param event The event data
     */
    @SubscribeEvent
    public void onAttach(AttachCapabilitiesEvent<Entity> event) {
        if (event.getObject() instanceof EntityPlayer) {
            event.addCapability(new ResourceLocation(Daoism.MODID, Daoism.NAME), new CultivationHandler());
        }
    }

    @SubscribeEvent
    public void onAttachItem(AttachCapabilitiesEvent<ItemStack> e) {
        if (e.getObject().getItem().equals(ItemInit.GOLDEN_CORE)) {
            e.addCapability(new ResourceLocation(Daoism.MODID, Daoism.NAME), new CoreHandler());
        }

    }

}
