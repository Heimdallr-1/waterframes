package me.srrapero720.waterframes.mixin.impl;

import me.srrapero720.waterframes.client.display.DisplayControl;
import net.minecraft.client.DeltaTracker;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(DeltaTracker.Timer.class)
public class DeltaTrackerTimerMixin {
    @Inject(method = "pause", at = @At("RETURN"))
    void pause(CallbackInfo ci) {
        DisplayControl.pause();
    }

    @Inject(method = "unPause", at = @At("RETURN"))
    void resume(CallbackInfo ci) {
        DisplayControl.resume();
    }
}
