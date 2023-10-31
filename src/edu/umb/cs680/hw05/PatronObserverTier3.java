package edu.umb.cs680.hw05;

public class PatronObserverTier3 implements Observer<PatreonPost>{
	private PatreonObservable subscribedTo;
	private String lastMessage;
	
	public PatronObserverTier3(PatreonObservable patreon) {
		this.subscribedTo = patreon;
		this.subscribedTo.addObserver(this);
	}
	
	@Override public void update(Observable<PatreonPost> sender, PatreonPost post) {
		this.lastMessage = post.getMessage();
	}
	
	public String readLastMessage() {
		return this.lastMessage;
	}  
}