package net.tutorialsbykaupenjoe.tutorialmod;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.item.BucketItem;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.FluidAttributes;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.fml.RegistryObject;

public class WaterLikeFluid {
  private static final ResourceLocation WATER_STILL_RL = new ResourceLocation("block/water_still");
  private static final ResourceLocation WATER_FLOWING_RL = new ResourceLocation("block/water_flow");
  private static final ResourceLocation WATER_OVERLAY_RL = new ResourceLocation("block/water_overlay");

  private ForgeFlowingFluid.Properties properties;
  public RegistryObject<ForgeFlowingFluid.Source> source;
  public RegistryObject<ForgeFlowingFluid.Flowing> flowing;
  public RegistryObject<FlowingFluidBlock> block;
  public RegistryObject<Item> bucketItem;

  public static WaterLikeFluid register(final String name, final int argbColor) {
    return new WaterLikeFluid(name, argbColor);
  }

  private WaterLikeFluid(final String name, final int argbColor) {

    final String sourceName = name + "_fluid";
    final String flowingName = name + "_flowing";
    final String bucketName = name + "_bucket";

    source = ModRegistries.FLUIDS.register(sourceName,
        () -> new ForgeFlowingFluid.Source(properties));
    flowing = ModRegistries.FLUIDS.register(flowingName,
        () -> new ForgeFlowingFluid.Flowing(properties));

    properties = new ForgeFlowingFluid.Properties(
        () -> source.get(),
        () -> flowing.get(),
        FluidAttributes
            .builder(WATER_STILL_RL, WATER_FLOWING_RL)
            .overlay(WATER_OVERLAY_RL)
            .color(argbColor))
        .block(() -> block.get())
        .bucket(() -> bucketItem.get());

    bucketItem = ModRegistries.ITEMS.register(bucketName,
        () -> new BucketItem(source,
            new Item.Properties().maxStackSize(1)));

    block = ModRegistries.BLOCKS.register(name,
        () -> new FlowingFluidBlock(() -> source.get(),
            AbstractBlock.Properties.create(Material.WATER)
                .doesNotBlockMovement()
                .hardnessAndResistance(100f)
                .noDrops()));
  }

  public void setRenderTranslucent() {
    RenderTypeLookup.setRenderLayer(source.get(), RenderType.getTranslucent());
    RenderTypeLookup.setRenderLayer(flowing.get(), RenderType.getTranslucent());
    RenderTypeLookup.setRenderLayer(block.get(), RenderType.getTranslucent());
  }
}
