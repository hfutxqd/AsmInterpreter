package room517.asm.interpreter.cmd;

import room517.asm.interpreter.register.Register;

import java.io.IOException;

/**
 * Created by Henry on 2015/12/31.
 *
 */
public class int_ extends operation {
    void func_ah1()
    {
        char ch = 0;
        try {
            System.out.println("请输入一个字符，然后按回车键...");
            ch = (char) System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Register.set("al", (int)ch);
    }
    void func_ah2()
    {
        System.out.print((char)Register.get("dl"));
    }
    void func_ah3()
    {
        System.out.print(Register.get("dl"));
    }

    void func_ah4c()
    {
        curr_node.ptr_next = null;
        curr_node.ptr_jump = null;
    }

    @Override
    long operate(long left, long right) {
        if(left != 0x21)
        {
            System.err.println("不支持的中断请求:"+operStr1);
            System.exit(-1);
        }
        if (Register.get("ah") == 1) {
            func_ah1();
        }
        else if (Register.get("ah") == 2) {
            func_ah2();
        }
        else if (Register.get("ah") == 3) {
            func_ah3();
        }
        else if (Register.get("ah") == 0x4C) {
            func_ah4c();
        }
        return 0;
    }
    node curr_node;
    public int_(String code, node ptr_node)
    {
        operStr1 = code;
        operStr2 = "";
        curr_node = ptr_node;
    }
}
