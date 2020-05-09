package fromage.fromage;

import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.world.World;

public class CheeseCloth extends Item {

    public CheeseCloth() {
        super(new Item.Settings().group(ItemGroup.MISC).maxDamage(5));
    }

    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        HitResult result = user.rayTrace(4, 0, true);

        if (result instanceof BlockHitResult) {
            BlockHitResult blockHitResult = (BlockHitResult) result;
            if (world.getBlockState(blockHitResult.getBlockPos()).getBlock().equals(Blocks.WATER)) {
                System.out.println("Hit water!");
                System.out.println(((BlockHitResult) result).getBlockPos());

                user.getStackInHand(hand).setDamage(0);

                return TypedActionResult.success(user.getStackInHand(hand));
            }
        }

        return TypedActionResult.fail(user.getStackInHand(hand));
    }
}
