package epicsquid.mysticalworld.init;

import java.util.HashSet;
import java.util.Set;

import epicsquid.mysticallib.LibRegistry;
import epicsquid.mysticallib.util.Util;
import epicsquid.mysticalworld.MysticalWorld;
import epicsquid.mysticalworld.config.ConfigManager;
import epicsquid.mysticalworld.entity.*;
import epicsquid.mysticalworld.entity.render.*;
import epicsquid.mysticalworld.proxy.ClientProxy;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class ModEntities {

  public static void registerMobs() {
    //EGG COLORS GO: MAIN THEN SPOTS
    LibRegistry.registerEntity(EntityFox.class, 0xD46724, 0xF5E0D3);
    if (MysticalWorld.proxy instanceof ClientProxy)
      LibRegistry.registerEntityRenderer(EntityFox.class, new RenderFox.Factory());
    LibRegistry.registerEntity(EntityFrog.class, 0x285234, 0xDBE697);
    if (MysticalWorld.proxy instanceof ClientProxy)
      LibRegistry.registerEntityRenderer(EntityFrog.class, new RenderFrog.Factory());
    LibRegistry.registerEntity(BeetleEntity.class, 0x418594, 0x211D15);
    if (MysticalWorld.proxy instanceof ClientProxy)
      LibRegistry.registerEntityRenderer(BeetleEntity.class, new BeetleRender.Factory());
    LibRegistry.registerEntity(SproutEntity.class, 0xe8f442, 0xd11f5a);
    if (MysticalWorld.proxy instanceof ClientProxy)
      LibRegistry.registerEntityRenderer(SproutEntity.class, new SproutRender.Factory());
    LibRegistry.registerEntity(EntityDeer.class, Util.intColor(161, 132, 88), Util.intColor(94, 77, 51));
    if (MysticalWorld.proxy instanceof ClientProxy)
      LibRegistry.registerEntityRenderer(EntityDeer.class, new RenderDeer.Factory());
  }

  public static void registerMobSpawn() {
    Set<Biome> biomes = new HashSet<>();

    if (ConfigManager.modules.rootsModuleEnabled && ConfigManager.mobs.spawnDeer) {
      for (String biomeName : ConfigManager.deer.biomes) {
        Type type = Type.getType(biomeName);
        biomes.addAll(BiomeDictionary.getBiomes(type));
      }
      EntityRegistry.addSpawn(EntityDeer.class, ConfigManager.deer.rate, ConfigManager.deer.min, ConfigManager.deer.max, EnumCreatureType.CREATURE, biomes.toArray(new Biome[0]));
    }

    biomes.clear();

    if (ConfigManager.modules.mysticalWorldModuleEnabled && ConfigManager.mobs.spawnFox) {
      for (String biomeName : ConfigManager.fox.biomes) {
        Type type = Type.getType(biomeName);
        biomes.addAll(BiomeDictionary.getBiomes(type));
      }
      EntityRegistry.addSpawn(EntityFox.class, ConfigManager.fox.rate, ConfigManager.fox.min, ConfigManager.fox.max, EnumCreatureType.CREATURE, biomes.toArray(new Biome[0]));
    }

    biomes.clear();

    if (ConfigManager.modules.mysticalWorldModuleEnabled && ConfigManager.mobs.spawnBeetle) {
      for (String biomeName : ConfigManager.beetle.biomes) {
        Type type = Type.getType(biomeName);
        biomes.addAll(BiomeDictionary.getBiomes(type));
      }
      EntityRegistry.addSpawn(BeetleEntity.class, ConfigManager.beetle.rate, ConfigManager.beetle.min, ConfigManager.beetle.max, EnumCreatureType.CREATURE, biomes.toArray(new Biome[0]));
    }

    biomes.clear();

    if (ConfigManager.modules.mysticalWorldModuleEnabled && ConfigManager.mobs.spawnFrog) {
      for (String biomeName : ConfigManager.frog.biomes) {
        Type type = Type.getType(biomeName);
        biomes.addAll(BiomeDictionary.getBiomes(type));
      }
      EntityRegistry.addSpawn(EntityFrog.class, ConfigManager.frog.rate, ConfigManager.frog.min, ConfigManager.frog.max, EnumCreatureType.CREATURE, biomes.toArray(new Biome[0]));
    }

    biomes.clear();

    if (ConfigManager.modules.mysticalWorldModuleEnabled && ConfigManager.mobs.spawnSprout) {
      for (String biomeName : ConfigManager.sprout.biomes) {
        Type type = Type.getType(biomeName);
        biomes.addAll(BiomeDictionary.getBiomes(type));
      }
      EntityRegistry.addSpawn(SproutEntity.class, ConfigManager.sprout.rate, ConfigManager.sprout.min, ConfigManager.sprout.max, EnumCreatureType.CREATURE, biomes.toArray(new Biome[0]));
    }
  }
}
