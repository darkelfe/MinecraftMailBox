package com.darkelfe14728.mailbox.registry;

import java.util.List;

import com.darkelfe14728.mailbox.item.craft.Craftable;
import com.darkelfe14728.mailbox.item.craft.CraftingRecipe;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

/**
 * @author Julien Rosset
 *
 * Registry for items
 */
public final class ItemRegistry
{
	/**
	 * List of registered items.
	 */
	public static List<Item> items;
	
	/**
	 * Initialize items list to register.
	 */
	public static final void init ()
	{
		
	}
	
	/**
	 * Process items registering.
	 */
	public static final void register ()
	{
		for(Item item : items)
		{
			GameRegistry.registerItem(item, item.getUnlocalizedName());
		}
	}
	/**
	 * Process items recipes registering.
	 */
	public static final void registerRecipes ()
	{
		for(Item item : items)
		{
			Craftable crafts = (Craftable)item;
			if(crafts == null)
				continue;
			
			for(CraftingRecipe craft : crafts.recipes())
			{
				if(!craft.isOk())
					continue;
				
				ItemStack result = craft.getItemStack(item);
				switch(craft.getType())
				{
					case SHAPED:
						GameRegistry.addShapedRecipe(result, craft.getData());
						break;
						
					case SHAPELESS:
						GameRegistry.addShapelessRecipe(result, craft.getData());
						break;
						
					default:
						break;
				}
			}
		}
	}
}
