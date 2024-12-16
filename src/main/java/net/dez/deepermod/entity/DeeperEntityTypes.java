package net.dez.deepermod.entity;

import net.dez.deepermod.DeeperMod;
import net.dez.deepermod.entity.custom.GlomerEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class DeeperEntityTypes {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, DeeperMod.MOD_ID);

    public static final RegistryObject<EntityType<GlomerEntity>> GLOMER =
        ENTITY_TYPES.register("glomer",
            () -> EntityType.Builder.of(GlomerEntity::new, MobCategory.MONSTER)
            .sized(1.5f, 1.5f) //hitbox size
            .build(new ResourceLocation(DeeperMod.MOD_ID, "glomer").toString()));

    public static void register(IEventBus eventBus){
        ENTITY_TYPES.register(eventBus);
    }
}
