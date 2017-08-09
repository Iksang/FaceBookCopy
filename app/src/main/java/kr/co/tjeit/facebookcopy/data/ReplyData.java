package kr.co.tjeit.facebookcopy.data;

import java.util.Calendar;

/**
 * Created by tjoeun on 2017-08-09.
 */

public class ReplyData {
    private int replyId;
    private int parentReplyId;
    // 0이면 그냥 댓글, 1~ 그 외 : 대댓글.


    private String writerName;
    private String replyContent;
    private Calendar createAt;

    public ReplyData() {
    }

    public ReplyData(int replyId, int parentReplyId, String writerName, String replyContent, Calendar createAt) {
        this.replyId = replyId;
        this.parentReplyId = parentReplyId;
        this.writerName = writerName;
        this.replyContent = replyContent;
        this.createAt = createAt;
    }

    public int getReplyId() {
        return replyId;
    }

    public void setReplyId(int replyId) {
        this.replyId = replyId;
    }

    public int getParentReplyId() {
        return parentReplyId;
    }

    public void setParentReplyId(int parentReplyId) {
        this.parentReplyId = parentReplyId;
    }

    public String getWriterName() {
        return writerName;
    }

    public void setWriterName(String writerName) {
        this.writerName = writerName;
    }

    public String getReplyContent() {
        return replyContent;
    }

    public void setReplyContent(String replyContent) {
        this.replyContent = replyContent;
    }

    public Calendar getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Calendar createAt) {
        this.createAt = createAt;
    }
}
