package kr.co.tjeit.facebookcopy.data;

/**
 * Created by tjoeun on 2017-08-04.
 */

public class NewSpeedData {
    private String linkUtl;
    private String userImagePath;
    private int minuteAgo;
    private String contentText;
    private int likeCount;

    public NewSpeedData() {
    }

    public NewSpeedData(String linkUtl, String userImagePath, int minuteAgo, String contentText, int likeCount) {
        this.linkUtl = linkUtl;
        this.userImagePath = userImagePath;
        this.minuteAgo = minuteAgo;
        this.contentText = contentText;
        this.likeCount = likeCount;
    }

    public String getLinkUtl() {
        return linkUtl;
    }

    public void setLinkUtl(String linkUtl) {
        this.linkUtl = linkUtl;
    }

    public String getUserImagePath() {
        return userImagePath;
    }

    public void setUserImagePath(String userImagePath) {
        this.userImagePath = userImagePath;
    }

    public int getMinuteAgo() {
        return minuteAgo;
    }

    public void setMinuteAgo(int minuteAgo) {
        this.minuteAgo = minuteAgo;
    }

    public String getContentText() {
        return contentText;
    }

    public void setContentText(String contentText) {
        this.contentText = contentText;
    }

    public int getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }
}
