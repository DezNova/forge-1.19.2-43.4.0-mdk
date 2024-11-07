package net.dez.deepermod.worldgen;

import net.dez.deepermod.DeeperMod;
import net.dez.deepermod.block.ModBlocks;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

public class DeeperPlacedFeature {


    public static  final DeferredRegister<PlacedFeature> PLACED_FEATURES =
            DeferredRegister.create(Registry.PLACED_FEATURE_REGISTRY, DeeperMod.MOD_ID);

    public static final RegistryObject<PlacedFeature> HOLLOW_TREE_CHECKED = PLACED_FEATURES.register("hollow_tree_checked",
            () -> new PlacedFeature(DeeperConfiguredFeatures.HOLLOW_TREE.getHolder().get(),
                    List.of(PlacementUtils.filteredByBlockSurvival(ModBlocks.HOLLOW_SAPLING.get()))));


    public static final RegistryObject<PlacedFeature> HOLLOW_TREE_PLACED = PLACED_FEATURES.register("hollow_tree_placed",
            () -> new PlacedFeature(DeeperConfiguredFeatures.HOLLOW_TREE_SPAWN.getHolder().get(), List.of(
                    //CountOnEveryLayerPlacement.of(4),
                    CountPlacement.of(10),
                    InSquarePlacement.spread(),
                    //HeightmapPlacement.onHeightmap(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES),
                    HeightRangePlacement.triangle(VerticalAnchor.absolute(60), VerticalAnchor.absolute(84)),
                    PlacementUtils.countExtra(8, 0.5f, 4),
                    BiomeFilter.biome()
            )));

    public static void register(IEventBus eventBus){
        PLACED_FEATURES.register(eventBus);
    }


    public static final RegistryObject<PlacedFeature> TEST_DIAMOND_BLOCK_PLACED =
            PLACED_FEATURES.register("test_diamond_block_placed",
                    () -> new PlacedFeature(DeeperConfiguredFeatures.TEST_DIAMOND_BLOCK.getHolder().get(),
                            List.of(
                                    InSquarePlacement.spread(),
                                    HeightRangePlacement.uniform(VerticalAnchor.absolute(30), VerticalAnchor.absolute(90)), // Adjust Y-level as needed
                                    BiomeFilter.biome()
                            )));

}
