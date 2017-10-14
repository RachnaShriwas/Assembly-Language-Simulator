import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringTokenizer;

class Register
{	
	static String registers[]={"A","B","C","D","E","H","L"};	//Array of registers A,B,C,D,E,H,L 
	static int registerval[]= { 0 , 0 , 0 , 0 , 0 , 0 , 0 };	//Initializing values of Registers with 0

	
	//Read Instructions From Input File
	//and call the functions accordingly
	void ReadInput(String filename) throws IOException
	{
		//This object will read Input File 
		BufferedReader br = new BufferedReader(new FileReader(filename));

		//A variable to read file line by line
		String line;
	
		while((line=br.readLine())!=null)
		{
			//Tokenizing line using " " as parameter 
			StringTokenizer s = new StringTokenizer(line," ");
			String choice = s.nextToken();
			
			switch(choice)
			{

				case "MOV" :
				{
					//Calls the mov function in Operations class and passes two registers as parameters
					Operations.mov(s.nextToken(),s.nextToken());
					break;	
				}
		
				case "MVI" :
				{
					//Calls the mvi function in operations class and passes a register and an integer value as parameter
					Operations.mvi(s.nextToken(),s.nextToken());
					break;	
				}

				case "ADD" :
				{
					//Calls the add function in Operations class and passes a register as parameter
					Operations.add(s.nextToken());
					break;
				}
	
				case "ADI" :
				{
					//Calls the adi function in Operations class and passes an integer value as parameter
					Operations.adi(s.nextToken());
					break;
				}
		
				case "SUB" :
				{
					//Calls the sub function in Operations class and passes a register as parameter
					Operations.sub(s.nextToken());
					break;
				}	

				case "SUI" :
				{
					//Calls the sui function in Operations class and passes an integer value as parameter
					Operations.sui(s.nextToken());
					break;
				}

				case "INR" :
				{
					//Calls the inr function in Operations class and passes a register as parameter
					Operations.inr(s.nextToken());
					break;
				}

				case "DCR" :
				{
					//Calls the dcr function in Operations class and passes a register as parameter
					Operations.dcr(s.nextToken());
					break;
				}

				case "ANA" :
				{
					//Calls the ana function in Operations class and passes a register as parameter
					Operations.ana(s.nextToken());
					break;
				}

				case "ANI" :
				{
					//Calls the ani function in Operations class and passes an integer value as parameter	
					Operations.ani(s.nextToken());
					break;
				}

				case "ORA" :
				{
					//Calls the ora function in Operations class and passes a register as parameter
					Operations.ora(s.nextToken());
					break;
				}

				case "ORI" :
				{
					//Calls the ori function in Operations class and passes an integer value as parameter
					Operations.ori(s.nextToken());
					break;
				}

				case "XRA" :
				{
					//Calls the xra function in Operations class and passes a register as parameter
					Operations.xra(s.nextToken());
					break;
				}

				case "XRI" :
				{
					//Calls the xri function in Operations class and passes an integer value as parameter
					Operations.xri(s.nextToken());
					break;
				}
		
				case "CMA":
				{
					//Calls the cma function in Operations class 
					Operations.cma();
					break;
				}


				case "CMP" :
				{
					//Calls the cmp function in Operations class and passes a register as parameter
					Operations.cmp(s.nextToken());
					break;
				}

				case "CPI" :
				{
					//Calls the cpi function in Operations class and passes an integer value as parameter
					Operations.cpi(s.nextToken());
					break;
				}

				case "HLT" :
				{
					//Display output on screen
					show();
					//terminates the program
					System.exit(0);
				}
				
				default :
				{
					System.out.println("\nInvalid Instruction in the Program.");
					System.exit(0);
				}		
			}
				
		}
									
	}	


	
	//A method to find the corresponding index of Register in the array 
	//Returns the index				
	static int getIndexOfReg(String reg)
	{
		for(int i=0;i<registers.length;i++)
		{
			if(reg.equals(registers[i]))
				return i;	
		}
		//returns -1 if Register not found in array
		return -1;
	}		
	
	
	//A method to display the values of registers and flags on Output Screen	
	void show()
	{
		System.out.println("\nValues of Registers are:");

		for(int i=0;i<registers.length;i++)
			System.out.print(registers[i]+"\t");

		System.out.println();

		for(int i=0;i<registerval.length;i++)
			System.out.print(Operations.toHexaDecimal(registerval[i])+"\t");

		
		System.out.println("\n\nFlag Status:");

		System.out.println("CARRY(CY) : "+Operations.CARRY);
		System.out.println("ZERO(Z)   : "+Operations.ZERO);
		System.out.println("SIGN(S)   : "+Operations.NEGATIVE);
	}			

}


public class AssemblyLang
{
	public static void main(String args[]) throws IOException 
	{
		//This will create an object of class Register
		Register r=new Register();

		try{
			//Calls the function of class Register to read from Input File
			r.ReadInput(args[0]);			
		
		}catch(ArrayIndexOutOfBoundsException e){
			System.out.println("No Input File specified");
			System.out.println("Loading the default Input File...");
			r.ReadInput("Input.txt");
		} 
		catch(IOException e){
			System.out.println("Couldn't find the given file");
			System.out.println("Terminating Program...");
		}
	}
}
