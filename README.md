# Assembly Language Simulator

The program takes Assembly Language instructions as input and displays the register values and flag status after performing all the instructions.

The required files for Simulation are :-<br />
I.  AssemblyLang.java (main file)<br />
II. Operations.java<br />
III.Input.txt (In Specified line by line Format only and all characters in uppercase only)

To Run/Start :<br />
1. Compile And Run AssemblyLang.java through java compiler<br />
2. Pass Input file (default file "Input.txt") as Command Line Argument.

I.AssemblyLang.java : <br />It contains the main method of the program.<br />
		                  It declares all the registers required for operation.<br />
                      It reads Instructions From Input File and calls the functions accordingly.<br />
		                  It also display the value of registers(in Hexadecimal format)<br /><br />
II.Operations.java :  <br />It contains all the functions needed for operation.<br />
		                  The operations are performed on Hexadecimal Numbers and calculations are done in 2's Complement form. <br /><br />
III. Input.txt :      <br />Write the Assembly Language Program in this file.

Example : Modify Input.txt similar to following :-

MVI D 8B<br />
MVI C 6F<br />
INR C<br />
MOV A C<br />
ADD D<br />
HLT
 
//It works in format as explained below

MVI [RegisterName] [Value]<br />
INR [RegisterName]<br />
MOV [Register1Name] [Register2Name]<br />
ADD [RegisterName]<br />
HLT   

    
The Assembly Language Simulator works for following Instructions:

MOV  [Register1Name]  [Register2Name]<br />
MVI  [RegisterName]   [Value]<br />
ADD  [RegisterName]<br />
ADI  [Value]<br />
SUB  [RegisterName]<br />
SUI  [Value]<br />
INR  [RegisterName]<br />
DCR  [RegisterName]<br />
ANA  [RegisterName]<br />
ANI  [Value]<br />
ORA  [RegisterName]<br />
ORI  [Value]<br />
XRA  [RegisterName]<br />
XRI  [Value]<br />
CMA  <br />
CMP  [RegisterName]<br />
CPI  [Value]<br />
HLT

*RegisterName represents any of registers A,B,C,D,E,H and L.          
