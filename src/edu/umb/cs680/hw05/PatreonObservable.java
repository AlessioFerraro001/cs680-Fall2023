package edu.umb.cs680.hw05;

public class PatreonObservable extends Observable<PatreonPost>{
	public void makePost(String message, int tier) {
		notifyObservers(new PatreonPost(message, tier));
	}
}