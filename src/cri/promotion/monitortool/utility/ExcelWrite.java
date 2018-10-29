package cri.promotion.monitortool.utility;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import cri.promotion.monitortool.model.UnavailablePromotionModel;

public class ExcelWrite {

	private static Logger logger = Logger.getLogger(cri.promotion.monitortool.utility.ExcelWrite.class);

	private static final String FILE_NAME = "PromotionFile.xlsx";

	public static boolean excelWriterList(List<UnavailablePromotionModel> list) {
		if(list == null || list.isEmpty()) {
			return false;
		}
		
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("Promotions");
		logger.info("Excel sheet is created.");

		Row headerRow = sheet.createRow(0);
		
		Cell cell1 = headerRow.createCell(0);
		cell1.setCellValue("STORE NUMBER");
		Cell cell2 = headerRow.createCell(1);
		cell2.setCellValue("PROMOTION ID");
		Cell cell3 = headerRow.createCell(2);
		cell3.setCellValue("START DATE");
		Cell cell4 = headerRow.createCell(3);
		cell4.setCellValue("END DATE");
		Cell cell5 = headerRow.createCell(4);
		cell5.setCellValue("STORE STATUS");		
		sheet.autoSizeColumn(0);
		sheet.autoSizeColumn(1);
		sheet.autoSizeColumn(2);
		sheet.autoSizeColumn(3);
		sheet.autoSizeColumn(4);
		
		int rowNum = 1;
		
		for (UnavailablePromotionModel unablabelPromotionModel : list) {
			int colNum = 0;
			Row row = sheet.createRow(rowNum++);
			
			if(unablabelPromotionModel.getStoreNumber() != null) {
				Cell storeCell = row.createCell(colNum++);
				storeCell.setCellValue(unablabelPromotionModel.getStoreNumber());
			}
			if(unablabelPromotionModel.getPromotionId() != null) {
				Cell promotionCell = row.createCell(colNum++);
				promotionCell.setCellValue(unablabelPromotionModel.getPromotionId());
			}
			if(unablabelPromotionModel.getStartDate() != null) {
				Cell startDateCell = row.createCell(colNum++);
				startDateCell.setCellValue(unablabelPromotionModel.getStartDate().toString());
			}
			if(unablabelPromotionModel.getEndDate() != null) {
				Cell endDateCell = row.createCell(colNum++);
				endDateCell.setCellValue(unablabelPromotionModel.getEndDate().toString());
			}
			Cell storeStatusCell = row.createCell(4);
			if(unablabelPromotionModel.getStoreStatus() != null) {
				storeStatusCell.setCellValue(unablabelPromotionModel.getStoreStatus());
			}else {
				storeStatusCell.setCellValue("Online");
			}
			
			


		}

		try {
			FileOutputStream outputStream = new FileOutputStream(FILE_NAME);
			workbook.write(outputStream);
			logger.info("Data is succesfully saved into Excel sheet.");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return true;
	}
}
