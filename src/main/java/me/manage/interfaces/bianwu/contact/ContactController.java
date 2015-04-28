package me.manage.interfaces.bianwu.contact;

import me.manage.domain.model.bianwu.contact.Contact;
import me.manage.domain.service.bianwu.contact.IContactService;
import me.manage.infrastructure.persistence.hibernate.generic.Pagination;
import me.manage.interfaces.bianwu.contact.command.CreateContactCommand;
import me.manage.interfaces.bianwu.contact.command.EditContactCommand;
import me.manage.interfaces.bianwu.contact.command.ListCommand;
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
 * Created by savion on 2015/4/28.
 */
@Controller
@RequestMapping("/contact")
public class ContactController extends BaseController {

    @Autowired
    private IContactService contactService;

    @RequestMapping("/list")
    public ModelAndView list(@ModelAttribute("contact")ListCommand command) throws Exception {
        Pagination<Contact> pagination = contactService.pagination(command);
        return new ModelAndView("/bianwu/contact/list", "pagination", pagination)
                .addObject("contact", command);
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public ModelAndView create(@ModelAttribute("contact")CreateContactCommand command) throws Exception {
        return new ModelAndView("/bianwu/contact/create", "contact", command);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ModelAndView create(@ModelAttribute("contact")CreateContactCommand command,
                               RedirectAttributes redirectAttributes,
                               Locale locale) throws Exception {

        contactService.create(command);

        AlertMessage alertMessage = new AlertMessage(AlertMessage.MessageType.SUCCESS,
                this.getMessage("default.create.success.message", new Object[]{command.getContactId()}, locale));
        redirectAttributes.addFlashAttribute(AlertMessage.MODEL_ATTRIBUTE_KEY, alertMessage);

        return new ModelAndView("redirect:/contact/list");
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView edit(@PathVariable String id) throws Exception {
        Contact contact = contactService.findById(id);
        return new ModelAndView("/bianwu/contact/edit", "contact", contact);
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    public ModelAndView edit(@ModelAttribute("contact")EditContactCommand command,
                               RedirectAttributes redirectAttributes,
                               Locale locale) throws Exception {

        contactService.edit(command);

        AlertMessage alertMessage = new AlertMessage(AlertMessage.MessageType.SUCCESS,
                this.getMessage("default.create.success.message", new Object[]{command.getContactId()}, locale));
        redirectAttributes.addFlashAttribute(AlertMessage.MODEL_ATTRIBUTE_KEY, alertMessage);

        return new ModelAndView("redirect:/contact/list");
    }

    @RequestMapping(value = "/view/{id}")
    public ModelAndView view(@PathVariable String id) throws Exception {
        Contact contact = contactService.findById(id);
        return new ModelAndView("/bianwu/contact/view", "contact", contact);
    }

    @RequestMapping(value = "/delete/{id}")
    public ModelAndView delete(@PathVariable String id, RedirectAttributes redirectAttributes, Locale locale) throws Exception {

        contactService.delete(id);

        AlertMessage alertMessage = new AlertMessage(AlertMessage.MessageType.SUCCESS, this.getMessage("default.delete.success.message",
                new Object[]{id}, locale));
        redirectAttributes.addFlashAttribute(AlertMessage.MODEL_ATTRIBUTE_KEY, alertMessage);

        return new ModelAndView("redirect:/contact/list");
    }
}
