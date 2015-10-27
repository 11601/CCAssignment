import java.util.List;
import java.util.Map;

/**
 * Created by Hakim on 10/23/15.
 */
class User{
    String name;
    int id;
    SubscriptionType subscriptionType;
    Book activeBook;

}

enum SubscriptionType{
    BASIC, PREMIUM
}

class Book{
    private String title;
    private int id;
    private LicenseType licenseType;

    public void updateLicenseType(){};

}

class Library{
    private List<Book> books;

    public void addBook(){};
    public void removeBook(){};
    public boolean searchBookByTitle(String title){};

}

enum LicenseType{
    // class type and maximum number of users who can access
    // a book that has this license at a time

}

class OnlineBookReader{
    private Map<Book, List<User>> activeUsers;
    private Library bookStore;
    private List<User> users;

    // manage users
    public void addUser(){};
    public void removeUser(){};

    // manage display
    public void displayBook(User user, Book book){};
    public void displayPage(User user, int pageNum){};
    public void turnPageUp(User user){};
    public void turnPageDown(User user){};

}



public class Solution05 {
}
