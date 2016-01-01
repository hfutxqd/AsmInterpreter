package room517.asm.interpreter.cmd;

import room517.asm.interpreter.register.Register;

/**
 * Created by Henry on 2015/12/31.
 *
 */
public abstract class cmd {
    Register reg = new Register();
    static cmd_buffer label_buf = null;
    String operand_1;
    String operand_2;
    public static void set_buffer(cmd_buffer b)
    {
        if (label_buf == null)
            label_buf = b;
    }
    public abstract void func();
    public static boolean is_reg(String word)
    {
        for(String i:Register.name)
        {
            if(i.equals(word))
            {
                return true;
            }
        }
        return false;
    }

    public static int str_to_int(String num_str)
    {
        return Integer.valueOf(num_str);
    }
}
