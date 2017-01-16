
public class UsandoArrays1 {

	public static void main(String[] args) {
		int nota1=0, nota2=4, nota3=6, nota4=9;
		//array de calificaciones
		//0,4,6,9,5,6,7
		//tipo[] nombreArray=new tipo[numero de elementos]
		int[] calificacion=new int[10];
		float media;
		
		//método largo insufrible
		media=(nota1+nota2+nota3+nota4)/4;
		
		//Rellenar los elementos de un array
		calificacion[0]=0;
		calificacion[1]=4;
		calificacion[2]=6;
		calificacion[3]=7;
		calificacion[4]=8;
		calificacion[5]=4;
		calificacion[6]=5;
		calificacion[7]=5;
		calificacion[8]=5;
		calificacion[9]=9;
		
		//calcular la media de un array de calificaciones
		for (int i=0;i<10;i++){
			media=media+calificacion[i];
		}
		
		media=media/10;
		System.out.println("media: "+media);
	}

}
