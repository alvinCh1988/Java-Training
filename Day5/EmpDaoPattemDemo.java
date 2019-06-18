package idv.Day5;

import java.util.List;

import com.emp.model.EmpVO;


public class EmpDaoPattemDemo {
	
	public static void main(String[] args) {
		
		
		EmpDAO dao = new EmpDAO();
		
		String url = "jdbc:mysql://localhost:3306/test1";
	    String userId = "root";
	    String passwd = "root";
		
	     
	     dao.settingDB(url, userId, passwd);
		
	     //insert
//	     EmpVO empVO1 = new EmpVO();
//	     empVO1.setName("GG");
//	     empVO1.setGender("M");
//	     dao.insert(empVO1);
	     
	     //update
//	     EmpVO empVO2 = new EmpVO();
//	     empVO2.setName("GG");
//	     empVO2.setGender("M");
//	     empVO2.setId(1);
//		 dao.update(empVO2);
		 
		 
		 //delete
//		 dao.delete(2);
		
		 
		//QUERY ONE
			EmpVO empVO3 = dao.findByPrimaryKey(3);
			System.out.print(empVO3.getId() + ",");
			System.out.print(empVO3.getName() + ",");
			System.out.println(empVO3.getGender());
			System.out.println("---------------------");	
	     
		 //QUERY ALL
		List<EmpVO> list = dao.getAll();
		for (EmpVO a : list) {
			System.out.print(a.getId()+ ",");
			System.out.print(a.getName()+ ",");
			System.out.print(a.getGender());
			System.out.println();
			
		}
		
	}

}
