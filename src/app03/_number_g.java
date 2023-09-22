package app03;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class _number_g extends JFrame {
    JPanel main_panel;
    JLabel hint_label, try_label;
    JLabel result_label, clear_label, result_label2, result_label3;
    JButton bt, bt2, clear_bt;
    JTextField input_field;

    int random_value = (int) (Math.random() * 1000 + 1);
    int try_count = 0, game_count = 1;
    int user_number;

    public _number_g() {
        setTitle("test game");
        setSize(500, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        main_panel = new JPanel();
        main_panel.setLayout(null);

        bt = new JButton("OK");
        bt.setBackground(Color.WHITE);
        bt2 = new JButton(" 포기");
        bt2.setBackground(Color.RED);

        clear_bt = new JButton("초기화");

        hint_label = new JLabel("힌트: ");
        hint_label.setFont(new Font("", Font.BOLD, 20));
        try_label = new JLabel("시도횟수: 0번");
        try_label.setFont(new Font("", Font.BOLD, 20));
        result_label = new JLabel("정답입니다");
        result_label.setFont(new Font("", Font.BOLD, 20));
        result_label2 = new JLabel("답은 : " + random_value + "였습니다!");
        result_label2.setFont(new Font("", Font.BOLD, 20));
        result_label3 = new JLabel("실패했습니다.");
        result_label3.setFont(new Font("", Font.BOLD, 20));
        clear_label = new JLabel("초기화 버튼을 눌러주세요");
        clear_label.setFont(new Font("", Font.BOLD, 10));

        input_field = new JTextField(30);
        input_field.setFont(new Font("Dialog", Font.BOLD, 30));
        input_field.setHorizontalAlignment(JTextField.CENTER);

        try_label.setBounds(30, 30, 200, 30);
        hint_label.setBounds(90, 150, 500, 30);
        input_field.setBounds(90, 190, 300, 50);
        bt.setBounds(165, 250, 150, 40);
        bt2.setBounds(165, 300, 150, 40);

        main_panel.add(result_label);
        main_panel.add(result_label2);
        main_panel.add(result_label3);
        main_panel.add(clear_label);
        main_panel.add(try_label);
        main_panel.add(hint_label);
        main_panel.add(input_field);
        main_panel.add(bt);
        main_panel.add(bt2);
        main_panel.add(clear_bt);

        add(main_panel);

        bt.addActionListener(new MyActionListener());
        bt2.addActionListener(new MyActionListener());
        clear_bt.addActionListener(new MyActionListener());

        System.out.println(game_count + "번째 게임에서 정해진 난수값: " + random_value);
        setVisible(true);

        while (true) {
            if (clear_label.getText().equals("초기화 버튼을 눌러주세요")) {
                clear_label.setText("");
            } else
                clear_label.setText("초기화 버튼을 눌러주세요");
            try {
                Thread.sleep(600);
            } catch (Exception e1) {
                System.exit(0);
            }
        }
    }

    class MyActionListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            if (e.getSource() == bt) {

                if (try_count >= 5) {
                    result_label3.setVisible(true);
                    result_label2.setVisible(true);
                    clear_label.setVisible(true);
                    try_label.setVisible(false);
                    hint_label.setVisible(false);
                    input_field.setVisible(false);

                    bt.setVisible(false);
                    bt2.setVisible(false);

                    result_label3.setBounds(85, 100, 500, 100);
                    result_label2.setBounds(85, 130, 500, 100);
                    clear_label.setBounds(155, 190, 300, 100);
                    clear_bt.setBounds(165, 255, 150, 50);
                }

                if (input_field.getText().equals(Integer.toString(random_value))) {

                    result_label.setVisible(true);
                    result_label2.setVisible(true);
                    clear_label.setVisible(true);
                    try_label.setVisible(false);
                    hint_label.setVisible(false);
                    input_field.setVisible(false);
                    bt.setVisible(false);
                    bt2.setVisible(false);

                    result_label.setBounds(85, 100, 500, 100);
                    result_label2.setBounds(85, 150, 500, 100);
                    clear_label.setBounds(155, 190, 300, 100);
                    clear_bt.setBounds(165, 255, 150, 50);
                } else {
                    user_number = Integer.parseInt(input_field.getText());

                    if (user_number < random_value) {
                        try_label.setText("시도횟수: " + Integer.toString(++try_count) + "번");
                        hint_label.setText("힌트: 높습니다  ▲");
                        hint_label.setForeground(Color.RED);

                    } else if (user_number > random_value) {
                        try_label.setText("시도횟수: " + Integer.toString(++try_count) + "번");
                        hint_label.setText("힌트: 낮습니다 ▼");
                        hint_label.setForeground(Color.BLUE);

                    }
                }

            } else if (e.getSource() == clear_bt) {
                result_label.setVisible(true);
                result_label2.setVisible(true);
                result_label3.setVisible(false);
                clear_label.setVisible(true);
                try_label.setVisible(true);
                hint_label.setVisible(true);
                input_field.setVisible(true);
                bt.setVisible(true);
                bt2.setVisible(true);

                result_label.setBounds(60, 53, 0, 0);
                result_label2.setBounds(60, 73, 0, 0);
                clear_label.setBounds(57, 142, 0, 0);
                clear_bt.setBounds(165, 230, 0, 0);

                try_count = 0;
                try_label.setText("시도횟수: " + try_count + "번");
                hint_label.setText("힌트: ");
                input_field.setText("");
                random_value = (int) (Math.random() * 100 + 1);

            } else if (e.getSource() == bt2) {
                result_label.setVisible(true);
                result_label2.setVisible(true);
                clear_label.setVisible(true);
                try_label.setVisible(false);
                hint_label.setVisible(false);
                input_field.setVisible(false);
                bt.setVisible(false);
                bt2.setVisible(false);
                result_label.setBounds(85, 100, 500, 100);
                result_label2.setBounds(85, 130, 500, 100);
                clear_label.setBounds(155, 190, 300, 100);
                clear_bt.setBounds(165, 255, 150, 50);

            }
        }
    }

    public static void main(String[] args) {
        new _number_g();
    }
}