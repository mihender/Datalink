package Lookup;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LookupController {

	@Resource(name = "LookUpService")
	private LookupService los;

	@RequestMapping("ToonresultaatSaN.htm")
	public String getByGenreSaN(HttpSession session,
			@RequestParam("SaN") String san, Model model) {

		DocuData docu;

		List<DocuData> GenreList = new ArrayList();

		if (san != null) {
			GenreList = los.FindByGenre(san);
		} else {
			System.out.println("Probleemkeee!");
		}

		System.out.println(GenreList.toString());
		model.addAttribute("genrelist", GenreList);

		return "ToonresultaatSaN";

	}

	@RequestMapping("ToonresultaatSaP.htm")
	public String getByGenreSaP(HttpSession session,
			@RequestParam("SaP") String sap, Model model) {

		DocuData docu;

		List<DocuData> GenreList = new ArrayList();

		if (sap != null) {
			GenreList = los.FindByGenre(sap);
		} else {
			System.out.println("Probleemkeee!");
		}

		System.out.println(GenreList.toString());
		model.addAttribute("genrelist", GenreList);

		return "ToonresultaatSaP";

	}

	@RequestMapping("ToonresultaatFaE.htm")
	public String getByGenreFaE(HttpSession session,
			@RequestParam("FaE") String fae, Model model) {

		DocuData docu;

		List<DocuData> GenreList = new ArrayList();

		if (fae != null) {
			GenreList = los.FindByGenre(fae);
		} else {
			System.out.println("Probleemkeee!");
		}

		System.out.println(GenreList.toString());
		model.addAttribute("genrelist", GenreList);

		return "ToonresultaatFaE";

	}

	@RequestMapping("ToonresultaatRaS.htm")
	public String getByGenreRaS(HttpSession session,
			@RequestParam("RaS") String ras, Model model) {

		DocuData docu;

		List<DocuData> GenreList = new ArrayList();

		if (ras != null) {
			GenreList = los.FindByGenre(ras);
		} else {
			System.out.println("Probleemkeee!");
		}

		System.out.println(GenreList.toString());
		model.addAttribute("genrelist", GenreList);

		return "ToonresultaatRaS";

	}

	@RequestMapping("ToonresultaatSearch.htm")
	public String getByGenreSearch(HttpSession session,
			@RequestParam("userInput") String userInput, Model model) {

		DocuData docu;

		List<DocuData> SearchList = new ArrayList();

		if (userInput != null) {
			SearchList = los.FindByNaam(userInput);
		} else {
			System.out.println("Probleemkeee!");
		}

		System.out.println(SearchList.toString());
		model.addAttribute("searchlist", SearchList);

		return "ToonresultaatSearch";

	}

}
