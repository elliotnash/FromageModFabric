package fromage.fromage;

import net.minecraft.block.BlockState;
import net.minecraft.block.DropperBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import static fromage.fromage.CheeseTable.*;

public class CheeseTableBaseCode {
    public static void onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit){
        if (world.getBlockState(pos).equals(state.with(FULL,false))){
            //so like if the block is empty it runs this
            if (player.getStackInHand(hand).getItem()== Items.MILK_BUCKET){
                System.out.println("U  wacked me with milk");
                world.setBlockState(pos, state.with(FULL, true));
                if (!player.abilities.creativeMode){
                    int invSlot = (player.inventory.getOccupiedSlotWithRoomForStack(new ItemStack(Items.BUCKET ,1)));
                    if (invSlot!=-1){
                        player.inventory.setInvStack(invSlot, new ItemStack(Items.BUCKET, (player.inventory.getInvStack(invSlot).getCount()+1)));
                        player.setStackInHand(hand, new ItemStack(Items.AIR));
                    } else {
                        player.setStackInHand(hand, new ItemStack(Items.BUCKET, 1));
                    }
                }
            }
        }
        if (world.getBlockState(pos).equals(state.with(FULL,true))){
            //runs when clean cheese cloth
            if (player.getStackInHand(hand).getItem()== Fromage.CHEESE_CLOTH){
                System.out.println("U  wacked me with cheese cloth");
                world.setBlockState(pos, state.with(FULL, false));
                if (!player.abilities.creativeMode){
                    if((player.getStackInHand(hand).getMaxDamage()-player.getStackInHand(hand).getDamage())!=1){
                        player.getStackInHand(hand).damage(1, player, (playerEntity -> {
                            playerEntity.sendToolBreakStatus(hand);
                        }));} else {
                        System.out.println(player.getStackInHand(hand).getMaxDamage()-player.getStackInHand(hand).getDamage());
                        player.setStackInHand(hand, new ItemStack(Fromage.DIRTY_CHEESE_CLOTH));
                    }
                }
                //drops cheese
                DropperBlock.dropStack(world, pos.up(1), new ItemStack(Fromage.FROMAGE, 1));
            }
            //runs when dirty cheese cloth
            if (player.getStackInHand(hand).getItem()== Fromage.DIRTY_CHEESE_CLOTH){
                System.out.println("U  wacked me with dirty cheese cloth");
                world.setBlockState(pos, state.with(FULL, false));
                //drops daddy cheese
                DropperBlock.dropStack(world, pos.up(1), new ItemStack(Fromage.DADDY_CHEESE, 1));
            }
        }
    }
}
