package io.github.maheevil.echainsaw.mixin;

import io.github.maheevil.echainsaw.EChainsawMod;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.mob.EvokerEntity;
import net.minecraft.entity.mob.IllagerEntity;
import net.minecraft.entity.mob.SpellcastingIllagerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.Packet;
import net.minecraft.sound.SoundEvent;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(EvokerEntity.WololoGoal.class)
public class WololoGoalMixin {

    @Final
    @Shadow(aliases = "field_7268")
    private EvokerEntity field_7268;
            //field_7268
    @Inject(
            method = "canStart",
            at = @At("RETURN"),
            cancellable = true
    )
    public void canStart(CallbackInfoReturnable<Boolean> cir){
        if(!field_7268.world.getGameRules().getBoolean(EChainsawMod.EVOKER_MOB_GRIEFING))
            cir.setReturnValue(false);
    }

}
