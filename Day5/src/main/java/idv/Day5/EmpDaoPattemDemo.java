package idv.Day5;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmpDaoPattemDemo {

	public static void main(String[] args) {

		EmpDAO dao = new EmpDAO();
		EmpDaoPattemDemo ptm = new EmpDaoPattemDemo();
		ReadSourceFile rsf = new ReadSourceFile();
		Map<String, String> map = new HashMap<String, String>();

		String path = "";

		if (args[0] != null) {
			path = args[0];
		}

		map = rsf.readFile(path);

		String url = map.get("ConnectionConnection");
		String userId = map.get("UserId");
		String passwd = map.get("Password");

		dao.settingDB(url, userId, passwd);

		String action = map.get("Action");

		System.out.println("=== Action: " + action + " === ");
		System.out.println();

		if (action.equals("C")) {
			String[] values = map.get("C.Data").split(",");

			String name = null;
			String gender = null;
			;
			if (values.length == 2) {
				name = values[0];
				gender = values[1];
			} else {
				System.out.println("Please enter the correct format");
			}

			// insert
			EmpVO empVO1 = new EmpVO();
			empVO1.setName(name);
			empVO1.setGender(gender);
			dao.insert(empVO1);
			
			ptm.queryAll();
		}

		if (action.equals("R")) {
			// QUERY ONE

			int id = Integer.valueOf(map.get("R.ID")).intValue();

			EmpVO empVO3 = dao.findByPrimaryKey(id);
			System.out.println("=============");
			System.out.print(empVO3.getId() + " | ");
			System.out.print(empVO3.getName() + " | ");
			System.out.println(empVO3.getGender());
			System.out.println("=============");
		}

		if (action.equals("U")) {
			String[] values = map.get("U.Data").split(",");

			String sid = null;
			String name = null;
			String gender = null;

			if (values.length == 3) {
				sid = values[0];
				name = values[1];
				gender = values[2];
			} else {
				System.out.println("Please enter the correct format");
			}

			int id = Integer.valueOf(sid).intValue();

			// update
			EmpVO empVO2 = new EmpVO();
			empVO2.setName(name);
			empVO2.setGender(gender);
			empVO2.setId(id);
			dao.update(empVO2);
			
			ptm.queryAll();
		}

		if (action.equals("D")) {
			// delete

			int id = Integer.valueOf(map.get("D.ID")).intValue();
			dao.delete(id);
			
			ptm.queryAll();
		}

		

	}
	
	private void queryAll() {
		// QUERY ALL
				EmpDAO dao = new EmpDAO();
				List<EmpVO> list = dao.getAll();
				System.out.println("=============");
				for (EmpVO a : list) {
					System.out.print(" . " + a.getId() + " | ");
					System.out.print(a.getName() + " | ");
					System.out.print(a.getGender());
					System.out.println();
				}
				System.out.println("=============");
	}

}
