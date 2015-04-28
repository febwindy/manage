package me.manage.infrastructure.persistence.hibernate;

import me.manage.domain.model.yinwu.printing.IPrintingRepository;
import me.manage.domain.model.yinwu.printing.Printing;
import me.manage.infrastructure.persistence.hibernate.generic.AbstractHibernateGenericRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by savion on 2015/4/28.
 */
@Repository("printingRepository")
public class PrintingRepository extends AbstractHibernateGenericRepository<Printing, String>
        implements IPrintingRepository<Printing, String> {
}
