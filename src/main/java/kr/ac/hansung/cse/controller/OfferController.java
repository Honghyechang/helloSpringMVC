package kr.ac.hansung.cse.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import kr.ac.hansung.cse.model.Offer;
import kr.ac.hansung.cse.service.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class OfferController {
    //controller -> service 호출 -> dao
    @Autowired
    private OfferService offerService;

    @GetMapping("/offers")
    public String showOffers(Model model){

        List<Offer> offers=offerService.getAlloffers();
        model.addAttribute("id_offers", offers);

        return "offers";
    }
    @GetMapping("/createoffer")
    public String creatOffer(Model model){

       model.addAttribute("offer", new Offer());
       return "createoffer";
    }
    @PostMapping("/docreate")
    public String doCreate(@Valid Offer offer, BindingResult result){
        if(result.hasErrors()){
            List<ObjectError> errors=result.getAllErrors();
            for(ObjectError error:errors){
                System.out.println(error.getDefaultMessage());
            }
            return "createoffer";
        }

        System.out.println(offer);
        offerService.insertOffer(offer);

        //return "redirect:/offers";
        return "offercreated";
    }
}
