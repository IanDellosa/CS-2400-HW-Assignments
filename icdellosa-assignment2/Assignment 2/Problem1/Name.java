package Problem1;

public class Name {
    private String fName;
    private String lName;

    public Name(String first, String last) {
        fName = first;
        lName = last;
    }

    @Override
    public String toString() {
        return fName + " " + lName;
    }
}
