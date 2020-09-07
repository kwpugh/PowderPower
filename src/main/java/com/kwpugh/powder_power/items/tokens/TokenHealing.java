package com.kwpugh.powder_power.items.tokens;

import java.util.List;

import javax.annotation.Nullable;

import com.kwpugh.powder_power.init.ItemInit;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class TokenHealing extends Item
{

	public TokenHealing(Properties properties)
	{
		super(properties);
	}

	public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity player, Hand hand)
	{	
		ItemStack stack = player.getHeldItem(hand);
		
		if (!world.isRemote)
		{
	        player.setHealth(player.getMaxHealth());
	        player.getFoodStats().setFoodLevel(20);

	        player.sendStatusMessage((new TranslationTextComponent("item.powder_power.token_healing.line2").mergeStyle(TextFormatting.BOLD)), true);
	        
	        double chance = random.nextDouble();
	    	
	        if(chance <= .05)
	        {
		        ItemStack gift = null;
		        gift = new ItemStack(ItemInit.SWORD_REDIUM.get());
		        gift.setCount(1);
		        gift.addEnchantment(Enchantments.SHARPNESS, 5);
		        gift.addEnchantment(Enchantments.SWEEPING, 5);
		        gift.addEnchantment(Enchantments.LOOTING, 5);
		        gift.setDisplayName(new StringTextComponent("Redium Vengeance"));
		        
		        BlockPos playerPos = player.getPosition();
				player.world.addEntity(new ItemEntity(player.world, playerPos.getX(), playerPos.getY(), playerPos.getZ(), gift));	        	
	        }
	        
	        if (!player.abilities.isCreativeMode) {
	           stack.shrink(1);
	        }
		}
        
        return new ActionResult<ItemStack>(ActionResultType.SUCCESS, stack);
	}
	
	@OnlyIn(Dist.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn)
	{
		super.addInformation(stack, worldIn, tooltip, flagIn);
		tooltip.add((new TranslationTextComponent("item.powder_power.token_healing.line1").mergeStyle(TextFormatting.GREEN)));	
	}
}
