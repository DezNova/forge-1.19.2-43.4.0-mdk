package net.dez.deepermod.worldgen;

import net.dez.deepermod.DeeperMod;
import net.dez.deepermod.block.ModBlocks;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
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
            () -> new PlacedFeature(DeeperConfiguredFeatures.HOLLOW_TREE_SPAWN.getHolder().get(), VegetationPlacements.treePlacement(
                    PlacementUtils.countExtra(3, 0.1f, 2))));

    public static void register(IEventBus eventBus){
        PLACED_FEATURES.register(eventBus);
    }
}
