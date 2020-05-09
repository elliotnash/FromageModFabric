package fromage.fromage;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;

import javax.imageio.spi.RegisterableService;

public class Fromage implements ModInitializer {

    public static final Item FROMAGE = new Item(new Item.Settings().group(ItemGroup.FOOD).food(new FoodComponent.Builder().hunger(8).saturationModifier(10).build()));

    public static final Item DADDY_CHEESE = new Item(new Item.Settings().group(ItemGroup.FOOD).food(new FoodComponent.Builder().hunger(8).saturationModifier(10).statusEffect(new StatusEffectInstance(StatusEffects.POISON, 20*20, 255), 100).statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 20*20, 255),100).build()));

    public static final Item CHEESE_CLOTH = new CheeseCloth();

    public static final Item DIRTY_CHEESE_CLOTH = new DirtyCheeseCloth();

    public static final Block CHEESE_TABLE_ACACIA = new CheeseTableAcacia();

    @Override
    public void onInitialize() {
        Registry.register(Registry.ITEM, new Identifier("fromage", "fromage"), FROMAGE);

        Registry.register(Registry.ITEM, new Identifier("fromage", "daddy_cheese"), DADDY_CHEESE);

        Registry.register(Registry.ITEM, new Identifier("fromage", "cheese_cloth"), CHEESE_CLOTH);

        Registry.register(Registry.ITEM, new Identifier("fromage","dirty_cheese_cloth"),DIRTY_CHEESE_CLOTH);

        Registry.register(Registry.BLOCK, new Identifier("fromage", "cheese_table_acacia"), CHEESE_TABLE_ACACIA);
        Registry.register(Registry.ITEM, new Identifier("fromage", "cheese_table_acacia"), new BlockItem(CHEESE_TABLE_ACACIA, new Item.Settings().group(ItemGroup.DECORATIONS)));


    }

}
