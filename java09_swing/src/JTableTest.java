import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class JTableTest extends JFrame{

   JTable table;
   JScrollPane sp; 
   DefaultTableModel model;
   
   //JTable에서 제목으로 사용할 배열
   String title[] = {"번호","이름","연락처","주소"}; 
   //JTable에서 목록으로 사용할 배열
   Object[][] data = { {100, "홍길동","010-1234-5678","서울시 마포구"},
                  {200,"이순신","010-7878-9696","서울시 종로구"},
                  {300,"세종대왕","010-8787-5555","서울시 영등포구"}
                 };
   
   JLabel lb1 = new JLabel (" ");
   
   public JTableTest() {
      model = new  DefaultTableModel(data,title);
      table = new JTable(model);
      sp = new JScrollPane(table);
      
      add(sp); //스크롤 기능이 있는 테이블
      add(BorderLayout.SOUTH,lb1);  //맨아래에
      
      setSize(500,400);
      setVisible(true);
      setDefaultCloseOperation(DISPOSE_ON_CLOSE);
      
      
      //try{Thread.sleep(3000);}catch(Exception e) {} //뜨는 시간지연 3초      
      //행추가 : addRow()
      Object[]row = {400,"김삿갓","010-1234-5555","서울시 서초구"};
      
      Vector<Object> v = new Vector<Object>();
      v.add(500);
      v.add("강감찬");
      v.add("010-4567-8888");
      v.add("서울시 은평구");      
      
      model.addRow(row);
      model.addRow(v);
      
      try{Thread.sleep(3000);}catch(Exception e) {} //뜨는 시간지연 3초
      //행삽입 : insertRow()
      Object[]row2= {600,"광개토대왕","010-1111-2222","서울시 강남구"};
      model.insertRow(2, row2);//2행에다 넣으면 원래2행에 있던 데이터는 뒤로밀림
      
      try{Thread.sleep(3000);}catch(Exception e) {} //뜨는 시간지연 3초
      //행이동 : moveRow() //특정한범위의 행을 이동시킴
      //		start end to
      model.moveRow(2,4,0); //index 2에서부터 4까지를 0으로 이동시킴      
      
      try{Thread.sleep(3000);}catch(Exception e) {} //뜨는 시간지연 3초
     
      /*
      //컬럼추가 : addColumn() 칸추가 
      model.addColumn("기타");
      Object cData[]= {1,2,3,4,5,6};
      model.addColumn("메모",cData);
      
      try{Thread.sleep(3000);}catch(Exception e) {} //뜨는 시간지연 3초
      //행삭제
      model.removeRow(3); //홍길동행삭제

      try{Thread.sleep(3000);}catch(Exception e) {} //뜨는 시간지연 3초
      //컬럼 (칸) 삭제 // JTable 에 있음
      table.removeColumn(table.getColumn("기타")); 
      
      */
      table.addMouseListener(new MyEvent()); //테이블에있는걸걸 모두 이벤트등록
      
   }
   
   //마우스 이벤트 내부클래스
   public class MyEvent extends MouseAdapter{// 어뎁터가 이미 인터페이스 오버라이딩해서 상속받았기때문에 상속안받고 이벤트등록하면됨
	   
	   //재오버라이딩 - 어뎁터에서 오버라이딩된메소드를 다시 오버라이딩
	   public void mouseClicked(MouseEvent me) { //클릭하면 여기로 넘어오게끔
		   //왼쪽버튼일때만 반응 있게 한다
		   //1.버튼의 종류(1: 왼쪽 2: 가운데 3:오른쪽)
		   int eventBtn = me.getButton();
		   String dataStr ="";
		   
		   if(eventBtn==1) {//왼쪽버튼으로 눌릴때만 반응하게
			  //선택한 행번호 얻어오기
			  int row = table.getSelectedRow(); //현재선택된행을 알아내기 //여러줄을 선택하게되면 배열에 담긴다
			  //				칸의수
			  for(int c=0; c<table.getColumnCount(); c++) {
				  Object data = table.getValueAt(row,c); //원하는 위치의 데이터를 가져오는
				  dataStr+=data+",";
			  }
			   lb1.setText(dataStr); //맨아래에 선택된 행의 데이터가 입력된다
		   }		   
	   }	   
   }

   public static void main(String[] args) {
      new JTableTest();
   }

}