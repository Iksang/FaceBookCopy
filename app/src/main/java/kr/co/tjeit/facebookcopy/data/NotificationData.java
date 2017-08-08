package kr.co.tjeit.facebookcopy.data;

/**
 * Created by tjoeun on 2017-08-08.
 */

public class NotificationData {

    private String imagePath;
    private String notificationText;
    private int notificationType; // 1 : ~~가 댓글을 남겼습니다.
    // 2 : ~가 내 글을 좋아합니다.
    private int minuteAgo;
//    private Calendar createAt; // 실제로는 이게 더 적합함.
    // 2분 이내 : 방금 전
    // 2~40 : ??분 전
    // 41~90분 : 한시간 전
    // 91~510분 : ??시간 전 Ex. 91~150 2시간 전, 151 ~ 210 3시간 전. => 알고리즘
    // 그 외 : 오래 전


    public NotificationData() {
    }

    public NotificationData(String imagePath, String notificationText, int notificationType, int minuteAgo) {
        this.imagePath = imagePath;
        this.notificationText = notificationText;
        this.notificationType = notificationType;
        this.minuteAgo = minuteAgo;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getNotificationText() {
        return notificationText;
    }

    public void setNotificationText(String notificationText) {
        this.notificationText = notificationText;
    }

    public int getNotificationType() {
        return notificationType;
    }

    public void setNotificationType(int notificationType) {
        this.notificationType = notificationType;
    }

    public int getMinuteAgo() {
        return minuteAgo;
    }

    public void setMinuteAgo(int minuteAgo) {
        this.minuteAgo = minuteAgo;
    }
}
