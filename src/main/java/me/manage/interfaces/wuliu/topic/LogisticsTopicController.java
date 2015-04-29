package me.manage.interfaces.wuliu.topic;

import me.manage.domain.model.wuliu.topic.LogisticsTopic;
import me.manage.domain.service.wuliu.topic.ILogisticsTopicService;
import me.manage.infrastructure.persistence.hibernate.generic.Pagination;
import me.manage.interfaces.shared.web.AlertMessage;
import me.manage.interfaces.shared.web.BaseController;
import me.manage.interfaces.wuliu.topic.command.CreateLogisticsCommand;
import me.manage.interfaces.wuliu.topic.command.EditLogisticsCommand;
import me.manage.interfaces.wuliu.topic.command.ListCommand;
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
@RequestMapping("/logistics")
public class LogisticsTopicController extends BaseController {

    @Autowired
    private ILogisticsTopicService logisticsTopicService;

    @RequestMapping("/list")
    public ModelAndView list(@ModelAttribute("topic")ListCommand command) throws Exception {
        Pagination<LogisticsTopic> pagination = logisticsTopicService.pagination(command);
        return new ModelAndView("/wuliu/topic/list", "pagination", pagination)
                .addObject("topic", command);
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public ModelAndView create(@ModelAttribute("topic")CreateLogisticsCommand command) throws Exception {
        return new ModelAndView("/wuliu/topic/create", "topic", command);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ModelAndView create(@ModelAttribute("topic")CreateLogisticsCommand command,
                               RedirectAttributes redirectAttributes,
                               Locale locale) throws Exception {

        logisticsTopicService.create(command);

        AlertMessage alertMessage = new AlertMessage(AlertMessage.MessageType.SUCCESS,
                this.getMessage("default.create.success.message", new Object[]{command.getPart()}, locale));
        redirectAttributes.addFlashAttribute(AlertMessage.MODEL_ATTRIBUTE_KEY, alertMessage);

        return new ModelAndView("redirect:/logistics/list");
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView edit(@PathVariable String id) throws Exception {
        LogisticsTopic topic = logisticsTopicService.findById(id);
        return new ModelAndView("/wuliu/topic/edit", "topic", topic);
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    public ModelAndView edit(@ModelAttribute("topic")EditLogisticsCommand command,
                             RedirectAttributes redirectAttributes,
                             Locale locale) throws Exception {

        logisticsTopicService.edit(command);

        AlertMessage alertMessage = new AlertMessage(AlertMessage.MessageType.SUCCESS,
                this.getMessage("default.create.success.message", new Object[]{command.getPart()}, locale));
        redirectAttributes.addFlashAttribute(AlertMessage.MODEL_ATTRIBUTE_KEY, alertMessage);

        return new ModelAndView("redirect:/logistics/list");
    }

    @RequestMapping(value = "/view/{id}")
    public ModelAndView view(@PathVariable String id) throws Exception {
        LogisticsTopic topic = logisticsTopicService.findById(id);
        return new ModelAndView("/wuliu/topic/view", "topic", topic);
    }

    @RequestMapping(value = "/delete/{id}")
    public ModelAndView delete(@PathVariable String id, RedirectAttributes redirectAttributes, Locale locale) throws Exception {

        logisticsTopicService.delete(id);

        AlertMessage alertMessage = new AlertMessage(AlertMessage.MessageType.SUCCESS, this.getMessage("default.delete.success.message",
                new Object[]{id}, locale));
        redirectAttributes.addFlashAttribute(AlertMessage.MODEL_ATTRIBUTE_KEY, alertMessage);

        return new ModelAndView("redirect:/logistics/list");
    }

    @RequestMapping(value = "/verified/{id}")
    public ModelAndView verified(@PathVariable String id, String status) throws Exception {
        logisticsTopicService.changeStatus(id, status);
        return new ModelAndView("redirect:/logistics/list");
    }

}
