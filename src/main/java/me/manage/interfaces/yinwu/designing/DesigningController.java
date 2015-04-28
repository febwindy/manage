package me.manage.interfaces.yinwu.designing;

import me.manage.domain.model.yinwu.designing.Designing;
import me.manage.domain.service.yinwu.designing.IDesigningService;
import me.manage.infrastructure.persistence.hibernate.generic.Pagination;
import me.manage.interfaces.shared.web.AlertMessage;
import me.manage.interfaces.shared.web.BaseController;
import me.manage.interfaces.yinwu.designing.command.CreateDesigningCommand;
import me.manage.interfaces.yinwu.designing.command.EditDesigningCommand;
import me.manage.interfaces.yinwu.designing.command.ListCommand;
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
@RequestMapping("/designing")
public class DesigningController extends BaseController {

    @Autowired
    private IDesigningService designingService;

    @RequestMapping("/list")
    public ModelAndView list(@ModelAttribute("designing")ListCommand command) throws Exception {
        Pagination<Designing> pagination = designingService.pagination(command);
        return new ModelAndView("/yinwu/designing/list", "pagination", pagination)
                .addObject("designing", command);
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public ModelAndView create(@ModelAttribute("designing")CreateDesigningCommand command) throws Exception {
        return new ModelAndView("/yinwu/designing/create", "designing", command);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ModelAndView create(@ModelAttribute("designing")CreateDesigningCommand command,
                               RedirectAttributes redirectAttributes,
                               Locale locale) throws Exception {

        designingService.create(command);

        AlertMessage alertMessage = new AlertMessage(AlertMessage.MessageType.SUCCESS,
                this.getMessage("default.create.success.message", new Object[]{command.getPart()}, locale));
        redirectAttributes.addFlashAttribute(AlertMessage.MODEL_ATTRIBUTE_KEY, alertMessage);

        return new ModelAndView("redirect:/designing/list");
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView edit(@PathVariable String id) throws Exception {
        Designing editing = designingService.findById(id);
        return new ModelAndView("/yinwu/designing/edit", "designing", editing);
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    public ModelAndView edit(@ModelAttribute("designing")EditDesigningCommand command,
                             RedirectAttributes redirectAttributes,
                             Locale locale) throws Exception {

        designingService.edit(command);

        AlertMessage alertMessage = new AlertMessage(AlertMessage.MessageType.SUCCESS,
                this.getMessage("default.create.success.message", new Object[]{command.getPart()}, locale));
        redirectAttributes.addFlashAttribute(AlertMessage.MODEL_ATTRIBUTE_KEY, alertMessage);

        return new ModelAndView("redirect:/designing/list");
    }

    @RequestMapping(value = "/view/{id}")
    public ModelAndView view(@PathVariable String id) throws Exception {
        Designing designing = designingService.findById(id);
        return new ModelAndView("/yinwu/designing/view", "designing", designing);
    }

    @RequestMapping(value = "/delete/{id}")
    public ModelAndView delete(@PathVariable String id, RedirectAttributes redirectAttributes, Locale locale) throws Exception {

        designingService.delete(id);

        AlertMessage alertMessage = new AlertMessage(AlertMessage.MessageType.SUCCESS, this.getMessage("default.delete.success.message",
                new Object[]{id}, locale));
        redirectAttributes.addFlashAttribute(AlertMessage.MODEL_ATTRIBUTE_KEY, alertMessage);

        return new ModelAndView("redirect:/designing/list");
    }

    @RequestMapping(value = "/verified/{id}")
    public ModelAndView verified(@PathVariable String id, String status) throws Exception {
        designingService.changeStatus(id, status);
        return new ModelAndView("redirect:/designing/list");
    }


}
