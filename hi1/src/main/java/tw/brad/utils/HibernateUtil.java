package tw.brad.utils;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static SessionFactory sessionFactory;
	private static StandardServiceRegistry registry;
	
	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			Configuration config = new Configuration();
			config.configure("hibernate.cfg.xml");
			
			registry = new StandardServiceRegistryBuilder()
							.applySettings(config.getProperties())
							.build();
			
			sessionFactory = config.buildSessionFactory(registry);
		}
		return sessionFactory;
	}
}
