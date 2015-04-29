package me.manage.domain.service.wuliu.warehousing;

import me.manage.domain.model.wuliu.warehousing.IWarehousingRepository;
import me.manage.domain.model.wuliu.warehousing.Warehousing;
import me.manage.infrastructure.persistence.hibernate.generic.Pagination;
import me.manage.interfaces.wuliu.warehousing.command.CreateWarehousingCommand;
import me.manage.interfaces.wuliu.warehousing.command.EditWarehousingCommand;
import me.manage.interfaces.wuliu.warehousing.command.ListCommand;
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
@Service("warehousingService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class WarehousingService implements IWarehousingService {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private IWarehousingRepository<Warehousing, String> warehousingRepository;

    @Override
    public Warehousing findById(String id) {
        return warehousingRepository.getById(id);
    }

    @Override
    public Pagination<Warehousing> pagination(ListCommand command) {

        command.setPageSize(10);

        List<Criterion> criterionList = new ArrayList<Criterion>();

        if (null != command.getWarehousingId() && !StringUtils.isEmpty(command.getWarehousingId())) {
            criterionList.add(Restrictions.eq("warehousingId", command.getWarehousingId()));
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
        return warehousingRepository.pagination(command.getPage(), command.getPageSize(), restrictions, orders);
    }

    @Override
    public void create(CreateWarehousingCommand command) {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

        Date warehousingDate = null;
        try {
            warehousingDate = sdf.parse(command.getWarehousingDate());
        } catch (ParseException e) {
            logger.warn("日期转换出错啦");
        }

        Warehousing warehousing = new Warehousing();
        warehousing.setWarehousingId(command.getWarehousingId());
        warehousing.setSupplier(command.getSupplier());
        warehousing.setStyle(command.getStyle());
        warehousing.setWarehousingDate(warehousingDate);

        warehousing.setProductId(command.getProductId());
        warehousing.setProductName(command.getProductName());
        warehousing.setProductType(command.getProductType());
        warehousing.setIsbn(command.getIsbn());
        warehousing.setAuthor(command.getAuthor());
        warehousing.setPress(command.getPress());
        warehousing.setStoreAddress(command.getStoreAddress());
        warehousing.setNum(command.getNum());
        warehousing.setPrice(command.getPrice());
        warehousing.setTotalAmount(command.getTotalAmount());
        warehousing.setPrincipal(command.getPrincipal());
        warehousing.setRemark(command.getRemark());
        warehousing.setCreatedDate(new Date());

        warehousingRepository.save(warehousing);
    }

    @Override
    public void edit(EditWarehousingCommand command) {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

        Date warehousingDate = null;
        try {
            warehousingDate = sdf.parse(command.getWarehousingDate());
        } catch (ParseException e) {
            logger.warn("日期转换出错啦");
        }

        Warehousing warehousing = this.findById(command.getId());
        warehousing.setWarehousingId(command.getWarehousingId());
        warehousing.setSupplier(command.getSupplier());
        warehousing.setStyle(command.getStyle());
        warehousing.setWarehousingDate(warehousingDate);

        warehousing.setProductId(command.getProductId());
        warehousing.setProductName(command.getProductName());
        warehousing.setProductType(command.getProductType());
        warehousing.setIsbn(command.getIsbn());
        warehousing.setAuthor(command.getAuthor());
        warehousing.setPress(command.getPress());
        warehousing.setStoreAddress(command.getStoreAddress());
        warehousing.setNum(command.getNum());
        warehousing.setPrice(command.getPrice());
        warehousing.setTotalAmount(command.getTotalAmount());
        warehousing.setPrincipal(command.getPrincipal());
        warehousing.setRemark(command.getRemark());
        warehousing.setCreatedDate(new Date());

        warehousingRepository.save(warehousing);
    }

    @Override
    public void delete(String id) {
        Warehousing warehousing = this.findById(id);
        warehousingRepository.delete(warehousing);
    }
}
