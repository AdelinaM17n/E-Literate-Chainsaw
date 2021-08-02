package io.github.maheevil.echainsaw.mixin;

import io.github.maheevil.echainsaw.EChainsawMod;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.BlazeEntity;
import net.minecraft.entity.projectile.AbstractFireballEntity;
import net.minecraft.entity.projectile.SmallFireballEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(SmallFireballEntity.class)
public class SmallFireballEntityMixin extends AbstractFireballEntity {


    public SmallFireballEntityMixin(EntityType<? extends AbstractFireballEntity> entityType, World world) {
        super(entityType, world);
    }

    @Redirect(
            method = "onBlockHit",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/world/GameRules;getBoolean(Lnet/minecraft/world/GameRules$Key;)Z", ordinal = 0)
    )
    private boolean redirectMobGriefing(GameRules gameRules, GameRules.Key<GameRules.BooleanRule> rule){
        if(!this.world.getGameRules().getBoolean(EChainsawMod.HOSTILE_MOB_BLOCK_DAMAGE))
            return false;
        else
            return this.world.getGameRules().getBoolean(GameRules.DO_MOB_GRIEFING);
    }
    /*private BlockPos blockPos(BlockPos blockPos){
        if(this.getOwner() instanceof BlazeEntity
                && !this.world.getGameRules().getBoolean(EChainsawMod.BLAZE_MOB_GRIEFING))
            return blockPos.withY(258);
        return blockPos;
    }*/
}
