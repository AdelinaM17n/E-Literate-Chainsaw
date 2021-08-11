package io.github.maheevil.echainsaw.mixin;

import io.github.maheevil.echainsaw.EChainsawMod;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.GolemEntity;
import net.minecraft.entity.passive.SnowGolemEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(SnowGolemEntity.class)
public class SnowGolemEntityMixin extends GolemEntity {
    protected SnowGolemEntityMixin(EntityType<? extends GolemEntity> entityType, World world) {
        super(entityType, world);
    }

    @Redirect(
            method = "tickMovement",
            at = @At(value = "INVOKE",target = "Lnet/minecraft/world/GameRules;getBoolean(Lnet/minecraft/world/GameRules$Key;)Z",ordinal = 0)
    )
    private boolean redirectMobGriefing(GameRules gameRules, GameRules.Key<GameRules.BooleanRule> rule){
        if(!this.world.getGameRules().getBoolean(EChainsawMod.PASSIVE_MOB_GRIEFING))
            return false;
        else
            return this.world.getGameRules().getBoolean(GameRules.DO_MOB_GRIEFING);
    }
    /*public BlockPos blockPos(BlockPos blockPos){
        if(!this.world.getGameRules().getBoolean(EChainsawMod.SNOW_GOLEM_MOB_GRIEFING))
            return blockPos.withY(277);
        return blockPos;
    }*/
}
