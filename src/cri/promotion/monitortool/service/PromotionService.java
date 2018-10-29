package cri.promotion.monitortool.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import cri.promotion.monitortool.dao.StorePrcDealDAO;
import cri.promotion.monitortool.dao.XRelateCmpPromotionDAO;
import cri.promotion.monitortool.model.PrcDealModel;
import cri.promotion.monitortool.model.UnavailablePromotionModel;
import cri.promotion.monitortool.model.XRelateModel;

public class PromotionService {

	public List<UnavailablePromotionModel> getPromotionInfos() {

		StorePrcDealDAO storePrcDealDAO = new StorePrcDealDAO();
		XRelateCmpPromotionDAO xRelateCmpPromotionDAO = new XRelateCmpPromotionDAO();
		List<UnavailablePromotionModel> unavailablePromotionModels = new ArrayList<>();

		try {
			// getting x-relate promotion list
			List<XRelateModel> xRelateModels = xRelateCmpPromotionDAO.getCmpPromotionList();
			UnavailablePromotionModel unavailablePromotionModel = null;

			for (XRelateModel xRelateModel : xRelateModels) {
				List<PrcDealModel> dealModels = storePrcDealDAO
						.getPrcDealModelListByStoreNumber(xRelateModel.getStoreNumber());
				if(dealModels != null && !dealModels.isEmpty()) {
					List<XRelateModel> list = xRelateModels.stream()
							.filter(model -> model.getStoreNumber() == xRelateModel.getStoreNumber())
							.collect(Collectors.toList());

					for (int k = 0; k < list.size(); k++) {
						int count = k;
						List<PrcDealModel> dealModelList = dealModels.stream().filter(
								dealModel -> Integer.parseInt(dealModel.getDealId()) == list.get(count).getPromotionId())
								.collect(Collectors.toList());

						if (dealModelList == null || dealModelList.isEmpty()) {
							unavailablePromotionModel = new UnavailablePromotionModel();
							unavailablePromotionModel.setEndDate(list.get(k).getEndDate());
							unavailablePromotionModel.setStartDate(list.get(k).getStartDate());
							unavailablePromotionModel.setPromotionId(list.get(k).getPromotionId());
							unavailablePromotionModel.setStoreNumber(list.get(k).getStoreNumber());
							unavailablePromotionModels.add(unavailablePromotionModel);
						}

					}
				}else {
					unavailablePromotionModel = new UnavailablePromotionModel();
					unavailablePromotionModel.setStoreNumber(xRelateModel.getStoreNumber());
					unavailablePromotionModel.setStoreStatus("Store has offline.");
					unavailablePromotionModels.add(unavailablePromotionModel);
				}
				
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return unavailablePromotionModels;
	}
}
