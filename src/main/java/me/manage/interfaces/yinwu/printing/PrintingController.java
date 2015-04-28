package me.manage.interfaces.yinwu.printing;

import me.manage.domain.model.yinwu.printing.Printing;
import me.manage.domain.service.yinwu.printing.IPrintingService;
import me.manage.infrastructure.persistence.hibernate.generic.Pagination;
import me.manage.interfaces.shared.web.AlertMessage;
import me.manage.interfaces.shared.web.BaseController;
import me.manage.interfaces.yinwu.printing.command.CreatePrintingCommand;
import me.manage.interfaces.yinwu.printing.command.EditPrintingCommand;
import me.manage.interfaces.yinwu.printing.command.ListCommand;
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
@RequestMapping("/printing")
public class PrintingController extends BaseController {

    @Autowired
    private IPrintingService printingService;

    @RequestMapping("/list")
    public ModelAndView list(@ModelAttribute("printing")ListCommand command) throws Exception {
        Pagination<Printing> pagination = printingService.pagination(command);
        return new ModelAndView("/yinwu/printing/list", "pagination", pagination)
                .addObject("printing", command);
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public ModelAndView create(@ModelAttribute("printing")CreatePrintingCommand command) throws Exception {
        return new ModelAndView("/yinwu/printing/create", "printing", command);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ModelAndView create(@ModelAttribute("printing")CreatePrintingCommand command,
                               RedirectAttributes redirectAttributes,
                               Locale locale) throws Exception {

        printingService.create(command);

        AlertMessage alertMessage = new AlertMessage(AlertMessage.MessageType.SUCCESS,
                this.getMessage("default.create.success.message", new Object[]{command.getName()}, locale));
        redirectAttributes.addFlashAttribute(AlertMessage.MODEL_ATTRIBUTE_KEY, alertMessage);

        return new ModelAndView("redirect:/printing/list");
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView edit(@PathVariable String id) throws Exception {
        Printing printing = printingService.findById(id);
        return new ModelAndView("/yinwu/printing/edit", "printing", printing);
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    public ModelAndView edit(@ModelAttribute("printing")EditPrintingCommand command,
                             RedirectAttributes redirectAttributes,
                             Locale locale) throws Exception {

        printingService.edit(command);

        AlertMessage alertMessage = new AlertMessage(AlertMessage.MessageType.SUCCESS,
                this.getMessage("default.create.success.message", new Object[]{command.getName()}, locale));
        redirectAttributes.addFlashAttribute(AlertMessage.MODEL_ATTRIBUTE_KEY, alertMessage);

        return new ModelAndView("redirect:/printing/list");
    }

    @RequestMapping(value = "/view/{id}")
    public ModelAndView view(@PathVariable String id) throws Exception {
        Printing printing = printingService.findById(id);
        return new ModelAndView("/yinwu/printing/view", "printing", printing);
    }

    @RequestMapping(value = "/delete/{id}")
    public ModelAndView delete(@PathVariable String id, RedirectAttributes redirectAttributes, Locale locale) throws Exception {

        printingService.delete(id);

        AlertMessage alertMessage = new AlertMessage(AlertMessage.MessageType.SUCCESS, this.getMessage("default.delete.success.message",
                new Object[]{id}, locale));
        redirectAttributes.addFlashAttribute(AlertMessage.MODEL_ATTRIBUTE_KEY, alertMessage);

        return new ModelAndView("redirect:/printing/list");
    }

}
