package net.rhyebread.deltatale.item.custom;

import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.Level;
import net.rhyebread.deltatale.sound.ModSounds;
import net.rhyebread.entity.custom.DevilsKnifeProjectileEntity;


public class DevilsKnifeItem extends Item {
    public DevilsKnifeItem(Item.Properties pProperties){
        super(pProperties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pHand){
        ItemStack itemstack = pPlayer.getItemInHand(pHand);
        int random = pLevel.getRandom().nextInt(1, 2);

        pLevel.playSound((Player) null, pPlayer.getX(), pPlayer.getY(), pPlayer.getZ(), ModSounds.DEVILSKNIFE_USE.get(), SoundSource.NEUTRAL, 1f, 1f / (pLevel.getRandom().nextFloat() * 0.4f + 0.8f));
        if (!pLevel.isClientSide){
            DevilsKnifeProjectileEntity devil = new DevilsKnifeProjectileEntity(pLevel, pPlayer);
            devil.shootFromRotation(pPlayer, pPlayer.getXRot(), pPlayer.getYRot(), 0.0f, 1.5f, 0f);
            pLevel.addFreshEntity(devil);
        }
        return InteractionResultHolder.sidedSuccess(itemstack, pLevel.isClientSide());
    }
}
