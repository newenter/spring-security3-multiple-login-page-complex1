package src.org.lhp.system.common.dao;

import java.io.Serializable;

import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactoryBean;
import org.springframework.data.repository.core.RepositoryMetadata;
import org.springframework.data.repository.core.support.RepositoryFactorySupport;

public class CustomRepositoryFactory<T extends JpaRepository<S, ID>, S,ID extends Serializable> extends JpaRepositoryFactoryBean<T, S, ID> {
	protected RepositoryFactorySupport getRepositoryFactory(EntityManager em) {
		return new MyRepositoryFactory(em);
	} 
	public CustomRepositoryFactory(){}
	@Override
	protected RepositoryFactorySupport createRepositoryFactory(
		EntityManager entityManager) {
		return new MyRepositoryFactory(entityManager);
	}
	private static class MyRepositoryFactory extends JpaRepositoryFactory {

	  private EntityManager em;

	public MyRepositoryFactory(EntityManager entityManager) {
		  super(entityManager);
		  this.em = entityManager;
	  }
	  
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	protected Object getTargetRepository(RepositoryMetadata metadata) {

		return new CustomRepositoryImpl (metadata.getDomainClass(), this.em);
	}

	@Override
	protected Class<?> getRepositoryBaseClass(RepositoryMetadata metadata) {
		return CustomRepositoryImpl.class;
	}

 }

}
