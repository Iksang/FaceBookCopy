package kr.co.tjeit.facebookcopy.data;

/**
 * Created by tjoeun on 2017-08-08.
 */

public class FriendRequestData {

    private String imagePath;
    private int commonFreindsCount;
    private String name;

    public FriendRequestData() {
    }

    public FriendRequestData(String imagePath, int commonFreindsCount, String name) {
        this.imagePath = imagePath;
        this.commonFreindsCount = commonFreindsCount;
        this.name = name;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public int getCommonFreindsCount() {
        return commonFreindsCount;
    }

    public void setCommonFreindsCount(int commonFreindsCount) {
        this.commonFreindsCount = commonFreindsCount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
