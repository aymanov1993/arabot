package arabot.wiki.doa;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import arabot.wiki.entity.Page;
import arabot.wiki.entity.Report;

@Repository
public class PageDOAImpl implements PageDOA {
	// need to inject the session factory
		@Autowired
		private SessionFactory sessionFactory;
				
		public List<Page> getPages(String keyword) {
			
			// get the current hibernate session
			Session currentSession = sessionFactory.getCurrentSession();
					
			// create a query  ... sort by last name
			Query<Page> theQuery = 
					currentSession.createQuery("from Page WHERE title like concat('%',:keyword,'%') or description like concat('%',:keyword,'%') order by creationDate",
							Page.class);
			theQuery.setString("keyword", keyword);
			
			// execute query and get result list
			List<Page> customers = theQuery.getResultList();
					
			// return the results		
			return customers;
		}

		public void savePage(Page thePage) {

			// get current hibernate session
			Session currentSession = sessionFactory.getCurrentSession();
			
			currentSession.saveOrUpdate(thePage);
			
		}
		
		public List<Report> getReport(){
			// get the current hibernate session
			Session currentSession = sessionFactory.getCurrentSession();
					
			String sql = "SELECT title, SUM( LENGTH( description ) -  LENGTH( REPLACE( description, ' ', '' ) ) +1 ) as value FROM pages group by title order by value";
			SQLQuery query = currentSession.createSQLQuery(sql);
			query.addEntity(Report.class);
			List results = query.list();
			
			List <Report> report = new ArrayList<Report>();
			if (!results.isEmpty()) {
				Report ref = (Report) results.get(0);
				Report min = new Report("Min",ref.getValue());
				
				ref = (Report) results.get(results.size() / 2);
				Report mid = new Report("Mid",ref.getValue());
				mid.setTitle("Mid");
				
				ref = (Report) results.get(results.size()-1);
				Report max = new Report("Max",ref.getValue());
				max.setTitle("Max");
				
				report.add(min);
				report.add(mid);
				report.add(max);
			}
			
			return report;
		}
}
