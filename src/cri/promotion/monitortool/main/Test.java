package cri.promotion.monitortool.main;

import java.util.List;

import cri.promotion.monitortool.model.UnavailablePromotionModel;
import cri.promotion.monitortool.service.PromotionService;
import cri.promotion.monitortool.utility.ExcelWrite;

public class Test {

	public static void main(String[] args) {
		try {
			PromotionService promotionService = new PromotionService();
			List<UnavailablePromotionModel> unavailablePromotionModels =  promotionService.getPromotionInfos();
			ExcelWrite.excelWriterList(unavailablePromotionModels);
			
		System.out.println("Unavailable Model size :"+unavailablePromotionModels.size());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
