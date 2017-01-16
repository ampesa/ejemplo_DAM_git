
public class UsandoArrays2 {

	public static void main(String[] args) {
		// Array1
		int[] metodo1=new int[5];
		// Array2
		int[] metodo2={3,4,5,0,6,5,4,};
		
		metodo1[0]=3;
		metodo1[1]=3;
		metodo1[2]=4;
		metodo1[3]=9;
		metodo1[4]=6;
		
		//recorrer el Array2
		for (int i=0;i<metodo2.length;i++){
			System.out.println(metodo2[i]);
		}

	}

}
