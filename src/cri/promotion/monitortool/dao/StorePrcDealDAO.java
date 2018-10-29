package cri.promotion.monitortool.dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import cri.promotion.monitortool.model.PrcDealModel;
import cri.promotion.monitortool.utility.DBConnectionWithStore;
import cri.promotion.monitortool.utility.Query;
import cri.promotion.monitortool.utility.StoreConnectionUtility;

public class StorePrcDealDAO {

	private static Logger logger = Logger.getLogger(cri.promotion.monitortool.dao.StorePrcDealDAO.class);
	
	public List<PrcDealModel> getPrcDealModelList() throws SQLException {
		Connection connection = DBConnectionWithStore.getConnection();
		Statement statement = connection.createStatement();
		logger.info("Statement Object created");
		ResultSet resultSet = statement.executeQuery(Query.STORE_GET_ALL_PRC_DEAL_MODEL);
		logger.info("Get ResultSet : "+ resultSet);
		PrcDealModel model;
		List<PrcDealModel> dealModels = new ArrayList<>();
		
		while(resultSet.next()) {
			model =new PrcDealModel();
			model.setOrganizationId(resultSet.getInt(1));
			dealModels.add(model);
		}
		
		return dealModels;
		
	} 
	
	public List<PrcDealModel> getPrcDealModelListByStoreNumber(Integer storeNumber){
		if(storeNumber == null) 
			return null;

		List<PrcDealModel> dealModels = new ArrayList<>();
		try {
			Connection connection = StoreConnectionUtility.getConnectionByStoreNumber(storeNumber);
			if(connection == null)
				return null;
			Statement  statement = connection.createStatement();
			logger.info("Statement Object created");
			ResultSet resultSet = statement.executeQuery(Query.STORE_GET_ALL_PRC_DEAL_MODEL);
			logger.info("Get ResultSet : "+ resultSet);
			PrcDealModel model = null;
			while(resultSet.next()) {
				model =new PrcDealModel();
				model.setDealId(resultSet.getString(2).split(":")[0]);
				dealModels.add(model);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return dealModels;
		
	}
}
