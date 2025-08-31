package net.rhyebread.deltatale.weirdroute;

import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.common.util.LazyOptional;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class PlayerWeirdnessProvider implements ICapabilityProvider, INBTSerializable<CompoundTag> {

    public static Capability<PlayerWeirdness> PLAYER_WEIRDNESS = CapabilityManager.get(new CapabilityToken<PlayerWeirdness>() {});

    private PlayerWeirdness weirdness = null;
    private final LazyOptional<PlayerWeirdness> optional = LazyOptional.of(this::createPlayerWeirdness);

    private PlayerWeirdness createPlayerWeirdness(){
        if(this.weirdness == null){
            this.weirdness = new PlayerWeirdness();
        }

        return this.weirdness;
    }

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if(cap==PLAYER_WEIRDNESS){
            return optional.cast();
        }

        return LazyOptional.empty();
    }

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag nbt = new CompoundTag();
        createPlayerWeirdness().saveNBTData(nbt);
        return nbt;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        createPlayerWeirdness().loadNBTData(nbt);

    }
}
