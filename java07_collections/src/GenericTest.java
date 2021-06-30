// E : element 
// k : key
// v : value
public class GenericTest<E> {
	private E username;
	public GenericTest() {
		
	//E는 대입되는 데이터 타입에 따라 다르게 적용	
	//다양한 데이터형 보관
	//그때그때 데이터 바뀜
		
	}
	
	public GenericTest(E username) {
		this.username = username;
	}

	//private변수는 getter-setter 만들어야함
	public E getUsername() {
		return username;
	}
	public void setUsername(E username) {
		this.username = username;
	}
	
}
