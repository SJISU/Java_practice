import java.io.File;
import java.io.FileOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UnicastFileReceive {

	DatagramSocket ds;
	DatagramPacket dp;
	
	public UnicastFileReceive() {
		//1. 파일받기 ->여러번받아야함
		receiveStart();
	}
	
	public void receiveStart() {// 파일받기 ->여러번받아야함
		try {
			
			ds = new DatagramSocket(16000); //객체생성-포트번호열어줌
			byte []data = new byte[512];
			dp = new DatagramPacket(data,data.length); //512byte를 맥스로 받음
			//파일생성 - 파일받아서 파일쓰기 outputStream
			FileOutputStream fos = null; //처음엔 null / 파일명을받으면 객체생성
			
			//여러번받음 -> 반복
			while(true) {
				//받기대기
				System.out.println("받기 대기 중....");
				ds.receive(dp); //받기대기 메소드..데이터가잇으면 아래로 내려온다
			
				//전송한 내용이 파일명,파일내용,마지막 표시인지 확인
				byte[] receiveData = dp.getData(); //배열구해짐
				int len = dp.getLength();
				String part = new String(receiveData,0,4);
				if(part.equals("FN##")) {//1.파일명 //넘어온데이터가 파일명이다
					String filename = new String(receiveData,4,len-4);//index의 4부터 끝까지 문자얄로바끈다
					System.out.println("filename-->"+filename);
					
					//outputstream
					fos = new FileOutputStream(new File("C://Users/jisu/Downloads",filename)); // 파일객체(파일경로,파일명)
					System.out.println("IO객체 생성됨");
				}else if(part.equals("$%#$")) {//2.파일내용
					//파일의 내용일때				
					if(fos!=null) {	//파일객체가 있을때만한다
						fos.write(receiveData,4,len-4);//쓰기:outputStream-write
					}
				}else if(part.equals("^%#$")) {
					fos.close();
					fos = null;
					System.out.println("파일받기가 완료됨......");
				}
				
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new UnicastFileReceive();

	}

}
