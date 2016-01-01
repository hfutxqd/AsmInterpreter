package room517.asm.interpreter.cmd;

import room517.asm.interpreter.register.Register;

/**
 * Created by Henry on 2015/12/31.
 *
 */
public class dec extends cmd {

    public dec(String o1)
    {
        operand_1 = o1;
        operand_2 = "";
    }

    @Override
    public void func() {
        Register.set(operand_1, Register.get(operand_1) - 1);
    }
}
