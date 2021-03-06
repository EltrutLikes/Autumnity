package com.minecraftabnormals.autumnity.core.other;

import java.util.ArrayList;
import java.util.List;

import com.minecraftabnormals.abnormals_core.core.util.DataUtil;
import com.minecraftabnormals.autumnity.core.Autumnity;
import com.minecraftabnormals.autumnity.core.AutumnityConfig;
import com.minecraftabnormals.autumnity.core.registry.AutumnityBiomes;
import com.minecraftabnormals.autumnity.core.registry.AutumnityEntities;
import com.minecraftabnormals.autumnity.core.registry.AutumnityFeatures;
import com.minecraftabnormals.autumnity.core.registry.AutumnityStructures;

import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Features;
import net.minecraft.world.gen.feature.structure.StructureFeatures;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.common.world.MobSpawnInfoBuilder;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Autumnity.MOD_ID)
public class AutumnityGeneration {

	@SubscribeEvent
	public static void onBiomeLoad(BiomeLoadingEvent event) {
		ResourceLocation biome = event.getName();
		MobSpawnInfoBuilder spawns = event.getSpawns();
		BiomeGenerationSettingsBuilder generation = event.getGeneration();

		if (biome == null) return;

		if (DataUtil.matchesKeys(biome, AutumnityBiomes.MAPLE_FOREST.getKey(), AutumnityBiomes.MAPLE_FOREST_HILLS.getKey(), AutumnityBiomes.PUMPKIN_FIELDS.getKey())) {
			DefaultBiomeFeatures.withStrongholdAndMineshaft(generation);
			DefaultBiomeFeatures.withCavesAndCanyons(generation);
			DefaultBiomeFeatures.withLavaAndWaterLakes(generation);
			DefaultBiomeFeatures.withMonsterRoom(generation);
			DefaultBiomeFeatures.withCommonOverworldBlocks(generation);
			DefaultBiomeFeatures.withOverworldOres(generation);
			DefaultBiomeFeatures.withDisks(generation);
			DefaultBiomeFeatures.withNormalMushroomGeneration(generation);
			DefaultBiomeFeatures.withSugarCaneAndPumpkins(generation);
			DefaultBiomeFeatures.withLavaAndWaterSprings(generation);
			DefaultBiomeFeatures.withFrozenTopLayer(generation);

			generation.withStructure(StructureFeatures.RUINED_PORTAL);
			generation.withStructure(AutumnityStructures.Configured.MAPLE_WITCH_HUT);

			DefaultBiomeFeatures.withBatsAndHostiles(spawns);
			spawns.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(AutumnityEntities.SNAIL.get(), 16, 2, 2));
			spawns.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(AutumnityEntities.TURKEY.get(), 10, 4, 4));
			spawns.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityType.SHEEP, 12, 4, 4));
			spawns.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityType.PIG, 10, 4, 4));
			spawns.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityType.COW, 8, 4, 4));

			if (DataUtil.matchesKeys(biome, AutumnityBiomes.MAPLE_FOREST.getKey(), AutumnityBiomes.MAPLE_FOREST_HILLS.getKey())) {
				DefaultBiomeFeatures.withDefaultFlowers(generation);
				DefaultBiomeFeatures.withForestGrass(generation);
				generation.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, AutumnityFeatures.Configured.MAPLE_FOREST_VEGETATION);
				generation.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, AutumnityFeatures.Configured.FLOWER_MAPLE_FOREST);
				generation.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, AutumnityFeatures.Configured.PATCH_GRASS_MAPLE_FOREST);
				generation.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, AutumnityFeatures.Configured.FALLEN_LEAVES);
				generation.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, AutumnityFeatures.Configured.PATCH_FOUL_BERRY_BUSH);
				spawns.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(AutumnityEntities.TURKEY.get(), 10, 4, 4));
			}

			if (DataUtil.matchesKeys(biome, AutumnityBiomes.PUMPKIN_FIELDS.getKey())) {
				generation.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Features.PATCH_GRASS_PLAIN);
				DefaultBiomeFeatures.withNoiseTallGrass(generation);
				generation.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, AutumnityFeatures.Configured.PUMPKIN_FIELDS_VEGETATION);
				generation.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, AutumnityFeatures.Configured.FLOWER_PUMPKIN_FIELDS);
				generation.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, AutumnityFeatures.Configured.PATCH_GRASS_PUMPKIN_FIELDS);
				generation.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, AutumnityFeatures.Configured.PATCH_PUMPKINS_PUMPKIN_FIELDS);
			}
		}
		else {
			if (DataUtil.matchesKeys(biome, AutumnityBiomes.YELLOW_SPOTTED_FOREST.getKey())) {
				DefaultBiomeFeatures.withStrongholdAndMineshaft(generation);
				DefaultBiomeFeatures.withCavesAndCanyons(generation);
				DefaultBiomeFeatures.withLavaAndWaterLakes(generation);
				DefaultBiomeFeatures.withMonsterRoom(generation);
				DefaultBiomeFeatures.withAllForestFlowerGeneration(generation);
				DefaultBiomeFeatures.withCommonOverworldBlocks(generation);
				DefaultBiomeFeatures.withOverworldOres(generation);
				DefaultBiomeFeatures.withDisks(generation);
				DefaultBiomeFeatures.withDefaultFlowers(generation);
				DefaultBiomeFeatures.withForestGrass(generation);
				DefaultBiomeFeatures.withNormalMushroomGeneration(generation);
				DefaultBiomeFeatures.withSugarCaneAndPumpkins(generation);
				DefaultBiomeFeatures.withLavaAndWaterSprings(generation);
				DefaultBiomeFeatures.withFrozenTopLayer(generation);

				generation.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, AutumnityFeatures.Configured.MAPLE_TREE_YELLOW_SPOTTED_FOREST);
				generation.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, AutumnityFeatures.Configured.YELLOW_SPOTTED_FOREST_VEGETATION);

				generation.withStructure(StructureFeatures.RUINED_PORTAL);

				DefaultBiomeFeatures.withBatsAndHostiles(spawns);
				DefaultBiomeFeatures.withPassiveMobs(spawns);
				spawns.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityType.WOLF, 5, 4, 4));
			} else if (DataUtil.matchesKeys(biome, AutumnityBiomes.ORANGE_SPOTTED_DARK_FOREST.getKey())) {
				DefaultBiomeFeatures.withStrongholdAndMineshaft(generation);
				DefaultBiomeFeatures.withCavesAndCanyons(generation);
				DefaultBiomeFeatures.withLavaAndWaterLakes(generation);
				DefaultBiomeFeatures.withMonsterRoom(generation);
				DefaultBiomeFeatures.withAllForestFlowerGeneration(generation);
				DefaultBiomeFeatures.withCommonOverworldBlocks(generation);
				DefaultBiomeFeatures.withOverworldOres(generation);
				DefaultBiomeFeatures.withDisks(generation);
				DefaultBiomeFeatures.withDefaultFlowers(generation);
				DefaultBiomeFeatures.withForestGrass(generation);
				DefaultBiomeFeatures.withNormalMushroomGeneration(generation);
				DefaultBiomeFeatures.withSugarCaneAndPumpkins(generation);
				DefaultBiomeFeatures.withLavaAndWaterSprings(generation);
				DefaultBiomeFeatures.withFrozenTopLayer(generation);

				generation.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, AutumnityFeatures.Configured.ORANGE_SPOTTED_DARK_FOREST_VEGETATION);

				generation.withStructure(StructureFeatures.RUINED_PORTAL);
				generation.withStructure(StructureFeatures.MANSION);

				DefaultBiomeFeatures.withBatsAndHostiles(spawns);
				DefaultBiomeFeatures.withPassiveMobs(spawns);
			} else if (DataUtil.matchesKeys(biome, AutumnityBiomes.RED_SPOTTED_TAIGA.getKey())) {
				DefaultBiomeFeatures.withStrongholdAndMineshaft(generation);
				DefaultBiomeFeatures.withCavesAndCanyons(generation);
				DefaultBiomeFeatures.withLavaAndWaterLakes(generation);
				DefaultBiomeFeatures.withMonsterRoom(generation);
				DefaultBiomeFeatures.withLargeFern(generation);
				DefaultBiomeFeatures.withCommonOverworldBlocks(generation);
				DefaultBiomeFeatures.withOverworldOres(generation);
				DefaultBiomeFeatures.withDisks(generation);
				DefaultBiomeFeatures.withDefaultFlowers(generation);
				DefaultBiomeFeatures.withTaigaGrassVegetation(generation);
				DefaultBiomeFeatures.withNormalMushroomGeneration(generation);
				DefaultBiomeFeatures.withSugarCaneAndPumpkins(generation);
				DefaultBiomeFeatures.withLavaAndWaterSprings(generation);
				DefaultBiomeFeatures.withSparseBerries(generation);
				DefaultBiomeFeatures.withFrozenTopLayer(generation);

				generation.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, AutumnityFeatures.Configured.RED_SPOTTED_TAIGA_VEGETATION);

				generation.withStructure(StructureFeatures.RUINED_PORTAL);
				generation.withStructure(StructureFeatures.VILLAGE_TAIGA);
				generation.withStructure(StructureFeatures.PILLAGER_OUTPOST);

				DefaultBiomeFeatures.withBatsAndHostiles(spawns);
				DefaultBiomeFeatures.withPassiveMobs(spawns);
				spawns.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityType.WOLF, 8, 4, 4));
				spawns.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityType.RABBIT, 4, 2, 3));
				spawns.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityType.FOX, 8, 2, 4));
			}

			if (AutumnityConfig.COMMON.snailSpawnBiomes.get().contains(biome.toString())) {
				spawns.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(AutumnityEntities.SNAIL.get(), 10, 2, 2));
			}

			if (AutumnityConfig.COMMON.turkeySpawnBiomes.get().contains(biome.toString())) {
				spawns.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(AutumnityEntities.TURKEY.get(), 10, 4, 4));
			}

			if (AutumnityConfig.COMMON.mapleTreeBiomes.get().contains(biome.toString())) {
				generation.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, AutumnityFeatures.Configured.MAPLE_TREE);
			}
		}

		removeSpawns(event);
	}

	private static void removeSpawns(BiomeLoadingEvent event) {
		MobSpawnInfoBuilder spawns = event.getSpawns();
		List<MobSpawnInfo.Spawners> entrysToRemove = new ArrayList<>();
		for (MobSpawnInfo.Spawners entry : spawns.getSpawner(EntityClassification.CREATURE)) {
			if (AutumnityConfig.COMMON.turkeySpawnBiomes.get().contains(event.getName().toString())) {
				if (entry.type == EntityType.CHICKEN) {
					entrysToRemove.add(entry);
				}
			}
		}
		;
		spawns.getSpawner(EntityClassification.CREATURE).removeAll(entrysToRemove);
	}
}