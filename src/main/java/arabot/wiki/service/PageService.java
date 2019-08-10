package arabot.wiki.service;

import java.util.List;

import arabot.wiki.entity.Page;
import arabot.wiki.entity.Report;

public interface PageService {
	public List<Page> getPage(String keyword);

	public void savePage(Page thePage);
	
	public List<Report> getReport();
}
