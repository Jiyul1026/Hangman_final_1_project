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

	
	/*	�ؽ�Ʈ������ �� ���� �Ű������� �޾Ƽ�
	�ؽ�Ʈ������ �ܾ��� �ϳ��� �����ϰ� �����ؼ� ���ڿ��� ��ȯ�ϴ� �޼ҵ�*/
	
	
	public static String fileRandomLine(int Line)throws IOException {
		Random random = new Random();
		
		String str="";
		//�ټ��� ��Ÿ������ �ټ� ���ϴ� �޼ҵ忡 +1 �س��� ���⵵ +1 
		//���ʹ� 0���ͽ����ϴµ� 1���ͺ��̰� �س����Ŷ�� �����
		int lineCnt=random.nextInt(Line)+1 ;		
		int cnt=1;
		//input,ouput�� ����Ʈ��Ʈ��
		//reader,writer�� ���ڽ�Ʈ��
		
		File file = new File("word.txt");		//�ؽ�Ʈ������ ����
		FileInputStream fr = new FileInputStream(file);
		InputStreamReader reader = new InputStreamReader(fr,"UTF-8");
		//open�� ���� ���پ������ͼ� ó���ϰ� �׷���
		BufferedReader br = new BufferedReader(reader);
		

		//read�� ���Ͽ��� �о to �������(����)
		//write�� Ű��������� �Է��Ͽ� to���Ͽ�
		String s = null;
		//file read - ȭ�����(write)  byte�ΰ��� readInt
		
	
		//�� �پ� �о ������ ���� ���ڿ��� �����´�
		while((s =br.readLine()  ) !=null) {//�ѱ��ھ� üũ�Ҷ��� null���  eof�� -1�� �����
			if(cnt == lineCnt) {
				str=s;

				break;
			}
			
			cnt++;
		}
		
		//���� �������� �ݾƾ���
		br.close();
		fr.close();
		return str;		//������ ���� ���ڿ� ��ȯ
		
	}
	
	
	
	
	//�ؽ�Ʈ ������ �� ���� ���ϴ� �Լ�
	public static int fileLineCount() throws IOException {
		int result;
		FileReader input = new FileReader("word.txt");		//�ؽ�Ʈ ������ ����
		LineNumberReader count = new LineNumberReader(input);
		
		while(count.skip(Long.MAX_VALUE)>0) {	//�ؽ�Ʈ������ ������ �ټ����� �����ԳѾ
			
		}
		result = count.getLineNumber()+1;		//���ʹ� 0���� ���������� ���ϰ� �ټ��� �������ؼ� +1�� ������
		
		input.close();
		return result;
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
