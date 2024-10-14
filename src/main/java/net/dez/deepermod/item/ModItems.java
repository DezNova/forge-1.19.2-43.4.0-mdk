package net.dez.deepermod.item;

import net.dez.deepermod.DeeperMod;
import net.dez.deepermod.item.custom.ParzaniteReinforcedPickaxeItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tiers;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, DeeperMod.MOD_ID);

    public static final RegistryObject<Item> PARZANITE = ITEMS.register("parzanite",
            () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));

    //can somehow make custom tiers, must look into this.
    public static final RegistryObject<Item> PARZANITE_IRON_PICK = ITEMS.register("parzanite_iron_pickaxe",
            () -> new ParzaniteReinforcedPickaxeItem(Tiers.IRON, 1, -2.4f,new Item.Properties().tab(CreativeModeTab.TAB_MISC)));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }


}
