package net.manmaed.bbg.items;

import net.manmaed.bbg.config.BBGConfig;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.network.chat.TextColor;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

import java.util.List;

public class BedRockPickaxe extends PickaxeItem {

    //TODO: Move To Config?
    public boolean shouldDropBedrock = true;
    public int damageby = 50;
    public BedRockPickaxe() {
        super(BBGTiers.BBG, new Item.Properties().attributes(PickaxeItem.createAttributes(BBGTiers.BBG, 1.0F, -2.8F)));
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        BlockPos clickedPos = context.getClickedPos();
        Level level = context.getLevel();
        Player player = context.getPlayer();
        ItemStack offhandItem = player.getOffhandItem();
        ItemStack mainHandItem = player.getMainHandItem();
        BlockState blockState = level.getBlockState(clickedPos);
        if (!level.isClientSide) {
                if (blockState.is(Blocks.BEDROCK)) {
                    if (offhandItem.isEmpty()) {
                        if (BBGConfig.BEDROCK_DROPS.get()) {
                            player.addItem(new ItemStack(Blocks.BEDROCK));

                        }
                        level.destroyBlock(clickedPos, true);
                        //level.playSound(player, player.getOnPos(), mainHandItem.getBreakingSound(), SoundSource.PLAYERS);
                        mainHandItem.setDamageValue(mainHandItem.getDamageValue() + BBGConfig.DAMAGE_PICK_BY.get());
                        if (mainHandItem.getDamageValue() == 4062) {
                            mainHandItem.shrink(1);
                        }
                        return InteractionResult.SUCCESS;
                    } else {
                        player.sendSystemMessage(Component.translatable("item.bbg.bbg_pickaxe.offhand.failed").setStyle(Style.EMPTY.withColor(TextColor.fromLegacyFormat(ChatFormatting.RED))));
                        return InteractionResult.FAIL;
                    }
                }
        }
        return InteractionResult.PASS;
    }

    @Override
    public void appendHoverText(ItemStack itemStack, TooltipContext tooltipContext, List<Component> list, TooltipFlag tooltipFlag) {
        list.add(Component.translatable("item.bbg.bbg_pickaxe.tooltip.one"));
        list.add(Component.translatable("item.bbg.bbg_pickaxe.tooltip.two", BBGConfig.DAMAGE_PICK_BY.get()));
        list.add(Component.translatable("item.bbg.bbg_pickaxe.tooltip.three", BBGConfig.BEDROCK_DROPS.get()));
    }
}
