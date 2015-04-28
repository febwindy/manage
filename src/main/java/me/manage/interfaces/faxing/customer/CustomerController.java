package me.manage.interfaces.faxing.customer;

import me.manage.domain.model.faxing.customer.Customer;
import me.manage.domain.service.faxing.customer.ICustomerService;
import me.manage.infrastructure.persistence.hibernate.generic.Pagination;
import me.manage.interfaces.faxing.customer.command.CreateCustomerCommand;
import me.manage.interfaces.faxing.customer.command.EditCustomerCommand;
import me.manage.interfaces.faxing.customer.command.ListCommand;
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
@RequestMapping("/customer")
public class CustomerController extends BaseController {

    @Autowired
    private ICustomerService customerService;

    @RequestMapping("/list")
    public ModelAndView list(@ModelAttribute("customer")ListCommand command) throws Exception {
        Pagination<Customer> pagination = customerService.pagination(command);
        return new ModelAndView("/faxing/customer/list", "pagination", pagination)
                .addObject("customer", command);
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public ModelAndView create(@ModelAttribute("customer")CreateCustomerCommand command) throws Exception {
        return new ModelAndView("/faxing/customer/create", "customer", command);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ModelAndView create(@ModelAttribute("customer")CreateCustomerCommand command,
                               RedirectAttributes redirectAttributes,
                               Locale locale) throws Exception {

        customerService.create(command);

        AlertMessage alertMessage = new AlertMessage(AlertMessage.MessageType.SUCCESS,
                this.getMessage("default.create.success.message", new Object[]{command.getName()}, locale));
        redirectAttributes.addFlashAttribute(AlertMessage.MODEL_ATTRIBUTE_KEY, alertMessage);

        return new ModelAndView("redirect:/customer/list");
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView edit(@PathVariable String id) throws Exception {
        Customer customer = customerService.findById(id);
        return new ModelAndView("/faxing/customer/edit", "customer", customer);
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    public ModelAndView edit(@ModelAttribute("customer")EditCustomerCommand command,
                             RedirectAttributes redirectAttributes,
                             Locale locale) throws Exception {

        customerService.edit(command);

        AlertMessage alertMessage = new AlertMessage(AlertMessage.MessageType.SUCCESS,
                this.getMessage("default.create.success.message", new Object[]{command.getName()}, locale));
        redirectAttributes.addFlashAttribute(AlertMessage.MODEL_ATTRIBUTE_KEY, alertMessage);

        return new ModelAndView("redirect:/customer/list");
    }

    @RequestMapping(value = "/view/{id}")
    public ModelAndView view(@PathVariable String id) throws Exception {
        Customer customer = customerService.findById(id);
        return new ModelAndView("/faxing/customer/view", "customer", customer);
    }

    @RequestMapping(value = "/delete/{id}")
    public ModelAndView delete(@PathVariable String id, RedirectAttributes redirectAttributes, Locale locale) throws Exception {

        customerService.delete(id);

        AlertMessage alertMessage = new AlertMessage(AlertMessage.MessageType.SUCCESS, this.getMessage("default.delete.success.message",
                new Object[]{id}, locale));
        redirectAttributes.addFlashAttribute(AlertMessage.MODEL_ATTRIBUTE_KEY, alertMessage);

        return new ModelAndView("redirect:/customer/list");
    }

}
