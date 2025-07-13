import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.*;

public class MailGenerator extends JFrame {

    private String[] domain;
    private JTextField textField;

    public MailGenerator() {
        
        setTitle("Random Email Generator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 300);
        setLayout(new BorderLayout(10, 10));
        getContentPane().setBackground(new Color(240, 240, 240));

        JPanel titlePanel = new JPanel();
        titlePanel.setBackground(new Color(70, 130, 180));
        JLabel titleLabel = new JLabel("RANDOM EMAIL GENERATOR");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setForeground(Color.WHITE);
        titlePanel.add(titleLabel);
        add(titlePanel, BorderLayout.NORTH);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        mainPanel.setBackground(new Color(240, 240, 240));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel emailLabel = new JLabel("Generated Email:");
        emailLabel.setFont(new Font("Arial", Font.BOLD, 14));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.LINE_START;
        mainPanel.add(emailLabel, gbc);

        textField = new JTextField();
        textField.setEditable(false);
        textField.setFont(new Font("Arial", Font.PLAIN, 14));
        textField.setPreferredSize(new Dimension(300, 30));
        textField.setHorizontalAlignment(JTextField.CENTER);
        textField.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(70, 130, 180), 2),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        mainPanel.add(textField, gbc);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(240, 240, 240));
        JButton button = new JButton("Generate Email");
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setBackground(new Color(70, 130, 180));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));

        button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(new Color(100, 150, 200));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(new Color(70, 130, 180));
            }
        });

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String email = generateEmail();
                textField.setText(email);
            }
        });

        buttonPanel.add(button);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        mainPanel.add(buttonPanel, gbc);

        add(mainPanel, BorderLayout.CENTER);

        // Footer
        JPanel footerPanel = new JPanel();
        footerPanel.setBackground(new Color(70, 130, 180));
        JLabel footerLabel = new JLabel("© 2023 Random Email Generator");
        footerLabel.setForeground(Color.WHITE);
        footerPanel.add(footerLabel);
        add(footerPanel, BorderLayout.SOUTH);

        setLocationRelativeTo(null);
    }

    public String generateEmail() {
        String characters = "abcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder generatedStringBuild = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 7; i++) {
            generatedStringBuild.append(characters.charAt(random.nextInt(characters.length())));
        }
        String generatedString = generatedStringBuild.toString();
    
        //domain thing
        String domainList = "@gmail.com,@outlook.com,@hotmail.com,@yahoo.com,@protonmail.com,@zoho.com,@aol.com,@gmx.com,@yandex.com,@icloud.com,@mail.com,@fastmail.com,@tutanota.com,@hushmail.com,@inbox.com,@lycos.com,@inbox.lv,@mail.ru,@protonmail.ch,@tutanota.de,@hush.com,@fastmail.fm,@posteo.de,@runbox.com,@zoznam.sk,@gmx.de,@lycos.co.uk,@icloud.co.uk,@ameritech.net,@bellsouth.net,@cox.net,@earthlink.net,@aim.com,@btinternet.com,@virginmedia.com,@orange.fr,@laposte.net,@web.de,@libero.it,@alice.it,@bluewin.ch,@seznam.cz,@wp.pl,@o2.pl,@interia.pl,@onet.pl,@virgilio.it,@tin.it,@tiscali.it,@telia.com,@telia.se,@telus.net,@shaw.ca,@sympatico.ca,@rogers.com,@bell.net,@frontier.com,@charter.net,@comcast.net,@netzero.net,@msn.com,@live.com,@mail.bg,@abv.bg,@inbox.ru,@rambler.ru,@bk.ru,@list.ru,@mail.kz,@mail.ua,@ukr.net,@sina.com,@qq.com,@163.com,@126.com,@yeah.net,@rediffmail.com,@mailinator.com,@yopmail.com,@guerrillamail.com";
        domain = domainList.split(",");
        int index = random.nextInt(domain.length);

        return generatedString + domain[index];
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
                    UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                new MailGenerator().setVisible(true);
            }
        });
    }
}
