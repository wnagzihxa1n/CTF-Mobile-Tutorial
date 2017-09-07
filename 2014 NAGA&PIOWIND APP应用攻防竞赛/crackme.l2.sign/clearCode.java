package com.crackme;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View$OnClickListener;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.io.PrintStream;

public class MainActivity extends Activity {
    private Button btn_login;
    private Button btn_reset;
    public static MainActivity m_lpThisBen;
    private EditText txt_name;
    private EditText txt_passwd;
    private TextView txt_result;

    static {
        String v0 = "crackme";
        System.loadLibrary(v0);
    }

    public MainActivity() {
        super();
    }

    static EditText access$0(MainActivity arg2) {
        EditText v0 = arg2.txt_name;
        return v0;
    }

    static EditText access$1(MainActivity arg2) {
        EditText v0 = arg2.txt_passwd;
        return v0;
    }

    static TextView access$2(MainActivity arg2) {
        TextView v0 = arg2.txt_result;
        return v0;
    }

    static String access$3(MainActivity arg2, String arg3, String arg4) {
        String v0 = arg2.crackme(arg3, arg4);
        return v0;
    }

    private native String crackme(String arg1, String arg2) {
    }

    protected void onCreate(Bundle arg4) {
        super.onCreate(arg4);
        int v0 = 2130903040;
        this.setContentView(v0);
        v0 = 2131165184;
        View v0_1 = this.findViewById(v0);
        this.txt_name = ((EditText)v0_1);
        v0 = 2131165185;
        v0_1 = this.findViewById(v0);
        this.txt_passwd = ((EditText)v0_1);
        v0 = 2131165186;
        v0_1 = this.findViewById(v0);
        this.btn_login = ((Button)v0_1);
        v0 = 2131165187;
        v0_1 = this.findViewById(v0);
        this.btn_reset = ((Button)v0_1);
        v0 = 2131165188;
        v0_1 = this.findViewById(v0);
        this.txt_result = ((TextView)v0_1);
        Button v0_2 = this.btn_login;
        com.crackme.MainActivity$1 v1 = new View$OnClickListener() {
            public void onClick(View arg8) {
                TextView v3_6;
                String v4;
                PrintStream v3_5;
                MainActivity v3 = MainActivity.this;
                EditText v3_1 = MainActivity.access$0(v3);
                Editable v3_2 = v3_1.getText();
                String v0 = v3_2.toString();
                v3 = MainActivity.this;
                v3_1 = MainActivity.access$1(v3);
                v3_2 = v3_1.getText();
                String v1 = v3_2.toString();
                String v3_3 = "";
                boolean v3_4 = v3_3.equals(v0);
                if(v3_4) {
                    v3_5 = System.out;
                    v4 = "name is null or \'\'";
                    v3_5.println(v4);
                    v3 = MainActivity.this;
                    v3_6 = MainActivity.access$2(v3);
                    v4 = "账户为空";
                    v3_6.setText(((CharSequence)v4));
                }
                else {
                    v3_3 = "";
                    v3_4 = v3_3.equals(v1);
                    if(v3_4) {
                        v3_5 = System.out;
                        v4 = "passwd is null or \'\'";
                        v3_5.println(v4);
                        v3 = MainActivity.this;
                        v3_6 = MainActivity.access$2(v3);
                        v4 = "密码为空";
                        v3_6.setText(((CharSequence)v4));
                        while(true) {
                            if(98 >= 0) {
                                goto label_152;
                            }
                        }
                    }
                    v3_5 = System.out;
                    String v5 = "name:";
                    StringBuilder v4_1 = new StringBuilder(v5);
                    v4_1 = v4_1.append(v0);
                    v4 = v4_1.toString();
                    v3_5.println(v4);
                    v3_5 = System.out;
                    v5 = "passwd:";
                    v4_1 = new StringBuilder(v5);
                    v4_1 = v4_1.append(v1);
                    v4 = v4_1.toString();
                    v3_5.println(v4);
                    v3_5 = System.out;
                    v4 = "Please treat me gently, you have to go a long way.";
                    v3_5.println(v4);
                    v3 = MainActivity.this;
                    String v2 = MainActivity.access$3(v3, v0, v1);
                    v3 = MainActivity.this;
                    v3_6 = MainActivity.access$2(v3);
                    v3_6.setText(((CharSequence)v2));
                }
            label_152:
            }
        };
        v0_2.setOnClickListener(((View$OnClickListener)v1));
        v0_2 = this.btn_reset;
        com.crackme.MainActivity$2 v1_1 = new View$OnClickListener() {
            public void onClick(View arg4) {
                MainActivity v0 = MainActivity.this;
                EditText v0_1 = MainActivity.access$0(v0);
                String v1 = "";
                v0_1.setText(((CharSequence)v1));
                v0 = MainActivity.this;
                v0_1 = MainActivity.access$1(v0);
                v1 = "";
                v0_1.setText(((CharSequence)v1));
                v0 = MainActivity.this;
                TextView v0_2 = MainActivity.access$2(v0);
                v1 = "";
                v0_2.setText(((CharSequence)v1));
            }
        };
        v0_2.setOnClickListener(((View$OnClickListener)v1_1));
    }
}

