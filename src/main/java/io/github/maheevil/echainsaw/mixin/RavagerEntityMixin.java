package io.github.maheevil.echainsaw.mixin;

import io.github.maheevil.echainsaw.EChainsawMod;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.RavagerEntity;
import net.minecraft.entity.raid.RaiderEntity;
import net.minecraft.sound.SoundEvent;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(RavagerEntity.class)
public class RavagerEntityMixin extends RaiderEntity {
    protected RavagerEntityMixin(EntityType<? extends RaiderEntity> entityType, World world) {
        super(entityType, world);
    }

    @ModifyVariable(
            method = "tickMovement",
            at = @At("STORE"),
            ordinal = 0
    )
    private BlockState blockState(BlockState blockState){
        if(!this.world.getGameRules().getBoolean(EChainsawMod.RAVAGER_MOB_GRIEFING))
            return Blocks.BEDROCK.getDefaultState();
        return blockState;
    }

    @Shadow
    public void addBonusForWave(int wave, boolean unused) {

    }

    @Shadow
    public SoundEvent getCelebratingSound() {
        return null;
    }
}
