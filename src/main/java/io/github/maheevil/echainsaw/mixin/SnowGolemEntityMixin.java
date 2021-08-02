package io.github.maheevil.echainsaw.mixin;

import io.github.maheevil.echainsaw.EChainsawMod;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.GolemEntity;
import net.minecraft.entity.passive.SnowGolemEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(SnowGolemEntity.class)
public class SnowGolemEntityMixin extends GolemEntity {
    protected SnowGolemEntityMixin(EntityType<? extends GolemEntity> entityType, World world) {
        super(entityType, world);
    }

    @ModifyVariable(
            method = "tickMovement",
            at = @At("STORE"),
            ordinal = 0
    )
    public BlockPos blockPos(BlockPos blockPos){
        if(!this.world.getGameRules().getBoolean(EChainsawMod.SNOW_GOLEM_MOB_GRIEFING))
            return blockPos.withY(277);
        return blockPos;
    }
}
