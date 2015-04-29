package me.manage.interfaces.wuliu.warehousing;

import me.manage.domain.model.wuliu.warehousing.Warehousing;
import me.manage.domain.service.wuliu.warehousing.IWarehousingService;
import me.manage.infrastructure.persistence.hibernate.generic.Pagination;
import me.manage.interfaces.shared.web.AlertMessage;
import me.manage.interfaces.shared.web.BaseController;
import me.manage.interfaces.wuliu.warehousing.command.CreateWarehousingCommand;
import me.manage.interfaces.wuliu.warehousing.command.EditWarehousingCommand;
import me.manage.interfaces.wuliu.warehousing.command.ListCommand;
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
@RequestMapping("/warehousing")
public class WarehousingController extends BaseController {

    @Autowired
    private IWarehousingService warehousingService;

    @RequestMapping("/list")
    public ModelAndView list(@ModelAttribute("warehousing")ListCommand command) throws Exception {
        Pagination<Warehousing> pagination = warehousingService.pagination(command);
        return new ModelAndView("/wuliu/warehousing/list", "pagination", pagination)
                .addObject("warehousing", command);
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public ModelAndView create(@ModelAttribute("warehousing")CreateWarehousingCommand command) throws Exception {
        return new ModelAndView("/wuliu/warehousing/create", "warehousing", command);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ModelAndView create(@ModelAttribute("warehousing")CreateWarehousingCommand command,
                               RedirectAttributes redirectAttributes,
                               Locale locale) throws Exception {

        warehousingService.create(command);

        AlertMessage alertMessage = new AlertMessage(AlertMessage.MessageType.SUCCESS,
                this.getMessage("default.create.success.message", new Object[]{command.getProductName()}, locale));
        redirectAttributes.addFlashAttribute(AlertMessage.MODEL_ATTRIBUTE_KEY, alertMessage);

        return new ModelAndView("redirect:/warehousing/list");
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView edit(@PathVariable String id) throws Exception {
        Warehousing warehousing = warehousingService.findById(id);
        return new ModelAndView("/wuliu/warehousing/edit", "warehousing", warehousing);
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    public ModelAndView edit(@ModelAttribute("warehousing")EditWarehousingCommand command,
                             RedirectAttributes redirectAttributes,
                             Locale locale) throws Exception {

        warehousingService.edit(command);

        AlertMessage alertMessage = new AlertMessage(AlertMessage.MessageType.SUCCESS,
                this.getMessage("default.create.success.message", new Object[]{command.getProductName()}, locale));
        redirectAttributes.addFlashAttribute(AlertMessage.MODEL_ATTRIBUTE_KEY, alertMessage);

        return new ModelAndView("redirect:/warehousing/list");
    }

    @RequestMapping(value = "/view/{id}")
    public ModelAndView view(@PathVariable String id) throws Exception {
        Warehousing warehousing = warehousingService.findById(id);
        return new ModelAndView("/wuliu/warehousing/view", "warehousing", warehousing);
    }

    @RequestMapping(value = "/delete/{id}")
    public ModelAndView delete(@PathVariable String id, RedirectAttributes redirectAttributes, Locale locale) throws Exception {

        warehousingService.delete(id);

        AlertMessage alertMessage = new AlertMessage(AlertMessage.MessageType.SUCCESS, this.getMessage("default.delete.success.message",
                new Object[]{id}, locale));
        redirectAttributes.addFlashAttribute(AlertMessage.MODEL_ATTRIBUTE_KEY, alertMessage);

        return new ModelAndView("redirect:/warehousing/list");
    }
}
