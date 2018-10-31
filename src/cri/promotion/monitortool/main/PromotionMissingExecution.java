package cri.promotion.monitortool.main;

import java.io.File;
import java.util.List;

import org.apache.log4j.Logger;

import cri.promotion.monitortool.email.EmailSender;
import cri.promotion.monitortool.model.UnavailablePromotionModel;
import cri.promotion.monitortool.service.PromotionService;
import cri.promotion.monitortool.utility.ExcelWriter;

public class PromotionMissingExecution {

	private static Logger logger = Logger.getLogger(cri.promotion.monitortool.main.PromotionMissingExecution.class);
	
	public static void main(String[] args) {
		try {
			PromotionService promotionService = new PromotionService();
			logger.info("Calling getMissingPromotionsInfo method for missing promotions");
			List<UnavailablePromotionModel> unavailablePromotionModels =  promotionService.getMissingPromotionsInfo();
			//writing list of data into file..
			logger.info("Writing Missing Promotions into Excel sheet.");
			File excelFile = ExcelWriter.excelWriterList(unavailablePromotionModels);
			logger.info("Missing Promotions successfully written into Excel sheet.");
			//sending email to manager
			logger.info("Sending Email");
			String res = EmailSender.sendEmail(excelFile);
			logger.info(res);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
