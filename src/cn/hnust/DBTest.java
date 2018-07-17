package cn.hnust;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Random;

public class DBTest {

	public static void main(String[] args) {
		try {
			DBConnection b =new DBConnection();
			//String sql = "insert into student(id,name,age,dept,address) values('1507','Tom',20,'计算机','湖南')";
			
			//b.execute(sql);
			ResultSet rs = b.executeQuery("select * from student");
			
			ArrayList<Question> list = new ArrayList();
			while(rs.next()){
				String id = rs.getString(1);
				String question = rs.getString(2);
				String optA = rs.getString(3);
				String optB = rs.getString(4);
				String optC = rs.getString(5);
				String optD = rs.getString(5);
				String answer = rs.getString(5);
				Question t = new Question(id,question,optA,optB,optC,optD,answer);
				list.add(t);
			}
			b.close();
			Random r = new Random();
			int j=0;
			int[] ques= {-1,-1,-1,-1};
			while(j<4) {
				int randnumber = r.nextInt(list.size());
				System.out.println(randnumber);
				//if not exist 
				ques[j] = randnumber;
				j++;
			}
			
			for(int k=0;k<4;k++) {
				Question s = list.get(k);
				//System.out.println(s.getId());
				//System.out.println(s.getName());
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
