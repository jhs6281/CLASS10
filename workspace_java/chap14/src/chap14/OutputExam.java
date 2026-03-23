package chap14;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class OutputExam {

	public static void main(String[] args) {

		String path = "c:\\tmp"; // 경로
		String fileName = "secret.txt"; // 파일

		// 방법 1
//		String fullFileName = path + "\\" + fileName ;   
		// 방법 2
		String fullFileName = path + System.getProperty("file.separator") + fileName;

		OutputStream os = null;

		try {
			// 스트림 열기
			os = new FileOutputStream(fullFileName);

			// 파일에 쓸 데이터 -> 바이트 타입
			String data = "123\nEng\n한글";
			byte[] datas = data.getBytes();

			// 쓰기 (바이트)데이터, 0에, 끝까지
			os.write(datas, 0, datas.length);

			// 버퍼에 남은 데이터 모두 출력
			os.flush();
			
//			os.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 스트림 닫기
			if (os != null) {
				try {
					os.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}
	
	void saveTxt(String data) {
		// try-with-resource
		// close() 를 자동으로 해줌
		
		String path = "c:\\tmp"; // 경로
		String fileName = "secret.txt"; // 파일
		String fullFileName = path + System.getProperty("file.separator") + fileName;
		
		try(
				OutputStream os = new FileOutputStream(fullFileName);
		){
			
			byte[] datas = data.getBytes();

			// 쓰기 (바이트)데이터, 0부터, 끝까지
			os.write(datas, 0, datas.length);

			// 버퍼에 남은 데이터 모두 출력
			os.flush();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
