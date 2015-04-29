package me.manage.infrastructure.persistence.hibernate;

import me.manage.domain.model.wuliu.delivery.Delivery;
import me.manage.domain.model.wuliu.delivery.IDeliveryRepository;
import me.manage.infrastructure.persistence.hibernate.generic.AbstractHibernateGenericRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by savion on 2015/4/29.
 */
@Repository("deliveryRepository")
public class DeliveryRepository extends AbstractHibernateGenericRepository<Delivery, String>
        implements IDeliveryRepository<Delivery, String> {
}
