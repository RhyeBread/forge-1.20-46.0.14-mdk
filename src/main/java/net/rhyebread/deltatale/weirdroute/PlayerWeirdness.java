package net.rhyebread.deltatale.weirdroute;

import net.minecraft.nbt.CompoundTag;

public class PlayerWeirdness {
    private int weirdness;
    private final int MIN_WEIRDNESS = 0;
    private final int MAX_WEIRDNESS = 12;

    public int getWeirdness(){
        return weirdness;
    }

    public void addWeirdness(int add){
        this.weirdness = Math.min(weirdness + add, MAX_WEIRDNESS);
    }

    public void bailWeird(){
        this.weirdness = MIN_WEIRDNESS;
    }

    public void copyFrom(PlayerWeirdness source){
        this.weirdness = source.weirdness;
    }

    public boolean isWeirder(){
        return weirdness != 10;
    }

    public void saveNBTData(CompoundTag nbt){
        nbt.putInt("weirdness",weirdness);
    }

    public void loadNBTData(CompoundTag nbt){
        weirdness = nbt.getInt("weirdness");
    }


}
