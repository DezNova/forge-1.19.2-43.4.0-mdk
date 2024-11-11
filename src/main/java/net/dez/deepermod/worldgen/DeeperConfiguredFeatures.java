package net.dez.deepermod.worldgen;

import com.google.common.base.Suppliers;
import net.dez.deepermod.DeeperMod;
import net.dez.deepermod.block.ModBlocks;
import net.minecraft.core.Registry;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.WeightedPlacedFeature;
import net.minecraft.world.level.levelgen.feature.configurations.*;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.GiantTrunkPlacer;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;
import java.util.function.Supplier;

public class DeeperConfiguredFeatures {

    public static final DeferredRegister<ConfiguredFeature< ?, ?>> CONFIGURED_FEATURES =
        DeferredRegister.create(Registry.CONFIGURED_FEATURE_REGISTRY, DeeperMod.MOD_ID);

    public static final RegistryObject<ConfiguredFeature<?, ?>> HOLLOW_TREE =
            CONFIGURED_FEATURES.register("hollow_tree", () ->
                    new ConfiguredFeature<>(Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                            BlockStateProvider.simple(ModBlocks.HOLLOW_WOOD.get()),
                            new GiantTrunkPlacer(22,10,5), //first parameter seems to be height
                            BlockStateProvider.simple(Blocks.AIR),
                            new BlobFoliagePlacer(ConstantInt.of(0), ConstantInt.of(0), 4),
                            new TwoLayersFeatureSize(1,0,2)).dirt(BlockStateProvider.simple(ModBlocks.STILL_DIRT.get())).build()));


    public static final RegistryObject<ConfiguredFeature<?, ?>> HOLLOW_TREE_SPAWN =
            CONFIGURED_FEATURES.register("hollow_tree_spawn", () -> new ConfiguredFeature<>(Feature.RANDOM_SELECTOR,
                    new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(
                            DeeperPlacedFeature.HOLLOW_TREE_CHECKED.getHolder().get(),
                            0.5F)), DeeperPlacedFeature.HOLLOW_TREE_CHECKED.getHolder().get())));


    public static final Supplier<List<OreConfiguration.TargetBlockState>> TECTONIC_PARZANITE_ORES = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(new BlockMatchTest(ModBlocks.YELLOW_GRANITE.get()), ModBlocks.PARZANITE_ORE.get().defaultBlockState())
    ));

    // to replace stone it's OreFeatures.NATURAL_STONE
    public static final Supplier<List<OreConfiguration.TargetBlockState>> TECTONIC_DIAMOND_ORE = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(new BlockMatchTest(ModBlocks.YELLOW_GRANITE.get()), ModBlocks.YELLOW_GRANITE_DIAMOND_ORE.get().defaultBlockState())
    ));

    public static final RegistryObject<ConfiguredFeature<?,? >> PARZANITE_ORE_TECTONIC = CONFIGURED_FEATURES.register("parzanite_ore",
            () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(TECTONIC_PARZANITE_ORES.get(), 7)));

    public static final RegistryObject<ConfiguredFeature<?,? >> DIAMOND_ORE_TECTONIC = CONFIGURED_FEATURES.register("diamond_ore_tectonic",
            () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(TECTONIC_PARZANITE_ORES.get(), 3)));


    public static void register(IEventBus eventBus){
        CONFIGURED_FEATURES.register(eventBus);
    }
}
