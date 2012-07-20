package src.org.lhp.system.common.dao;

import java.io.Serializable;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import src.org.lhp.system.common.domain.BaseEntity;
@NoRepositoryBean
public interface CustomRepository<T extends BaseEntity, ID extends Serializable> extends JpaRepository<T, ID>{
	Page<?> findBySQL(String sql,Map<String, Object> param,Class<?> clazz,Pageable page);
	Page<?> findByHQL(String hql,String totalHql,Map<String, Object> param,Class<?> clazz,Pageable page);
}
