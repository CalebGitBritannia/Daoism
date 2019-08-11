package com.daoism.cultivation.ItemBlockData.Sword;

import com.daoism.cultivation.API.ItemMethods;
import com.daoism.cultivation.API.PlayerMethods;
import com.daoism.cultivation.Registration.ItemBase;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

public class FlameTalisman extends ItemBase {

    /**
     * Constructor, sets the unlocalised name and registers it
     *
     * @param name Unlocalised name
     */
    public FlameTalisman(String name) {
        super(name);
        this.setMaxStackSize(1);
    }

    @Override
    public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity) {
        if (!player.getEntityWorld().isRemote) {
            if (entity instanceof EntityLiving) {
                EntityLiving entityLiving = (EntityLiving) entity;
                if (PlayerMethods.getEntityCultivationLevel(player) / 10 >= entityLiving.getMaxHealth()) {
                    entityLiving.setFire((PlayerMethods.getEntityCultivationLevel(player) / 100) - ((int) entityLiving.getMaxHealth() /10) + 2);
                    player.inventory.removeStackFromSlot(player.inventory.getSlotFor(stack));
                } else {
                    PlayerMethods.sendMsgToPlayer(player, "You do not have enough cultivation to harm this entity", new Style().setColor(TextFormatting.GOLD));
                }
            }

        } return true;
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
        ItemStack item = playerIn.getHeldItem(handIn);
        if (!worldIn.isRemote) {

        } return new ActionResult<>(EnumActionResult.SUCCESS, item);
    }
}

