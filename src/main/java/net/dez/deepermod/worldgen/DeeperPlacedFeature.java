package net.dez.deepermod.worldgen;

import net.dez.deepermod.DeeperMod;
import net.dez.deepermod.block.ModBlocks;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.placement.OrePlacements;
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
                    //CountOnEveryLayerPlacement.of(10),
                    CountPlacement.of(100),
                    InSquarePlacement.spread(),
                    HeightmapPlacement.onHeightmap(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES),
                    HeightRangePlacement.uniform(VerticalAnchor.absolute(60), VerticalAnchor.absolute(85)),
                    //PlacementUtils.FULL_RANGE,
                    //PlacementUtils.countExtra(20, 1, 6),
                    BiomeFilter.biome()
            )));


    public static final RegistryObject<PlacedFeature> PARZANITE_ORE_PLACED = PLACED_FEATURES.register("parzanite_ore_placed",
            () -> new PlacedFeature(DeeperConfiguredFeatures.PARZANITE_ORE_TECTONIC.getHolder().get(),
                    orePlacementCommon(7, //veins per chunk
                            HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(5), VerticalAnchor.aboveBottom(200)))));


    public static List<PlacementModifier> orePlacement(PlacementModifier p, PlacementModifier p2){
        return List.of(p, InSquarePlacement.spread(), p2, BiomeFilter.biome());
    }

    public static List<PlacementModifier> orePlacementCommon(int p1, PlacementModifier p2){
        return orePlacement(CountPlacement.of(p1), p2);
    }

    public static List<PlacementModifier> orePlacementRare(int p1, PlacementModifier p2){
        return orePlacement(RarityFilter.onAverageOnceEvery(p1), p2);
    }


    public static void register(IEventBus eventBus){
        PLACED_FEATURES.register(eventBus);
    }

}
