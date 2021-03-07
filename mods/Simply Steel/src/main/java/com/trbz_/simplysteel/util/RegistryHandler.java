package com.trbz_.simplysteel.util;

import com.trbz_.simplysteel.SimplySteel;
import com.trbz_.simplysteel.armor.SteelArmorMaterial;
import com.trbz_.simplysteel.items.RNGFlintAndSteelItem;
import com.trbz_.simplysteel.tools.SteelItemTier;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.entity.EntityType;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class RegistryHandler {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, SimplySteel.MOD_ID);
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, SimplySteel.MOD_ID);

    public static void init(){

        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());

    }

    //Items

    public static final RegistryObject<Item> STEEL_INGOT = ITEMS.register("steel_ingot", () -> new Item(new Item.Properties().group(ItemGroup.MATERIALS)));
    public static final RegistryObject<Item> CRUDE_IRON = ITEMS.register("crude_iron", () -> new Item(new Item.Properties().group(ItemGroup.MATERIALS)));
    public static final RegistryObject<Item> STEEL_NUGGET = ITEMS.register("steel_nugget", () -> new Item(new Item.Properties().group(ItemGroup.MATERIALS)));

    //Blocks

    public static final RegistryObject<Block> STEEL_BLOCK = BLOCKS.register("steel_block", () -> new Block(Block.Properties
            .create(Material.IRON)
            .hardnessAndResistance(7.0F,10.0F)
            .sound(SoundType.METAL)
            .harvestLevel(1)
            .setRequiresTool()
            .harvestTool(ToolType.PICKAXE)));

    public static final RegistryObject<PaneBlock> STEEL_BARS = BLOCKS.register("steel_bars", () -> new PaneBlock(AbstractBlock.Properties
            .create(Material.IRON, MaterialColor.AIR)
            .setRequiresTool()
            .hardnessAndResistance(7.0F,10.0F)
            .sound(SoundType.METAL)
            .harvestLevel(1)
            .setRequiresTool()
            .notSolid()));

    public static final RegistryObject<DoorBlock> STEEL_DOOR = BLOCKS.register("steel_door", () -> new DoorBlock(AbstractBlock.Properties
            .create(Material.IRON, MaterialColor.IRON)
            .setRequiresTool()
            .hardnessAndResistance(7.0F,10.0F)
            .sound(SoundType.METAL)
            .harvestLevel(1)
            .notSolid()));

    public static final RegistryObject<TrapDoorBlock> STEEL_TRAPDOOR = BLOCKS.register("steel_trapdoor", () -> new TrapDoorBlock(AbstractBlock.Properties
            .create(Material.IRON)
            .setRequiresTool()
            .hardnessAndResistance(5.0F)
            .sound(SoundType.METAL)
            .notSolid()
            .setAllowsSpawn(RegistryHandler::neverAllowSpawn)));


    private static Boolean neverAllowSpawn(BlockState state, IBlockReader reader, BlockPos pos, EntityType<?> entity) {
        return (boolean)false;
    }

    //Tools

    public static final RegistryObject<SwordItem> STEEL_SWORD = ITEMS.register("steel_sword", () -> new SwordItem(SteelItemTier.STEEL,3,-2.4f, new Item.Properties().group(ItemGroup.COMBAT)));
    public static final RegistryObject<ShovelItem> STEEL_SHOVEL = ITEMS.register("steel_shovel", () -> new ShovelItem(SteelItemTier.STEEL, 1.5F, -3.0F, (new Item.Properties()).group(ItemGroup.TOOLS)));
    public static final RegistryObject<PickaxeItem> STEEL_PICKAXE = ITEMS.register("steel_pickaxe", () -> new PickaxeItem(SteelItemTier.STEEL, 1, -2.8F, (new Item.Properties()).group(ItemGroup.TOOLS)));
    public static final RegistryObject<AxeItem> STEEL_AXE = ITEMS.register("steel_axe", () -> new AxeItem(SteelItemTier.STEEL, 6.0F, -3.1F, (new Item.Properties()).group(ItemGroup.TOOLS)));
    public static final RegistryObject<HoeItem> STEEL_HOE = ITEMS.register("steel_hoe", () -> new HoeItem(SteelItemTier.STEEL, -2, -1.0F, (new Item.Properties()).group(ItemGroup.TOOLS)));

    public static final RegistryObject<FlintAndSteelItem> QUARTZ_AND_STEEL = ITEMS.register("quartz_and_steel", () -> new FlintAndSteelItem(new Item.Properties().maxDamage(88).group(ItemGroup.TOOLS)));
    public static final RegistryObject<RNGFlintAndSteelItem> FLINT_AND_IRON = ITEMS.register("flint_and_iron", () -> new RNGFlintAndSteelItem(new Item.Properties().maxDamage(64).group(ItemGroup.TOOLS), 0.5F));
    public static final RegistryObject<RNGFlintAndSteelItem> QUARTZ_AND_IRON = ITEMS.register("quartz_and_iron", () -> new RNGFlintAndSteelItem(new Item.Properties().maxDamage(88).group(ItemGroup.TOOLS), 0.5F));



    //Armor

    public static final RegistryObject<ArmorItem> STEEL_HELMET = ITEMS.register("steel_helmet", () -> new ArmorItem(SteelArmorMaterial.STEEL, EquipmentSlotType.HEAD, new Item.Properties().group(ItemGroup.COMBAT)));
    public static final RegistryObject<ArmorItem> STEEL_CHESTPLATE = ITEMS.register("steel_chestplate", () -> new ArmorItem(SteelArmorMaterial.STEEL, EquipmentSlotType.CHEST, new Item.Properties().group(ItemGroup.COMBAT)));
    public static final RegistryObject<ArmorItem> STEEL_LEGGINGS = ITEMS.register("steel_leggings", () -> new ArmorItem(SteelArmorMaterial.STEEL, EquipmentSlotType.LEGS, new Item.Properties().group(ItemGroup.COMBAT)));
    public static final RegistryObject<ArmorItem> STEEL_BOOTS = ITEMS.register("steel_boots", () -> new ArmorItem(SteelArmorMaterial.STEEL, EquipmentSlotType.FEET, new Item.Properties().group(ItemGroup.COMBAT)));

    //Block Items

    public static final RegistryObject<Item> STEEL_BLOCK_ITEM = ITEMS.register("steel_block", () -> new BlockItem(STEEL_BLOCK.get(), new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)));
    public static final RegistryObject<Item> STEEL_BARS_ITEM = ITEMS.register("steel_bars", () -> new BlockItem(STEEL_BARS.get(), new Item.Properties().group(ItemGroup.DECORATIONS)));
    public static final RegistryObject<Item> STEEL_DOOR_ITEM = ITEMS.register("steel_door", () -> new TallBlockItem(STEEL_DOOR.get(), (new Item.Properties()).group(ItemGroup.REDSTONE)));
    public static final RegistryObject<Item> STEEL_TRAPDOOR_ITEM = ITEMS.register("steel_trapdoor", () -> new BlockItem(STEEL_TRAPDOOR.get(), (new Item.Properties()).group(ItemGroup.REDSTONE)));


}