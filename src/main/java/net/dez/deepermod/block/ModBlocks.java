package net.dez.deepermod.block;

import net.dez.deepermod.DeeperMod;
import net.dez.deepermod.item.ModItems;
import net.dez.deepermod.worldgen.tree.HollowTreeGrower;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;



public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, DeeperMod.MOD_ID);

    public static final RegistryObject<Block> YELLOW_GRANITE = registerBlock("yellow_granite",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(5f)
                    .requiresCorrectToolForDrops())
                    , CreativeModeTab.TAB_BUILDING_BLOCKS);

    public static final RegistryObject<Block> STILL_DIRT = registerBlock("still_dirt",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DIRT)), CreativeModeTab.TAB_BUILDING_BLOCKS);

    public static final RegistryObject<Block> PARZANITE_ORE = registerBlock("parzanite_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(6f)
                    .requiresCorrectToolForDrops()
                    , UniformInt.of(3,7))
                    , CreativeModeTab.TAB_BUILDING_BLOCKS);

    public static final RegistryObject<Block> YELLOW_GRANITE_DIAMOND_ORE = registerBlock("yellow_granite_diamond_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(6f)
                    .requiresCorrectToolForDrops()
                    , UniformInt.of(3,7))
                    , CreativeModeTab.TAB_BUILDING_BLOCKS);

    public static final RegistryObject<Block> YELLOW_GRANITE_IRON_ORE = registerBlock("yellow_granite_iron_ore",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(7f)
                    .requiresCorrectToolForDrops())
                    , CreativeModeTab.TAB_BUILDING_BLOCKS);


    public static final RegistryObject<Block> PARZANITE_Block = registerBlock("parzanite_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(8f)
                    .requiresCorrectToolForDrops())
                    , CreativeModeTab.TAB_BUILDING_BLOCKS);

    public static final RegistryObject<Block> HOLLOW_WOOD = registerBlock("hollow_wood",
            () -> new DeeperWoodBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)
                    .strength(6f))
                    , CreativeModeTab.TAB_BUILDING_BLOCKS);

    public static final RegistryObject<Block> HOLLOW_SAPLING = registerBlock("hollow_sapling",
            () -> new DeeperSaplings( new HollowTreeGrower()
                    , BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING), ModBlocks.STILL_DIRT::get), CreativeModeTab.TAB_DECORATIONS);







    private static<T extends Block>RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab){
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block, CreativeModeTab tab){
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }

    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
