package cn.hnust;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import cn.hnust.DBConnection;

public class Search extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/plain;charset=utf-8");
		String question_id = request.getParameter("id");
		System.out.println("id:" + question_id);
		
		try {
			////////////
			// do something
			////////////
			DBConnection db = new DBConnection();
			ResultSet rs = db.executeQuery("select * from question");
			
			String id = "";
			String question = "";
			String optA = "";
			String optB = "";
			String optC = "";
			String optD = "";
			String answer = "";
			
			int count = 0;
			ArrayList<Question> list = new ArrayList<Question>();
			while(rs.next()){
				count ++;
				id=rs.getString(1);
				question=rs.getString(2);
				optA=rs.getString(3);
				optB=rs.getString(4);
				optC=rs.getString(5);
				optD=rs.getString(6);
				answer=rs.getString(7);
				Question q = new Question(id,question,optA,optB,optC,optD,answer);
				list.add(q);
			}
			db.close();
			
			response.setCharacterEncoding("utf-8");
			PrintWriter out = response.getWriter();
			JSONObject obj = new JSONObject();
			
			JSONObject obj1 = new JSONObject();
			Question q1 = list.get(0);
			obj1.put("result", "ok");
			obj1.put("id", q1.id);
			obj1.put("question",q1.question);
			obj1.put("optA", q1.optA);
			obj1.put("optB", q1.optB);
			obj1.put("optC", q1.optC);
			obj1.put("optD", q1.optD);
			obj1.put("answer", q1.answer);
			obj.put("question1",obj1);
			
			JSONObject obj2 = new JSONObject();
			Question q2 = list.get(1);
			obj2.put("result", "ok");
			obj2.put("id", q2.id);
			obj2.put("question",q2.question);
			obj2.put("optA", q2.optA);
			obj2.put("optB", q2.optB);
			obj2.put("optC", q2.optC);
			obj2.put("optD", q2.optD);
			obj2.put("answer", q2.answer);
			obj.put("question1",obj2);
			
			JSONObject obj3 = new JSONObject();
			Question q3 = list.get(2);
			obj3.put("result", "ok");
			obj3.put("id", q3.id);
			obj3.put("question",q3.question);
			obj3.put("optA", q3.optA);
			obj3.put("optB", q3.optB);
			obj3.put("optC", q3.optC);
			obj3.put("optD", q3.optD);
			obj3.put("answer", q3.answer);
			obj.put("question1",obj3);
			
			JSONObject obj4 = new JSONObject();
			Question q4 = list.get(3);
			obj4.put("result", "ok");
			obj4.put("id", q4.id);
			obj4.put("question",q4.question);
			obj4.put("optA", q4.optA);
			obj4.put("optB", q4.optB);
			obj4.put("optC", q4.optC);
			obj4.put("optD", q4.optD);
			obj4.put("answer", q4.answer);
			obj.put("question1",obj4);
			
			System.out.println(obj.toString());
			out.print(obj.toString());
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void doSearch(String question_id) {
		try {
			
			DBConnection db = new DBConnection();
			ResultSet rs = db.executeQuery("select * from question where id = '" + 	question_id +"'");
			
			String id = "";
			String question = "";
			String optA = "";
			String optB = "";
			String optC = "";
			String optD = "";
			String answer = "";
			
			while(rs.next()){
				id=rs.getString(1);
				question=rs.getString(2);
				optA=rs.getString(3);
				optB=rs.getString(4);
				optC=rs.getString(5);
				optD=rs.getString(6);
				answer=rs.getString(7);
			}
			db.close();
			
			JSONObject obj = new JSONObject();
			
			obj.put("result", "ok");
			obj.put("id", id);
			obj.put("question", question);
			obj.put("optA", optA);
			obj.put("optB", optB);
			obj.put("optC", optC);
			obj.put("optD", optD);
			obj.put("answer", answer);
			
			System.out.println(obj.toString());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		doSearch("2");
	}

}
