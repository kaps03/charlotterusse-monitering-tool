package cri.promotion.monitortool.main;

import java.io.File;
import java.util.List;

import org.apache.log4j.Logger;

import cri.promotion.monitortool.email.EmailSender;
import cri.promotion.monitortool.model.UnavailablePromotionModel;
import cri.promotion.monitortool.service.PromotionService;
import cri.promotion.monitortool.utility.ExcelWrite;

public class PromotionExecution {

	private static Logger logger = Logger.getLogger(cri.promotion.monitortool.main.PromotionExecution.class);
	
	public static void main(String[] args) {
		try {
			PromotionService promotionService = new PromotionService();
			logger.info("Calling list of promotion which is not available into store.");
			List<UnavailablePromotionModel> unavailablePromotionModels =  promotionService.getPromotionInfos();
			//writing list of data into file..
			logger.info("Writing into Excel sheet.");
			File excelFile = ExcelWrite.excelWriterList(unavailablePromotionModels);
			logger.info("Successfully Writtern into Excel sheet.");
			//sending email to manager
			logger.info("Sending Email");
			String res = EmailSender.sendEmail(excelFile);
			logger.info(res);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
