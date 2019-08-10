package arabot.wiki.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pages")
public class Page {

	@Id
	@Column(name = "page_id")
	private int pageId;

	@Column(name = "title")
	private String title;

	@Column(name = "creation_date")
	private String creationDate;

	public Page(int pageId, String title, String description) {
		super();
		this.pageId = pageId;
		this.title = title;
		this.description = description;
	}

	@Column(name = "description")
	private String description;

	public Page() {

	}

	@Override
	public String toString() {
		return "Page [pageId=" + pageId + ", title=" + title + ", creationDate=" + creationDate + ", description="
				+ description + "]";
	}

	public int getPageId() {
		return pageId;
	}

	public void setPageId(int pageId) {
		this.pageId = pageId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}