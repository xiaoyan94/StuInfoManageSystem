package bean;

import java.sql.Timestamp;

public class Notice {
	private Long id;
	private String title;
	private String content;
	private Timestamp time;
	private Admin admin;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Timestamp getTime() {
		return time;
	}
	public void setTime(Timestamp time) {
		this.time = time;
	}
	public Admin getAdmin() {
		return admin;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	public Notice(Long id, String title, String content, Timestamp time, Admin admin) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.time = time;
		this.admin = admin;
	}
	
}
