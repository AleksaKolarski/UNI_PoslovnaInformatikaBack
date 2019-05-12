package com.projekat.poslovna;

import com.projekat.poslovna.entity.*;
import com.projekat.poslovna.entity.enums.DocumentType;
import com.projekat.poslovna.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class PoslovnaApplication {

	public static void main(String[] args) {
		SpringApplication.run(PoslovnaApplication.class, args);
	}

	@Autowired private UnitService unitService;
	@Autowired private CityService cityService;
	@Autowired private CompanyService companyService;
	@Autowired private BusinessPartnerService businessPartnerService;
	@Autowired private ArticleGroupService articleGroupService;
	@Autowired private ArticleService articleService;
	@Autowired private FiscalYearService fiscalYearService;

	@PostConstruct
	public void initialData(){
		City cityNoviSad = cityService.create(new City("Novi Sad", "021"));
		City cityBelgrade = cityService.create(new City("Belgrade", "011"));

		Company company = companyService.create(new Company("TimRaketa", "123456789", "Naroda 29", cityNoviSad));

		BusinessPartner businessPartner1 = businessPartnerService
				.create(new BusinessPartner("MaxBet", "567891234", "Bogoslvaij 23", cityNoviSad));
		BusinessPartner businessPartner2 = businessPartnerService
				.create(new BusinessPartner("Societe Generale", "567123894", "Kaliena 2243", cityBelgrade));


		Unit unitLiter = unitService.create(new Unit("liter", "l"));
		Unit unitKilogram = unitService.create(new Unit("kilogram", "kg"));
		Unit unitPiece = unitService.create(new Unit("piece", "pc"));

		ArticleGroup articleGroupGraphicCard = articleGroupService.create(new ArticleGroup("Graphic Card"));
		ArticleGroup articleGroupCoolingFluid = articleGroupService.create(new ArticleGroup("Cooling fluid"));
		ArticleGroup articleGroupCpu = articleGroupService.create(new ArticleGroup("CPU"));

		Article articleGeForce = articleService.create(new Article("GeForce 1080", unitPiece, articleGroupGraphicCard));
		Article articleI9 = articleService.create(new Article("i9 8thGen", unitPiece, articleGroupCpu));
		Article articleCooler = articleService.create(new Article("CollerMaster 125ml", unitLiter, articleGroupCoolingFluid));



		FiscalYear fiscalYear2019 = fiscalYearService.create(new FiscalYear(2019, false));

		ArticleCard articleCard1 = ArticleCard.builder()
				.price(2400000)
				.startStateValue(20) // TODO: 09 May 2019 15:28 milan.miljus sta je ovo???
				.inValue(100000)
				.outValue(50000)
				.article(articleGeForce)
				.fiscalYear(fiscalYear2019)
				.build();

		ArticleCardAnalytics articleCardAnalytics11 =
				new ArticleCardAnalytics(DocumentType.IMPORT, 2400000, 1, articleCard1);
		ArticleCardAnalytics articleCardAnalytics12 =
				new ArticleCardAnalytics(DocumentType.EXPORT, 2400000, 1, articleCard1);
		ArticleCardAnalytics articleCardAnalytics13 =
				new ArticleCardAnalytics(DocumentType.IMPORT, 2400000, 1, articleCard1);
	}

}

