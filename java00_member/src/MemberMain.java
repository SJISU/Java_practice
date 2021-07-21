import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

public class MemberMain extends JFrame implements ActionListener{

	//JFrame-North
	JPanel formPane = new JPanel(new BorderLayout());
		JPanel formWestPane= new JPanel(new GridLayout(6,1));
			String formLb1[]= {" 번 호 "," 이 름 "," 연락처 "," 이메일 "," 주 소 "," 등 록 "};
		JPanel formCenter = new JPanel(new GridLayout(6,1,5,5)); //뒤에 추가한 5는 간격을 5px만큼 주는것
			JTextField[] formTf = {new JTextField(5), new JTextField(15), new JTextField(20), new JTextField(30),
					               new JTextField(45), new JTextField(20)};  
			
	//JFrame - center
	JPanel centerPane = new JPanel(new BorderLayout());
		JPanel btnList = new JPanel(new GridLayout(1,0,3,3));
			JButton[] btn = {new JButton("전체목록"), new JButton("사원추가"),new JButton("사원수정"),new JButton("사원삭제")
							,new JButton("폼지우기"),new JButton("종료")
							,new JButton("엑셀쓰기")	,new JButton("엑셀읽기")};
		
		DefaultTableModel model;
		String title = "번호/이름/연락처/이메일/주소/등록일";
		JTable memberList;
		JScrollPane sp;
		
		//JFrame -south
		JPanel southPane = new JPanel();
			//JLabel searchLb1 = new JLabel("이름");
			DefaultComboBoxModel<String> searchModel = new DefaultComboBoxModel<String>();
			JComboBox<String> searchkey = new JComboBox<String>(searchModel);			
			JTextField searchWord = new JTextField(15); //검색할 이름사이즈
			JButton searchBtn = new JButton("Search");
			
	public MemberMain() {
		super("회원관리시스템");
		
		//Frame - North
		setForm();
		//Frame - Center
		setButtonTable();
		//Frame - south
		setSearchForm();
		//ㄴ여기까지 화면구성끝남
		
		setSize(800,600);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		memberAllList();
		
	}
	
	//데이터 베이스에서 회원전체목록(이름순으로) 가져오기 - JTable 목록을 보여준다.
	public void memberAllList() { 
		//MeberDAO 에서 전체선택(allRecord - db작업하는메소드)하는 메소드를 가져올것이다.
		//JTable 여기에 있으니간 메소드를 이용하여 db에서 가져온 메소드(allRecord)를 
		//한사람의 정보는 vo에 담는다 그vo를 컬렉션에 담아서 컬렉션을 반환형으로 리턴해준다 -> arrayList컬렉션(순서가있는컬렉션)-상위클래스List사용
		
//		//기존 JTable 의 목록을 지우고 새로 리스트를 출력한다
//		model.setRowCount(0); //모델을 0행으로 바꾼다 -> 그전의 레코드가 몇만개이던지 
		
		
		MemberDAO dao = new MemberDAO();
		List<MemberVO> list =dao.allRecord(); // list 저장소가 리턴됨
		
//		//컬력센의 vo를 get하여 JTable에 목록으로 추가한다. -> model 에 추가
//		for(int i=0; i<list.size(); i++) {
//			MemberVO vo = list.get(i); //회원한명의 정보 ->배열로 만들어서 model에 추가시킬것임
//			Object[]obj = {vo.getMem_no(),vo.getUsername(),vo.getTel(),vo.getEmail(),vo.getAddr(),vo.getWrite_date() };
//			model.addRow(obj); //배열추가
//		}	
		setMemberModel(list);
	}	
	
	public void setMemberModel(List<MemberVO> list) { //리스트를받고
		//기존 JTable 의 목록을 지우고 새로 리스트를 출력한다
		model.setRowCount(0); //모델을 0행으로 바꾼다 -> 그전의 레코드가 몇만개이던지 
		
		//컬력센의 vo를 get하여 JTable에 목록으로 추가한다. -> model 에 추가
				for(int i=0; i<list.size(); i++) {
					MemberVO vo = list.get(i); //회원한명의 정보 ->배열로 만들어서 model에 추가시킬것임
					Object[]obj = {vo.getMem_no(),vo.getUsername(),vo.getTel(),vo.getEmail(),vo.getAddr(),vo.getWrite_date() };
					
					model.addRow(obj); //배열추가
		
				}
	}
	//Frame - North
	public void setForm() {
		
		add(BorderLayout.NORTH,formPane);
			formPane.add(BorderLayout.WEST,formWestPane);
				for(int i=0; i<formLb1.length; i++) {
					JLabel lb1 = new JLabel(formLb1[i]);
					formWestPane.add(lb1);
				}
			formPane.add(BorderLayout.CENTER,formCenter);
				for(int i=0; i<formTf.length; i++) {
					JPanel p = new JPanel(new FlowLayout(FlowLayout.LEFT)); //왼쪽정렬
					p.add(formTf[i]);					
					formCenter.add(p);
					
					//사원수정
					if(i==0 || i==5)  formTf[i].setEditable(false);
								
				}			
	}
	
