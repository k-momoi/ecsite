package com.internousdev.template.action;

import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;
import java.sql.SQLException;
import com.internousdev.template.dao.MyPageDAO;
import com.internousdev.template.dto.MyPageDTO;
import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;



public class MyPageAction extends ActionSupport implements SessionAware{
	public Map<String, Object> session;
	private MyPageDAO myPageDAO =new MyPageDAO();
	private ArrayList<MyPageDTO> myPageList =new ArrayList<MyPageDTO>();
	private String deleteFlg;
	private String message;


	public String execute() throws SQLException{

		if(!session.containsKey("id"))
		{
			return ERROR;
		}

		if(deleteFlg == null)
		{
			String item_transaction_id = session.get("id").toString();
			String user_master_id = session.get("login_user_id").toString();
			myPageList = myPageDAO.getMyPageUserInfo(item_transaction_id,user_master_id);
		}else if(deleteFlg.equals("1")){
			delete();
		}
		String result = SUCCESS;
		return result;
	}

	public void delete() throws SQLException {

		String item_transaction_id = session.get("id").toString();
		String user_master_id = session.get("login_user_id").toString();

		int res = myPageDAO.buyItemHistoryDelete(item_transaction_id, user_master_id);

		if(res > 0){
			myPageList = null;
			setMessage("���i���𐳂����폜���܂����B");
		}else if (res == 0){
			setMessage("���i���̍폜�Ɏ��s���܂����B");
		}
	}


		public void setDeleteFlg(String deleteFlg){
			this.deleteFlg = deleteFlg;
		}

		@Override
		public void setSession(Map<String, Object> Session){
			this.session = Session;
		}

		public ArrayList<MyPageDTO> getMyPageList(){
			return this.myPageList;
		}

		public String getMessage(){
			return this.message;
		}

		public void setMessage(String message){
			this.message = message;
		}
}
