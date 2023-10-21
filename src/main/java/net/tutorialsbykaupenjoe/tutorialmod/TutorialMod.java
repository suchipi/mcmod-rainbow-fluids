package net.tutorialsbykaupenjoe.tutorialmod;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(TutorialMod.MOD_ID)
public class TutorialMod {
  // The value here should match an entry in the META-INF/mods.toml file
  public static final String MOD_ID = "tutorialmod";
  private static final Logger LOGGER = LogManager.getLogger();

  public TutorialMod() {
    IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

    ModFluids.registerAll();

    ModRegistries.registerAll(eventBus);

    eventBus.addListener(this::clientSetup);

    MinecraftForge.EVENT_BUS.register(this);
  }

  private void clientSetup(final FMLClientSetupEvent event) {
    ModFluids.clientSetup(event);
  }
}
