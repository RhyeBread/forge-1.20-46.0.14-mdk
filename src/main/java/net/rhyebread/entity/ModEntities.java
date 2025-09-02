package net.rhyebread.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.rhyebread.deltatale.DeltaTale;
import net.rhyebread.entity.custom.DevilsKnifeProjectileEntity;
import net.rhyebread.entity.custom.RudeBusterProjectileEntity;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, DeltaTale.MOD_ID);

    public static final RegistryObject<EntityType<RudeBusterProjectileEntity>> RUDE_BUSTER_PROJECTILE =
            ENTITY_TYPES.register("rude_axe_use", () -> EntityType.Builder.<RudeBusterProjectileEntity>of(RudeBusterProjectileEntity::new, MobCategory.MISC)
                    .sized(10f, 10f).build("rude_axe_use"));

    public static final RegistryObject<EntityType<DevilsKnifeProjectileEntity>> DEVILSKNIFE_PROJECTILE =
            ENTITY_TYPES.register("devilsknife", () -> EntityType.Builder.<DevilsKnifeProjectileEntity>of(DevilsKnifeProjectileEntity::new, MobCategory.MISC)
                    .sized(10f, 10f).build("devilsknife"));

    public static void register(IEventBus eventBus){
        ENTITY_TYPES.register(eventBus);
    }
}
