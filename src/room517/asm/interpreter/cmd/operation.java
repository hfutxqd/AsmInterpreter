package room517.asm.interpreter.cmd;

import room517.asm.interpreter.register.Register;

/**
 * Created by Henry on 2015/12/31.
 *
 */
public abstract class Operation extends Command {
    abstract long operate(long left,long right);
    @Override
    public void func() {
        if(!is_reg(operStr2) && is_reg(operStr1)) {//第二个操作数不是寄存器，第一个是寄存器
            Register.set(operStr1, operate(Register.get(operStr1), str_to_long(operStr2)));
        }else if(is_reg(operStr2) && is_reg(operStr1)){//两个都是寄存器
            Register.set(operStr1, operate(Register.get(operStr1), Register.get(operStr2)));
        }else if(!is_reg(operStr1)){//第一个不是寄存器
            operate(str_to_long(operStr1), -1);
        }
    }
    public Operation(String o1, String o2)
    {
        operStr1 = o1;
        operStr2 = o2;
    }
    public Operation()
    {
        operStr1 = "";
        operStr2 = "";
    }
}
