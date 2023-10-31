package edu.umb.cs680.hw05;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class PatreonTest {
	private String testMessage = "Hello to all of my patrons! I've been working on something special. "
			+ "Here is the link to the work-in-progress to my next piece: (link).";
	private String testMessageCropped = testMessage.split("\\.|\\?|\\!")[0];

	@Test 
	public void tier1SubTier1Message() {
		PatreonObservable testPatreon = new PatreonObservable();
		PatronObserverTier1 tier1Test = new PatronObserverTier1(testPatreon);
		
		
		testPatreon.makePost(testMessage, 1);
		assertEquals(tier1Test.readLastMessage(), testMessage);
	}
	
	@Test
	public void tier2SubTier1Message() {
		PatreonObservable testPatreon = new PatreonObservable();
		PatronObserverTier2 tier2Test = new PatronObserverTier2(testPatreon);
		
		testPatreon.makePost(testMessage, 1);
		assertEquals(tier2Test.readLastMessage(), testMessage);
	}

	@Test 
	public void tier3SubTier3Message() {
		PatreonObservable testPatreon = new PatreonObservable();
		PatronObserverTier3 tier3Test = new PatronObserverTier3(testPatreon);
		
		
		testPatreon.makePost(testMessage, 3);
		assertEquals(tier3Test.readLastMessage(), testMessage);
	}
	
	@Test
	public void tier1SubTier3Message() {
		PatreonObservable testPatreon = new PatreonObservable();
		PatronObserverTier1 tier1Test = new PatronObserverTier1(testPatreon);
		
		testPatreon.makePost(testMessage, 3);
		assertEquals(tier1Test.readLastMessage(), testMessageCropped + "... [This post is locked to Tier 3 or higher patrons. "
				+ "Increase your patron to tier 3 or higher to read the rest of this message.");
	}

	@Test
	public void tierWrong() {
		PatreonObservable testPatreon = new PatreonObservable();
		PatronObserverTier1 tier1Test = new PatronObserverTier1(testPatreon);
		
		try {
			testPatreon.makePost(testMessage, 5);
		}
		catch(RuntimeException ex) {
			assertEquals("Invalid post tier number given: 5. Post tier must be 1, 2, or 3.", ex.getMessage());
		}
	}
	
}
