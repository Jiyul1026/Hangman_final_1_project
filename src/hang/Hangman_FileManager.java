package hang;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.Random;

public class Hangman_FileManager {

	
	/*	텍스트파일의 줄 수를 매개변수로 받아서
	텍스트파일이 단어중 하나를 랜덤하게 선택해서 문자열을 반환하는 메소드*/
	
	
	public static String fileRandomLine(int Line)throws IOException {
		Random random = new Random();
		
		String str="";
		//줄수를 나타내려고 줄수 구하는 메소드에 +1 해놔서 여기도 +1 
		//컴터는 0부터시작하는데 1부터보이게 해놓은거라고 보면됨
		int lineCnt=random.nextInt(Line)+1 ;		
		int cnt=1;
		//input,ouput은 바이트스트림
		//reader,writer는 문자스트림
		
		File file = new File("word.txt");		//텍스트파일을 연다
		FileInputStream fr = new FileInputStream(file);
		InputStreamReader reader = new InputStreamReader(fr,"UTF-8");
		//open을 도움 한줄씩가져와서 처리하고 그런거
		BufferedReader br = new BufferedReader(reader);
		

		//read는 파일에서 읽어서 to 기억참고(변수)
		//write는 키보드등으로 입력하여 to파일에
		String s = null;
		//file read - 화면출력(write)  byte인경우는 readInt
		
	
		//한 줄씩 읽어서 랜덤한 줄의 문자열를 가져온다
		while((s =br.readLine()  ) !=null) {//한글자씩 체크할때는 null대신  eof나 -1을 써야함
			if(cnt == lineCnt) {
				str=s;

				break;
			}
			
			cnt++;
		}
		
		//파일 열었으면 닫아야함
		br.close();
		fr.close();
		return str;		//랜덤한 줄의 문자열 반환
		
	}
	
	
	
	
	//텍스트 파일의 줄 수를 구하는 함수
	public static int fileLineCount() throws IOException {
		int result;
		FileReader input = new FileReader("word.txt");		//텍스트 파일을 연다
		LineNumberReader count = new LineNumberReader(input);
		
		while(count.skip(Long.MAX_VALUE)>0) {	//텍스트파일의 마지막 줄수까지 빠르게넘어감
			
		}
		result = count.getLineNumber()+1;		//컴터는 0부터 시작하지만 편하게 줄수로 보기위해서 +1을 시켜줌
		
		input.close();
		return result;
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
