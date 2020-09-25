package com.kwpugh.powder_power.util;

import com.kwpugh.powder_power.PowderPower;
import com.kwpugh.powder_power.init.ItemInit;

import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.text.StringTextComponent;
import net.minecraftforge.event.AnvilUpdateEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber(modid = PowderPower.modid, bus = EventBusSubscriber.Bus.FORGE )
public class AnvilEventHandler
{
	@SubscribeEvent
	public static void upgradeSomeTools(AnvilUpdateEvent event)
	{
		ItemStack left = event.getLeft();
		ItemStack right = event.getRight();
		
		if(left.isEmpty() || right.isEmpty())
		{
			return;
		}

		if(left.getItem().equals(ItemInit.PICKAXE_OBSIDIAN.get()) && right.getItem().equals(ItemInit.BLEND_LAPIUM.get()))
		{			
			ItemStack output = new ItemStack(ItemInit.PICKAXE_OBSIDIAN.get());
			output.addEnchantment(Enchantments.SILK_TOUCH, 1);
			output.addEnchantment(Enchantments.EFFICIENCY, 3);
			output.setDisplayName(new StringTextComponent("Improved Obsidian Pickaxe"));
			event.setCost(10);
			event.setOutput(output);
		}
		
		if(left.getItem().equals(ItemInit.PICKAXE_PRISMARINE.get()) && right.getItem().equals(ItemInit.BLEND_LAPIUM.get()))
		{			
			ItemStack output = new ItemStack(ItemInit.PICKAXE_PRISMARINE.get());
			output.addEnchantment(Enchantments.FORTUNE, 3);
			output.addEnchantment(Enchantments.EFFICIENCY, 3);
			output.setDisplayName(new StringTextComponent("Improved Prismarine Pickaxe"));
			event.setCost(10);
			event.setOutput(output);
		}
		
		if(left.getItem().equals(ItemInit.DAGGER_PRISMARINE.get()) && right.getItem().equals(ItemInit.BLEND_LAPIUM.get()))
		{			
			ItemStack output = new ItemStack(ItemInit.DAGGER_PRISMARINE.get());
			output.addEnchantment(Enchantments.SHARPNESS, 3);
			output.addEnchantment(Enchantments.LOOTING, 3);
			output.setDisplayName(new StringTextComponent("Deadly Prismarine Dagger"));
			event.setCost(10);
			event.setOutput(output);
		}
		
		if(left.getItem().equals(Items.DIAMOND_SWORD) && right.getItem().equals(ItemInit.BLEND_REDIUM.get()))
		{			
			ItemStack output = new ItemStack(Items.DIAMOND_SWORD);
			output.addEnchantment(Enchantments.FIRE_ASPECT, 1);
			output.addEnchantment(Enchantments.SHARPNESS, 4);
			output.addEnchantment(Enchantments.LOOTING, 4);
			output.setDisplayName(new StringTextComponent("Deadly Diamond Sword"));
			event.setCost(20);
			event.setOutput(output);
		}
		
		if(left.getItem().equals(Items.DIAMOND_PICKAXE) && right.getItem().equals(ItemInit.BLEND_TRILIUM.get()))
		{			
			ItemStack output = new ItemStack(Items.DIAMOND_PICKAXE);
			output.addEnchantment(Enchantments.FORTUNE, 5);
			output.addEnchantment(Enchantments.EFFICIENCY, 5);
			output.setDisplayName(new StringTextComponent("Improved Diamond Pickaxe"));
			event.setCost(20);
			event.setOutput(output);
		}
		
		if(left.getItem().equals(Items.NETHERITE_SWORD) && right.getItem().equals(ItemInit.BLEND_QUADRILIUM.get()))
		{			
			ItemStack output = new ItemStack(Items.NETHERITE_SWORD);
			output.addEnchantment(Enchantments.FIRE_ASPECT, 2);
			output.addEnchantment(Enchantments.SHARPNESS, 9);
			output.addEnchantment(Enchantments.LOOTING, 5);
			output.addEnchantment(Enchantments.KNOCKBACK, 2);
			output.addEnchantment(Enchantments.BANE_OF_ARTHROPODS, 3);
			output.setDisplayName(new StringTextComponent("Deadly Quadrilirite Sword"));
			output.getOrCreateTag().putBoolean("Unbreakable", true);
			event.setCost(30);
			event.setOutput(output);
		}
	}
}
