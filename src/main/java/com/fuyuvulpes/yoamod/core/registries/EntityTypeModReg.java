package com.fuyuvulpes.yoamod.core.registries;

import com.fuyuvulpes.yoamod.world.entity.ArmedSpider;
import com.fuyuvulpes.yoamod.world.entity.Blockling;
import com.fuyuvulpes.yoamod.world.entity.BrawlerEntity;
import com.fuyuvulpes.yoamod.world.entity.vehicle.PlaneEntity;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import static com.fuyuvulpes.yoamod.YOAMod.MODID;

public class EntityTypeModReg {

    public static final DeferredRegister<EntityType<?>> ENTITY = DeferredRegister.create(Registries.ENTITY_TYPE, MODID);

    public static final DeferredHolder<EntityType<?>,EntityType<PlaneEntity>> PLANE_TYPE = ENTITY.register("plane",
            () -> EntityType.Builder.<PlaneEntity>of(PlaneEntity::new, MobCategory.MISC)
                    .sized(5.75f,2.5F).clientTrackingRange(8)
                    .build(new ResourceLocation(MODID,"plane").toString()));

    public static final DeferredHolder<EntityType<?>,EntityType<BrawlerEntity>> BRAWLER_TYPE = ENTITY.register("brawler",
            () -> EntityType.Builder.<BrawlerEntity>of(BrawlerEntity::new, MobCategory.MONSTER)
                    .sized(2.5f,3.0F)
                    .build(new ResourceLocation(MODID,"brawler").toString()));

    public static final DeferredHolder<EntityType<?>,EntityType<Blockling>> BLOCKLING_TYPE = ENTITY.register("blockling",
            () -> EntityType.Builder.<Blockling>of(Blockling::new, MobCategory.CREATURE)
                    .sized(0.8F,0.8F)
                    .build(new ResourceLocation(MODID,"blockling").toString()));

    public static final DeferredHolder<EntityType<?>,EntityType<ArmedSpider>> ARMED_SPIDER_TYPE = ENTITY.register("armed_spider",
            () -> EntityType.Builder.<ArmedSpider>of(ArmedSpider::new, MobCategory.MONSTER)
                    .sized(2.0F,1.7F)
                    .build(new ResourceLocation(MODID,"armed_spider").toString()));





    public static void register(IEventBus eventBus){
        ENTITY.register(eventBus);
    }




}