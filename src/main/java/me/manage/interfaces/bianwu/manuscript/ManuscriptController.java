package me.manage.interfaces.bianwu.manuscript;

import me.manage.domain.model.bianwu.manuscript.Manuscript;
import me.manage.domain.service.bianwu.manuscript.IManuscriptService;
import me.manage.infrastructure.persistence.hibernate.generic.Pagination;
import me.manage.interfaces.bianwu.manuscript.command.CreateManuscriptCommand;
import me.manage.interfaces.bianwu.manuscript.command.EditManuscriptCommand;
import me.manage.interfaces.bianwu.manuscript.command.ListCommand;
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
@RequestMapping("manuscript")
public class ManuscriptController extends BaseController {

    @Autowired
    private IManuscriptService manuscriptService;

    @RequestMapping("/list")
    public ModelAndView list(@ModelAttribute("manuscript")ListCommand command) throws Exception {
        Pagination<Manuscript> pagination = manuscriptService.pagination(command);
        return new ModelAndView("/bianwu/manuscript/list", "pagination", pagination)
                .addObject("manuscript", command);
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public ModelAndView create(@ModelAttribute("manuscript")CreateManuscriptCommand command) throws Exception {
        return new ModelAndView("/bianwu/manuscript/create", "manuscript", command);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ModelAndView create(@ModelAttribute("manuscript")CreateManuscriptCommand command,
                               RedirectAttributes redirectAttributes,
                               Locale locale) throws Exception {

        manuscriptService.create(command);

        AlertMessage alertMessage = new AlertMessage(AlertMessage.MessageType.SUCCESS,
                this.getMessage("default.create.success.message", new Object[]{command.getName()}, locale));
        redirectAttributes.addFlashAttribute(AlertMessage.MODEL_ATTRIBUTE_KEY, alertMessage);

        return new ModelAndView("redirect:/manuscript/list");
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView edit(@PathVariable String id) throws Exception {
        Manuscript manuscript = manuscriptService.findById(id);
        return new ModelAndView("/bianwu/manuscript/edit", "manuscript", manuscript);
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    public ModelAndView edit(@ModelAttribute("manuscript")EditManuscriptCommand command,
                             RedirectAttributes redirectAttributes,
                             Locale locale) throws Exception {

        manuscriptService.edit(command);

        AlertMessage alertMessage = new AlertMessage(AlertMessage.MessageType.SUCCESS,
                this.getMessage("default.create.success.message", new Object[]{command.getName()}, locale));
        redirectAttributes.addFlashAttribute(AlertMessage.MODEL_ATTRIBUTE_KEY, alertMessage);

        return new ModelAndView("redirect:/manuscript/list");
    }

    @RequestMapping(value = "/view/{id}")
    public ModelAndView view(@PathVariable String id) throws Exception {
        Manuscript manuscript = manuscriptService.findById(id);
        return new ModelAndView("/bianwu/manuscript/view", "manuscript", manuscript);
    }

    @RequestMapping(value = "/delete/{id}")
    public ModelAndView delete(@PathVariable String id, RedirectAttributes redirectAttributes, Locale locale) throws Exception {

        manuscriptService.delete(id);

        AlertMessage alertMessage = new AlertMessage(AlertMessage.MessageType.SUCCESS, this.getMessage("default.delete.success.message",
                new Object[]{id}, locale));
        redirectAttributes.addFlashAttribute(AlertMessage.MODEL_ATTRIBUTE_KEY, alertMessage);

        return new ModelAndView("redirect:/manuscript/list");
    }

}
