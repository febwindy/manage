package me.manage.interfaces.wuliu.delivery;

import me.manage.domain.model.wuliu.delivery.Delivery;
import me.manage.domain.service.wuliu.delivery.IDeliveryService;
import me.manage.infrastructure.persistence.hibernate.generic.Pagination;
import me.manage.interfaces.shared.web.AlertMessage;
import me.manage.interfaces.shared.web.BaseController;
import me.manage.interfaces.wuliu.delivery.command.CreateDeliveryCommand;
import me.manage.interfaces.wuliu.delivery.command.EditDeliveryCommand;
import me.manage.interfaces.wuliu.delivery.command.ListCommand;
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
@RequestMapping("/delivery")
public class DeliveryController extends BaseController {

    @Autowired
    private IDeliveryService deliveryService;

    @RequestMapping("/list")
    public ModelAndView list(@ModelAttribute("delivery")ListCommand command) throws Exception {
        Pagination<Delivery> pagination = deliveryService.pagination(command);
        return new ModelAndView("/wuliu/delivery/list", "pagination", pagination)
                .addObject("delivery", command);
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public ModelAndView create(@ModelAttribute("delivery")CreateDeliveryCommand command) throws Exception {
        return new ModelAndView("/wuliu/delivery/create", "delivery", command);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ModelAndView create(@ModelAttribute("delivery")CreateDeliveryCommand command,
                               RedirectAttributes redirectAttributes,
                               Locale locale) throws Exception {

        deliveryService.create(command);

        AlertMessage alertMessage = new AlertMessage(AlertMessage.MessageType.SUCCESS,
                this.getMessage("default.create.success.message", new Object[]{command.getProductName()}, locale));
        redirectAttributes.addFlashAttribute(AlertMessage.MODEL_ATTRIBUTE_KEY, alertMessage);

        return new ModelAndView("redirect:/delivery/list");
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView edit(@PathVariable String id) throws Exception {
        Delivery warehousing = deliveryService.findById(id);
        return new ModelAndView("/wuliu/delivery/edit", "delivery", warehousing);
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    public ModelAndView edit(@ModelAttribute("delivery")EditDeliveryCommand command,
                             RedirectAttributes redirectAttributes,
                             Locale locale) throws Exception {

        deliveryService.edit(command);

        AlertMessage alertMessage = new AlertMessage(AlertMessage.MessageType.SUCCESS,
                this.getMessage("default.create.success.message", new Object[]{command.getProductName()}, locale));
        redirectAttributes.addFlashAttribute(AlertMessage.MODEL_ATTRIBUTE_KEY, alertMessage);

        return new ModelAndView("redirect:/delivery/list");
    }

    @RequestMapping(value = "/view/{id}")
    public ModelAndView view(@PathVariable String id) throws Exception {
        Delivery delivery = deliveryService.findById(id);
        return new ModelAndView("/wuliu/delivery/view", "delivery", delivery);
    }

    @RequestMapping(value = "/delete/{id}")
    public ModelAndView delete(@PathVariable String id, RedirectAttributes redirectAttributes, Locale locale) throws Exception {

        deliveryService.delete(id);

        AlertMessage alertMessage = new AlertMessage(AlertMessage.MessageType.SUCCESS, this.getMessage("default.delete.success.message",
                new Object[]{id}, locale));
        redirectAttributes.addFlashAttribute(AlertMessage.MODEL_ATTRIBUTE_KEY, alertMessage);

        return new ModelAndView("redirect:/delivery/list");
    }
}
