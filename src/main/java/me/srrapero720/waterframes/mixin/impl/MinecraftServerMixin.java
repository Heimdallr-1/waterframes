package me.srrapero720.waterframes.mixin.impl;

import me.srrapero720.waterframes.common.block.entity.DisplayTile;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.TimeUtil;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

import java.util.concurrent.TimeUnit;

@Mixin(MinecraftServer.class)
public class MinecraftServerMixin {
    @Inject(method = "runServer", at = @At(value = "FIELD", target = "Lnet/minecraft/server/MinecraftServer;nextTickTimeNanos:J", ordinal = 3, opcode = Opcodes.PUTFIELD), locals = LocalCapture.CAPTURE_FAILHARD)
    public void inject$runServer(CallbackInfo ci, long time) {
        long timeMillis = TimeUnit.NANOSECONDS.toMillis(time);
        if (timeMillis > 1000L) {
            DisplayTile.setLagTickTime(timeMillis);
        }
    }
}
