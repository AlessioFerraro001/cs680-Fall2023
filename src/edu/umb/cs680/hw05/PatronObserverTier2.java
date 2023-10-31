package edu.umb.cs680.hw05;

public class PatronObserverTier2 implements Observer<PatreonPost>{
	private PatreonObservable subscribedTo;
	private String lastMessage;
	
	public PatronObserverTier2(PatreonObservable patreon) {
		this.subscribedTo = patreon;
		this.subscribedTo.addObserver(this);
	}
	
	@Override public void update(Observable<PatreonPost> sender, PatreonPost post) {
		if (post.getTier() > 2){
			this.lastMessage = post.getMessage().split("\\.|\\?|\\!")[0] + "... [This post is locked to Tier " + post.getTier()
			+ " or higher patrons. Increase your patron to tier " + post.getTier() + " or higher to read the rest of this message.";
		}
		else {
			this.lastMessage = post.getMessage();
		}
	}
	
	public String readLastMessage() {
		return this.lastMessage;
	}
}