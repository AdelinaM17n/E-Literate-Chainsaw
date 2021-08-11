package io.github.maheevil.echainsaw.mixin;

import io.github.maheevil.echainsaw.EChainsawMod;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.Packet;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(LivingEntity.class)
public class LivingEntityMixin extends Entity {
    public LivingEntityMixin(EntityType<?> type, World world) {
        super(type, world);
    }

    @Redirect(
            method = "onKilledBy",
            at = @At(value = "INVOKE", target = "net/minecraft/world/GameRules.getBoolean(Lnet/minecraft/world/GameRules$Key;)Z", ordinal = 0)
    )
    public boolean redirectMobGriefing(GameRules gameRules, GameRules.Key<GameRules.BooleanRule> rule){
        if(!gameRules.getBoolean(EChainsawMod.WITHER_MOB_DAMAGE))
            return false;
        return gameRules.getBoolean(GameRules.DO_MOB_GRIEFING);
    }

    @Shadow
    protected void initDataTracker() {

    }

    @Shadow
    public void readCustomDataFromNbt(NbtCompound nbt) {

    }

    @Shadow
    public void writeCustomDataToNbt(NbtCompound nbt) {

    }

    @Shadow
    public Packet<?> createSpawnPacket() {
        return null;
    }
}
