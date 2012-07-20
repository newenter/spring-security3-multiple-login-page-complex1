package src.org.lhp.system.common.dao;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Map;
import java.util.Map.Entry;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.apache.commons.lang.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import src.org.lhp.system.common.domain.BaseEntity;

@NoRepositoryBean
public class CustomRepositoryImpl <T extends BaseEntity, ID extends Serializable> extends SimpleJpaRepository<T, ID>  implements CustomRepository<T, ID> {
	private EntityManager em;
	public CustomRepositoryImpl(Class<T> domainClass, EntityManager em) {
		super(domainClass, em);
		this.em=em;
	}
	
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Page<?> findBySQL(String sql, Map<String, Object> param,Class<?> clazz, Pageable page) {
		Query totalQuery = em.createNativeQuery(getCountQueryString(sql));
		this.initParam(totalQuery, param);
		BigInteger total = (BigInteger) totalQuery.getSingleResult();
		//
		Query query = em.createNativeQuery(sql, clazz);
		this.initParam(query, param);
		this.setPage(query, page);
		//
		return  new PageImpl(query.getResultList(), page, total.longValue());
	}




	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Page<?> findByHQL(String hql,String totalHql, Map<String, Object> param,Class<?> clazz, Pageable page) {
		BigInteger total = null;
		if(StringUtils.isNotEmpty(totalHql)){
			Query totalQuery = em.createQuery(totalHql);
			this.initParam(totalQuery, param);
			total = (BigInteger) totalQuery.getSingleResult();
		}
		//
		Query query = em.createQuery(hql, clazz);
		this.initParam(query, param);
		this.setPage(query, page);
		//
		return  new PageImpl(query.getResultList(), page, total.longValue());
	} 
	
	private String getCountQueryString(String sql) {

		String countQuery = "SELECT COUNT(1) FROM ("+sql+") COUNT_TABLE";
		return countQuery;
	}
	private void initParam(Query query,Map<String, Object> param){
		if(null==param) return;
		for (Entry<String, Object> par : param.entrySet()) {
			query.setParameter(par.getKey(), par.getValue());
		}
	}
	private void setPage(Query query,Pageable page){
		if(null==page)return;
		query.setMaxResults(page.getPageSize()).setFirstResult(page.getOffset()-page.getPageSize());
	}
}
