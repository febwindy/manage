package me.manage.domain.service.wuliu.delivery;

import me.manage.domain.model.wuliu.delivery.Delivery;
import me.manage.domain.model.wuliu.delivery.IDeliveryRepository;
import me.manage.infrastructure.persistence.hibernate.generic.Pagination;
import me.manage.interfaces.wuliu.delivery.command.CreateDeliveryCommand;
import me.manage.interfaces.wuliu.delivery.command.EditDeliveryCommand;
import me.manage.interfaces.wuliu.delivery.command.ListCommand;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by savion on 2015/4/29.
 */
@Service("deliveryService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class DeliveryService implements IDeliveryService {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private IDeliveryRepository<Delivery, String> deliveryRepository;

    @Override
    public Delivery findById(String id) {
        return deliveryRepository.getById(id);
    }

    @Override
    public Pagination<Delivery> pagination(ListCommand command) {

        command.setPageSize(10);

        List<Criterion> criterionList = new ArrayList<Criterion>();

        if (null != command.getDeliveryId() && !StringUtils.isEmpty(command.getDeliveryId())) {
            criterionList.add(Restrictions.eq("deliveryId", command.getDeliveryId()));
        }

        if (null != command.getIsbn() && !StringUtils.isEmpty(command.getIsbn())) {
            criterionList.add(Restrictions.eq("isbn", command.getIsbn()));
        }

        if (null != command.getProductName() && !StringUtils.isEmpty(command.getProductName())) {
            criterionList.add(Restrictions.like("productName", command.getProductName(), MatchMode.ANYWHERE));
        }

        Criterion[] restrictions = null;
        int size = criterionList.size();
        if (size> 0) {
            restrictions = new Criterion[size];
            criterionList.toArray(restrictions);
        }

        Order[] orders = {Order.desc("createdDate")};
        return deliveryRepository.pagination(command.getPage(), command.getPageSize(), restrictions, orders);
    }

    @Override
    public void create(CreateDeliveryCommand command) {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

        Date deliveryDate = null;
        try {
            deliveryDate = sdf.parse(command.getDeliveryDate());
        } catch (ParseException e) {
            logger.warn("日期转换出错啦");
        }

        Delivery delivery = new Delivery();
        delivery.setDeliveryId(command.getDeliveryId());
        delivery.setSupplier(command.getSupplier());
        delivery.setStyle(command.getStyle());
        delivery.setDeliveryDate(deliveryDate);

        delivery.setProductId(command.getProductId());
        delivery.setProductName(command.getProductName());
        delivery.setProductType(command.getProductType());
        delivery.setIsbn(command.getIsbn());
        delivery.setAuthor(command.getAuthor());
        delivery.setPress(command.getPress());
        delivery.setStoreAddress(command.getStoreAddress());
        delivery.setNum(command.getNum());
        delivery.setPrice(command.getPrice());
        delivery.setTotalAmount(command.getTotalAmount());
        delivery.setPrincipal(command.getPrincipal());
        delivery.setRemark(command.getRemark());
        delivery.setCreatedDate(new Date());

        deliveryRepository.save(delivery);
    }

    @Override
    public void edit(EditDeliveryCommand command) {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

        Date deliveryDate = null;
        try {
            deliveryDate = sdf.parse(command.getDeliveryDate());
        } catch (ParseException e) {
            logger.warn("日期转换出错啦");
        }

        Delivery delivery = this.findById(command.getId());
        delivery.setDeliveryId(command.getDeliveryId());
        delivery.setSupplier(command.getSupplier());
        delivery.setStyle(command.getStyle());
        delivery.setDeliveryDate(deliveryDate);

        delivery.setProductId(command.getProductId());
        delivery.setProductName(command.getProductName());
        delivery.setProductType(command.getProductType());
        delivery.setIsbn(command.getIsbn());
        delivery.setAuthor(command.getAuthor());
        delivery.setPress(command.getPress());
        delivery.setStoreAddress(command.getStoreAddress());
        delivery.setNum(command.getNum());
        delivery.setPrice(command.getPrice());
        delivery.setTotalAmount(command.getTotalAmount());
        delivery.setPrincipal(command.getPrincipal());
        delivery.setRemark(command.getRemark());
        delivery.setCreatedDate(new Date());

        deliveryRepository.save(delivery);
    }

    @Override
    public void delete(String id) {
        Delivery delivery = this.findById(id);
        deliveryRepository.delete(delivery);
    }
}
