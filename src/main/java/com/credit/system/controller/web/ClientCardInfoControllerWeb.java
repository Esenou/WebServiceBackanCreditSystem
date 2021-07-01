package com.credit.system.controller.web;


import com.credit.system.entity.Client;
import com.credit.system.entity.ClientAdditionalInfo;
import com.credit.system.entity.ClientCardInfo;
import com.credit.system.enums.ListStatus;
import com.credit.system.service.ClientCardInfoService;
import com.credit.system.service.ClientService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("cardInfo")
public class ClientCardInfoControllerWeb {

    private final ClientCardInfoService clientCardInfoService;

    private static final Logger logger = LogManager.getLogger(ClientCardInfoControllerWeb.class);

    public ClientCardInfoControllerWeb(ClientCardInfoService clientCardInfoService) {
        this.clientCardInfoService = clientCardInfoService;
    }

    @GetMapping("{id}")
    public String getClientCardInfo(@PathVariable("id") Long id, Model model) {

        ClientCardInfo cardInfo = clientCardInfoService.findByClientId(id);
        model.addAttribute("clientCardInfo", cardInfo);
        model.addAttribute("add", false);

        return "clientCardInfoForm";
    }


    @PostMapping("/updateCardInfo/{id}")
    public String updateClientAddInfo(@PathVariable("id") Long id
            , @ModelAttribute("client") Client client, Model model
            , @ModelAttribute("clientCardInfo") ClientCardInfo cardInfo,BindingResult result
    ) {

        ClientCardInfo oldCardInfo = clientCardInfoService.findById(id);

        if(result.hasErrors()){
            model.addAttribute("clientCardInfo", oldCardInfo);
            model.addAttribute("add", false);
        }

        cardInfo.setId(oldCardInfo.getId());
        cardInfo.setCreateDate(oldCardInfo.getCreateDate());
        cardInfo.setClient(client);
        clientCardInfoService.update(cardInfo);
        return "redirect:/client/" + client.getId();
    }

    @PostMapping("delete/{id}")
    public String deleteById(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
        try {
            clientCardInfoService.deleteById(id);
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("has_exception", true);
            return "redirect:/client/" + id;
        }
        return "redirect:/client/list";
    }
}
