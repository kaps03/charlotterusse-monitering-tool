package cri.promotion.monitortool.utility;

public class Query {

	public static String STORE_GET_ALL_PRC_DEAL_MODEL = "SELECT * from PRC_DEAL";
	public static String XRELATE_GET_ALL_CMP_PROMOTION = "SELECT * FROM CMP_PROMOTION";
	public static String XRELATE_JOIN_QUERY = "SELECT promotion.PROMOTION_ID, promotion.PROMOTION_NAME, promotion.START_DATE, promotion.END_DATE,\r\n"
			+ "  storepromo.ATTRIBUTE_NAME, storepromo.ATTRIBUTE_VALUE\r\n"
			+ "  FROM [Relate].[dbo].[CMP_PROMO_STORE_LOCATION] storepromo \r\n"
			+ "  INNER JOIN [Relate].[dbo].[CMP_PROMOTION] promotion \r\n"
			+ "  ON storepromo.PROMOTION_ID = promotion.PROMOTION_ID\r\n" + "  where ATTRIBUTE_NAME ='LOCATION_ID'";

}
