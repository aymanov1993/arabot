package arabot.wiki.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import arabot.wiki.doa.PageDOA;
import arabot.wiki.entity.Page;
import arabot.wiki.entity.Report;

@Service
public class PageServiceImpl implements PageService {
	@Autowired
	private PageDOA pageDOA;

	@Transactional
	public List<Page> getPage(String keyword) {
		return pageDOA.getPages(keyword);
	}

	@Transactional
	public void savePage(Page thePage) {
		
		pageDOA.savePage(thePage);
	}
	
	@Transactional
	public List<Report> getReport() {
		
		return pageDOA.getReport();
	}

}
