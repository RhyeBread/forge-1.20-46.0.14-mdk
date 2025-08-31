package net.rhyebread.deltatale.item.custom;

import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.AbstractHurtingProjectile;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.*;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.rhyebread.deltatale.item.ModItems;
import net.rhyebread.deltatale.sound.ModSounds;
import net.rhyebread.entity.custom.RudeBusterProjectileEntity;

public class RudeAxeItem extends AxeItem{
    public RudeAxeItem(Tier tier, int attackDamage, float attackSpeed, Item.Properties pProperties) {
        super(tier, attackDamage, attackSpeed, pProperties);
    }




    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand){
        ItemStack itemStack = pPlayer.getItemInHand(pUsedHand);

        pLevel.playSound(null, pPlayer.getX(), pPlayer.getY(), pPlayer.getZ(),
                ModSounds.RUDE_AXE_USE.get(), SoundSource.NEUTRAL, 1f, 1f / (pLevel.getRandom().nextFloat() * 0.4f + 0.8f));

        if (!pLevel.isClientSide()){
            RudeBusterProjectileEntity rude= new RudeBusterProjectileEntity(pPlayer, pLevel);
            rude.shootFromRotation(pPlayer, pPlayer.getXRot(), pPlayer.getYRot(), 0.0f, 1.5f, 0f);
            pLevel.addFreshEntity(rude);
        }
        return (InteractionResultHolder.sidedSuccess(itemStack, pLevel.isClientSide()));
    }
}
