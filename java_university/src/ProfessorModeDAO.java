import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class ProfessorModeDAO extends DBConnection {

	int id =Integer.parseInt(AllStateSession.login_id); //������ȣ	
	
	public ProfessorModeDAO() {
		
	}

	public List<StudentModeVO2> allClassRecord(){ 
		List<StudentModeVO2> list = new ArrayList<StudentModeVO2>();
		try {
			dbConn();
			//Prof_Code�� ������ �� ������ ������ ���Ǹ� �����´� , �ٵ� ���ǹ�ȣ��� �̸� �����´�
			String sql = " SELECT C.CLASS_CODE ,P.PROF_NAME ,C.CLASS_DIV ,C.CLASS_NAME ,c.CLASS_GRADE "
				     +",C.CLASS_TIME , C.CLASS_ROOM , C.TOT_MEM , C.REG_MEM , to_char(C.CLASS_DATE,'YY-MM-DD') "
				     +"from CLASS C , PROFESSOR P "
				     +"where P.Prof_Code=? and P.Prof_Code = C.PROF_CODE";
			System.out.println("sql"+sql);
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,id);	
			
			rs =pstmt.executeQuery(); //���õȷ��ڵ��� ������ ������:����Ʈ������
				
				
			while(rs.next()) {
				StudentModeVO2 vo = new StudentModeVO2();
				vo.setClass_code(rs.getInt(1));
				vo.setProf_name(rs.getString(2));
				vo.setClass_div(rs.getString(3));
				vo.setClass_name(rs.getString(4));
				vo.setClass_grade(rs.getString(5));
				vo.setClass_time(rs.getString(6));
				vo.setClass_room(rs.getString(7));
				vo.setTot_mem(rs.getInt(8));
				vo.setReg_mem(rs.getInt(9));
				vo.setClass_date(rs.getString(10));
				
				list.add(vo);
			}
				
		}catch(Exception e) {
			System.out.println("ProfessorModeDAO ��������������ü��Ͽ��� �߻�.......");
			e.printStackTrace();
		}finally {
			dbClose();
		}
		
		
		
		return list;
	}
	
	//���Ǽ����Է��Ѱ� ��񳻿� ������Ʈ
	public int updateClassRecord(StudentModeVO2 vo){
		int cnt =0;
		
		try {
			dbConn();
			
			String sql ="update class set  class_div=?,class_name=?,class_grade=?,class_time=?,class_room=?,tot_mem=?,reg_mem=? "
					+ " where Class_code=?";

			pstmt = con.prepareStatement(sql);
				
			
			pstmt.setString(1, vo. getClass_div());
			pstmt.setString(2, vo.getClass_name());
			pstmt.setString(3, vo.getClass_grade());
			pstmt.setString(4,vo.getClass_time());
			pstmt.setString(5,vo.getClass_room());
			pstmt.setInt(6,vo.getTot_mem()); 
			pstmt.setInt(7,vo.getReg_mem()); 
			pstmt.setInt(8,vo.getClass_code());
			
	
			cnt = pstmt.executeUpdate();
				
		}catch(Exception e) {
			System.out.println("DAO ���������Ǽ��� ���� �߻�...");
			e.printStackTrace();
		}finally {
			dbClose();
		}
		
		
		return cnt;
	}
	//���Ǹ����� ���ǹ�ȣ��������
	public int searchCladdCode(String search) {
		
		int result=0;
		try {
			dbConn();
			String sql = "select Class_Code "
					+ " from class where class_name like ? ";
			System.out.println("sql"+sql);
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,search); // %��%
			rs =pstmt.executeQuery(); //���õȷ��ڵ��� ������ ������:����Ʈ������
			
			while(rs.next())  {
				result = rs.getInt(1);
			System.out.println(result);
			}
			
		}catch(Exception e) {
			System.out.println("���Ǹ����� ���ǹ�ȣ�������� ���� �߻�.......");
			e.printStackTrace();
		}finally {
			
		}
		return result;
	}
	
	
	//�������ǻ���
	public int deleteClassRecord(int code) {//��ȣ�� �����ͼ� ���̺� �ִ��� ������ Ȯ���ϰ�
		int cnt=0;
		try {
			dbConn();
			String sql = "delete from class where Class_Code=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1,code);
			
			cnt = pstmt.executeUpdate();
			
		}catch(Exception e) {
			System.out.println("ProfessorModeDAO ���ǻ��� ���� �߻�");
			e.printStackTrace();
		}finally {
			dbClose();
		}
		return cnt;			
		
	}
	
	
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//	}

}
