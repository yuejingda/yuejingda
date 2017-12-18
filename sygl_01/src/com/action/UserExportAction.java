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

		//------------------------------��������-------------------------
		public String userExport(){
			try{
			 users = new UserService().findUserAll();
			 Workbook book = new HSSFWorkbook();
			//������Ԫ
				Sheet sheet = book.createSheet();
				//������
				Row row = sheet.createRow(0);
				//������
				Cell cell1 = row.createCell(0);
				Cell cell2 = row.createCell(1);
				Cell cell3 = row.createCell(2);
				Cell cell4 = row.createCell(3);
				cell1.setCellValue("�û����");
				cell2.setCellValue("�û�����");
				cell3.setCellValue("�û���ʵ����");
				cell4.setCellValue("�û�״̬");
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
				//���浽������ʱ�ļ���
				File file = new File("e:/temp.xls");
				FileOutputStream fos = new FileOutputStream(file);
				book.write(fos);
				fos.close();
				
				//����
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
