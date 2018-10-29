package cri.promotion.monitortool.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import cri.promotion.monitortool.model.XRelateModel;
import cri.promotion.monitortool.utility.DBConnectionWithXRelate;
import cri.promotion.monitortool.utility.Query;

public class XRelateCmpPromotionDAO {

	private static Logger logger = Logger.getLogger(cri.promotion.monitortool.dao.StorePrcDealDAO.class);

	public List<XRelateModel> getCmpPromotionList() throws SQLException {
		Connection connection = DBConnectionWithXRelate.getConnection();
		
		Statement statement = connection.createStatement();
		logger.info("X-Relate Statement Object created");

		ResultSet resultSet = statement.executeQuery(Query.XRELATE_JOIN_QUERY);
		logger.info("Get CMP_PROMOTION TABLE ResultSet : " + resultSet);

		XRelateModel xRelateModel = null;
		List<XRelateModel> xRelateModels = new ArrayList<>();

		while (resultSet.next()) {
			xRelateModel = new XRelateModel();
			xRelateModel.setPromotionId(resultSet.getInt(1));
			xRelateModel.setStartDate(resultSet.getDate(2));
			xRelateModel.setEndDate(resultSet.getDate(3));
			xRelateModel.setAttributeName(resultSet.getString(4));
			xRelateModel.setStoreNumber(resultSet.getInt(5));
			xRelateModels.add(xRelateModel);
		}

		return xRelateModels;

	}
}
