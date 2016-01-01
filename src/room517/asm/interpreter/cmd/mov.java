package room517.asm.interpreter.cmd;

import room517.asm.interpreter.register.Register;

/**
 * Created by Henry on 2015/12/31.
 *
 */
public class mov extends cmd {

    void func_1()
    {
        Register.set(operand_1, str_to_long(operand_2));
    }
    void func_2()
    {
        Register.set(operand_1, Register.get(operand_2));
    }
    public mov(String o1, String o2)
    {
        operand_1 = o1;
        operand_2 = o2;
    }
    public mov()
    {
        operand_1 = "";
        operand_2 = "";
    }


    @Override
    public void func() {
        if(is_reg(operand_2)) {
            func_2();
        }
        else {
            func_1();
        }
    }
}
