package com.cicada3301.verysimplecommands.commands;

import com.cicada3301.verysimplecommands.util.Reference;
import com.google.common.collect.Lists;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;

import java.util.List;

public class CommandGodmode extends CommandBase {

    private final List<String> aliases = Lists.newArrayList(Reference.MODID,"gm", "god", "godmod", "godmode");

    @Override
    public String getName() {
        return "godmod";
    }

    @Override
    public String getUsage(ICommandSender sender) {
        return null;
    }

    @Override
    public List<String> getAliases() {
       return aliases;
    }

    @Override
    public boolean checkPermission(MinecraftServer server, ICommandSender sender) {
        return true;
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
        if(sender instanceof EntityPlayer)
        {
            if(((EntityPlayer) sender).capabilities.isCreativeMode)
            {
                sender.sendMessage(new TextComponentString(TextFormatting.RED + "Player in Creative mode") {
                });
            } else {
                if (!((EntityPlayer) sender).capabilities.disableDamage) {
                    ((EntityPlayer) sender).capabilities.disableDamage = true;
                    sender.sendMessage(new TextComponentString("Godmode is " + TextFormatting.GREEN + "Enabled"));
                } else {
                    ((EntityPlayer) sender).capabilities.disableDamage = false;
                    sender.sendMessage(new TextComponentString("Godmode is " + TextFormatting.RED + "Disabled"));
                }
            }
        }
    }
}
