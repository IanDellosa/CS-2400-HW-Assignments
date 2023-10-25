package Problem1;
/**
 * An implementation of a profile on a simple social network.
 */
public class Profile {
	private Name name;
	private String status;
	private AList<Profile> friends;

	public Profile() {
		this.name = new Name("", "");
		this.status = "";
		this.friends = new AList<>();
	}

	/**
	 * Returns the name associated with the profile.
	 * 
	 * @return The profile's name.
	 */
	public Name getName() {
		return this.name;
	}

	/**
	 * Sets the name associated with the profile to the given first and last name.
	 * 
	 * @param first The first name for the profile.
	 * @param last  The last name for the profile.
	 */
	public void setName(String first, String last) {
		this.name = new Name(first, last);
	}

	/**
	 * Sets the name associated with the profile to the given name.
	 * 
	 * @param name The name for the profile.
	 */
	public void setName(Name name) {
		this.name = name;
	}

	/**
	 * Sets the current status of the profile to the given string.
	 * 
	 * @param stat The new status for the profile.
	 */
	public void setStatus(String stat) {
		this.status = stat;
	}

	/**
	 * Returns the status associated with the profile.
	 * 
	 * @return The profile's status.
	 */
	public String getStatus() {
		return this.status;
	}

	/**
	 * Returns a list of all the profile's friends on the social network.
	 * 
	 * @return The list of friends.
	 */
	public AList<Profile> getFriends() {
		return this.friends;
	}

	/**
	 * Adds a friend to the profile's list of friends.
	 * 
	 * @param p The profile to be added to the list.
	 */
	public void addFriend(Profile p) {
		friends.add(p);
	}

	/**
	 * Removes a friend from the profile's list of friends.
	 * 
	 * @param p The profile to be removed from the list.
	 */
	public void removeFriend(Profile p) {
		friends.remove(friends.getIndexOf(p));
	}

	public String toString() {
		return "Name: " + getName() + "\nStatus: " + getStatus() +
				"\n# of friends: " + this.friends.getLength() + "\n";
	}

	/** Displays the profile's information and friends. */
	public void display() {
		System.out.print(toString());
		System.out.println("Friends:");
		for (int x = 1; x <= this.friends.getLength(); x++)
			System.out.println("\t" + this.friends.getEntry(x).getName());
	}
}
