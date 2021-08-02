package io.github.maheevil.echainsaw.mixin;

import io.github.maheevil.echainsaw.EChainsawMod;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.boss.dragon.EnderDragonEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(EnderDragonEntity.class)
public class EnderDragonMixin extends MobEntity {

    protected EnderDragonMixin(EntityType<? extends MobEntity> entityType, World world) {
        super(entityType, world);
    }

    //10
    @Redirect(
            method = "destroyBlocks",
            at = @At(value = "INVOKE",target = "Lnet/minecraft/world/GameRules;getBoolean(Lnet/minecraft/world/GameRules$Key;)Z", ordinal = 0)
            //name = "blockState"
            //ordinal = 0
    )
    private boolean redirectMobGriefing(GameRules gameRules, GameRules.Key<GameRules.BooleanRule> rule){
        if(!this.world.getGameRules().getBoolean(EChainsawMod.ENDERDRAGON_MOB_GRIEFING))
            return false;
        else
            return this.world.getGameRules().getBoolean(GameRules.DO_MOB_GRIEFING);
    }
}
