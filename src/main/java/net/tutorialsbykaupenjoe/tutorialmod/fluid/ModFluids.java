package net.tutorialsbykaupenjoe.tutorialmod.fluid;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.block.material.Material;
import net.minecraft.fluid.FlowingFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.FluidAttributes;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.tutorialsbykaupenjoe.tutorialmod.TutorialMod;
import net.tutorialsbykaupenjoe.tutorialmod.block.ModBlocks;
import net.tutorialsbykaupenjoe.tutorialmod.item.ModItems;

public class ModFluids {
  public static final ResourceLocation WATER_STILL_RL = new ResourceLocation("block/water_still");
  public static final ResourceLocation WATER_FLOWING_RL = new ResourceLocation("block/water_flow");
  public static final ResourceLocation WATER_OVERLAY_RL = new ResourceLocation("block/water_overlay");

  public static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(ForgeRegistries.FLUIDS,
      TutorialMod.MOD_ID);

  public static final RegistryObject<FlowingFluid> SLUDGE_FLUID = FLUIDS.register("sludge_fluid",
      () -> new ForgeFlowingFluid.Source(ModFluids.SLUDGE_PROPERTIES));

  public static final RegistryObject<FlowingFluid> SLUDGE_FLOWING = FLUIDS.register("sludge_flowing",
      () -> new ForgeFlowingFluid.Flowing(ModFluids.SLUDGE_PROPERTIES));

  public static final ForgeFlowingFluid.Properties SLUDGE_PROPERTIES = new ForgeFlowingFluid.Properties(
      () -> SLUDGE_FLUID.get(), () -> SLUDGE_FLOWING.get(),
      FluidAttributes.builder(WATER_STILL_RL, WATER_FLOWING_RL).overlay(WATER_OVERLAY_RL)
          .color(0xFF80C71F))
      .block(() -> ModFluids.SLUDGE_BLOCK.get()).bucket(() -> ModItems.SLUDGE_BUCKET.get());

  public static final RegistryObject<FlowingFluidBlock> SLUDGE_BLOCK = ModBlocks.BLOCKS.register("sludge",
      () -> new FlowingFluidBlock(() -> ModFluids.SLUDGE_FLUID.get(),
          AbstractBlock.Properties.create(Material.WATER)
              .doesNotBlockMovement().hardnessAndResistance(100f).noDrops()));

  public static void register(IEventBus eventBus) {
    FLUIDS.register(eventBus);
  }
}
