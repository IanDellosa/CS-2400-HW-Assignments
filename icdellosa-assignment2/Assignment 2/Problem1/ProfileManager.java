package Problem1;

/**
 * An implementation of a profile manager on a simple social network.
 */
public class ProfileManager {
	private AList<Profile> profiles;

	/** Constructor for an instance of a profile manager. */
	public ProfileManager() {
		profiles = new AList<>();
	}

	/**
	 * Adds a profile onto the social network.
	 * 
	 * @param p The profile to be added to the network.
	 */
	public void addProfile(Profile p) {
		profiles.add(p);
	}

	/**
	 * Removes a profile from the social network.
	 * 
	 * @param p The profile to be removed from the network.
	 */
	public void removeProfile(Profile p) {
		// Maybe use a for each loop?
		// TODO
		// Check if p is in Profiles
		// get entry
//		Object[] arr = p.getFriends().toArray();
//		Profile[] friends = (Profile[]) arr;

		if (profiles.contains(p)) {
			for (int i = 0; i <= profiles.getLength(); i++) {
				Profile profile = profiles.getEntry(i);
				endFriendship(p, profile);
			}
			profiles.remove(profiles.getIndexOf(p));
		}
	}

	/**
	 * Created a friendship between two profiles on the social network.
	 * 
	 * @param a The first profile in the friendship.
	 * @param b The second profile in the friendship.
	 */
	public void createFriendship(Profile a, Profile b) {
		a.addFriend(b);
		b.addFriend(a);
	}

	/**
	 * Ends a friendship between two profiles on the social network.
	 * 
	 * @param a The first profile in the friendship.
	 * @param b The second profile in the friendship.
	 */
	public void endFriendship(Profile a, Profile b) {
		a.removeFriend(b);
		b.removeFriend(a);
	}

	/** Displays each profile's information and friends. */
	public void display() {
		for (int i = 1; i <= profiles.getLength(); i++) {
			profiles.getEntry(i).display();
			System.out.println();
		}
	}
}
