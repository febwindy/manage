package me.manage.interfaces.faxing.business;

import me.manage.domain.model.faxing.business.ProcurementAndSales;
import me.manage.domain.service.faxing.business.IProcurementAndSalesService;
import me.manage.infrastructure.persistence.hibernate.generic.Pagination;
import me.manage.interfaces.faxing.business.command.CreateProAndSaleCommand;
import me.manage.interfaces.faxing.business.command.EditProAndSaleCommand;
import me.manage.interfaces.faxing.business.command.ListCommand;
import me.manage.interfaces.shared.web.AlertMessage;
import me.manage.interfaces.shared.web.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Locale;

/**
 * Created by savion on 2015/4/29.
 */
@Controller
@RequestMapping("/business")
public class ProcurementAndSalesController extends BaseController {

    @Autowired
    private IProcurementAndSalesService procurementAndSalesService;

    @RequestMapping("/list")
    public ModelAndView list(@ModelAttribute("business")ListCommand command) throws Exception {
        Pagination<ProcurementAndSales> pagination = procurementAndSalesService.pagination(command);
        return new ModelAndView("/faxing/business/list", "pagination", pagination)
                .addObject("business", command);
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public ModelAndView create(@ModelAttribute("business")CreateProAndSaleCommand command) throws Exception {
        return new ModelAndView("/faxing/business/create", "business", command);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ModelAndView create(@ModelAttribute("business")CreateProAndSaleCommand command,
                               RedirectAttributes redirectAttributes,
                               Locale locale) throws Exception {

        procurementAndSalesService.create(command);

        AlertMessage alertMessage = new AlertMessage(AlertMessage.MessageType.SUCCESS,
                this.getMessage("default.create.success.message", new Object[]{command.getProductName()}, locale));
        redirectAttributes.addFlashAttribute(AlertMessage.MODEL_ATTRIBUTE_KEY, alertMessage);

        return new ModelAndView("redirect:/business/list");
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView edit(@PathVariable String id) throws Exception {
        ProcurementAndSales procurementAndSales = procurementAndSalesService.findById(id);
        return new ModelAndView("/faxing/business/edit", "business", procurementAndSales);
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    public ModelAndView edit(@ModelAttribute("business")EditProAndSaleCommand command,
                             RedirectAttributes redirectAttributes,
                             Locale locale) throws Exception {

        procurementAndSalesService.edit(command);

        AlertMessage alertMessage = new AlertMessage(AlertMessage.MessageType.SUCCESS,
                this.getMessage("default.create.success.message", new Object[]{command.getProductName()}, locale));
        redirectAttributes.addFlashAttribute(AlertMessage.MODEL_ATTRIBUTE_KEY, alertMessage);

        return new ModelAndView("redirect:/business/list");
    }

    @RequestMapping(value = "/view/{id}")
    public ModelAndView view(@PathVariable String id) throws Exception {
        ProcurementAndSales procurementAndSales = procurementAndSalesService.findById(id);
        return new ModelAndView("/faxing/business/view", "business", procurementAndSales);
    }

    @RequestMapping(value = "/delete/{id}")
    public ModelAndView delete(@PathVariable String id, RedirectAttributes redirectAttributes, Locale locale) throws Exception {

        procurementAndSalesService.delete(id);

        AlertMessage alertMessage = new AlertMessage(AlertMessage.MessageType.SUCCESS, this.getMessage("default.delete.success.message",
                new Object[]{id}, locale));
        redirectAttributes.addFlashAttribute(AlertMessage.MODEL_ATTRIBUTE_KEY, alertMessage);

        return new ModelAndView("redirect:/business/list");
    }

}
