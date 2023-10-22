package com.suchipi.rainbowfluids;

import net.minecraft.block.Block;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModRegistries {
  public static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(ForgeRegistries.FLUIDS,
      RainbowFluidsMod.MOD_ID);

  public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS,
      RainbowFluidsMod.MOD_ID);

  public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS,
      RainbowFluidsMod.MOD_ID);

  public static void registerAll(IEventBus eventBus) {
    FLUIDS.register(eventBus);
    ITEMS.register(eventBus);
    BLOCKS.register(eventBus);
  }
}
