package io.github.maheevil.echainsaw.mixin;

import io.github.maheevil.echainsaw.EChainsawMod;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.AbstractPiglinEntity;
import net.minecraft.entity.mob.PiglinActivity;
import net.minecraft.entity.mob.PiglinEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PiglinEntity.class)
public class PiglinEntityMixin extends AbstractPiglinEntity {
    public PiglinEntityMixin(EntityType<? extends AbstractPiglinEntity> entityType, World world) {
        super(entityType, world);
    }

    @Inject(
            method = "canGather",
            at = @At("RETURN"),
            cancellable = true
    )
    public void canGather(ItemStack stack, CallbackInfoReturnable<Boolean> cir){
        if(!this.world.getGameRules().getBoolean(EChainsawMod.PIGLIN_ITEM_PICKUP))
            cir.setReturnValue(false);
    }

    @Shadow
    protected boolean canHunt() {
        return false;
    }

    @Shadow
    public PiglinActivity getActivity() {
        return null;
    }

    @Shadow
    protected void playZombificationSound() {

    }
}
