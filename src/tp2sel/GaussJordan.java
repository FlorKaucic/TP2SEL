package tp2sel;


public class GaussJordan {
	
	//Tiene sysos por todos lados porque quería ver paso a paso que hacía para detectar los errores
	public static boolean esIdentidad(double m1[][])
	{
		for (int i=0;i<5;i++)
			for(int j=0;j<5;j++)
			{
				if(i==j && m1[i][j]!=1)
					return false;
				if(i!=j && m1[i][j]!=0)
					return false;
			}
		return true;
	}
	public static int gaussJordan(double m1[][], double m2[][]){
		int i=0, y=0, j=0, a=0, z=0;
		double k;
		while(!esIdentidad(m1) && z<10){
			System.out.println(i);
			if(i==5)
				i=0;
			
			for(y=0;y<5;y++){
				if(m1[y][i]!=0){
				
					k = 1/m1[y][i];
					//System.out.println("Prueba"+ y);
				for(j=0;j<5;j++)
				{
					m1[y][j]*=k;
					m2[y][j]*=k;
					//System.out.println("Prueba"+j);
					for(int l=0;l<5;l++)
					{	for(int h=0; h<5; h++)
							{	System.out.print(m1[l][h]);
								
							}
						System.out.println("");
					}
					System.out.println("---------");
				}
				}
			}
			for(y=0; y<5; y++)
			{
				if(i!=y){
					if(y<i)
						k = m1[y][i];
					else
						k=1;
					for(j=0;j<5;j++){
					
					
						m1[y][j]-=m1[i][j]*k;
						m2[y][j]-=m2[i][j]*k;
						//System.out.println("Prueba"+j+i);
						for(int l=0;l<5;l++)
						{	for(int h=0; h<5; h++)
								{	System.out.print(m1[l][h]);
									
								}
							System.out.println("");
						}
						System.out.println("---------");
					}
					}
			}
			System.out.println("Prueba"+i +","+z);
			z++;
			for(y=0;y<5;y++)
			{	for(j=0; j<5; j++)
					{	System.out.print(m1[y][j]);
						
					}
				System.out.println("");
			}
			System.out.println("---------");
			
			
			i++;
			
			
			
		}
		a=1;
		return a;
	}	
	
	
	
	public static void main(String[] args) {
		double [][] m = new double[5][5];
		double [][] n = new double[5][5];
		
		for(int i=0;i<5;i++)
			for(int j=0; j<5; j++)
				m[i][j]= i+j+1;
		
		for(int i=0;i<5;i++)
			for(int j=0; j<5; j++)
				{
					if(i==j)n[i][j]= 1;
					else n[i][j]= 0;
				}
		for(int i=0;i<5;i++)
		{	for(int j=0; j<5; j++)
				{	System.out.print(m[i][j]);
					
				}
			System.out.println("");
		}
		for(int i=0;i<5;i++)
		{	for(int j=0; j<5; j++)
				{	System.out.print(n[i][j]);
					
				}
			System.out.println("");
		}
		System.out.println("Prueba");
		
		System.out.println(gaussJordan(m,n));
		
		for(int i=0;i<5;i++)
		{	for(int j=0; j<5; j++)
				{	System.out.print(m[i][j]);
					
				}
			System.out.println("");
		}
		
		for(int i=0;i<5;i++)
		{	for(int j=0; j<5; j++)
				{	System.out.print(n[i][j]);
					
				}
			System.out.println("");
		}
		}
	}