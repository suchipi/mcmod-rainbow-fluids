package net.tutorialsbykaupenjoe.tutorialmod.item;

import net.minecraft.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.tutorialsbykaupenjoe.tutorialmod.TutorialMod;
import net.tutorialsbykaupenjoe.tutorialmod.fluid.ModFluids;

public class ModItems {

  public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, TutorialMod.MOD_ID);

  public static final RegistryObject<Item> SLUDGE_BUCKET = ITEMS.register("sludge_bucket",
      () -> new BucketItem(ModFluids.SLUDGE_FLUID,
          new Item.Properties().maxStackSize(1)));

  public static void register(IEventBus eventBus) {
    ITEMS.register(eventBus);
  }
}
