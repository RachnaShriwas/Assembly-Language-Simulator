public class Operations
{
	static int CARRY=0;			//Initializing CARRY Flag with 0			
	static int NEGATIVE=0;			//Initializing NEGATIVE Flag with 0
	static int ZERO=0;			//Initializing ZERO Flag with 0
	

	//Performs function of instruction MOV of Assembly Language Programming
	//Copies value of Register reg2 to Register reg1
	static void mov(String reg1,String reg2)
	{	
		//Get the index of reg1
		int n1=Register.getIndexOfReg(reg1);
		//Get the index of reg2
		int n2=Register.getIndexOfReg(reg2);

		Register.registerval[n1]=Register.registerval[n2];
	}

	
	//Performs function of instruction MVI of Assembly Language Programming
	//Copies val to Register reg
	static void mvi(String reg,String val)
	{
		//Get the index of reg
		int n1=Register.getIndexOfReg(reg);

		Register.registerval[n1]=Integer.parseInt(val,16);
	}


	//Performs function of instruction ADD of Assembly Language Programming
	//Adds the value of Register reg to the value of Accumulator and stores the sum in Accumulator
	static void add(String reg)
	{
		//A variable to store the sum 
		String sum = "";
      
		//A counter to run the loop 8 times for 8-bit data
        	int i=7;

		//Get the index of the Register reg
		int n=Register.getIndexOfReg(reg);
		
		//Convert value of Register reg to 8-bit Binary number
		String register=toBinary(Register.registerval[n]);
		
		//Convert value of Accumulator to 8-bit Binary number
		String accumulator=toBinary(Register.registerval[0]);
		
		//calculate the value of sum
		//follows binary addition laws
		//and sets the CARRY flag accordingly
        	while (i >= 0)
		{
			if(accumulator.charAt(i) == '1' && register.charAt(i) == '1' && CARRY==1)
			{
                		sum = "1"+sum;
                		CARRY=1;
            		}
			else if(accumulator.charAt(i) == '1' && register.charAt(i) == '0' && CARRY==1)
			{
                		sum = "0"+sum;
               		 	CARRY=1;
            		}
			else if(accumulator.charAt(i) == '0' && register.charAt(i) == '1' && CARRY==1)
			{
                		sum = "0"+sum;
                		CARRY=1;
        	    	}
			else if(accumulator.charAt(i) == '0' && register.charAt(i) == '0' && CARRY==1)
			{
		                sum = "1"+sum;
        		        CARRY=0;
            		}
			else if(accumulator.charAt(i) == '1' && register.charAt(i) == '1' && CARRY==0)
			{
               		 	sum = "0"+sum;
                		CARRY=1;
            		}
			else if(accumulator.charAt(i) == '1' && register.charAt(i) == '0' && CARRY==0)
			{
                		sum = "1"+sum;
         		       	CARRY=0;
            		}
			else if(accumulator.charAt(i) == '0' && register.charAt(i) == '1' && CARRY==0)
			{
                		sum = "1"+sum;
                		CARRY=0;
            		}
			else if(accumulator.charAt(i) == '0' && register.charAt(i) == '0' && CARRY==0)
			{
                		sum = "0"+sum;
                		CARRY=0;
            		}
            
            		i--;
        	}	
	
		//Store the sum in Accumulator
		Register.registerval[0]=Integer.parseInt(sum,2);
		
		//Set the NEGATIVE flag on the basis of value of Most Significant Bit(MSB)
	        if(sum.charAt(0)=='1')
		{
         	   	NEGATIVE=1;
       	 	}
		else
		{
        	    NEGATIVE=0;
        	}

		//Set the value of ZERO flag on the basis of value of sum        
       	 	if(Integer.parseInt(sum, 2)==0)
		{
            		ZERO=1;
        	}
		else
		{
            		ZERO=0;
        	} 
       	}
	

	//Performs the function of instruction ADI of Asssembly Language Programming
	//Add the value of variable val to the value of Accumulator and stores the sum in Accumulator
	static void adi(String val)
	{
		//A variable to store the sum 
		String sum = "";
      
		//A counter to run the loop 8 times for 8-bit data
        	int i=7;

		//Convert value of variable val to 8-bit Binary number
		String value=toBinary(Integer.parseInt(val,16));
		
		//Convert value of Accumulator to 8-bit Binary number
		String accumulator=toBinary(Register.registerval[0]);
		
		//calculate the value of sum
		//follows binary addition laws
		//and sets the CARRY flag accordingly
        	while (i >= 0)
		{
			if(accumulator.charAt(i) == '1' && value.charAt(i) == '1' && CARRY==1)
			{
                		sum = "1"+sum;
                		CARRY=1;
            		}
			else if(accumulator.charAt(i) == '1' && value.charAt(i) == '0' && CARRY==1)
			{
                		sum = "0"+sum;
               		 	CARRY=1;
            		}
			else if(accumulator.charAt(i) == '0' && value.charAt(i) == '1' && CARRY==1)
			{
                		sum = "0"+sum;
                		CARRY=1;
        	    	}
			else if(accumulator.charAt(i) == '0' && value.charAt(i) == '0' && CARRY==1)
			{
		                sum = "1"+sum;
        		        CARRY=0;
            		}
			else if(accumulator.charAt(i) == '1' && value.charAt(i) == '1' && CARRY==0)
			{
               		 	sum = "0"+sum;
                		CARRY=1;
            		}
			else if(accumulator.charAt(i) == '1' && value.charAt(i) == '0' && CARRY==0)
			{
                		sum = "1"+sum;
         		       	CARRY=0;
            		}
			else if(accumulator.charAt(i) == '0' && value.charAt(i) == '1' && CARRY==0)
			{
                		sum = "1"+sum;
                		CARRY=0;
            		}
			else if(accumulator.charAt(i) == '0' && value.charAt(i) == '0' && CARRY==0)
			{
                		sum = "0"+sum;
                		CARRY=0;
            		}
            
            		i--;
        	}	
	
		//Store the sum in Accumulator
		Register.registerval[0]=Integer.parseInt(sum,2);

		//Set the NEGATIVE flag on the basis of value of Most Significant Bit(MSB)
	        if(sum.charAt(0)=='1')
		{
         	   	NEGATIVE=1;
       	 	}
		else
		{
        	    NEGATIVE=0;
        	}
        
		//Set the value of ZERO flag on the basis of value of sum  
       	 	if(Integer.parseInt(sum, 2)==0)
		{
            		ZERO=1;
        	}
		else
		{
            		ZERO=0;
        	}
	}


	//Performs function of instruction SUB of Assembly Language Programming
	//Subtracts the value of Register reg from the value of Accumulator 
	//and stores the result in Accumulator
	static void sub(String reg)
	{
		//Get the index of the Register reg
		int n=Register.getIndexOfReg(reg);
		
		//Convert value of Register reg to 8-bit Binary number
		String regNeg = neg(toBinary(Register.registerval[n]));

		//Calls addc function to add regNeg and value of Accumulator 
		//and store it in variable sub
        	String sub = addc(toBinary(Register.registerval[0]), regNeg);

		
		//Store the result in Accumulator in Decimal format
		Register.registerval[0]=Integer.parseInt(sub,2);
        
		//Set the NEGATIVE flag on the basis of value of Most Significant Bit(MSB)
        	if(sub.charAt(0)=='1')
            		NEGATIVE=1;
        	else
           		NEGATIVE=0;
        
		//Set the value of ZERO flag on the basis of value of sub  
        	if(Integer.parseInt(sub, 2)==0)
           	 	ZERO=1;
        	else
            		ZERO=0;
	}


	//Performs function of instruction SUI of Assembly Language Programming
	//Subtracts the value of val from the value of Accumulator
	//and stores the result in Accumulator
	static void sui(String val)
	{
		//Find the 2's complement of the value of register
		String regNeg = neg(toBinary(Integer.parseInt(val,16)));

		//Calls addc function to add regNeg and value of Accumulator 
		//and store it in variable sub
        	String sub = addc(toBinary(Register.registerval[0]), regNeg);

		//Store the result in Accumulator in Decimal format
		Register.registerval[0]=Integer.parseInt(sub,2);
        
		//Set the NEGATIVE flag on the basis of value of Most Significant Bit(MSB)
        	if(sub.charAt(0)=='1')
            		NEGATIVE=1;
        	else
           		NEGATIVE=0;
        
		//Set the value of ZERO flag on the basis of value of sub  
        	if(Integer.parseInt(sub, 2)==0)
           	 	ZERO=1;
        	else
            		ZERO=0;
	}

	//Performs function of instruction INR of Assembly Language Programming
	//Increments the value of Register reg by 1
	static void inr(String reg)
	{
		//Get the index of the Register reg
		int n=Register.getIndexOfReg(reg);
		//Increment the value
		Register.registerval[n]++;
	}
	
	//Performs function of instruction DCR of Assembly Language Programming
	//Decrements the value of Register reg by 1	
	static void dcr(String reg)
	{
		//Get the index of the Register reg
		int n=Register.getIndexOfReg(reg);
		//Decrement the value
		Register.registerval[n]--;
	}

	//Performs function of instruction ANA of Assembly Language Programming
	//AND the value of Register reg with the value of Accumulator
	//and store the result in Accumulator
	static void ana(String reg)
	{
		//Get the index of the Register reg
		int n=Register.getIndexOfReg(reg);
		
		//Convert value of Register reg to 8-bit Binary number
		String register=toBinary(Register.registerval[n]);
		
		//Convert value of Accumulator to 8-bit Binary number
		String accumulator=toBinary(Register.registerval[0]);

		//A counter to run the loop 8 times for 8-bit data
		int i = 0;
		//A variable to store the result
        	String and = "";
        
		//Performs AND operation
        	while (i < 8)
		{
            		if(accumulator.charAt(i) == '0' || register.charAt(i) == '0')
                		and = and.concat("0");
            		else
                		and = and.concat("1");
			i++;
		}

		//Store the result in Accumulator
		Register.registerval[0]=Integer.parseInt(and,2);
        
		//Set the CARRY flag to 0
		CARRY=0;

		//Set the value of ZERO flag on the basis of value of and
       		if(Integer.parseInt(and, 2)==0)
            		ZERO=1;
       		else
           	 	ZERO=0;
        	
       
		//Set the NEGATIVE flag on the basis of value of Most Significant Bit(MSB)
       		if(and.charAt(0)=='1')
        		NEGATIVE=1;
        	else
        		NEGATIVE=0;
    	}


	//Performs function of instruction ANI of Assembly Language Programming
	//AND the value of val with the value of Accumulator
	//and store the result in Accumulator
	static void ani(String val)
	{
		//Convert the given value to 8-bit Binary number
		String value=toBinary(Integer.parseInt(val,16));
		
		//Convert value of Accumulator to 8-bit Binary number
		String accumulator=toBinary(Register.registerval[0]);

		//A counter to run the loop 8 times for 8-bit data
		int i = 0;
		//A variable to store the result
        	String and = "";

		//Performs AND operation
        	while (i < 8)
		{
            		if(accumulator.charAt(i) == '0' || value.charAt(i) == '0')
                		and = and.concat("0");
            		else
                		and = and.concat("1");
			i++;
		}
                        
            	

		//Store the result in Accumulator
		Register.registerval[0]=Integer.parseInt(and,2);
        
		//Set the CARRY flag to 0
		CARRY=0;

		//Set the value of ZERO flag on the basis of value of and
       		if(Integer.parseInt(and, 2)==0)
            		ZERO=1;
       		else
           	 	ZERO=0;
        	
       
		//Set the NEGATIVE flag on the basis of value of Most Significant Bit(MSB)
       		if(and.charAt(0)=='1')
        		NEGATIVE=1;
        	else
        		NEGATIVE=0;

	}

	//Performs function of instruction ORA of Assembly Language Programming
	//OR the value of Register reg with the value of Accumulator
	//and store the result in Accumulator
	static void ora(String reg)
	{
		//Get the index of the Register reg
		int n=Register.getIndexOfReg(reg);
		
		//Convert value of Register reg to 8-bit Binary number
		String register=toBinary(Register.registerval[n]);
		
		//Convert value of Accumulator to 8-bit Binary number
		String accumulator=toBinary(Register.registerval[0]);

		//A counter to run the loop 8 times for 8-bit data
		int i = 0;
		//A variable to store the result
        	String or = "";
        
		//Performs OR operation
        	while (i < 8)
		{
            		if(accumulator.charAt(i) == '0' && register.charAt(i) == '0')
                		or = or.concat("0");
            		else
                		or = or.concat("1");
			i++;
		}
                        
            	

		//Store the result in Accumulator
		Register.registerval[0]=Integer.parseInt(or,2);
        
		//Set the CARRY flag to 0
		CARRY=0;

		//Set the value of ZERO flag on the basis of value of or
       		if(Integer.parseInt(or, 2)==0)
            		ZERO=1;
       		else
           	 	ZERO=0;
        	
       
		//Set the NEGATIVE flag on the basis of value of Most Significant Bit(MSB)
       		if(or.charAt(0)=='1')
        		NEGATIVE=1;
        	else
        		NEGATIVE=0;

	}

	//Performs function of instruction ORI of Assembly Language Programming
	//OR the value of val with the value of Accumulator
	//and store the result in Accumulator
	static void ori(String val)
	{
		//Convert the given value to 8-bit Binary number
		String value=toBinary(Integer.parseInt(val,16));
		
		//Convert value of Accumulator to 8-bit Binary number
		String accumulator=toBinary(Register.registerval[0]);

		//A counter to run the loop 8 times for 8-bit data
		int i = 0;
		//A variable to store the result
        	String or = "";

		//Performs OR operation
        	while (i < 8)
		{
            		if(accumulator.charAt(i) == '0' && value.charAt(i) == '0')
                		or = or.concat("0");
            		else
                		or = or.concat("1");
			i++;
		}
                        
            	

		//Store the result in Accumulator
		Register.registerval[0]=Integer.parseInt(or,2);
        
		//Set the CARRY flag to 0
		CARRY=0;

		//Set the value of ZERO flag on the basis of value of or
       		if(Integer.parseInt(or, 2)==0)
            		ZERO=1;
       		else
           	 	ZERO=0;
        	
       
		//Set the NEGATIVE flag on the basis of value of Most Significant Bit(MSB)
       		if(or.charAt(0)=='1')
        		NEGATIVE=1;
        	else
        		NEGATIVE=0;
	}

	
	//Performs function of instruction XRA of Assembly Language Programming
	//Exclusive-ORs the value of Register reg with the value of Accumulator
	//and store the result in Accumulator
	static void xra(String reg)
	{
		//Get the index of the Register reg
		int n=Register.getIndexOfReg(reg);
		
		//Convert value of Register reg to 8-bit Binary number
		String register=toBinary(Register.registerval[n]);
		
		//Convert value of Accumulator to 8-bit Binary number
		String accumulator=toBinary(Register.registerval[0]);

		//A counter to run the loop 8 times for 8-bit data
		int i = 0;
		//A variable to store the result
        	String xor = "";
        
		//Performs XOR operation
        	while (i < 8)
		{
            		if(accumulator.charAt(i) == '1' && register.charAt(i) == '1')
                		xor = xor.concat("0");
			else if(accumulator.charAt(i) == '0' && register.charAt(i) == '0')
				xor = xor.concat("0");
            		else
                		xor = xor.concat("1");
			i++;
		}
                        
            	

		//Store the result in Accumulator
		Register.registerval[0]=Integer.parseInt(xor,2);
        
		//Set the CARRY flag to 0
		CARRY=0;

		//Set the value of ZERO flag on the basis of value of xor
       		if(Integer.parseInt(xor, 2)==0)
            		ZERO=1;
       		else
           	 	ZERO=0;
        	
       
		//Set the NEGATIVE flag on the basis of value of Most Significant Bit(MSB)
       		if(xor.charAt(0)=='1')
        		NEGATIVE=1;
        	else
        		NEGATIVE=0;

	}

	
	//Performs function of instruction XRI of Assembly Language Programming
	//Exclusive-ORs the value of val with the value of Accumulator
	//and store the result in Accumulator
	static void xri(String val)
	{
		//Convert the given value to 8-bit Binary number
		String value=toBinary(Integer.parseInt(val,16));
		
		//Convert value of Accumulator to 8-bit Binary number
		String accumulator=toBinary(Register.registerval[0]);

		//A counter to run the loop 8 times for 8-bit data
		int i = 0;
		//A variable to store the result
        	String xor = "";

		//Performs XOR operation
        	while (i < 8)
		{
            		if(accumulator.charAt(i) == '1' && value.charAt(i) == '1')
                		xor = xor.concat("0");
			else if(accumulator.charAt(i) == '0' && value.charAt(i) == '0')
				xor = xor.concat("0");
            		else
                		xor = xor.concat("1");
			i++;
		}
                        
            	

		//Store the result in Accumulator
		Register.registerval[0]=Integer.parseInt(xor,2);
        
		//Set the CARRY flag to 0
		CARRY=0;

		//Set the value of ZERO flag on the basis of value of xor
       		if(Integer.parseInt(xor, 2)==0)
            		ZERO=1;
       		else
           	 	ZERO=0;
        	
       
		//Set the NEGATIVE flag on the basis of value of Most Significant Bit(MSB)
       		if(xor.charAt(0)=='1')
        		NEGATIVE=1;
        	else
        		NEGATIVE=0;
	}



	//Performs function of instruction CMA of Assembly Language Programming
	//Complements the value of Accumulator
	static void cma()
	{
		//A counter to run the loop 8 times for 8-bit data
        	int i = 0;
		//A variable to store the result
        	String cma = "";
	
		//Convert value of Accumulator to 8-bit Binary number
		String accumulator=toBinary(Register.registerval[0]);

		//Complements the value
        	while(i < 8)
		{
            		if(accumulator.charAt(i) == '0')
                		cma = cma.concat("1");
            		else
                		cma = cma.concat("0");
            		i++;
        	}
		
		//Store the result in Accumulator
		Register.registerval[0]=Integer.parseInt(cma,2);		
	}

	//Performs function of instruction CMP of Asssembly Language Programming
	//Compares the value of Register reg and the value of Accumulator 
	//and sets the CARRY, NEGATIVE and ZERO flag accordingly
	static void cmp(String reg)
	{
		//Get the index of the Register reg
		int n=Register.getIndexOfReg(reg);
		
		//Convert value of Register reg to 8-bit Binary number
		String register=toBinary(Register.registerval[n]);
		
		//Convert value of Accumulator to 8-bit Binary number
		String accumulator=toBinary(Register.registerval[0]);

		//A counter to run the loop 8 times for 8-bit data
		int i = 0;

		//A flag to check if values are equal
		int flag=0;

		//Compare the two values 
		while(i<8)
		{
			if(accumulator.charAt(i) != register.charAt(i))
			{
				flag=1;
				break;
			}
			i++;
		}

		//Set the value of ZERO flag on the basis of value of flag
		if(flag==0)
			ZERO=1;
		else
			ZERO=0;

		//Subtract the two values to check which one is greater.
		//Calculates 2's complement of register
		//and adds it to the value of accumulator
		//to perform subtraction using 2's complement 
		String temp=addc(accumulator,neg(register));

		//Set the NEGATIVE flag on the basis of value of Most Significant Bit(MSB)
       		if(temp.charAt(0)=='1')
        		NEGATIVE=1;
        	else
        		NEGATIVE=0;		
	}


	//Performs function of instruction CPI of Asssembly Language Programming
	//Compares the value of val and the value of Accumulator 
	//and sets the CARRY, NEGATIVE and ZERO flag accordingly
	static void cpi(String val)
	{		
		//Convert the given value to 8-bit Binary number
		String value=toBinary(Integer.parseInt(val,16));
		
		//Convert value of Accumulator to 8-bit Binary number
		String accumulator=toBinary(Register.registerval[0]);

		//A counter to run the loop 8 times for 8-bit data
		int i = 0;

		//A flag to check if values are equal
		int flag=0;

		//Compare the two values 
		while(i<8)
		{
			if(accumulator.charAt(i) != value.charAt(i))
			{
				flag=1;
				break;
			}
			i++;
		}

		//Set the value of ZERO flag on the basis of value of flag
		if(flag==0)
			ZERO=1;
		else
			ZERO=0;

		//Subtract the two values to check which one is greater.
		//Calculates 2's complement of register
		//and adds it to the value of accumulator
		//to perform subtraction using 2's complement 
		String temp=addc(accumulator,neg(value));

		//Set the NEGATIVE flag on the basis of value of Most Significant Bit(MSB)
       		if(temp.charAt(0)=='1')
        		NEGATIVE=1;
        	else
        		NEGATIVE=0;

	}
	

	//Add The values of two Registers
	//return the sum
	static String addc(String register1,String register2)
	{
		//A variable to store the sum 
		String sum = "";
      
		//A counter to run the loop 8 times for 8-bit data 
        	int i=7;

		//calculate the value of sum
		//follows binary addition laws
		//and sets the CARRY flag accordingly				
           	while (i >= 0)
		{
			if(register1.charAt(i) == '1' && register2.charAt(i) == '1' && CARRY==1)
			{
                		sum = "1"+sum;
                		CARRY=1;
            		}
			else if(register1.charAt(i) == '1' && register2.charAt(i) == '0' && CARRY==1)
			{
                		sum = "0"+sum;
               		 	CARRY=1;
            		}
			else if(register1.charAt(i) == '0' && register2.charAt(i) == '1' && CARRY==1)
			{
                		sum = "0"+sum;
                		CARRY=1;
        	    	}
			else if(register1.charAt(i) == '0' && register2.charAt(i) == '0' && CARRY==1)
			{
		                sum = "1"+sum;
        		        CARRY=0;
            		}
			else if(register1.charAt(i) == '1' && register2.charAt(i) == '1' && CARRY==0)
			{
               		 	sum = "0"+sum;
                		CARRY=1;
            		}
			else if(register1.charAt(i) == '1' && register2.charAt(i) == '0' && CARRY==0)
			{
                		sum = "1"+sum;
         		       	CARRY=0;
            		}
			else if(register1.charAt(i) == '0' && register2.charAt(i) == '1' && CARRY==0)
			{
                		sum = "1"+sum;
                		CARRY=0;
            		}
			else if(register1.charAt(i) == '0' && register2.charAt(i) == '0' && CARRY==0)
			{
                		sum = "0"+sum;
                		CARRY=0;
            		}
            
            		i--;
        	}	
	
		//Set the NEGATIVE flag on the basis of value of Most Significant Bit(MSB)		
	        if(sum.charAt(0)=='1')
		{
         	   	NEGATIVE=1;
       	 	}
		else
		{
        	    NEGATIVE=0;
        	}
        
		//Set the value of ZERO flag on the basis of value of sum     
       	 	if(Integer.parseInt(sum, 2)==0)
		{
            		ZERO=1;
        	}
		else
		{
            		ZERO=0;
        	}
        
		//return the value of sum
		return sum;
	}


	//Calculate 1's Complement of the value of Register reg
	static String not(String reg)
    	{
		//A counter to run the loop 8 times for 8-bit data
        	int i = 0;
		//A variable to store the result
        	String not = "";

		//Complements the value
        	while(i < 8)
		{
            		if(reg.charAt(i) == '0')
                		not = not.concat("1");
            		else
                		not = not.concat("0");
            		i++;
        	}

        	//Set the value of ZERO flag on the basis of value of result     
		if(Integer.parseInt(not, 2)==0)
           		 ZERO=1;
        
		else
            		 ZERO=0;
        
		//Set the NEGATIVE flag on the basis of value of Most Significant Bit(MSB)
        	if(not.charAt(0)=='1')
            		NEGATIVE=1;
		else
            		NEGATIVE=0;
                
		//returns the complemented value
        	return not;
        }
 
	//Calculate 2's Complement of the value of Register reg
	static String neg(String reg)
    	{
		//Calls function not to find 1's complement and store it in variable not
        	String not = not(reg);
		//A variable with value 1
	 	String one = "00000001";

		//Initialize CARRY flag with 0 to perform addition
        	CARRY=0;
		//Calls function addc to find 2's complement and store the result in variable neg 
        	String neg = addc(not,one);
        
        	//Set the value of ZERO flag on the basis of value of result            
        	if(Integer.parseInt(neg, 2)==0)
            		ZERO=1;
		else
            		ZERO=0;
        
		//Set the NEGATIVE flag on the basis of value of Most Significant Bit(MSB)
        	if(neg.charAt(0)=='1')
            		NEGATIVE=1;
		else
            		NEGATIVE=0;
        
		//returns 2's complement
        	return neg;
    	}

	
	//Converts given integer value to Hexadecimal value
	//returns result in String format
	static String toHexaDecimal(int val)
	{
		//Calls function to convert to hexadecimal value
		String temp=Integer.toHexString(val);
		//return the result
		return temp;
	}
	
		
	//Converts given integer value to 8-bit Binary value
	//return result in String format
	static String toBinary(int val)
	{
		//Calls function to convert to binary value
		String temp=Integer.toBinaryString(val);
		
		//Find the length of Binary value temp
		int length=temp.length();
		//A variable to store 8-bit value
		StringBuilder temp1=new StringBuilder();

		//Check whether binary value is 8-bit 
		//If not, convert it to 8-bit value
		if(length<8)
		{
			//run the loop, the no. of times required to make it 8-bit
			while(8-length>0)
			{
				//Make a string of all 0
				temp1.append("0");
				length++;
			}
		}

		//Concatenate the binary value with zero string in beginning 		
		temp=temp1+temp;
		//return the 8-bit binary value
		return temp;
	}
}
