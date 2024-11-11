package net.dez.deepermod.worldgen.dimension.carvers;

import net.dez.deepermod.DeeperMod;
import net.dez.deepermod.block.ModBlocks;
import net.dez.deepermod.worldgen.dimension.DeeperCarvers;
import net.minecraft.core.HolderSet;
import net.minecraft.core.Registry;
import net.minecraft.util.valueproviders.ConstantFloat;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.carver.CaveCarverConfiguration;
import net.minecraft.world.level.levelgen.carver.ConfiguredWorldCarver;
import net.minecraft.world.level.levelgen.heightproviders.UniformHeight;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ConfiguredCarvers {

    public static final DeferredRegister<ConfiguredWorldCarver<?>> CONFIGURED_CARVERS = DeferredRegister.create(Registry.CONFIGURED_CARVER_REGISTRY, DeeperMod.MOD_ID);

    public static Supplier<HolderSet<Block>> replaceableBlocks = () -> HolderSet.direct(
            ModBlocks.YELLOW_GRANITE.getHolder().orElseThrow()
    );

    public static final RegistryObject<ConfiguredWorldCarver<CaveCarverConfiguration>> TECTONIC_CAVE =
            CONFIGURED_CARVERS.register("tectonic_cave",
                    () -> DeeperCarvers.TECTONIC_CAVE.get().configured(new CaveCarverConfiguration(
                            .5f,
                            UniformHeight.of(VerticalAnchor.bottom(), VerticalAnchor.top()),
                            ConstantFloat.of(0.5f),
                            VerticalAnchor.aboveBottom(10),
                            replaceableBlocks.get(),
                            ConstantFloat.of(1.0F),
                            ConstantFloat.of(1.0F),
                            ConstantFloat.of(-0.7F))));

    public static void register(IEventBus eventBus){
        CONFIGURED_CARVERS.register(eventBus);
    }


}
