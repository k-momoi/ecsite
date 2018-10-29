package com.internousdev.template.action;


import java.sql.SQLException;
import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;
import com.opensymphony.xwork2.ActionSupport;
import com.internousdev.template.dao.BuyItemCompleteDAO;

public class BuyItemConfirmAction extends ActionSupport implements SessionAware{

	private Map<String, Object> session;
	private BuyItemCompleteDAO buyItemCompleteDAO = new BuyItemCompleteDAO();
	public String execute() throws SQLException{


		buyItemCompleteDAO.buyItemeInfo(
				session.get("id").toString(),
				session.get("login_user_id").toString(),
				session.get("buyItem_price").toString(),
				session.get("count").toString(),
				session.get("pay").toString());

		String result = SUCCESS;
		return result;

	}


	@Override
	public void setSession(Map<String, Object> session){
		this.session = session;
	}

}
