package net.dez.deepermod.worldgen.dimension;

import net.dez.deepermod.DeeperMod;
import net.dez.deepermod.worldgen.dimension.carvers.TectonicWorldCarver;
import net.minecraft.world.level.levelgen.carver.CaveCarverConfiguration;
import net.minecraft.world.level.levelgen.carver.WorldCarver;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class DeeperCarvers {
    public static final DeferredRegister<WorldCarver<?>> CARVERS = DeferredRegister.create(ForgeRegistries.WORLD_CARVERS, DeeperMod.MOD_ID);

    public static final RegistryObject<WorldCarver<CaveCarverConfiguration>> TECTONIC_CAVE = CARVERS.register("tectonic_cave", () -> new TectonicWorldCarver(CaveCarverConfiguration.CODEC));

    public static void register(IEventBus eventBus){
        CARVERS.register(eventBus);
    }
}
