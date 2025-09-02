package net.rhyebread.deltatale.sound;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.*;
import net.rhyebread.deltatale.DeltaTale;

public class ModSounds {

    private static SoundEvent registerSound(String soundName){
        final ResourceLocation soundID = new ResourceLocation(DeltaTale.MOD_ID, soundName);
        return SoundEvent.createVariableRangeEvent(soundID);
    }



    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, DeltaTale.MOD_ID);

    public static final RegistryObject<SoundEvent> RUDE_AXE_HIT = registerSoundEvents("rude_axe_hit");
    public static final RegistryObject<SoundEvent> RUDE_AXE_USE = registerSoundEvents("rude_axe_use");
    public static final RegistryObject<SoundEvent> DEVILSKNIFE_USE = registerSoundEvents("devils_knife");
    public static final RegistryObject<SoundEvent> HURT = registerSoundEvents("hurts");

    public static final RegistryObject<SoundEvent> CAVE_SOUND_1 = registerSoundEvents("cave_sound_1");
    public static final RegistryObject<SoundEvent> CAVE_SOUND_2 = registerSoundEvents("cave_sound_2");
    public static final RegistryObject<SoundEvent> CAVE_SOUND_3 = registerSoundEvents("cave_sound_3");
    public static final RegistryObject<SoundEvent> CAVE_SOUND_4 = registerSoundEvents("cave_sound_4");
    public static final RegistryObject<SoundEvent> CAVE_SOUND_5 = registerSoundEvents("cave_sound_5");

    public static final RegistryObject<SoundEvent> WEIRD_ROUTE_START = registerSoundEvents("weird_route_start");
    public static final RegistryObject<SoundEvent> WEIRD_ROUTE_CANCEL = registerSoundEvents("weird_route_cancel");
    public static final RegistryObject<SoundEvent> WEIRD_ROUTE_WORSEN = registerSoundEvents("weird_route_worsen");
    public static final RegistryObject<SoundEvent> WEIRD_ROUTE_CAVE_SOUND = registerSoundEvents("weird_route_cave_sound");
    public static final RegistryObject<SoundEvent> WEIRD_ROUTE_DAMAGE = registerSoundEvents("weird_route_damage");

    public static final RegistryObject<SoundEvent> FIGHTING_WITHER = registerSoundEvents("wither_boss_music");
    public static final RegistryObject<SoundEvent> FIGHTING_ENEMIES = registerSoundEvents("fight_music");
    public static final RegistryObject<SoundEvent> FIGHTING_ENEMIES_UNDER_HALF = registerSoundEvents("fight_low_health_music");
    public static final RegistryObject<SoundEvent> FIGHTING_DRAGON = registerSoundEvents("dragon_boss_music");
    public static final RegistryObject<SoundEvent> FIGHTING_WARDEN = registerSoundEvents("warden_boss_music");

    public static final RegistryObject<SoundEvent> BIOME_MUSIC_SOULSAND_VALLEY = registerSoundEvents("soulsand_valley_biome_music");
    public static final RegistryObject<SoundEvent> BIOME_MUSIC_SNOW = registerSoundEvents("snow_biome_music");
    public static final RegistryObject<SoundEvent> BIOME_MUSIC_MOUNTAIN = registerSoundEvents("mountains_biome_music");
    public static final RegistryObject<SoundEvent> BIOME_MUSIC_BASALT_DELTAS = registerSoundEvents("basalt_deltas_biome_music");
    public static final RegistryObject<SoundEvent> BIOME_MUSIC_PLAINS = registerSoundEvents("plains_biome_music");



    private static RegistryObject<SoundEvent> registerSoundEvents(String name) {
        return SOUND_EVENTS.register(name, () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(DeltaTale.MOD_ID, name)));
    }


    public static void register(IEventBus eventBus){
        SOUND_EVENTS.register(eventBus);
    }
}