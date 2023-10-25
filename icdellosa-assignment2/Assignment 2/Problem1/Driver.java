package Problem1;
/**
 * A driver for the classes Profile and ProfileManager.
 * 
 * @author Jesse Grabowski
 * @author Joseph Erickson
 * @version 5.0
 */
public class Driver {
	public static void main(String[] args) {
		System.out.println("Creating profiles and adding to database.");
		ProfileManager m = new ProfileManager();

		Profile john = new Profile();
		john.setName("John", "Doe");
		john.setStatus("My name is John.");

		Profile jane = new Profile();
		jane.setName("Jane", "Doe");
		jane.setStatus("My name is Jane.");

		Profile billy = new Profile();
		billy.setName(new Name("Billy", "Bob"));
		billy.setStatus("My name is Billy Bob!");

		Profile smith = new Profile();
		smith.setName(new Name("John", "Smith"));
		smith.setStatus("My name is also John.");

		m.addProfile(john);
		m.addProfile(jane);
		m.addProfile(billy);
		m.addProfile(smith);
		m.display();

		System.out.println("-------------------------------------\n");
		System.out.println("Creating friendships.\n");

		m.createFriendship(john, jane);
		m.createFriendship(jane, billy);
		m.createFriendship(john, smith);
		m.createFriendship(smith, jane);
		m.createFriendship(billy, smith);
		m.display();

		System.out.println("-------------------------------------\n");
		System.out.println("Changing statuses / names.\n");

		smith.setStatus("Just got married!");
		jane.setStatus("Now Mrs. Smith!");
		jane.setName("Jane", "Smith");
		m.display();

		System.out.println("-------------------------------------\n");
		System.out.println("Ending a friendship.\n");
		m.endFriendship(john, billy);
		m.display();

		System.out.println("-------------------------------------\n");
		System.out.println("Removing John.\n");
		m.removeProfile(john);
		m.display();
	}
} 

/*
Creating profiles and adding to database.
Name: John Doe
Status: My name is John.
# of friends: 0
Friends:

Name: Jane Doe
Status: My name is Jane.
# of friends: 0
Friends:

Name: Billy Bob
Status: My name is Billy Bob!
# of friends: 0
Friends:

Name: John Smith
Status: My name is also John.
# of friends: 0
Friends:

-------------------------------------

Creating friendships.

Name: John Doe
Status: My name is John.
# of friends: 2
Friends:
        Jane Doe
        John Smith

Name: Jane Doe
Status: My name is Jane.
# of friends: 3
Friends:
        John Doe
        Billy Bob
        John Smith

Name: Billy Bob
Status: My name is Billy Bob!
# of friends: 2
Friends:
        Jane Doe
        John Smith

Name: John Smith
Status: My name is also John.
# of friends: 3
Friends:
        John Doe
        Jane Doe
        Billy Bob

-------------------------------------

Changing statuses / names.

Name: John Doe
Status: My name is John.
# of friends: 2
Friends:
        Jane Smith
        John Smith

Name: Jane Smith
Status: Now Mrs. Smith!
# of friends: 3
Friends:
        John Doe
        Billy Bob
        John Smith

Name: Billy Bob
Status: My name is Billy Bob!
# of friends: 2
Friends:
        Jane Smith
        John Smith

Name: John Smith
Status: Just got married!
# of friends: 3
Friends:
        John Doe
        Jane Smith
        Billy Bob

-------------------------------------

Ending a friendship.

Name: John Doe
Status: My name is John.
# of friends: 2
Friends:
        Jane Smith
        John Smith

Name: Jane Smith
Status: Now Mrs. Smith!
# of friends: 3
Friends:
        John Doe
        Billy Bob
        John Smith

Name: Billy Bob
Status: My name is Billy Bob!
# of friends: 2
Friends:
        Jane Smith
        John Smith

Name: John Smith
Status: Just got married!
# of friends: 3
Friends:
        John Doe
        Jane Smith
        Billy Bob

-------------------------------------

Removing John.

Name: Jane Smith
Status: Now Mrs. Smith!
# of friends: 2
Friends:
        Billy Bob
        John Smith

Name: Billy Bob
Status: My name is Billy Bob!
# of friends: 2
Friends:
        Jane Smith
        John Smith

Name: John Smith
Status: Just got married!
# of friends: 2
Friends:
        Jane Smith
        Billy Bob
 */
