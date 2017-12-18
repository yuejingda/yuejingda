package com.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.xiudun.mvc.NeedResponse;

import com.domain.User1;
import com.service.UserService;


public class UserExportAction implements NeedResponse {
	private List<User1> users;
	private HttpServletResponse resp;
	
	public List<User1> getUsers() {
		return users;
	}

	public void setUsers(List<User1> users) {
		this.users = users;
	}

	public HttpServletResponse getResp() {
		return resp;
	}

	public void setResp(HttpServletResponse resp) {
		this.resp = resp;
	}

		//------------------------------批量导出-------------------------
		public String userExport(){
			try{
			 users = new UserService().findUserAll();
			 Workbook book = new HSSFWorkbook();
			//创建单元
				Sheet sheet = book.createSheet();
				//创建行
				Row row = sheet.createRow(0);
				//创建列
				Cell cell1 = row.createCell(0);
				Cell cell2 = row.createCell(1);
				Cell cell3 = row.createCell(2);
				Cell cell4 = row.createCell(3);
				cell1.setCellValue("用户编号");
				cell2.setCellValue("用户名称");
				cell3.setCellValue("用户真实姓名");
				cell4.setCellValue("用户状态");
				for(int i=0;i<users.size();i++){
					Row r = sheet.createRow(i+1);
					Cell c1 = r.createCell(0);
					Cell c2 = r.createCell(1);
					Cell c3 = r.createCell(2);
					Cell c4 = r.createCell(3);
					c1.setCellValue(users.get(i).getUno());
					c2.setCellValue(users.get(i).getUname());
					c3.setCellValue(users.get(i).getTruename());
					c4.setCellValue(users.get(i).getFlag());
				}
				//保存到本地临时文件中
				File file = new File("e:/temp.xls");
				FileOutputStream fos = new FileOutputStream(file);
				book.write(fos);
				fos.close();
				
				//下载
				resp.setContentType("application/vnd.ms-excel");
				resp.setHeader("Content-Disposition", "attachment;filename=users.xls");
				
				FileInputStream fis = new FileInputStream(file);
				while(true){
					int b = fis.read();
					if(b==-1){
						break;
					}
					resp.getOutputStream().write(b);
				}
				resp.getOutputStream().flush();
				fis.close();
			}catch(Exception e){
				e.printStackTrace();
			}
				
			 
			 return null;
		}

	@Override
	public void needResponse(HttpServletResponse arg0) {
		this.resp = arg0;
		
	}
}
