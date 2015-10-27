import javax.jws.soap.SOAPBinding;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by Hakim on 10/24/15.
 */
// conversations stored in users' machines

enum Status{
    ONLINE, OFFLINE, AWAY, BUSY
}

class UserManager{
    private static UserManager _instance;
    private Map<String, Integer> userByName;
    private Map<Integer, String> userById;
    protected UserManager(){};
    public static UserManager getInstance(){
        if (_instance == null){
            _instance = new UserManager();
        }
        return _instance;
    }
}

class User{
    private int id;
    private String name;
    private Status status;
    private Set<User> friends;

    public void sendFriendshipRequest(User receiver){};
    public void acceptFriendshipRequest(int requestId){};
    public void rejectFriendShipRequest(int requestId){};
    public void createConversation(User other){};
    public void createConversation(Group group){};
    public void addToConversation(Conversation conversationId, User user){};
    public void signin(){};
    public void signOff(){};
    public void setStatus(){};
    public void updateFriendsList(){};

    public User(String name){};
}

class FriendshipRequest{
    private int senderId;
    private int receiverId;
    private int requestId;

    public FriendshipRequest(User sender, User receiver){};
}

class Conversation{
    private List<User> members;
    private List<Message> messages;

    public Conversation(User initiator, User other){};
    public Conversation(User initiator, Group group){};
}

class Message{
    private String content;
    private int senderId;
    private int receiverId;
    public Message(User sender, Conversation conversation, String content){};
}

class Group{
    private List<User> members;
    public Group(User admin, List<User> users){};
}

public class Solution07 {
}
