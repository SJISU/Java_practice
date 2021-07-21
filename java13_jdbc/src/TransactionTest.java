
public class TransactionTest extends DBConnection {

	public TransactionTest() {
		
		// a_bank:5000��� b_bank:5000�Ա�
		
		try {
			dbConn(); //db����
			
			//�ڵ� commit ���� : Ʈ������Ŀ������ //�����ͺ��̽��� ����Ǿ��ִº��� con���� ����
			con.setAutoCommit(false); //true : �ڵ�Ŀ��, false: �ڵ�Ŀ������ //->Ŀ������� �����ͺ����
			
			int abank= -5000; //a��ũ���� ����� �ݾ�
			int bbank = 5000;
			
			//���
			sql = "insert into a_bank (num,money) values(a_number.nextval,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,abank);			
			int cnt = pstmt.executeUpdate();
			if(cnt>0) {
				System.out.println(Math.abs(abank)+"���� ��ݵǾ����ϴ�"); //-�����ֱ� ���ؼ� ���밪���� ��ȯ
			}else {
				System.out.println(Math.abs(abank)+"���� ����� �����Ͽ����ϴ�");
			}
			//*****
			if(cnt>0) throw new Exception(); //0����Ŭ���� insert�� �ȴ� -> ������ ����� �Ʒ� catch�����ΰ��� �Աݱ���� ����ȵ�
			// -> �̰�쿡 �Աݱ���� �ȵ����ϱ� ��ݱ���Ѱ��� �ѹ� �ؾ��Ѵ�....
			
			//�Ա�
			sql = "insert into b_bank(num,money) values (b_number.nextval,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,bbank);
			int cnt2 = pstmt.executeUpdate();
			if(cnt2>0) {
				System.out.println(bbank+"���� �ԱݵǾ����ϴ�");
			}else {
				System.out.println(bbank+"���� �Ա� �����Ͽ����ϴ�");
			}
			
			
			con.commit(); //�������� ����Ǹ� ���°�
		}catch(Exception e) {
			e.printStackTrace();
			try {	
				//rollback ->con �� ���ؼ�
				con.rollback(); //������ ����� �ѹ�
			}catch(Exception ee) {}
		}finally {
			dbClose();
		}
	}

	public static void main(String[] args) {
		new TransactionTest();
	}

}
