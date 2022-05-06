package mineral;

import net.arikia.dev.drpc.*;
import net.arikia.dev.drpc.callbacks.ReadyCallback;

public class DiscordRP {
	
	public boolean running = true;
	private long created = 0;

	public void start() {
		this.created = System.currentTimeMillis();
		
		DiscordEventHandlers handlers = new DiscordEventHandlers.Builder().setReadyEventHandler(new ReadyCallback() {
			@Override
			public void apply(DiscordUser user) {
				System.out.println("Welcome, " + user.username + "#" + user.discriminator + "!");
				System.out.println("User ID: " + user.userId);
				update("Starting Mineral", "Mineral ver " + Client.clientVer);
			}
		}).build();
		
		DiscordRPC.discordInitialize("971528254311764059", handlers, true);
		
		new Thread("Discord RPC Callback") {
			public void run() {
				while(running) {
					DiscordRPC.discordRunCallbacks();
				}
			};
		}.start();
	}	
	
	public void shutdown() {
		running = false;
		DiscordRPC.discordShutdown();
	}
	
	public void update(String firstLine, String secondLine) {
		DiscordRichPresence.Builder b = new DiscordRichPresence.Builder(secondLine);
		b.setBigImage("logo", "Mineral ver. " + Client.clientVer);
		b.setDetails(firstLine);
		b.setStartTimestamps(created);
		
		DiscordRPC.discordUpdatePresence(b.build());
	}
}