	//Frame - Center
	public void setButtonTable() {
		
		add(centerPane);
		centerPane.add(BorderLayout.NORTH,btnList);
			for(int i=0; i<btn.length; i++) {
				btnList.add(btn[i]);
				//이벤트등록
				btn[i].addActionListener(this);
			}	
		//JTable					  제목
		model = new DefaultTableModel(title.split("/"),0);
		memberList = new JTable(model);
		sp = new JScrollPane(memberList);
		centerPane.add(sp);
		
		//**마우스 이벤트등록
		memberList.addMouseListener(new JTableMouseEventProcess(formTf,memberList));
		
	}
	
	//Frame - south
	public void setSearchForm() {
		add(BorderLayout.SOUTH,southPane);
		
		//southPane.add(searchLb1);
		searchModel.addElement("이름");
		searchModel.addElement("전화번호");
		searchModel.addElement("주소");
		southPane.add(searchkey);
		
		southPane.add(searchWord);
		southPane.add(searchBtn);
		
		searchBtn.addActionListener(this);
	}
	
	
	public void actionPerformed(ActionEvent ae) {
		String eventBtn = ae.getActionCommand();
		if(eventBtn.equals("사원추가")) {
			memberInsert();
		}else if(eventBtn.equals("폼지우기")) {
			formDataClear();
		}else if(eventBtn.equals("종료")) {
			System.exit(0);
		}else if(eventBtn.equals("사원수정")) {
			memberUpdate();
		}else if(eventBtn.equals("사원삭제")) {
			memberDelete();
		}else if(eventBtn.equals("Search")) {
			memberSearch();
		}else if(eventBtn.equals("전체목록")) {
			memberAllList();
		}else if(eventBtn.equals("엑셀쓰기")) {
			//기준은 JTable의 레코드를 엑셀로 쓰기
			excelWrite();
		}else if(eventBtn.equals("엑셀읽기")) {
			excelRead();
		}
	
	}
	
	//사원추가
	public void memberInsert() {
		//폼의 이름이 입력되었는지 확인
		String username = formTf[1].getText(); //배열에 입력된값을 얻어와서
		if(username==null || username.equals(" ")) {
			JOptionPane.showMessageDialog(this, "이름을 입력하세요");
			
		}else { 
			//입력된걸 vo에 담고 그걸 가져와서 insert한다(insert하는 메소드 이용하여)
			//DAO 에서 작업 -> 사원등록메소드 : insertRecord()
			
			//폼의 데이터를 vo에 대입
			MemberVO vo = new MemberVO();
			vo.setUsername(username);
			vo.setTel(formTf[2].getText());
			vo.setEmail(formTf[3].getText());
			vo.setAddr(formTf[4].getText());;
			
			MemberDAO dao = new MemberDAO();
			int cnt =dao.insertRecord(vo);
			if(cnt>0) {//회원추가 : 추가된 레코드가 잇을때
				formDataClear(); //회원이 추가되면 폼의 데이털르 지운다
				memberAllList();
			}else{ //회원추가실패
				JOptionPane.showMessageDialog(this, "회원추가 실패하였습니다");
			}			
		}		
	}
	
	//폼지우기
	public void formDataClear() {
		//회원이 추가되고나면 form에 있던 데이터를 지운다
		//폼의 값을 지운다.
		for(int i=0; i<formTf.length; i++) {
			formTf[i].setText(" ");
		}
		
	}
	
	//사원수정- 폼에 입력된 정보 수정
	public void memberUpdate() {
		//기준이될 회원번호
		//변경할데이터3개 -> 4개를 vo에 담고 dao에서 수정할메소드에보내고
		//dao로 넘어가는이유->db에있는정보를 여기에 있는정보로 수정하기위해서
		MemberVO vo = new MemberVO();
		vo.setMem_no(Integer.parseInt(formTf[0].getText()));
		vo.setTel(formTf[2].getText());
		vo.setEmail(formTf[3].getText());
		vo.setAddr(formTf[4].getText());
		MemberDAO dao = new MemberDAO();
		int cnt = dao.updateRecord(vo);
		
		if(cnt>0){//수정시 리스트 다시 선택하기
			memberAllList();
		}else {
			//수정실패하면 안내메시지 표시
			
			JOptionPane.showMessageDialog(this,"회원정보 수정 실패하였습니다");
		}
	}
	
