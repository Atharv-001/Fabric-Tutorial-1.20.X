package net.kaupenjoe.tutorialmod.block;

import com.terraformersmc.terraform.sign.block.*;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.kaupenjoe.tutorialmod.TutorialMod;
import net.kaupenjoe.tutorialmod.block.custom.*;
import net.kaupenjoe.tutorialmod.sound.ModSounds;
import net.kaupenjoe.tutorialmod.world.tree.ModSaplingGenerators;
import net.minecraft.block.*;
import net.minecraft.data.family.BlockFamilies;
import net.minecraft.data.family.BlockFamily;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class ModBlocks {
    public static final Block RUBY_BLOCK = registerBlock("ruby_block", new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK)));
    public static final Block RAW_RUBY_BLOCK = registerBlock("raw_ruby_block", new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK)));

    public static final Block RUBY_ORE = registerBlock("ruby_ore", new ExperienceDroppingBlock(UniformIntProvider.create(2, 5), FabricBlockSettings.copyOf(Blocks.STONE).strength(2f)));
    public static final Block DEEPSLATE_RUBY_ORE = registerBlock("deepslate_ruby_ore", new ExperienceDroppingBlock(UniformIntProvider.create(2, 5), FabricBlockSettings.copyOf(Blocks.DEEPSLATE).strength(4f)));

    public static final Block SOUND_BLOCK = registerBlock("sound_block", new SoundBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).sounds(ModSounds.SOUND_BLOCK_SOUNDS)));

    public static final Block TOMATO_CROP = Registry.register(Registries.BLOCK, new Identifier(TutorialMod.MOD_ID, "tomato_crop"), new TomatoCropBlock(FabricBlockSettings.copyOf(Blocks.WHEAT).noCollision().ticksRandomly()));
    public static final Block CORN_CROP = Registry.register(Registries.BLOCK, new Identifier(TutorialMod.MOD_ID, "corn_crop"), new CornCropBlock(FabricBlockSettings.copyOf(Blocks.WHEAT).noCollision().ticksRandomly()));

    public static final Block DAHLIA = registerBlock("dahlia", new FlowerBlock(StatusEffects.FIRE_RESISTANCE, 10, FabricBlockSettings.copyOf(Blocks.ALLIUM).noCollision()));
    public static final Block POTTED_DAHLIA = Registry.register(Registries.BLOCK, new Identifier(TutorialMod.MOD_ID, "potted_dahlia"), new FlowerPotBlock(DAHLIA, FabricBlockSettings.copyOf(Blocks.POTTED_ALLIUM)));

    public static final Identifier CHESTNUT_SIGN_TEXTURE = new Identifier(TutorialMod.MOD_ID, "entity/signs/chestnut");
    public static final Identifier CHESTNUT_HANGING_SIGN_TEXTURE = new Identifier(TutorialMod.MOD_ID, "entity/signs/hanging/chestnut");
    public static final Identifier CHESTNUT_HANGING_GUI_SIGN_TEXTURE = new Identifier(TutorialMod.MOD_ID, "textures/gui/hanging_signs/chestnut");

    public static final Block STANDING_CHESTNUT_SIGN = Registry.register(Registries.BLOCK, new Identifier(TutorialMod.MOD_ID, "chestnut_standing_sign"), new TerraformSignBlock(CHESTNUT_SIGN_TEXTURE, FabricBlockSettings.copyOf(Blocks.OAK_SIGN)));
    public static final Block WALL_CHESTNUT_SIGN = Registry.register(Registries.BLOCK, new Identifier(TutorialMod.MOD_ID, "chestnut_wall_sign"), new TerraformWallSignBlock(CHESTNUT_SIGN_TEXTURE, FabricBlockSettings.copyOf(Blocks.OAK_WALL_SIGN)));
    public static final Block HANGING_CHESTNUT_SIGN = Registry.register(Registries.BLOCK, new Identifier(TutorialMod.MOD_ID, "chestnut_hanging_sign"), new TerraformHangingSignBlock(CHESTNUT_HANGING_SIGN_TEXTURE, CHESTNUT_HANGING_GUI_SIGN_TEXTURE, FabricBlockSettings.copyOf(Blocks.OAK_HANGING_SIGN)));
    public static final Block WALL_HANGING_CHESTNUT_SIGN = Registry.register(Registries.BLOCK, new Identifier(TutorialMod.MOD_ID, "chestnut_wall_hanging_sign"), new TerraformWallHangingSignBlock(CHESTNUT_HANGING_SIGN_TEXTURE, CHESTNUT_HANGING_GUI_SIGN_TEXTURE, FabricBlockSettings.copyOf(Blocks.OAK_WALL_HANGING_SIGN)));

    public static final BlockFamily CHESTNUT_FAMILY = BlockFamilies.register(registerBlock("chestnut_planks", new Block(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS).strength(4f))))
            .sign(STANDING_CHESTNUT_SIGN, WALL_CHESTNUT_SIGN)
            .group("wooden").unlockCriterionName("has_planks").build();

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(TutorialMod.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(TutorialMod.MOD_ID, name), new BlockItem(block, new FabricItemSettings()));
    }

    public static void registerModBlocks() {
        TutorialMod.LOGGER.info("Registering ModBlocks for " + TutorialMod.MOD_ID);
    }
}
