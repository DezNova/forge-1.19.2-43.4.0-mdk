package net.dez.deepermod.worldgen;

import net.dez.deepermod.DeeperMod;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.biome.OverworldBiomes;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;


public class DeeperBiomes {
    public static final DeferredRegister<Biome> BIOMES = DeferredRegister.create(ForgeRegistries.BIOMES, DeeperMod.MOD_ID);

    public static final ResourceKey<Biome> BARREN_LANDS = registerBiome("barren_lands");

    public static final ResourceKey<Biome> HOLLOW_WOODS = registerBiome("hollow_woods");

    private static ResourceKey<Biome> registerBiome(String name){
        BIOMES.register(name, OverworldBiomes::theVoid);
        return  ResourceKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(DeeperMod.MOD_ID, name));
    }


    public static void register(IEventBus eventBus){
        BIOMES.register(eventBus);
    }
}
