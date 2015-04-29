package me.manage.infrastructure.persistence.hibernate.generic;

import org.hibernate.*;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;


/**
 * Author: EthanTu
 * Date: 12-4-20
 * Time: 下午3:43
 */
@Repository
public abstract class AbstractHibernateGenericRepository<T, ID extends Serializable> implements IHibernateGenericRepository<T, ID> {

//    private static final String DELETE_FLAG_PROPERTY = "deleted";

    private Class<T> persistentClass;

    @Autowired
    private SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
    public AbstractHibernateGenericRepository() {
        this.persistentClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public Class<T> getPersistentClass() {
        return persistentClass;
    }

    @Override
    public void clear() {
        getSession().clear();
    }

    @Override
    public void evict(Object obj) {
        getSession().evict(obj);
    }

    @Override
    public void refresh(Object obj) {
        getSession().refresh(obj);
    }

    @Override
    public T loadById(ID id) {
        return (T) getSession().load(getPersistentClass(), id);
    }

    @Override
    public T getById(ID id) {
        return (T) getSession().get(getPersistentClass(), id);
    }

    @Override
    public void flush() {
        getSession().flush();
    }

    @Override
    public void save(T entity) {
        getSession().save(entity);
    }

    @Override
    public void saveAll(List<T> list) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        for (int i=0; i < list.size(); i++) {
            T entity = list.get(i);
            session.save(entity);

            if (i % 50 == 0) {
                session.flush();
                session.clear();
            }
        }

        tx.commit();
        session.close();
    }

    @Override
    public void update(T entity) {
        getSession().update(entity);
    }

    @Override
    public void saveOrUpdate(T entity) {getSession().saveOrUpdate(entity);}

    @Override
    public void delete(T entity) {
        getSession().delete(entity);
    }

    @Override
    public Pagination<T> pagination(int page, int pageSize, Criterion[] criteria, Order[] orders) {
        return this.pagination(page, pageSize, null, criteria, orders, null);
    }

    @Override
    public Pagination<T> pagination(int page, int pageSize, Criterion[] criteria, Order[] orders, Map<String, FetchMode> fetchModeMap) {
        return this.pagination(page, pageSize, null, criteria, orders, fetchModeMap);
    }

    @Override
    @SuppressWarnings("unchecked")
    public Pagination<T> pagination(int page, int pageSize, Map<String, String> alias, Criterion[] criteria, Order[] orders,
                                    Map<String, FetchMode> fetchModeMap) {

        Criteria criteriaCount = getSession().createCriteria(getPersistentClass()).
                setProjection(Projections.rowCount());

        Criteria criteriaSearch = getSession().createCriteria(getPersistentClass());

        if (null != alias) {
            for (Map.Entry<String, String> entry : alias.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                criteriaCount.createAlias(key, value);
                criteriaSearch.createAlias(key, value);
            }
        }

        if (null != criteria) {
            for (Criterion criterion : criteria) {
                criteriaCount.add(criterion);
                criteriaSearch.add(criterion);
            }
        }

        if (null != orders) {
            for (Order order : orders) {
                criteriaSearch.addOrder(order);
            }
        }

        if (null != fetchModeMap) {
            for (Map.Entry<String, FetchMode> entry : fetchModeMap.entrySet()) {
                String key = entry.getKey();
                FetchMode value = entry.getValue();
                criteriaCount.setFetchMode(key, value);
                criteriaSearch.setFetchMode(key, value);
            }
        }

        int count = ((Long) criteriaCount.uniqueResult()).intValue();

        int firstResult = (page - 1) * pageSize;

        criteriaSearch.setFirstResult(firstResult).setMaxResults(pageSize);
        return new Pagination<T>(criteriaSearch.list(), count, page, pageSize);
    }

    @Override
    public List<T> findAll() {
          return getSession().createCriteria(getPersistentClass()).list();
      }
}