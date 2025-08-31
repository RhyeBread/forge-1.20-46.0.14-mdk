package net.rhyebread.entity.custom;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.Vec2;
import net.rhyebread.deltatale.item.ModItems;
import net.rhyebread.deltatale.sound.ModSounds;
import net.rhyebread.entity.ModEntities;
import org.jetbrains.annotations.NotNull;

public class RudeBusterProjectileEntity extends ThrowableItemProjectile {
    private float rotation;
    public Vec2 groundedOffset;

    public RudeBusterProjectileEntity(EntityType<? extends ThrowableItemProjectile> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    @Override
    protected Item getDefaultItem() {
        return ModItems.RUDE_BUSTER_USE.get();
    }

    public RudeBusterProjectileEntity(Level level){
        super(ModEntities.RUDE_BUSTER_PROJECTILE.get(), level);
    }

    public RudeBusterProjectileEntity(Level level, LivingEntity shooter){
        super(ModEntities.RUDE_BUSTER_PROJECTILE.get(), shooter, level);
    }

    @Override
    protected void onHitEntity(EntityHitResult pResult) {
        super.onHitEntity(pResult);
        Entity entity = pResult.getEntity();
        entity.hurt(this.damageSources().thrown(this, this.getOwner()), 10);
        this.playSound(ModSounds.RUDE_AXE_HIT.get(), 1f, 1f);

        if (!this.level().isClientSide()){
            this.level().broadcastEntityEvent(this, (byte) 3);
            this.discard();
        }
    }

    @Override
    protected void onHitBlock(BlockHitResult pResult) {
        if(!this.level().isClientSide()){
            this.level().broadcastEntityEvent(this, (byte) 3);
            this.playSound(ModSounds.RUDE_AXE_HIT.get(), 1f, 1f);
            this.discard();
        }
        super.onHitBlock(pResult);
    }

}