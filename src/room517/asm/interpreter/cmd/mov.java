package room517.asm.interpreter.cmd;

import room517.asm.interpreter.register.Register;

/**
 * Created by Henry on 2015/12/31.
 *
 */
public class mov extends Command {

    void func_1()
    {
        Register.set(operStr1, str_to_long(operStr2));
    }
    void func_2()
    {
        Register.set(operStr1, Register.get(operStr2));
    }
    public mov(String o1, String o2)
    {
        operStr1 = o1;
        operStr2 = o2;
    }
    public mov()
    {
        operStr1 = "";
        operStr2 = "";
    }


    @Override
    public void func() {
        if(is_reg(operStr2)) {
            func_2();
        }
        else {
            func_1();
        }
    }
}
