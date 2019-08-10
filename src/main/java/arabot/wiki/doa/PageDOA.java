package arabot.wiki.doa;

import java.util.List;

import arabot.wiki.entity.Page;
import arabot.wiki.entity.Report;

public interface PageDOA {
	public List<Page> getPages(String keyword);

	public void savePage(Page thePage);
	
	public List<Report> getReport();
}
