import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.*;

public class MailGenerator extends JFrame {

    private String[] domain;
    private JTextField textField;

    public MailGenerator() {

        setTitle("Mail Generator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setLayout(new BorderLayout());

        textField = new JTextField();
        textField.setEditable(false);           //email text field
        textField.setColumns(25);
        add(textField, BorderLayout.NORTH);

        JButton button = new JButton("Generate Mail");
        add(button, BorderLayout.SOUTH); // Button now at bottom center

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String email = generateEmail();
                textField.setText(email);
            }
        });

        setLocationRelativeTo(null);            //centered for the user

    }
    public String generateEmail() {

        //first part of the mail
        String characters = "abcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder generatedStringBuild= new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 7; i++) {
            generatedStringBuild.append(characters.charAt(random.nextInt(characters.length())));
        }
        String generatedString = generatedStringBuild.toString();




        //second part of the mail
        Random rand = new Random();
        String domainList="@gmail.com,@outlook.com,@hotmail.com,@yahoo.com,@protonmail.com,@zoho.com,@aol.com,@gmx.com,@yandex.com,@icloud.com,@mail.com,@fastmail.com,@tutanota.com,@hushmail.com,@inbox.com,@lycos.com,@inbox.lv,@mail.ru,@protonmail.ch,@tutanota.de,@hush.com,@fastmail.fm,@posteo.de,@runbox.com,@zoznam.sk,@gmx.de,@lycos.co.uk,@icloud.co.uk,@ameritech.net,@bellsouth.net,@cox.net,@earthlink.net,@aim.com,@btinternet.com,@virginmedia.com,@orange.fr,@laposte.net,@web.de,@libero.it,@alice.it,@bluewin.ch,@seznam.cz,@wp.pl,@o2.pl,@interia.pl,@onet.pl,@virgilio.it,@tin.it,@tiscali.it,@telia.com,@telia.se,@telus.net,@shaw.ca,@sympatico.ca,@rogers.com,@bell.net,@frontier.com,@charter.net,@comcast.net,@netzero.net,@msn.com,@live.com,@mail.bg,@abv.bg,@inbox.ru,@rambler.ru,@bk.ru,@list.ru,@mail.kz,@mail.ua,@ukr.net,@sina.com,@qq.com,@163.com,@126.com,@yeah.net,@rediffmail.com,@mailinator.com,@yopmail.com,@guerrillamail.com";
        domain=domainList.split(",");
        int index = rand.nextInt(domain.length);            //randomized array thing

        String newMail;
        newMail=generatedString+domain[index];
        return newMail;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MailGenerator().setVisible(true);    //change here
            }
        });
    }
}
