package com.rizomm.carpooling.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.rizomm.carpooling.model.Membre;
import com.rizomm.carpooling.model.Reservation;

//informer que le bean sert à la configuration de spring
@Configuration
//importer un fichier 
@PropertySource("classpath:com/rizomm/carpooling/config/properties/data/hibernate.properties")
// activer l’utilisation des annotations @Transactional
@EnableTransactionManagement 
public class HibernateConfig {
	// ajouter une dépendance
	@Autowired private Environment env;

	private Properties getHibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
		properties.put("hibernate.dialect", env.getProperty("hibernate.dialect"));
		properties.put("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
		return properties;
	}

	// définir un bean spring
	@Autowired
	@Bean(name = "sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource) {
		LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
		// ajouter les properties 
		sessionBuilder.addProperties(getHibernateProperties());
		// ajouter les dépendances aux classes persistantes
		sessionBuilder.addAnnotatedClasses(Membre.class);
		sessionBuilder.addAnnotatedClasses(Reservation.class);
		return sessionBuilder.buildSessionFactory();
	}

	// définir un bean spring
	@Autowired
	@Bean(name = "transactionManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
		return transactionManager;
	}
}
