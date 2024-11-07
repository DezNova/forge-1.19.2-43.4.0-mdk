package net.dez.deepermod.worldgen;

import net.dez.deepermod.DeeperMod;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.biome.OverworldBiomes;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.BiomeSpecialEffects;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;


public class DeeperBiomes {
    public static final DeferredRegister<Biome> BIOMES = DeferredRegister.create(ForgeRegistries.BIOMES, DeeperMod.MOD_ID);

    public static final ResourceKey<Biome> BARREN_LANDS = registerBiome("barren_lands");

    public static final ResourceKey<Biome> HOLLOW_WOODS = registerBiomeCustom("hollow_woods", DeeperBiomes::createHollowWoodsBiome);

    public static final ResourceKey<Biome> MOLTEN_FIELDS = registerBiome("molten_fields");

    private static ResourceKey<Biome> registerBiome(String name){
        BIOMES.register(name, OverworldBiomes::theVoid);
        return  ResourceKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(DeeperMod.MOD_ID, name));
    }

    private static ResourceKey<Biome> registerBiomeCustom(String name, Supplier<Biome> biomeSupplier){
        BIOMES.register(name, biomeSupplier);
        return  ResourceKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(DeeperMod.MOD_ID, name));
    }



    public static void register(IEventBus eventBus){
        BIOMES.register(eventBus);
    }


/*
Used for debugging tree Placed Feature
 */
    static Biome createHollowWoodsBiome() {
        BiomeGenerationSettings.Builder generationSettings = new BiomeGenerationSettings.Builder()
                .addFeature(GenerationStep.Decoration.TOP_LAYER_MODIFICATION, DeeperPlacedFeature.HOLLOW_TREE_PLACED.getHolder().get());


        MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();

        return new Biome.BiomeBuilder()
                .precipitation(Biome.Precipitation.RAIN)
                .temperature(0.7F)
                .downfall(0.8F)
                .specialEffects(new BiomeSpecialEffects.Builder()
                        .fogColor(0xC0D8FF)
                        .waterColor(0x3F76E4)
                        .waterFogColor(0x050533)
                        .skyColor(0x77ADFF)
                        .build())
                .mobSpawnSettings(spawnSettings.build())
                .generationSettings(generationSettings.build())
                .build();
    }

}
