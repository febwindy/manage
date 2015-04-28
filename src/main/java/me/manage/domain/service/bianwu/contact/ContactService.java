package me.manage.domain.service.bianwu.contact;

import me.manage.domain.model.bianwu.contact.Contact;
import me.manage.domain.model.bianwu.contact.IContactRepository;
import me.manage.infrastructure.persistence.hibernate.generic.Pagination;
import me.manage.interfaces.bianwu.contact.command.CreateContactCommand;
import me.manage.interfaces.bianwu.contact.command.EditContactCommand;
import me.manage.interfaces.bianwu.contact.command.ListCommand;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.Criterion;
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
 * Created by savion on 2015/4/28.
 */
@Service("contactService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class ContactService implements IContactService {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private IContactRepository<Contact, String> contactRepository;

    @Override
    public Contact findById(String id) {
        return contactRepository.getById(id);
    }

    @Override
    public Pagination<Contact> pagination(ListCommand command) {

        command.setPageSize(10);

        List<Criterion> criterionList = new ArrayList<Criterion>();

        if (null != command.getContactId() && !StringUtils.isEmpty(command.getContactId())) {
            criterionList.add(Restrictions.eq("contactId", command.getContactId()));
        }

        if (null != command.getAuthor() && !StringUtils.isEmpty(command.getAuthor())) {
            criterionList.add(Restrictions.eq("author", command.getAuthor()));
        }

        Criterion[] restrictions = null;
        int size = criterionList.size();
        if (size> 0) {
            restrictions = new Criterion[size];
            criterionList.toArray(restrictions);
        }

        Order[] orders = {Order.desc("createdDate")};
        return contactRepository.pagination(command.getPage(), command.getPageSize(), restrictions, orders);
    }

    @Override
    public void create(CreateContactCommand command) {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Date date = null;
        try {
            date = sdf.parse(command.getManuscriptOutDate());
        } catch (ParseException e) {
            logger.warn("日期转换出错啦");
        }

        Contact contact = new Contact();
        contact.setContactId(command.getContactId());
        contact.setPage(command.getPage());
        contact.setAuthor(command.getAuthor());
        contact.setAddress(command.getAddress());
        contact.setManuscriptOutDate(date);
        contact.setDiscount(command.getDiscount());
        contact.setType(command.getType());
        contact.setRemark(command.getRemark());
        contact.setCreatedDate(new Date());

        contactRepository.save(contact);
    }

    @Override
    public void edit(EditContactCommand command) {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Date date = null;
        try {
            date = sdf.parse(command.getManuscriptOutDate());
        } catch (ParseException e) {
            logger.warn("日期转换出错啦");
        }

        Contact contact = this.findById(command.getId());
        contact.setContactId(command.getContactId());
        contact.setPage(command.getPage());
        contact.setAuthor(command.getAuthor());
        contact.setAddress(command.getAddress());
        contact.setManuscriptOutDate(date);
        contact.setDiscount(command.getDiscount());
        contact.setType(command.getType());
        contact.setRemark(command.getRemark());

        contactRepository.update(contact);
    }

    @Override
    public void delete(String id) {
        Contact contact = this.findById(id);
        contactRepository.delete(contact);
    }
}
