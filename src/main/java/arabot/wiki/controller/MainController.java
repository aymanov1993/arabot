package arabot.wiki.controller;

import java.util.List;

import org.jsoup.Jsoup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;

import arabot.wiki.entity.GeoSearchResponse;
import arabot.wiki.entity.Geosearch;
import arabot.wiki.entity.Page;
import arabot.wiki.entity.Report;
import arabot.wiki.service.PageService;

@RestController
@RequestMapping("/")
public class MainController {
	@Autowired
	private PageService pageService;

	@GetMapping("/fill")
	public String fill() {
		String uri = "https://en.wikipedia.org/w/api.php?action=query&format=json&list=geosearch&gscoord=31.9539|35.9106&gsradius=10000&gslimit=1000";

		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.getForObject(uri, String.class);

		GeoSearchResponse data = new GeoSearchResponse();
		Gson gson = new Gson();
		data = gson.fromJson(result, GeoSearchResponse.class);
		// now you have Pojo do whatever

		for (Geosearch geosearch : data.getQuery().getGeosearch()) {
			try {
				uri = "https://en.wikipedia.org/wiki/" + geosearch.getTitle();

				restTemplate = new RestTemplate();
				result = restTemplate.getForObject(uri, String.class);

				pageService.savePage(new Page(Integer.parseInt(geosearch.getPageid()), geosearch.getTitle(),
						Jsoup.parse(result).text()));
			} catch (Exception e) {
				continue;
			}
		}

		return "filled";
	}

	@GetMapping("/pages")
	public List<Page> search(@RequestParam(name = "keyword") String keyword) {
		return pageService.getPage(keyword);
	}

	@GetMapping("/report")
	public List<Report> report() {
		return pageService.getReport();
	}
}