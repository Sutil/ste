package br.com.ste.config.root;

import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import br.com.ste.app.conteudo.Conteudo;
import br.com.ste.app.topico.Topico;

@EnableJpaRepositories(basePackageClasses = { Topico.class, Conteudo.class })
@EnableTransactionManagement(proxyTargetClass = true)
@Configuration
public class RepositoryConfig {

	@Autowired
	private EntityManagerFactory entityManagerFactory;

	@Bean
	public PlatformTransactionManager transactionManager() {
		return new JpaTransactionManager(entityManagerFactory);
	}

}
