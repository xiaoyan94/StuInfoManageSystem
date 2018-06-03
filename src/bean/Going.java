package bean;

import java.util.Set;

public class Going {
	//去向
	private Long id;
	private String name;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	private Set<GoingRecord> goingRecords;
	public Set<GoingRecord> getGoingRecords() {
		return goingRecords;
	}
	public void setGoingRecords(Set<GoingRecord> goingRecords) {
		this.goingRecords = goingRecords;
	}

	
}
