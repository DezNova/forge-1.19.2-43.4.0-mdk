package net.dez.deepermod.worldgen;

import net.dez.deepermod.DeeperMod;
import net.dez.deepermod.block.ModBlocks;
import net.minecraft.client.Minecraft;
import net.minecraft.core.Registry;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.GiantTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.MegaJungleTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class DeeperConfiguredFeatures {

    public static final DeferredRegister<ConfiguredFeature< ?, ?>> CONFIGURED_FEATURES =
        DeferredRegister.create(Registry.CONFIGURED_FEATURE_REGISTRY, DeeperMod.MOD_ID);

    public static final RegistryObject<ConfiguredFeature<?, ?>> HOLLOW_TREE =
            CONFIGURED_FEATURES.register("hollow_tree", () ->
                    new ConfiguredFeature<>(Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                            BlockStateProvider.simple(ModBlocks.HOLLOW_WOOD.get()),
                            new GiantTrunkPlacer(40,6,3), //first parameter seems to be height
                            BlockStateProvider.simple(Blocks.AIR),
                            new BlobFoliagePlacer(ConstantInt.of(0), ConstantInt.of(0), 4),
                            new TwoLayersFeatureSize(1,0,2)).build()));

    public static void register(IEventBus eventBus){
        CONFIGURED_FEATURES.register(eventBus);
    }
}
