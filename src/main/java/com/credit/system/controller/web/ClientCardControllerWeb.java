package com.credit.system.controller.web;

import com.credit.system.entity.Client;
import com.credit.system.entity.ClientAdditionalInfo;
import com.credit.system.entity.ClientCardInfo;
import com.credit.system.service.ClientCardInfoService;
import com.credit.system.service.ClientService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("card")
public class ClientCardControllerWeb {

    private ClientCardInfoService clientCardInfoService;
    private ClientService clientService;

    public ClientCardControllerWeb(ClientCardInfoService clientCardInfoService, ClientService clientService) {
        this.clientCardInfoService = clientCardInfoService;
        this.clientService = clientService;
    }


    @GetMapping("{id}")
    public String getCard(@PathVariable("id") long id, Model model){

        ClientCardInfo card = clientCardInfoService.findById(id);
        Client client = card.getClient();
        if(card == null){
            model.addAttribute("card", new ClientCardInfo());
            model.addAttribute("add", true);
            model.addAttribute("client", client);
        } else {

            model.addAttribute("client", card.getClient());
            model.addAttribute("card", card);
            model.addAttribute("add", false);
        }
        return "clientOneCardInfo";
    }

    @GetMapping("/list/{id}")
    public String getCardsList(
            @PathVariable("id") long id,
            @PageableDefault(5) Pageable pageable,
            @RequestParam(value = "search", required = false) String bankAccount
            , Model model){

        Page<ClientCardInfo> cards;

        if(bankAccount != null){
            cards = clientCardInfoService.findByAccount(pageable,bankAccount);
        } else {
            cards = clientCardInfoService.findByClientId(pageable, id);
        }

        model.addAttribute("cards", cards);

        return "clientCardInfo";
    }

    @PostMapping("/update/{id}")
    public String updateClientAddInfo(@PathVariable("id") Long id
            , @ModelAttribute("card") ClientCardInfo newCard
    ) {

        ClientCardInfo oldCard = clientCardInfoService.findById(id);
        newCard.setId(oldCard.getId());
        newCard.setCreateDate(oldCard.getCreateDate());
        newCard.setClient(oldCard.getClient());
        clientCardInfoService.update(newCard);
        return "redirect:/card/list/" + newCard.getClient().getId();
    }

    @PostMapping("delete/{id}")
    public String deleteById(@PathVariable("id") Long id, RedirectAttributes redirectAttributes){
        try {
            clientCardInfoService.deleteById(id);
        }catch (Exception e){
            redirectAttributes.addFlashAttribute("has_exception", true);
            return "redirect:/list/" + clientCardInfoService.findById(id).getClient().getId();
        }
        return "redirect:/" + clientCardInfoService.findById(id).getClient().getId() ;
    }

}
