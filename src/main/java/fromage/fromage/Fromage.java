package fromage.fromage;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffectType;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.BlockItem;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import static net.minecraft.util.registry.Registry.register;

public class Fromage implements ModInitializer {

    public static final Item FROMAGE = new Item(new Item.Settings().group(ItemGroup.FOOD).food(new FoodComponent.Builder().hunger(4).saturationModifier(10).build()));

    public static final Item DADDY_CHEESE = new Item(new Item.Settings().group(ItemGroup.FOOD).food(new FoodComponent.Builder().hunger(4).saturationModifier(10).statusEffect(new StatusEffectInstance(StatusEffects.POISON, 20*20, 255), 100).statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 20*20, 255),100).build()));

    public static final Item CHEESE_BREAD = new Item(new Item.Settings().group(ItemGroup.FOOD).food(new FoodComponent.Builder().hunger(8).saturationModifier(13).build()));

    public static final Item CHEESE_CLOTH = new CheeseCloth();

    public static final Item DIRTY_CHEESE_CLOTH = new DirtyCheeseCloth();

    public static final Block.Settings CheeseTableSettings = FabricBlockSettings.of(Material.WOOD).breakByHand(true).breakByTool(FabricToolTags.AXES).sounds(BlockSoundGroup.WOOD).strength(2.5f, 2.5f);

    public static final Block CHEESE_TABLE_ACACIA = new CheeseTable(CheeseTableSettings);
    public static final Block CHEESE_TABLE_BIRCH = new CheeseTable(CheeseTableSettings);
    public static final Block CHEESE_TABLE_DARK_OAK = new CheeseTable(CheeseTableSettings);
    public static final Block CHEESE_TABLE_JUNGLE = new CheeseTable(CheeseTableSettings);
    public static final Block CHEESE_TABLE_OAK = new CheeseTable(CheeseTableSettings);
    public static final Block CHEESE_TABLE_SPRUCE = new CheeseTable(CheeseTableSettings);



    @Override
    public void onInitialize() {

        register(Registry.ITEM, new Identifier("fromage", "fromage"), FROMAGE);

        register(Registry.ITEM, new Identifier("fromage", "daddy_cheese"), DADDY_CHEESE);

        register(Registry.ITEM, new Identifier("fromage", "cheese_bread"), CHEESE_BREAD);

        register(Registry.ITEM, new Identifier("fromage", "cheese_cloth"), CHEESE_CLOTH);

        register(Registry.ITEM, new Identifier("fromage","dirty_cheese_cloth"),DIRTY_CHEESE_CLOTH);


        register(Registry.BLOCK, new Identifier("fromage", "cheese_table_acacia"), CHEESE_TABLE_ACACIA);
        register(Registry.ITEM, new Identifier("fromage", "cheese_table_acacia"), new BlockItem(CHEESE_TABLE_ACACIA, new Item.Settings().group(ItemGroup.DECORATIONS)));

        register(Registry.BLOCK, new Identifier("fromage", "cheese_table_birch"), CHEESE_TABLE_BIRCH);
        register(Registry.ITEM, new Identifier("fromage", "cheese_table_birch"), new BlockItem(CHEESE_TABLE_BIRCH, new Item.Settings().group(ItemGroup.DECORATIONS)));

        register(Registry.BLOCK, new Identifier("fromage", "cheese_table_dark_oak"), CHEESE_TABLE_DARK_OAK);
        register(Registry.ITEM, new Identifier("fromage", "cheese_table_dark_oak"), new BlockItem(CHEESE_TABLE_DARK_OAK, new Item.Settings().group(ItemGroup.DECORATIONS)));

        register(Registry.BLOCK, new Identifier("fromage", "cheese_table_jungle"), CHEESE_TABLE_JUNGLE);
        register(Registry.ITEM, new Identifier("fromage", "cheese_table_jungle"), new BlockItem(CHEESE_TABLE_JUNGLE, new Item.Settings().group(ItemGroup.DECORATIONS)));

        register(Registry.BLOCK, new Identifier("fromage", "cheese_table_oak"), CHEESE_TABLE_OAK);
        register(Registry.ITEM, new Identifier("fromage", "cheese_table_oak"), new BlockItem(CHEESE_TABLE_OAK, new Item.Settings().group(ItemGroup.DECORATIONS)));

        register(Registry.BLOCK, new Identifier("fromage", "cheese_table_spruce"), CHEESE_TABLE_SPRUCE);
        register(Registry.ITEM, new Identifier("fromage", "cheese_table_spruce"), new BlockItem(CHEESE_TABLE_SPRUCE, new Item.Settings().group(ItemGroup.DECORATIONS)));



    }

}
