package com.darkelfe14728.mailbox;

import java.util.Arrays;

import com.darkelfe14728.mailbox.proxy.AbstractProxy;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.ModMetadata;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

/**
 * @author Julien Rosset
 *
 * Mod entry point
 */
@Mod(
	modid                     = MailBox.META_MOD_ID,
	name                      = MailBox.META_MOD_NAME,
	version                   = MailBox.META_VERSION,
	dependencies              = MailBox.META_DEPENDENCIES,
	acceptedMinecraftVersions = MailBox.META_MCVERSION,
	canBeDeactivated          = MailBox.META_CANBEDESACTIVATED
)
public class MailBox
{
	// Meta informations
	public static final String META_MOD_ID = "mailbox";
	public static final String META_MOD_NAME = "MailBox";
	public static final String META_VERSION = "0.0.1";
	public static final String META_DEPENDENCIES = "required-after:Forge@[10.13.4.1614,)";
	public static final String META_MCVERSION = "[1.7.10,)";
	public static final String META_DESCRIPTION = "A simply MailBox system";
	public static final String[] META_AUTHORS = { "Julien Rosset" };
	public static final String META_CREDITS = "";
	public static final boolean META_CANBEDESACTIVATED = false;
	
	/**
	 * Mod instance 
	 */
	@Instance public static MailBox instance = new MailBox();
	
	/**
	 * Proxy class
	 */
	@SidedProxy(
		clientSide = "com.darkelfe14728.mailbox.proxy.ClientProxy",
		serverSide = "com.darkelfe14728.mailbox.proxy.ServerProxy"
	)
	public static AbstractProxy proxy;
	
	/**
	 * Mod pre-initialization.
	 * 
	 * @param event		Pre-initialization event.
	 */
	@EventHandler
	public void preInit (FMLPreInitializationEvent event)
	{
		LogHelper.info("Pre-initialization");
		
		LogHelper.info("Registering mod metadata");
		ModMetadata metadata = event.getModMetadata();
		metadata.modId = META_MOD_ID;
		metadata.name = META_MOD_NAME;
		metadata.version = META_VERSION;
		metadata.description = META_DESCRIPTION;
		metadata.authorList = Arrays.asList(META_AUTHORS);
		metadata.credits = META_CREDITS;
	}
	
	/**
	 * Mod initialization.
	 * 
	 * @param event		Initialization event.
	 */
	@EventHandler
	public void init (FMLInitializationEvent event)
	{
		LogHelper.info("Initialization");
	}
	
	/**
	 * Mod post-initialization.
	 * 
	 * @param event		Post-initialization event.
	 */
	@EventHandler
	public void postInit (FMLPostInitializationEvent event)
	{
		LogHelper.info("Post-initialization");
	}
}
