package net.tutorialsbykaupenjoe.tutorialmod;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

public class ModFluids {
  public static WaterLikeFluid SLUDGE;

  public static void registerAll() {
    SLUDGE = WaterLikeFluid.register("sludge", 0xFF80C71F);
  }

  public static void clientSetup(final FMLClientSetupEvent event) {
    event.enqueueWork(() -> {
      SLUDGE.setRenderTranslucent();
    });
  }
}
