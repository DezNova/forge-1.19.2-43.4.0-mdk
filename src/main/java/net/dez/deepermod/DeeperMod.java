package net.dez.deepermod;

import com.mojang.logging.LogUtils;
import net.dez.deepermod.block.ModBlocks;
import net.dez.deepermod.item.ModItems;
import net.dez.deepermod.worldgen.DeeperBiomes;
import net.dez.deepermod.worldgen.DeeperConfiguredFeatures;
import net.dez.deepermod.worldgen.DeeperPlacedFeature;
import net.dez.deepermod.worldgen.dimension.DeeperCarvers;
import net.dez.deepermod.worldgen.dimension.carvers.ConfiguredCarvers;
import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;
import org.slf4j.Logger;

import java.util.ArrayList;
import java.util.List;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(DeeperMod.MOD_ID)
public class DeeperMod
{
    public static final String MOD_ID = "deepermod";
    private static final Logger LOGGER = LogUtils.getLogger();

    public DeeperMod()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();


        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);


        DeeperCarvers.register(modEventBus);
        ConfiguredCarvers.register(modEventBus);


        DeeperConfiguredFeatures.register(modEventBus);
        DeeperPlacedFeature.register(modEventBus);

        DeeperBiomes.register(modEventBus);

        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

        // Register our mod's ForgeConfigSpec so that Forge can create and load the config file for us
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        // Some common setup code
        LOGGER.info("HELLO FROM COMMON SETUP");

        if (Config.logDirtBlock)
            LOGGER.info("DIRT BLOCK >> {}", ForgeRegistries.BLOCKS.getKey(Blocks.DIRT));

        LOGGER.info(Config.magicNumberIntroduction + Config.magicNumber);

        Config.items.forEach((item) -> LOGGER.info("ITEM >> {}", item.toString()));

        ResourceLocation id = new ResourceLocation(MOD_ID, "hollow_tree");
        ResourceLocation id2 = new ResourceLocation(MOD_ID, "hollow_tree_placed");
        LOGGER.info("CF:" + BuiltinRegistries.CONFIGURED_FEATURE.get(id));
        LOGGER.info("PF:" + BuiltinRegistries.PLACED_FEATURE.get(id2));

        ResourceLocation id3 = new ResourceLocation(MOD_ID, "hollow_woods");
        LOGGER.info("Hollow woods exist:" + ForgeRegistries.BIOMES.getHolder(id3).isPresent());


    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {

        }
    }
}
