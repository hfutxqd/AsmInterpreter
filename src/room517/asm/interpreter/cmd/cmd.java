package room517.asm.interpreter.cmd;

import room517.asm.interpreter.register.Register;

/**
 * Created by Henry on 2015/12/31.
 *
 */
public abstract class cmd {
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

    public static long str_to_long(String num_str)
    {
        return Long.valueOf(num_str);
    }
}
