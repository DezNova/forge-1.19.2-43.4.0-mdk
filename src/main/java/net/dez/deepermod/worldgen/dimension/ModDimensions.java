package net.dez.deepermod.worldgen.dimension;

import net.dez.deepermod.DeeperMod;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.dimension.LevelStem;
import net.minecraftforge.eventbus.api.IEventBus;
//import net.minecraft.data.worldgen.BootstapContext;

public class ModDimensions {

   // public static final ResourceKey<LevelStem> TECTONIC_KEY = ResourceKey.create(Registry.LEVEL_STEM_REGISTRY,
   //         new ResourceLocation(DeeperMod.MOD_ID, "tectonic"));

    //public static final ResourceKey<Level> TECTONIC_LEVEL_KEY = ResourceKey.create(Registry.DIMENSION_REGISTRY,
    //        new ResourceLocation(DeeperMod.MOD_ID, "tectonic"));

    //new one for other dimension

    //public static final ResourceKey<DimensionType> TECTONIC_DIMENSION_TYPE = ResourceKey.create(Registry.DIMENSION_TYPE_REGISTRY,
//
    //public static void bootstrapType(BootstapContext<DimensionType> context) {

    //}

    public static final ResourceKey<Level> TECTONIC_LEVEL_KEY = ResourceKey.create(Registry.DIMENSION_REGISTRY,
            new ResourceLocation(DeeperMod.MOD_ID, "tectonic"));

    public static final ResourceKey<DimensionType> TECTONIC_DIMENSION_TYPE = ResourceKey.create(Registry.DIMENSION_TYPE_REGISTRY,
            new ResourceLocation(DeeperMod.MOD_ID, "tectonic"));

    public static final ResourceKey<LevelStem> TECTONIC_KEY = ResourceKey.create(Registry.LEVEL_STEM_REGISTRY,
            new ResourceLocation(DeeperMod.MOD_ID, "tectonic"));

}
