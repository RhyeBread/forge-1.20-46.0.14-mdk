package net.rhyebread.deltatale.item.custom;

import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.common.Mod;
import net.rhyebread.deltatale.item.ModItems;
import net.rhyebread.deltatale.sound.ModSounds;
import net.rhyebread.entity.custom.RudeBusterProjectileEntity;

import java.util.Collections;
import java.util.Set;
import java.util.function.Predicate;

public class RudeAxeItem extends AxeItem{


    public RudeAxeItem(Tier pTier, float pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties) {
        super(pTier, pAttackDamageModifier, pAttackSpeedModifier, pProperties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pHand){
        ItemStack itemstack = pPlayer.getItemInHand(pHand);
        pLevel.playSound((Player) null, pPlayer.getX(), pPlayer.getY(), pPlayer.getZ(), ModSounds.RUDE_AXE_USE.get(), SoundSource.NEUTRAL, 1f, 1f / (pLevel.getRandom().nextFloat() * 0.4f + 0.8f));
        if (!pLevel.isClientSide){
            if (!pPlayer.getCooldowns().isOnCooldown(this)){
                RudeBusterProjectileEntity rude= new RudeBusterProjectileEntity(pLevel, pPlayer);
                rude.shootFromRotation(pPlayer, pPlayer.getXRot(), pPlayer.getYRot(), 0.0f, 1.5f, 0f);
                pLevel.addFreshEntity(rude);
                int cooldownTicks = 600;
                if(pPlayer.getInventory().hasAnyOf(Collections.singleton((ModItems.REDDEVILSKNIFE.get())))){
                    pPlayer.getCooldowns().addCooldown(this, (cooldownTicks - 200));
                }
                else{
                    pPlayer.getCooldowns().addCooldown(this, cooldownTicks);
                }
            }
        }
        return InteractionResultHolder.sidedSuccess(itemstack, pLevel.isClientSide());
    }
}
