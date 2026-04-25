package kr.or.human3;

import lombok.Data;


//@Getter
//@Setter
//@ToString
//@RequiredArgsConstructor
//@EqualsAndHashCode

@Data // 다 해주잖아
public class MemberDTO {
	String id;
	String pw;
	String name;
	String tel;
	String email;
	int age;
	
	
}
