package net.rhyebread.entity.custom;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraftforge.fml.common.Mod;
import net.rhyebread.deltatale.item.ModItems;
import net.rhyebread.deltatale.sound.ModSounds;
import net.rhyebread.entity.ModEntities;

public class DevilsKnifeProjectileEntity extends ThrowableItemProjectile {
    public DevilsKnifeProjectileEntity(EntityType<? extends ThrowableItemProjectile> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    @Override
    protected Item getDefaultItem() {
        return ModItems.SPADE.get();



    }

    public DevilsKnifeProjectileEntity(Level pLevel, LivingEntity shooter) {
        super(ModEntities.DEVILSKNIFE_PROJECTILE.get(), shooter, pLevel);
    }

    public DevilsKnifeProjectileEntity(Level pLevel) {
        super(ModEntities.DEVILSKNIFE_PROJECTILE.get(), pLevel);
    }


    @Override
    protected void onHitEntity(EntityHitResult pResult) {
        super.onHitEntity(pResult);
        Entity entity = pResult.getEntity();
        entity.hurt(this.damageSources().thrown(this, this.getOwner()), 10);
        this.playSound(ModSounds.HURT.get(), 1f, 1f);

        if (!this.level().isClientSide()){
            this.level().broadcastEntityEvent(this, (byte) 3);
            this.discard();
        }
    }

    @Override
    protected void onHitBlock(BlockHitResult pResult) {
        if(!this.level().isClientSide()){
            this.level().broadcastEntityEvent(this, (byte) 3);
            this.playSound(ModSounds.DEVILSKNIFE_USE.get(), 1f,.01f);
            this.discard();
        }
        super.onHitBlock(pResult);
    }

}
