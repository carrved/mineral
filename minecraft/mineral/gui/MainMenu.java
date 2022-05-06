package mineral.gui;

import java.io.IOException;

import org.lwjgl.opengl.GL11;

import mineral.Client;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiMultiplayer;
import net.minecraft.client.gui.GuiOptions;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiSelectWorld;
import net.minecraft.util.ResourceLocation;

public class MainMenu extends GuiScreen {
	
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		GL11.glColor4f(1, 1, 1, 1);
		mc.getTextureManager().bindTexture(new ResourceLocation("mineral/splash.png"));
		this.drawModalRectWithCustomSizedTexture(0, 0, 0, 0, this.width, this.height, this.width, this.height);
		mc.getTextureManager().bindTexture(new ResourceLocation("mineral/logo.png"));
		super.drawScreen(mouseX, mouseY, partialTicks);
	}
	
	@Override
	public void initGui() {
		Client.getInstance().getDiscordRP().update("Idle", "In Main Menu");
		
		this.buttonList.add(new GuiButton(1, 10, height / 2 - 40, "Test Worlds"));
		this.buttonList.add(new GuiButton(2, 10, height / 2 - 15, "Servers"));
		this.buttonList.add(new GuiButton(3, 10, height / 2 + 10, "Tweaks"));
		this.buttonList.add(new GuiButton(4, 10, height / 2 + 35, "Rage Quit"));
		super.initGui();
	}
	
	@Override
	protected void actionPerformed(GuiButton button) throws IOException {
		
		if(button.id == 1) {
			mc.displayGuiScreen(new GuiSelectWorld(this));
		}
		
		if(button.id == 2) {
			mc.displayGuiScreen(new GuiMultiplayer(this));
		}
		
		if(button.id == 3) {
			mc.displayGuiScreen(new GuiOptions(this, mc.gameSettings));
		}
		
		if(button.id == 4) {
			mc.shutdown();
		}
		
		super.actionPerformed(button);
		
	}
}
