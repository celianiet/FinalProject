package Entities;

public class User {
    private int userId;
    private String userName;
    private String password;
    private int totalPoints;

    public User(int userId, String userName, String password, int totalPoints) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.totalPoints = totalPoints;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getTotalPoints() {
        return totalPoints;
    }

    public void setTotalPoints(int totalPoints) {
        this.totalPoints = totalPoints;
    }
}



