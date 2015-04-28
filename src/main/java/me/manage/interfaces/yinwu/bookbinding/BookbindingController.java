package me.manage.interfaces.yinwu.bookbinding;

import me.manage.domain.model.yinwu.bookbinding.Bookbinding;
import me.manage.domain.service.yinwu.bookbinding.IBookbindingService;
import me.manage.infrastructure.persistence.hibernate.generic.Pagination;
import me.manage.interfaces.shared.web.AlertMessage;
import me.manage.interfaces.shared.web.BaseController;
import me.manage.interfaces.yinwu.bookbinding.command.CreateBookbindingCommand;
import me.manage.interfaces.yinwu.bookbinding.command.EditBookbindingCommand;
import me.manage.interfaces.yinwu.bookbinding.command.ListCommand;
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
@RequestMapping("/bookbinding")
public class BookbindingController extends BaseController {

    @Autowired
    private IBookbindingService bookbindingService;

    @RequestMapping("/list")
    public ModelAndView list(@ModelAttribute("bookbinding")ListCommand command) throws Exception {
        Pagination<Bookbinding> pagination = bookbindingService.pagination(command);
        return new ModelAndView("/yinwu/bookbinding/list", "pagination", pagination)
                .addObject("bookbinding", command);
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public ModelAndView create(@ModelAttribute("bookbinding")CreateBookbindingCommand command) throws Exception {
        return new ModelAndView("/yinwu/bookbinding/create", "bookbinding", command);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ModelAndView create(@ModelAttribute("bookbinding")CreateBookbindingCommand command,
                               RedirectAttributes redirectAttributes,
                               Locale locale) throws Exception {

        bookbindingService.create(command);

        AlertMessage alertMessage = new AlertMessage(AlertMessage.MessageType.SUCCESS,
                this.getMessage("default.create.success.message", new Object[]{command.getName()}, locale));
        redirectAttributes.addFlashAttribute(AlertMessage.MODEL_ATTRIBUTE_KEY, alertMessage);

        return new ModelAndView("redirect:/bookbinding/list");
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView edit(@PathVariable String id) throws Exception {
        Bookbinding bookbinding = bookbindingService.findById(id);
        return new ModelAndView("/yinwu/bookbinding/edit", "bookbinding", bookbinding);
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    public ModelAndView edit(@ModelAttribute("bookbinding")EditBookbindingCommand command,
                             RedirectAttributes redirectAttributes,
                             Locale locale) throws Exception {

        bookbindingService.edit(command);

        AlertMessage alertMessage = new AlertMessage(AlertMessage.MessageType.SUCCESS,
                this.getMessage("default.create.success.message", new Object[]{command.getName()}, locale));
        redirectAttributes.addFlashAttribute(AlertMessage.MODEL_ATTRIBUTE_KEY, alertMessage);

        return new ModelAndView("redirect:/bookbinding/list");
    }

    @RequestMapping(value = "/view/{id}")
    public ModelAndView view(@PathVariable String id) throws Exception {
        Bookbinding bookbinding = bookbindingService.findById(id);
        return new ModelAndView("/yinwu/bookbinding/view", "bookbinding", bookbinding);
    }

    @RequestMapping(value = "/delete/{id}")
    public ModelAndView delete(@PathVariable String id, RedirectAttributes redirectAttributes, Locale locale) throws Exception {

        bookbindingService.delete(id);

        AlertMessage alertMessage = new AlertMessage(AlertMessage.MessageType.SUCCESS, this.getMessage("default.delete.success.message",
                new Object[]{id}, locale));
        redirectAttributes.addFlashAttribute(AlertMessage.MODEL_ATTRIBUTE_KEY, alertMessage);

        return new ModelAndView("redirect:/bookbinding/list");
    }

}
