package singlylinkedlist;

import java.util.*;

class FriendNode {
    int friendId;
    FriendNode next;

    public FriendNode(int friendId) {
        this.friendId = friendId;
        this.next = null;
    }
}

class User {
    int userId;
    String name;
    int age;
    FriendNode friendList;
    User next;

    public User(int userId, String name, int age) {
        this.userId = userId;
        this.name = name;
        this.age = age;
        this.friendList = null;
        this.next = null;
    }

    public void addFriend(int friendId) {
        if (isAlreadyFriend(friendId)) return;

        FriendNode newFriend = new FriendNode(friendId);
        newFriend.next = friendList;
        friendList = newFriend;
    }

    public void removeFriend(int friendId) {
        if (friendList == null) return;

        if (friendList.friendId == friendId) {
            friendList = friendList.next;
            return;
        }

        FriendNode temp = friendList;
        while (temp.next != null && temp.next.friendId != friendId) {
            temp = temp.next;
        }

        if (temp.next != null) {
            temp.next = temp.next.next;
        }
    }

    public boolean isAlreadyFriend(int friendId) {
        FriendNode temp = friendList;
        while (temp != null) {
            if (temp.friendId == friendId) return true;
            temp = temp.next;
        }
        return false;
    }
    public Set<Integer> getFriendSet() {
        Set<Integer> set = new HashSet<>();
        FriendNode temp = friendList;
        while (temp != null) {
            set.add(temp.friendId);
            temp = temp.next;
        }
        return set;
    }

    public void displayFriends() {
        FriendNode temp = friendList;
        if (temp == null) {
            System.out.println(name + " has no friends.");
            return;
        }

        System.out.print(name + "'s Friends (IDs): ");
        while (temp != null) {
            System.out.print(temp.friendId + " ");
            temp = temp.next;
        }
        System.out.println();
    }
    public int countFriends() {
        int count = 0;
        FriendNode temp = friendList;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }
}

class SocialNetwork {
    private User head = null;

    public void addUser(int id, String name, int age) {
        if (findUserById(id) != null) {
            System.out.println("User ID already exists.");
            return;
        }

        User newUser = new User(id, name, age);
        newUser.next = head;
        head = newUser;
    }
    public User findUserById(int id) {
        User temp = head;
        while (temp != null) {
            if (temp.userId == id) return temp;
            temp = temp.next;
        }
        return null;
    }
    public void searchUserByName(String name) {
        User temp = head;
        boolean found = false;
        while (temp != null) {
            if (temp.name.equalsIgnoreCase(name)) {
                System.out.println("Found: ID = " + temp.userId + ", Name = " + temp.name + ", Age = " + temp.age);
                found = true;
            }
            temp = temp.next;
        }
        if (!found)
            System.out.println("No user found with name: " + name);
    }
    public void addFriendConnection(int id1, int id2) {
        if (id1 == id2) {
            System.out.println("Cannot friend yourself.");
            return;
        }

        User user1 = findUserById(id1);
        User user2 = findUserById(id2);

        if (user1 == null || user2 == null) {
            System.out.println("User(s) not found.");
            return;
        }

        user1.addFriend(id2);
        user2.addFriend(id1);
        System.out.println("Friend connection added between " + user1.name + " and " + user2.name);
    }
    public void removeFriendConnection(int id1, int id2) {
        User user1 = findUserById(id1);
        User user2 = findUserById(id2);

        if (user1 == null || user2 == null) {
            System.out.println("User(s) not found.");
            return;
        }

        user1.removeFriend(id2);
        user2.removeFriend(id1);
        System.out.println("Friend connection removed between " + user1.name + " and " + user2.name);
    }
    public void displayUserFriends(int userId) {
        User user = findUserById(userId);
        if (user == null) {
            System.out.println("User not found.");
            return;
        }
        user.displayFriends();
    }
    public void findMutualFriends(int id1, int id2) {
        User u1 = findUserById(id1);
        User u2 = findUserById(id2);

        if (u1 == null || u2 == null) {
            System.out.println("User(s) not found.");
            return;
        }

        Set<Integer> set1 = u1.getFriendSet();
        Set<Integer> set2 = u2.getFriendSet();

        set1.retainAll(set2);

        if (set1.isEmpty()) {
            System.out.println("No mutual friends between " + u1.name + " and " + u2.name);
        } else {
            System.out.println("Mutual friends between " + u1.name + " and " + u2.name + ": " + set1);
        }
    }
    public void countFriendsForAll() {
        User temp = head;
        while (temp != null) {
            System.out.println(temp.name + " has " + temp.countFriends() + " friend(s).");
            temp = temp.next;
        }
    }
    public void displayAllUsers() {
        User temp = head;
        while (temp != null) {
            System.out.println("ID: " + temp.userId + ", Name: " + temp.name + ", Age: " + temp.age);
            temp = temp.next;
        }
    }
}

public class SocialMediaFriendConnections {
    public static void main(String[] args) {
        SocialNetwork network = new SocialNetwork();

        network.addUser(1, "Alice", 22);
        network.addUser(2, "Bob", 24);
        network.addUser(3, "Charlie", 20);
        network.addUser(4, "Diana", 23);

        network.displayAllUsers();

        System.out.println("\n-- Adding Friend Connections --");
        network.addFriendConnection(1, 2);
        network.addFriendConnection(1, 3);
        network.addFriendConnection(2, 3);

        System.out.println("\n-- Display Friends --");
        network.displayUserFriends(1);
        network.displayUserFriends(2);
        network.displayUserFriends(4);

        System.out.println("\n-- Find Mutual Friends --");
        network.findMutualFriends(1, 2);
        network.findMutualFriends(1, 4);

        System.out.println("\n-- Remove Friend Connection --");
        network.removeFriendConnection(1, 2);
        network.displayUserFriends(1);
        network.displayUserFriends(2);

        System.out.println("\n-- Search User --");
        network.searchUserByName("Charlie");

        System.out.println("\n-- Friend Count --");
        network.countFriendsForAll();
    }
}


