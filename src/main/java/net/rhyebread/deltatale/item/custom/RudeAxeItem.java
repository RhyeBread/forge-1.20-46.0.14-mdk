package net.rhyebread.deltatale.item.custom;

import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.rhyebread.deltatale.item.ModItems;
import net.rhyebread.deltatale.sound.ModSounds;
import net.rhyebread.entity.custom.RudeBusterProjectileEntity;

public class RudeAxeItem extends Item{
    public RudeAxeItem(Item.Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pHand){
        ItemStack itemstack = pPlayer.getItemInHand(pHand);
        pLevel.playSound((Player) null, pPlayer.getX(), pPlayer.getY(), pPlayer.getZ(), ModSounds.RUDE_AXE_USE.get(), SoundSource.NEUTRAL, 1f, 1f / (pLevel.getRandom().nextFloat() * 0.4f + 0.8f));
        if (!pLevel.isClientSide){
            RudeBusterProjectileEntity rude= new RudeBusterProjectileEntity(pLevel, pPlayer);
            rude.shootFromRotation(pPlayer, pPlayer.getXRot(), pPlayer.getYRot(), 0.0f, 1.5f, 0f);
            pLevel.addFreshEntity(rude);
        }
        return InteractionResultHolder.sidedSuccess(itemstack, pLevel.isClientSide());
    }
}
