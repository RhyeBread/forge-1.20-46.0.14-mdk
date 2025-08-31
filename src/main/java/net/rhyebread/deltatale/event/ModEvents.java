package net.rhyebread.deltatale.event;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.ItemStackedOnOtherEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.rhyebread.deltatale.DeltaTale;
import net.rhyebread.deltatale.item.ModItems;
import net.rhyebread.deltatale.item.custom.WeirdRouteItem;
import net.rhyebread.deltatale.sound.ModSounds;
import net.rhyebread.deltatale.util.ModTags;
import net.rhyebread.deltatale.util.ModTags.Entities;
import net.rhyebread.deltatale.weirdroute.PlayerWeirdness;
import net.rhyebread.deltatale.weirdroute.PlayerWeirdnessProvider;

import static net.rhyebread.deltatale.weirdroute.PlayerWeirdnessProvider.PLAYER_WEIRDNESS;

@Mod.EventBusSubscriber(modid = DeltaTale.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ModEvents {

    @SubscribeEvent
    public static void weirdRouteKill(LivingDeathEvent event){

        if (event.getEntity().getType().is(Entities.WEIRDER_ROUTE) &&
                event.getSource().getEntity() instanceof Player player){
            if (player.getMainHandItem().is(ModTags.Items.WEAPON_INCREASE_WEIRDNESS)){
                player.getCapability(PLAYER_WEIRDNESS).ifPresent(playerWeirdness -> {
                    playerWeirdness.addWeirdness(2);
                    if(playerWeirdness.getWeirdness() == 2){
                        player.playNotifySound(ModSounds.WEIRD_ROUTE_START.get(), SoundSource.HOSTILE,1f,1f);
                    }
                    if(!playerWeirdness.isWeirder()){
                        player.playNotifySound(ModSounds.WEIRD_ROUTE_WORSEN.get(), SoundSource.HOSTILE,1f,1f);
                    }
                });
            }
        }

    }

    @SubscribeEvent
    public static void onAttachCapabilitiesPlayer(AttachCapabilitiesEvent<Entity> event){
        if(event.getObject() instanceof Player){
            if(!event.getObject().getCapability(PLAYER_WEIRDNESS).isPresent()){
                event.addCapability(new ResourceLocation(DeltaTale.MOD_ID,"properties"), new PlayerWeirdnessProvider());
            }
        }
    }

    @SubscribeEvent
    public static void weirdRouteCancel(PlayerInteractEvent.RightClickItem playerInteractEvent){
        if (playerInteractEvent.getItemStack().getItem() == ModItems.DELTARUNE.get()){
            playerInteractEvent.getEntity().playSound(ModSounds.WEIRD_ROUTE_CANCEL.get());
            playerInteractEvent.getItemStack().shrink(1);
            playerInteractEvent.getEntity().getCapability(PLAYER_WEIRDNESS).ifPresent(PlayerWeirdness::bailWeird);

        }
    }


}
