package com.javamakeuse.datafilter;

import java.util.List;

import org.hibernate.Filter;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class MovieMain {
	public static void main(String[] args) {
		Session session = buildSessionFactory().openSession();

		session.beginTransaction();

		Filter filter = session.enableFilter("movieFilter");
		filter.setParameter("yearParam", "2014");

		Query query = session.createQuery("from Movie");
		List<Movie> movieList = query.list();

		for (Movie movie : movieList) {
			System.out.println(movie);
		}

		session.getTransaction().commit();
	}

	private static SessionFactory buildSessionFactory() {
		Configuration configuration = new Configuration();
		configuration.configure();

		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties()).build();
		SessionFactory sessionFactory = configuration
				.buildSessionFactory(serviceRegistry);
		return sessionFactory;
	}
}
