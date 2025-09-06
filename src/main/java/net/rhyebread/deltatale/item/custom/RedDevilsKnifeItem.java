package net.rhyebread.deltatale.item.custom;

import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.rhyebread.deltatale.sound.ModSounds;
import net.rhyebread.entity.custom.DevilsKnifeProjectileEntity;
import org.jetbrains.annotations.Nullable;

import java.util.List;


public class RedDevilsKnifeItem extends HoeItem {

    public RedDevilsKnifeItem(Tier pTier, int pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties) {
        super(pTier, pAttackDamageModifier, pAttackSpeedModifier, pProperties);
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.literal("§e§oPassive: Takes 10s off Rude Buster's cooldown").withStyle());
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
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
