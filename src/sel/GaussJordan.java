package sel;


public class GaussJordan {
	
	//Tiene sysos por todos lados para ver paso a paso que hacía para detectar los errores
	public static boolean esIdentidad(MatrizMath m1)
	{
		MatrizMath id = new MatrizMath(m1.getDimF(), m1.getDimC()),
				   aux;
		
		for(int i=0; i<m1.getMat().length; i++)
			id.setValue(i, i, 1);
		aux = m1.restar(id);
		if(aux.normaDos() < m1.getErrTol())
			return true;
		
		return false;
	}
	public static int gaussJordan(MatrizMath m1, MatrizMath m2){
		int i=0, y=0, j=0, a=0, z=0;
		double k;
		while(!esIdentidad(m1) && z<10){
			System.out.println(i);
			if(i==5)
				i=0;
			
			for(y=0;y<m1.getDimF();y++){
				if(m1.getMat()[y][i]!=0 && y>=i){
				
					k = 1/m1.getMat()[y][i];
					
				for(j=0;j<m1.getDimF();j++)
				{
					
					m1.getMat()[y][j]*=k;
					m2.getMat()[y][j]*=k;
					
					for(int l=0;l<m1.getDimF();l++)
					{	for(int h=0; h<5; h++)
							{	System.out.print(m1.getMat()[l][h] + "\t");
								
							}
						System.out.println("");
					}
					System.out.println("---------");
				}
				}
			}
			for(y=0; y<m1.getDimF(); y++)
			{
				if(i!=y){
					if(y<i)
						k = m1.getMat()[y][i];
					else
						k=1;
					for(j=0;j<5;j++){
					
					
						m1.getMat()[y][j]-=m1.getMat()[i][j]*k;
						m2.getMat()[y][j]-=m2.getMat()[i][j]*k;
						
						for(int l=0;l<m1.getDimF();l++)
						{	for(int h=0; h<5; h++)
								{	System.out.print(m1.getMat()[l][h]+"\t");
									
								}
							System.out.println("");
						}
						System.out.println("---------");
					}
					}
			}
			System.out.println("Prueba"+i +","+z);
			z++;
			for(y=0;y<m1.getDimF();y++)
			{	for(j=0; j<5; j++)
					{	System.out.print(m1.getMat()[y][j]+"\t");
						
					}
				System.out.println("");
			}
			System.out.println("---------");
			
			
			i++;
			
			
			
		}
		a=1;
		return a;

	}	
	
	
	

	}



