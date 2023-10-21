package net.tutorialsbykaupenjoe.tutorialmod;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

public class ModFluids {
  public static WaterLikeFluid MILK_2;
  public static WaterLikeFluid CEMENT;
  public static WaterLikeFluid GOOP;
  public static WaterLikeFluid TAR; // tar
  public static WaterLikeFluid MUDDY_WATER;
  public static WaterLikeFluid BLOOD;
  public static WaterLikeFluid SUNNY_C;
  public static WaterLikeFluid PISS;
  public static WaterLikeFluid SLUDGE;
  public static WaterLikeFluid MOTOROYLE;
  public static WaterLikeFluid SLURPEE;
  public static WaterLikeFluid ABABABABABABA;
  public static WaterLikeFluid LIQUID_ICE;
  public static WaterLikeFluid LEAN;
  public static WaterLikeFluid PRINTER_INK;
  public static WaterLikeFluid ANTIFREEZE;

  public static void registerAll() {
    MILK_2 = WaterLikeFluid.register("milk_2", 0xFFF9FFFE);
    CEMENT = WaterLikeFluid.register("cement", 0xFF9D9D97);
    GOOP = WaterLikeFluid.register("goop", 0xFF474F52);
    TAR = WaterLikeFluid.register("tar", 0xFF1D1D21);
    MUDDY_WATER = WaterLikeFluid.register("muddy_water", 0xFF835432);
    BLOOD = WaterLikeFluid.register("blood", 0xFFB02E26);
    SUNNY_C = WaterLikeFluid.register("sunny_c", 0XFFFFAC2E);
    PISS = WaterLikeFluid.register("piss", 0xFFFED83D);
    SLUDGE = WaterLikeFluid.register("sludge", 0XFFB5FA56);
    MOTOROYLE = WaterLikeFluid.register("motoroyle", 0xFF80C71F);
    SLURPEE = WaterLikeFluid.register("slurpee", 0xFF169C9C);
    ABABABABABABA = WaterLikeFluid.register("ababababababa", 0xFF3AB3DA);
    LIQUID_ICE = WaterLikeFluid.register("liquid_ice", 0xFF3C44AA);
    LEAN = WaterLikeFluid.register("lean", 0xFF8932B8);
    PRINTER_INK = WaterLikeFluid.register("printer_ink", 0xFFC74EBD);
    ANTIFREEZE = WaterLikeFluid.register("antifreeze", 0xFFF38BAA);
  }

  public static void clientSetup(final FMLClientSetupEvent event) {
    event.enqueueWork(() -> {
      // We decided some of these look nicer opaque

      // MILK_2.setRenderTranslucent();
      // CEMENT.setRenderTranslucent();
      GOOP.setRenderTranslucent();
      // TAR.setRenderTranslucent();
      MUDDY_WATER.setRenderTranslucent();
      BLOOD.setRenderTranslucent();
      // SUNNY_C.setRenderTranslucent();
      PISS.setRenderTranslucent();
      // SLUDGE.setRenderTranslucent();
      MOTOROYLE.setRenderTranslucent();
      SLURPEE.setRenderTranslucent();
      ABABABABABABA.setRenderTranslucent();
      LIQUID_ICE.setRenderTranslucent();
      LEAN.setRenderTranslucent();
      // PRINTER_INK.setRenderTranslucent();
      ANTIFREEZE.setRenderTranslucent();
    });
  }
}
