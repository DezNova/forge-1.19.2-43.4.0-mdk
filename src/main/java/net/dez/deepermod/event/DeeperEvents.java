package net.dez.deepermod.event;

import net.dez.deepermod.DeeperMod;
import net.dez.deepermod.entity.DeeperEntityTypes;
import net.dez.deepermod.entity.custom.GlomerEntity;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

public class DeeperEvents {


    @Mod.EventBusSubscriber(modid = DeeperMod.MOD_ID)
    public static class ForgeEvents{

    }

    @Mod.EventBusSubscriber(modid = DeeperMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ModEventBusEventss{

        @SubscribeEvent
        public static void entityyAttributeEvent(EntityAttributeCreationEvent event){
            event.put(DeeperEntityTypes.GLOMER.get(), GlomerEntity.setAttributes());
        }
    }

}
