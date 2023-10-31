package edu.umb.cs680.hw04;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class VideoPlayerTest{
	@Test
	public void firstScene() {
		VideoPlayer player = new VideoPlayer();
		assertEquals("The video has resumed.\nOrdinary World", player.pressPlayPause());
	}
	
	@Test
	public void sleep() {
		VideoPlayer player = new VideoPlayer();
		player.pressPlayPause();
		player.pressPlayPause();
		player.watch();
		assertEquals("The player is aleep and there is only a black screen.", player.watch());
	}
	
	@Test
	public void fullViewing() {
		VideoPlayer player = new VideoPlayer();
		player.pressPlayPause();
		for (int i = 0; i < 13; i++) {
			player.watch();
		}
		assertEquals("The player has been awoken and the video has resumed.\nOrdinary World", player.pressPlayPause());
	}
	
	@Test 
	public void fullViewingSpamPause() {
		VideoPlayer player = new VideoPlayer();
		for (int i = 0; i < 25; i++) {
			player.pressPlayPause();
		}
		assertEquals("The movie has been started again.\nOrdinary World", player.pressPlayPause());
	}
	
	@Test void waitForever() {
		VideoPlayer player = new VideoPlayer();
		player.pressPlayPause();
		player.pressPlayPause();
		for (int i = 0; i < 10; i++) {
			player.watch();
		}
		assertEquals("The player has been awoken and the video has resumed.\nCall to Adventure", player.pressPlayPause());
	}
}