package net.rhyebread.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.client.event.RenderHighlightEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.rhyebread.deltatale.DeltaTale;
import net.rhyebread.entity.custom.RudeBusterProjectileEntity;

import javax.swing.*;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, DeltaTale.MOD_ID);

    public static final RegistryObject<EntityType<RudeBusterProjectileEntity>> RUDE_BUSTER_PROJECTILE =
            ENTITY_TYPES.register("rude_buster_use", () -> EntityType.Builder.<RudeBusterProjectileEntity>of(RudeBusterProjectileEntity::new, MobCategory.MISC)
                    .sized(2.5f, 2.5f).build("rude_buster_use"));

    public static void register(IEventBus eventBus){
        ENTITY_TYPES.register(eventBus);
    }
}
