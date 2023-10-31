package edu.umb.cs680.hw04;

interface PlayerState{
	public String pressPlayPause(VideoPlayer player);
	public String watch(VideoPlayer player);
}

class VideoPlayer {
	private PlayerState currentState;
	private String[] herosJourney = {
			"Ordinary World",
			"Call to Adventure",
			"Refusal to Call",
			"Meet the Mentor",
			"Cross the First Threshold",
			"Test, Allies, Enemies",
			"Innermost Cave",
			"Ordeal",
			"Reward",
			"The Road Back",
			"Resurection",
			"Return with the Elixer"
	};
	private int storyStep;
	
	public VideoPlayer() {
		this.currentState = new VideoPaused();
		this.storyStep = 0;
	}
	
	public void setState(PlayerState newState) {
		this.currentState = newState;
	}
	
	public String pressPlayPause() {
		return currentState.pressPlayPause(this);
	}
	
	public String watch() {
		return(currentState.watch(this));
	}
	
	public String watchMovie() {
		if (this.storyStep >= this.herosJourney.length) {
			this.storyStep = 0;
			this.currentState = new VideoOver();
			return("The movie is over, press play again to rewatch from the start.");
		}
		else {
			return herosJourney[this.storyStep++];
		}
	}
	
	public static void main(String[] args) {
		VideoPlayer player = new VideoPlayer();
		System.out.println(player.pressPlayPause());
		
		for (int i = 0; i < 13; i++) {
			System.out.println(player.watch());
		}
		
		System.out.println(player.pressPlayPause());
		
		for (int i = 0; i < 12; i++) {
			System.out.println(player.watch());
		}
	}
}

class VideoPaused implements PlayerState{
	@Override public String pressPlayPause(VideoPlayer player) {
		player.setState(new VideoPlaying());
		return("The video has resumed.\n" + player.watchMovie());
	}
	
	@Override public String watch(VideoPlayer player) {
		player.setState(new Sleeping());
		return("The movie player has fallen aleep due to inactivity.");
	}
}

class VideoPlaying implements PlayerState{
	@Override public String pressPlayPause(VideoPlayer player) {
		player.setState(new VideoPaused());
		return("The movie has been paused.");
	}
	
	@Override public String watch(VideoPlayer player) {
		return(player.watchMovie());
	}
}

class Sleeping implements PlayerState{
	@Override public String pressPlayPause(VideoPlayer player) {
		player.setState(new VideoPlaying());
		return("The player has been awoken and the video has resumed.\n" + player.watchMovie());
	}
	
	@Override public String watch(VideoPlayer player) {
		return("The player is aleep and there is only a black screen.");
	}
}

class VideoOver implements PlayerState{
	@Override public String pressPlayPause(VideoPlayer player) {
		player.setState(new VideoPlaying());
		return("The movie has been started again.\n" + player.watchMovie());
	}
	
	@Override public String watch(VideoPlayer player) {
		player.setState(new Sleeping());
		return("As there is nothing more to see, the player has fallen asleep. Reawake the player to start the movie again.");
	}
}
