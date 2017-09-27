package resources;

import java.io.Serializable;

/**
 * Created by Jim on 20.09.2017.
 */
public class User implements Serializable{
    private String userId;
    private String nickName;

    public User() {
    }

    public String getUserId() {
        return userId;
    }

    public String getNickName() {
        return nickName;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
}
