# Asm_Interpreter
一个简单的汇编语言解释器  
支持的寄存器有:  
ax,bx,cx,dx  
ah,al,bh,bl,ch,cl,dh,dl 
操作数只能是立即数和寄存器  
立即数格式示例：  
十进制：123  
八进制:0123  
十六进制:0x123  
支持的命令有：  
算术运算命令：  
add  
inc  
sub  
dec  
mul16  
mul32  
div16  
div32  
neg  
逻辑运算命令：  
and  
or  
not  
xor  
转移命令：  
cmp  
jcxz  
jz  
jg  
jl  
jne  
jnz  
jmp  
loop  
其他命令:  
test  
xchg  
clr  
int  (只支持21)  
