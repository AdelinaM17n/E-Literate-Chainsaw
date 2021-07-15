package io.github.maheevil.echainsaw.mixin;

import io.github.maheevil.echainsaw.EChainsawMod;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.boss.dragon.EnderDragonEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(EnderDragonEntity.class)
public class EnderDragonMixin extends MobEntity {

    protected EnderDragonMixin(EntityType<? extends MobEntity> entityType, World world) {
        super(entityType, world);
    }

    //10
    @ModifyVariable(
            method = "destroyBlocks",
            at = @At("STORE"),
            name = "blockState"
    )
    private BlockState blockState(BlockState blockState){
        if(!this.world.getGameRules().getBoolean(EChainsawMod.ENDERDRAGON_MOB_GRIEFING))
            return Blocks.AIR.getDefaultState();
        return blockState;
    }
}
