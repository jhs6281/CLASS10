package chap14;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class InputExam {

	public static void main(String[] args) {

		String fullPath = "C:\\tmp\\secret.txt";

		try (InputStream is = new FileInputStream(fullPath);) {

//			int BUFFER_SIZE = 1024 * 8; // 사이즈 8 킬로 바이트
			int BUFFER_SIZE = 1; // 사이즈 8 킬로 바이트
			byte[] buffer = new byte[BUFFER_SIZE]; // 바가지 마련

//			int result = is.read( buffer ); // 읽힌 길이
//			System.out.println("읽은 byte 수 : " + result );
//			
//			String data = new String(buffer, 0, result); // 읽을 내용
//			System.out.println("읽은 내용 : \n" + data);

			int result = 0;
			String data = "";

//			result = is.read(buffer);
//			if (result != -1) {
//				data += new String(buffer, 0, result);
//			} 
			
			
			// 바가지로 계속 푸는 문법 
//			while (result != -1) { 
//				result = is.read(buffer);
//
//				if (result != -1) {
//					data += new String(buffer, 0, result);
//					System.out.println("------------");
//					System.out.println(data);
//				}
//			}
			
			// 위와 동일한 코드 실무 축약형 
			while (( result = is.read(buffer)) != -1 ) {
				data += new String(buffer, 0, result);
			}
			
			System.out.println("읽은 내용 : \n" + data);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
