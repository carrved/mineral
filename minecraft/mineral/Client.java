package mineral;

import org.lwjgl.opengl.Display;

import mineral.gui.SplashProgress;
import mineral.gui.UnicodeFontRenderer;
import net.minecraft.util.ResourceLocation;

public class Client {
	//set name vars
	public static String clientName = "Mineral";
	public static String clientVer = "Indev";
	public static String clientCreator = "Zaxify";
	private static final Client INSTANCE = new Client();
	public static final Client getInstance() { return INSTANCE; }
	public static ResourceLocation mmBg = new ResourceLocation("mineral/splash.png");
	public static UnicodeFontRenderer ufr;
	
	private DiscordRP discordRP = new DiscordRP();
	
	//init client var
	public static Client client = new Client();
	
	//start class
	public void StartClient() {
		SplashProgress.setProgress(1, "Mineral - Setting user session");
		SessionChanger.getInstance().setUserOffline("z4x");
		SplashProgress.setProgress(2, "Mineral - Setting display title");
		Display.setTitle("MC 1.8.8 | " + clientName + " " + clientVer);
		SplashProgress.setProgress(3, "Mineral - Initializing Discord RPC");
		discordRP.start();
	}
	
	public void ShutdownClient() {
		discordRP.shutdown();
	}
	
	public DiscordRP getDiscordRP() {
		return discordRP;
	}
}
