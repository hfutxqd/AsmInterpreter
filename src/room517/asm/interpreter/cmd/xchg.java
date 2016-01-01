package room517.asm.interpreter.cmd;

import room517.asm.interpreter.register.Register;

/**
 * Created by Henry on 2015/12/31.
 *
 */
public class xchg extends cmd {
    public xchg(String o1, String o2)
    {
        operand_1 = o1; operand_2 = o2;
    }
    public void func()
    {
        long temp = Register.get(operand_1);
        Register.set(operand_1, Register.get(operand_2));
        Register.set(operand_2, temp);
    }
}
