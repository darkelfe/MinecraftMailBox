package com.darkelfe14728.mailbox.item.craft;

import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;
import java.util.Map.Entry;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

/**
 * @author Julien Rosset
 *
 * One crafting recipe.
 */
public class CraftingRecipe
{
	/**
	 * @author Julien Rosset
	 *
	 * Crafting type.
	 */
	public enum CraftingType
	{
		SHAPED,
		SHAPELESS
	}
	
	/**
	 * The crafting type;
	 */
	private CraftingType type;
	
	/**
	 * The output ItemStack size (= quantity), default 1.
	 */
	private int amount   = 1;
	/**
	 * The output ItemStack metadata, default 0 (no metadata).
	 */
	private int metadata = 0;
	
	/**
	 * The crafting pattern.
	 */
	private String[] pattern;
	/**
	 * The list of materials used in pattern.
	 */
	private Hashtable<String, Object> materials;
	
	/**
	 * Create new crafting recipe.
	 * 
	 * @param type The crafting type.
	 */
	public CraftingRecipe(CraftingType type)
	{
		this.type = type;
	}
	
	public boolean isOk()
	{
		if(pattern.length == 0)
			return false;
		
		List<?> pattern_list = Arrays.asList(pattern);
		for(Entry<String, Object> material : materials.entrySet())
		{
			if(!pattern_list.contains(material.getKey()))
				return false;
			
			if(material.getValue() == null)
				return false;
		}
		
		return true;
	}
	
	public ItemStack getItemStack(Item item)
	{
		return new ItemStack(item, amount, metadata);
	}
	public Object[] getData()
	{
		List<Object> out = Arrays.asList(new Object[] {});
		
		for(String elem : pattern)
			out.add(elem);
		for(Entry<String, Object> material : materials.entrySet())
		{
			out.add(material.getKey());
			out.add(material.getValue());
		}
		
		return out.toArray(new Object[out.size()]);
	}
	
	/**
	 * @return The crafting type.
	 */
	public CraftingType getType()
	{
		return type;
	}
	
	/**
	 * @return The output ItemStack size (= quantity).
	 */
	public int getAmount()
	{		
		return amount;
	}
	/**
	 * @param amount The new output ItemStack size (= quantity).
	 */
	public void setAmount(int amount)
	{
		if(amount <= 0)
			throw new IllegalArgumentException("The ouput ItemStack size must be a positive not nul integer");
		
		this.amount = amount;
	}
	
	/**
	 * @return The output ItemStack metadata.
	 */
	public int getMetadata()
	{
		return metadata;
	}
	/**
	 * @param metadata The new output ItemStack metadata.
	 */
	public void setMetadata(int metadata) {
		this.metadata = metadata;
	}
	
	/**
	 * @return The crafting pattern.
	 */
	public String[] getPattern()
	{
		return pattern;
	}
	/**
	 * @param The new crafting pattern.
	 */
	public void setPattern(String[] pattern) 
	{
		this.pattern = pattern;
	}
	
	/**
	 * @return The list of materials used in pattern.
	 */
	public Hashtable<String, Object> getMaterials()
	{
		return materials;
	}
	/**
	 * @param materials The new list of materials used in pattern.
	 */
	public void setMaterials(Hashtable<String, Object> materials)
	{
		this.materials = materials;
	}
}
