package io.github.maheevil.echainsaw.mixin;

import io.github.maheevil.echainsaw.EChainsawMod;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.projectile.AbstractFireballEntity;
import net.minecraft.entity.projectile.FireballEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(FireballEntity.class)
public class FireballEntityMixin extends AbstractFireballEntity {

    public FireballEntityMixin(EntityType<? extends AbstractFireballEntity> entityType, World world) {
        super(entityType, world);
    }

    @ModifyVariable(
            method = "onCollision",
            at = @At("STORE"),
            ordinal = 0
    )
    private boolean bl(boolean bl){
        if(!this.world.getGameRules().getBoolean(EChainsawMod.HOSTILE_MOB_BLOCK_DAMAGE))
            return false;
        return bl;

    }
}
