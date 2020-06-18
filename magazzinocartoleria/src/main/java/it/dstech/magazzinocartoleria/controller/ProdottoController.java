package it.dstech.magazzinocartoleria.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import it.dstech.magazzinocartoleria.model.Prodotto;
import it.dstech.magazzinocartoleria.service.ProdottoService;


@Controller
public class ProdottoController {

	@Autowired
	private ProdottoService prodottoService;
	
	@RequestMapping("/")
	public ModelAndView home() {
		List<Prodotto> listaProdotto = prodottoService.listAll();
		ModelAndView mav = new ModelAndView("index");
		mav.addObject("listaProdotto", listaProdotto);
		return mav;
	}
	
	@RequestMapping("/new")
	public String newProdottoForm(Map<String, Object> model) {
		Prodotto prodotto = new Prodotto();
		model.put("prodotto", prodotto);
		return "new_prodotto";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveProdotto(@ModelAttribute("prodotto") Prodotto prodotto) {
		prodottoService.save(prodotto);
		return "redirect:/";
	}
	
	@RequestMapping("/edit")
	public ModelAndView editProdottoForm(@RequestParam long id) {
		ModelAndView mav = new ModelAndView("edit_prodotto");
		Prodotto prodotto = prodottoService.get(id);
		mav.addObject("prodotto", prodotto);
		
		return mav;
	}
	
	@RequestMapping("/delete")
	public String deleteProdottoForm(@RequestParam long id) {
		prodottoService.delete(id);
		return "redirect:/";		
	}
	
	@RequestMapping("/search")
	public ModelAndView search(@RequestParam String keyword) {
		List<Prodotto> result = prodottoService.search(keyword);
		ModelAndView mav = new ModelAndView("search");
		mav.addObject("result", result);
		
		return mav;		
	}	
	
	@RequestMapping(value  = "/indietro", method = RequestMethod.POST)
	public ModelAndView indietro(Model model) {
		
		ModelAndView newModel = new ModelAndView("redirect:/");
		return newModel;
		
	}
}
