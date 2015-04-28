package me.manage.interfaces.editing;

import me.manage.domain.model.editing.Editing;
import me.manage.domain.service.editing.IEditingService;
import me.manage.infrastructure.persistence.hibernate.generic.Pagination;
import me.manage.interfaces.editing.command.CreateEditingCommand;
import me.manage.interfaces.editing.command.EditEditingCommand;
import me.manage.interfaces.editing.command.ListCommand;
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
@RequestMapping("/editing")
public class EditingController extends BaseController {

    @Autowired
    private IEditingService editingService;

    @RequestMapping("/list")
    public ModelAndView list(@ModelAttribute("editing")ListCommand command) throws Exception {
        Pagination<Editing> pagination = editingService.pagination(command);
        return new ModelAndView("/editing/list", "pagination", pagination)
                .addObject("editing", command);
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public ModelAndView create(@ModelAttribute("editing")CreateEditingCommand command) throws Exception {
        return new ModelAndView("/editing/create", "editing", command);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ModelAndView create(@ModelAttribute("editing")CreateEditingCommand command,
                               RedirectAttributes redirectAttributes,
                               Locale locale) throws Exception {

        editingService.create(command);

        AlertMessage alertMessage = new AlertMessage(AlertMessage.MessageType.SUCCESS,
                this.getMessage("default.create.success.message", new Object[]{command.getPart()}, locale));
        redirectAttributes.addFlashAttribute(AlertMessage.MODEL_ATTRIBUTE_KEY, alertMessage);

        return new ModelAndView("redirect:/editing/list");
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView create(@PathVariable String id) throws Exception {
        Editing editing = editingService.findById(id);
        return new ModelAndView("/editing/edit", "editing", editing);
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    public ModelAndView create(@ModelAttribute("editing")EditEditingCommand command,
                               RedirectAttributes redirectAttributes,
                               Locale locale) throws Exception {

        editingService.edit(command);

        AlertMessage alertMessage = new AlertMessage(AlertMessage.MessageType.SUCCESS,
                this.getMessage("default.create.success.message", new Object[]{command.getPart()}, locale));
        redirectAttributes.addFlashAttribute(AlertMessage.MODEL_ATTRIBUTE_KEY, alertMessage);

        return new ModelAndView("redirect:/editing/list");
    }

    @RequestMapping(value = "/view/{id}")
    public ModelAndView view(@PathVariable String id) throws Exception {
        Editing editing = editingService.findById(id);
        return new ModelAndView("/editing/view", "editing", editing);
    }

    @RequestMapping(value = "/delete/{id}")
    public ModelAndView delete(@PathVariable String id, RedirectAttributes redirectAttributes, Locale locale) throws Exception {

        editingService.delete(id);

        AlertMessage alertMessage = new AlertMessage(AlertMessage.MessageType.SUCCESS, this.getMessage("default.delete.success.message",
                new Object[]{id}, locale));
        redirectAttributes.addFlashAttribute(AlertMessage.MODEL_ATTRIBUTE_KEY, alertMessage);

        return new ModelAndView("redirect:/editing/list");
    }

    @RequestMapping(value = "/verified/{id}")
    public ModelAndView verified(@PathVariable String id, String status) throws Exception {
        editingService.changeStatus(id, status);
        return new ModelAndView("redirect:/editing/list");
    }

}
