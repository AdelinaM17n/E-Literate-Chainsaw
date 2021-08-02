package io.github.maheevil.echainsaw.mixin;

import io.github.maheevil.echainsaw.EChainsawMod;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.boss.WitherEntity;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.tag.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.Difficulty;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;
import net.minecraft.world.WorldEvents;
import net.minecraft.world.explosion.Explosion;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.List;

@Mixin(WitherEntity.class)
public class WitherMixin extends HostileEntity {

    @Shadow private int blockBreakingCooldown;

    protected WitherMixin(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
    }

    @Redirect(
            method = "mobTick",
            at = @At(value = "INVOKE",target = "Lnet/minecraft/world/GameRules;getBoolean(Lnet/minecraft/world/GameRules$Key;)Z", ordinal = 1)
    )
    private boolean redirectMobGriefing(GameRules gameRules, GameRules.Key<GameRules.BooleanRule> rule){
        if(!this.world.getGameRules().getBoolean(EChainsawMod.WITHER_MOB_DAMAGE))
            return false;
        else
            return this.world.getGameRules().getBoolean(GameRules.DO_MOB_GRIEFING);
    }


    @ModifyVariable(
            method = "mobTick",
            at = @At(value = "STORE"),
            //name = "destructionType"
            ordinal = 0
    )
    private Explosion.DestructionType destructionType(Explosion.DestructionType destructionType){
        if(!this.world.getGameRules().getBoolean(EChainsawMod.WITHER_MOB_DAMAGE))
            return Explosion.DestructionType.NONE;
        return destructionType;
    }
}
