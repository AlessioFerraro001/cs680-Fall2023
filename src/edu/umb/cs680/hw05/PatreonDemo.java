package edu.umb.cs680.hw05;

public class PatreonDemo {
	public static void main(String[] args) {
		PatreonObservable testPatreon= new PatreonObservable();
		PatronObserverTier1 tier1Test = new PatronObserverTier1(testPatreon);
		PatronObserverTier2 tier2Test = new PatronObserverTier2(testPatreon);
		PatronObserverTier3 tier3Test = new PatronObserverTier3(testPatreon);
		
		testPatreon.makePost("Testing...", 1);
		System.out.println(tier1Test.readLastMessage());
		System.out.println(tier2Test.readLastMessage());
		System.out.println(tier3Test.readLastMessage());
		
		System.out.println("\n-----------------------\n");
		
		testPatreon.makePost("This is a sentence. This is a second. This is a third.", 3);
		System.out.println(tier1Test.readLastMessage());
		System.out.println(tier2Test.readLastMessage());
		System.out.println(tier3Test.readLastMessage());
		
		/*
		System.out.println("\n-----------------------\n");
		
		testPatreon.makePost("This should break the program.", 5);
		System.out.println(tier1Test.readLastMessage());
		System.out.println(tier2Test.readLastMessage());
		System.out.println(tier3Test.readLastMessage());
		*/
	} 
}
