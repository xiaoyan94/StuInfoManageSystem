package bean;
//留言回复

import java.sql.Timestamp;

public class Reply {
	private Long replyId;
	private Timestamp replyTime;
	private Admin replyAdmin;//回复管理员
	public Long getReplyId() {
		return replyId;
	}
	public void setReplyId(Long replyId) {
		this.replyId = replyId;
	}
	public Timestamp getReplyTime() {
		return replyTime;
	}
	public void setReplyTime(Timestamp replyTime) {
		this.replyTime = replyTime;
	}
	public Admin getReplyAdmin() {
		return replyAdmin;
	}
	public void setReplyAdmin(Admin replyAdmin) {
		this.replyAdmin = replyAdmin;
	}
	
}
