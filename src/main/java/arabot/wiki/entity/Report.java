package arabot.wiki.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Report {
	@Id
	@Column(name = "title")
	String title;
	@Column(name = "value")
	String value;
	
	@Override
	public String toString() {
		return "Report [title=" + title + ", value=" + value + "]";
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Report(String title, String value) {
		super();
		this.title = title;
		this.value = value;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
	public Report() {
		
	}
}
