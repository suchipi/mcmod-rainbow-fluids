package net.tutorialsbykaupenjoe.tutorialmod;

import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.tutorialsbykaupenjoe.tutorialmod.block.ModBlocks;
import net.tutorialsbykaupenjoe.tutorialmod.fluid.ModFluids;
import net.tutorialsbykaupenjoe.tutorialmod.item.ModItems;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(TutorialMod.MOD_ID)
public class TutorialMod {
  public static final String MOD_ID = "tutorialmod";

  private static final Logger LOGGER = LogManager.getLogger();

  public TutorialMod() {
    IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

    ModItems.register(eventBus);
    ModBlocks.register(eventBus);
    ModFluids.register(eventBus);

    eventBus.addListener(this::clientSetup);

    MinecraftForge.EVENT_BUS.register(this);
  }

  private void clientSetup(final FMLClientSetupEvent event) {
    event.enqueueWork(() -> {
      RenderTypeLookup.setRenderLayer(ModFluids.SLUDGE_FLUID.get(), RenderType.getTranslucent());
      RenderTypeLookup.setRenderLayer(ModFluids.SLUDGE_BLOCK.get(), RenderType.getTranslucent());
      RenderTypeLookup.setRenderLayer(ModFluids.SLUDGE_FLOWING.get(), RenderType.getTranslucent());
    });
  }
}