	//사원삭제
	public void memberDelete() {//번호를 가져와서 테이블에 있는지 없는지 확인하고
		
		//삭제할 사원번호
		//							      데이터o  데이터x
		String delNum = formTf[0].getText(); // "5"  ""
		if(delNum==null || delNum.equals(" ")){
			JOptionPane.showMessageDialog(this, "삭제할 사원을 선택하세요");
		}else {
			//db작업 -> memberDAO
			MemberDAO dao = new MemberDAO();
			int result = dao.deleteRecord(Integer.parseInt(delNum)); //0이면삭제x 0이상이면삭제o
			if(result>0) { //회원삭제됨
				JOptionPane.showMessageDialog(this, delNum+"사원을 삭제하였습니다");
				memberAllList();
				formDataClear();
			}else {//회원삭제실패
				JOptionPane.showMessageDialog(this, delNum+"사원삭제를 실패하였습니다");
			}
		}
		
	}
	//레코드검색
	public void memberSearch() {
		//검색어가 입력되어있는지 확인
		String search =searchWord.getText(); //검색할단어
		if(search!=null && !search.equals(" ")) { // 검색어가 있다
			String searchField = (String)searchkey.getSelectedItem(); // 검색어 "이름","주소","전화번호"
			//필드네임을 데이터로 보낸다
			String fieldName=" "; //어떤필드에서 검색할지 단어가 들어가있음
			if(searchField.equals("이름")) {
				fieldName="username";
			}else if(searchField.equals("전화번호")) {
				fieldName="tel";
			}else if(searchField.equals("주소")) {
				fieldName="addr";
			}
			MemberDAO dao = new MemberDAO();
			List<MemberVO>list = dao.searchRecord(search,fieldName);
			setMemberModel(list);
			searchWord.setText(" ");
		}
	}
	//엑셀로쓰기
	public void excelWrite() { // 저장할때 파일명.xls
		
		JFileChooser fc = new JFileChooser();
		int state = fc.showSaveDialog(this);
		if(state==0) { //저장:0 취소:1
			File f = fc.getSelectedFile(); //이 파일로 쓰기
			
			//엑셀
			HSSFWorkbook workbook = new HSSFWorkbook();
			HSSFSheet sheet = workbook.createSheet("회원목록");
			//제목
			HSSFRow rowTitle = sheet.createRow(0); //행을만들어서 제목이들어가고
			
			String[]excelTitle = title.split("/");
			
			for(int i=0; i<excelTitle.length; i++) {
				rowTitle.createCell(0).setCellValue(excelTitle[i]);
			}
			//여기까지 제목생성
			
			//JTable목록의 행의수
			int rows = memberList.getRowCount();
			int cols = memberList.getColumnCount();
			for(int i=0; i<rows; i++) { // 0,1,2,3,4 //행을만들어서 데이터를 넣는과정
				HSSFRow row = sheet.createRow(i+1); //0행은 제목셋팅 1행부터만든다
				//JTable목록의 열의수
				for(int j=0; j<cols; j++) {//0,1,2,3,4,5
					if(j==0) {
					//												    i행 j열
					row.createCell(j).setCellValue((int)memberList.getValueAt(i, j));
					}else {
						row.createCell(j).setCellValue((String)memberList.getValueAt(i,j));
					}
				}
			}			
			//엑셀을 파일로 쓰기
			try {
				FileOutputStream fos = new FileOutputStream(f);
				workbook.write(fos);
				fos.close();
				workbook.close();
			}catch(Exception e) {
				System.out.println("엑셀로 쓰기 에러");
				e.printStackTrace();
			}
		}
	}
	//엑셀로 읽기
	public void excelRead() {
		JFileChooser fc = new JFileChooser(); //탐색기
		int state = fc.showOpenDialog(this); //0:열기 1:취소
		
		if(state==0) {
			try {
				
				File f = fc.getSelectedFile();
				FileInputStream fis = new FileInputStream(f);
				
				POIFSFileSystem poi = new POIFSFileSystem(fis); // 여기서에 워크북 가져올수있다
				
				HSSFWorkbook workbook = new HSSFWorkbook(poi);				
				HSSFSheet sheet = workbook.getSheet("회원목록");
				
				//기존 JTable의 데이터 지우기
				model.setRowCount(0); //0행으로 셋팅
				
				//시트의 행의수 -> 데이터는 제목행을 뺀 행의수만큼만겟
				int rows = sheet.getPhysicalNumberOfRows();
				for(int r=1; r<rows; r++) {
					//행 얻어오기
					HSSFRow row = sheet.getRow(r); //행안에는 칸의수 가 있다
					int cols = row.getPhysicalNumberOfCells();//열의수
					Vector v = new Vector();
					for(int c=0; c<cols; c++) { //c:칼럼
						if(c==0) {
							v.add(row.getCell(c).getNumericCellValue());
						}else {
							v.add(row.getCell(c).getStringCellValue());
						}
					}
					model.addRow(v);
				}
				poi.close();
				fis.close();
					
			}catch(Exception e) {
				System.out.println("엑셀읽기 에러");
				e.printStackTrace();
			}
		}
		
	}
	
	public static void main(String[] args) {
		new MemberMain();
	}

}
