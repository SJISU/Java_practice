package View;

import Dao.Login.LoginDao;
import Select.AllStateSession;
import View.Admin.AdminMainPage;
import View.UI.ProfessorModeUI;
import View.UI.StudentModeUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainIndex extends JFrame implements ActionListener {

//   Functions
    AllStateSession LoginSession = new AllStateSession();
    LoginDao LDao = new LoginDao();

// =======================================================================================================    
    
// Fucking Swing
    // Fonts
    Font font_big = new Font("바탕", Font.BOLD, 30);
    Font font_middle = new Font("바탕", Font.BOLD, 25);
    Font font_small = new Font("바탕", Font.BOLD, 12);
    
    // Bitcamp University panel
    JPanel northPane = new JPanel(new BorderLayout());
       JPanel smallSpace = new JPanel();
       JLabel title_lbl = new JLabel("<html>비트대학교<br> BITCAMP UNIVERSITY</html>");
    
    // spacing for login panel
    JPanel northSpace = new JPanel();
    JPanel westSpace = new JPanel();
    JPanel eastSpace = new JPanel();
    JPanel southSpace = new JPanel();
   
   // Login panel details
    JPanel loginPane = new JPanel(new FlowLayout());
       JPanel loginTitle_space = new JPanel();
       JLabel loginTitle_lbl = new JLabel("수강신청 시스템", JLabel.CENTER);
       
       JPanel SpacePaneBetweenTitleAndInput = new JPanel();
       
       JPanel inputPane = new JPanel(new GridLayout(3, 1));
          JPanel input_ID_pane = new JPanel(new GridLayout(1, 2));
             JPanel paneForID = new JPanel();
             JLabel input_ID_Lbl = new JLabel("학번", JLabel.CENTER);
             JTextField idField = new JTextField(20);
         JPanel paneBetweenIDAndPW = new JPanel();
          JPanel input_PW_pane = new JPanel(new GridLayout(1, 2));
             JPanel paneForPW = new JPanel();
             JLabel input_PW_Lbl = new JLabel("비밀번호", JLabel.CENTER);
             JPasswordField pwField = new JPasswordField(20);
             
      JPanel SpacePaneBetweenLoginAndBtn = new JPanel();
       JButton loginButton = new JButton("로그인");
       JPanel btnPane = new JPanel(new FlowLayout());
     //  JButton idBtn = new JButton("ID/PW찾기");
       //JButton pwBtn = new JButton("PW변경");
    
       
       // 공지사항
       JPanel notice1st = new JPanel();
       JPanel notice2nd = new JPanel();
       JPanel notice3rd = new JPanel();

    // 메인 페이지
    public MainIndex() {

       // JFrame 레이아웃 설정
       setLayout(new FlowLayout());
       
       // northPane 설정
       northPane.setPreferredSize(new Dimension(1008, 100));
        title_lbl.setFont(font_big);
        title_lbl.setOpaque(true);
        title_lbl.setBackground(new Color(33, 140, 116)); //(22, 160, 133)
        title_lbl.setForeground(Color.white);
        northPane.add(title_lbl);
        add(northPane);
        
        // 상하좌우 공백 + 로그인 패널
        northSpace.setPreferredSize(new Dimension(900, 40));
        westSpace.setPreferredSize(new Dimension(400, 60));
        loginPane.setPreferredSize(new Dimension(500, 300));
        eastSpace.setPreferredSize(new Dimension(124, 60));
        // southSpace 여기에 공지사항 추가하면 됨
        southSpace.setPreferredSize(new Dimension(1024, 200));
        add(northSpace);
        add(westSpace);
        add(loginPane);
        add(eastSpace);
        add(southSpace);
        
        // 로그인 패널 디테일
        // Title
        loginPane.setBackground(new Color(255, 229, 200));//255, 234, 167 //(255, 229, 200
        loginTitle_space.setPreferredSize(new Dimension(500, 10));
        loginTitle_space.setBackground(new Color(255, 229, 200));
        loginTitle_lbl.setFont(font_middle);
        loginTitle_lbl.setForeground(new Color(33, 140, 116));
        loginPane.add(loginTitle_space);
        loginPane.add(loginTitle_lbl);
        
        // 타이틀과 Input 패널 사이
        SpacePaneBetweenTitleAndInput.setBackground(new Color(255, 229, 200));
        SpacePaneBetweenTitleAndInput.setPreferredSize(new Dimension(500, 40));
        loginPane.add(SpacePaneBetweenTitleAndInput);
        
        // 패널 세팅
        input_ID_pane.setPreferredSize(new Dimension(200, 100));
        input_ID_pane.setBackground(new Color(255, 229, 200));
        input_ID_pane.add(input_ID_Lbl);
        input_ID_pane.add(idField);
        input_PW_pane.setPreferredSize(new Dimension(200, 100));
        input_PW_pane.setBackground(new Color(255, 229, 200));
        input_PW_pane.add(input_PW_Lbl);
        input_PW_pane.add(pwField);
        
        // 라벨
        input_ID_Lbl.setOpaque(true);
        input_ID_Lbl.setFont(font_small);
        input_ID_Lbl.setBackground(new Color(255, 229, 200));
        input_PW_Lbl.setOpaque(true);
        input_PW_Lbl.setFont(font_small);
        input_PW_Lbl.setBackground(new Color(255, 229, 200));

        // 만든 패널 담기
        input_ID_pane.add(input_ID_Lbl);
        input_PW_pane.add(input_PW_Lbl);
        
        // input 패널 (ID 입력창 & PW 입력창)
        inputPane.setPreferredSize(new Dimension(300, 120));
        inputPane.setBackground(Color.black);
        inputPane.add(input_ID_pane);
        paneBetweenIDAndPW.setPreferredSize(new Dimension(300, 80));
        paneBetweenIDAndPW.setBackground(new Color(255, 229, 200));
        inputPane.add(paneBetweenIDAndPW);
        inputPane.add(input_PW_pane);
        loginPane.add(inputPane);
        
        // 거리두기
        SpacePaneBetweenLoginAndBtn.setPreferredSize(new Dimension(50, 30));
        SpacePaneBetweenLoginAndBtn.setBackground(new Color(255, 229, 200));
        loginPane.add(SpacePaneBetweenLoginAndBtn);
        
        // Button
        loginButton.setPreferredSize(new Dimension(90, 120)); //로그인버튼 사이즈조절
        loginButton.setBackground(new Color(33, 140, 116));
        loginButton.setForeground(Color.white);
        loginPane.add(loginButton);//로그인버튼추가

        btnPane.setPreferredSize(new Dimension(0, 50));//위치
        btnPane.setBackground(new Color(255, 229, 200));

//        idBtn.setBackground(new Color(33, 140, 116));
//        idBtn.setForeground(Color.white);
//        pwBtn.setBackground(new Color(33, 140, 116));
//        pwBtn.setForeground(Color.white);

        //btnPane.add(idBtn);
        //btnPane.add(pwBtn);
        loginPane.add(btnPane);

        
        // 공지사항 패널
        notice1st.setPreferredSize(new Dimension(300, 100));
        notice2nd.setPreferredSize(new Dimension(300, 100));
        notice3rd.setPreferredSize(new Dimension(300, 100));
        notice1st.setBackground(Color.black);
        notice2nd.setBackground(Color.black);
        notice3rd.setBackground(Color.black);
        southSpace.add(notice1st);
        southSpace.add(notice2nd);
        southSpace.add(notice3rd);
        
        //--------------------------------------------------------------------


        setSize(1024, 768);
        setVisible(true);

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        loginButton.addActionListener(this);
        System.out.println(AllStateSession.login_id);
        System.out.println(AllStateSession.login_state);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object event = e.getSource();
        if (event==loginButton) {
            if (idField.getText().length() == 0 || pwField.getText().length() == 0) {
                JOptionPane.showMessageDialog(null, "한번더 확인해주세요.", "Message", JOptionPane.ERROR_MESSAGE);
            } else {
                SessionCheckLogin(idField.getText(), pwField.getText());
            }
        }
    }

    public void SessionCheckLogin(String id, String pw) {
            int session =LDao.Login(id, pw);
            if(session==1)
            {
                AllStateSession.login_id=id;
                System.out.println(AllStateSession.login_id);
                System.out.printf("학11111111111생 들어갑니다");
                System.out.printf("어드민 들어갑니다");
                setVisible(false);

                new AdminMainPage();
                //어드민 객체 쓰면됨
            }

            else if(session==2)
            {
                System.out.printf("교수 들어갑니다");
                setVisible(false);
                new ProfessorModeUI();
                //new ProTestPage();
                //교수 객체 쓰면됨
            }
            else if(session==3)
            {
                System.out.printf("학생 들어갑니다");
                setVisible(false);

                new StudentModeUI();
                //학생 객체 쓰면됨
            }
            else
            {
                JOptionPane.showMessageDialog(null, "아이디 비밀번호 확인해주세요.", "Message", JOptionPane.ERROR_MESSAGE);
            }
    }

    public static void main(String[] args) {
        new MainIndex();
    }
}

