package me.manage.interfaces.faxing.issue;

import me.manage.domain.model.faxing.issue.Issue;
import me.manage.domain.service.faxing.issue.IIssueService;
import me.manage.infrastructure.persistence.hibernate.generic.Pagination;
import me.manage.interfaces.faxing.issue.command.CreateIssueCommand;
import me.manage.interfaces.faxing.issue.command.EditIssueCommand;
import me.manage.interfaces.faxing.issue.command.ListCommand;
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
@RequestMapping("/issue")
public class IssueController extends BaseController {

    @Autowired
    private IIssueService issueService;

    @RequestMapping("/list")
    public ModelAndView list(@ModelAttribute("issue")ListCommand command) throws Exception {
        Pagination<Issue> pagination = issueService.pagination(command);
        return new ModelAndView("/faxing/issue/list", "pagination", pagination)
                .addObject("issue", command);
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public ModelAndView create(@ModelAttribute("issue")CreateIssueCommand command) throws Exception {
        return new ModelAndView("/faxing/issue/create", "issue", command);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ModelAndView create(@ModelAttribute("issue")CreateIssueCommand command,
                               RedirectAttributes redirectAttributes,
                               Locale locale) throws Exception {

        issueService.create(command);

        AlertMessage alertMessage = new AlertMessage(AlertMessage.MessageType.SUCCESS,
                this.getMessage("default.create.success.message", new Object[]{command.getPart()}, locale));
        redirectAttributes.addFlashAttribute(AlertMessage.MODEL_ATTRIBUTE_KEY, alertMessage);

        return new ModelAndView("redirect:/issue/list");
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView edit(@PathVariable String id) throws Exception {
        Issue issue = issueService.findById(id);
        return new ModelAndView("/faxing/issue/edit", "issue", issue);
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    public ModelAndView edit(@ModelAttribute("issue")EditIssueCommand command,
                             RedirectAttributes redirectAttributes,
                             Locale locale) throws Exception {

        issueService.edit(command);

        AlertMessage alertMessage = new AlertMessage(AlertMessage.MessageType.SUCCESS,
                this.getMessage("default.create.success.message", new Object[]{command.getPart()}, locale));
        redirectAttributes.addFlashAttribute(AlertMessage.MODEL_ATTRIBUTE_KEY, alertMessage);

        return new ModelAndView("redirect:/issue/list");
    }

    @RequestMapping(value = "/view/{id}")
    public ModelAndView view(@PathVariable String id) throws Exception {
        Issue issue = issueService.findById(id);
        return new ModelAndView("/faxing/issue/view", "issue", issue);
    }

    @RequestMapping(value = "/delete/{id}")
    public ModelAndView delete(@PathVariable String id, RedirectAttributes redirectAttributes, Locale locale) throws Exception {

        issueService.delete(id);

        AlertMessage alertMessage = new AlertMessage(AlertMessage.MessageType.SUCCESS, this.getMessage("default.delete.success.message",
                new Object[]{id}, locale));
        redirectAttributes.addFlashAttribute(AlertMessage.MODEL_ATTRIBUTE_KEY, alertMessage);

        return new ModelAndView("redirect:/issue/list");
    }

    @RequestMapping(value = "/verified/{id}")
    public ModelAndView verified(@PathVariable String id, String status) throws Exception {
        issueService.changeStatus(id, status);
        return new ModelAndView("redirect:/issue/list");
    }

}
