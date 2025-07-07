import java.nio.charset.Charset;
import java.util.Random;
import java.util.Scanner;

public class MailGenerator {

    private String[] domain;

    public void firstPart(){
        byte[] array = new byte[7]; // length is bounded by 7
        new Random().nextBytes(array);
        String generatedString = new String(array, Charset.forName("UTF-8"));       //Randomized mail thing
        System.out.print(generatedString);
    }
    public void secondPart(){
        String domainList="@gmail.com,@outlook.com,@hotmail.com,@yahoo.com,@protonmail.com,@zoho.com,@aol.com,@gmx.com,@yandex.com,@icloud.com,@mail.com,@fastmail.com,@tutanota.com,@hushmail.com,@inbox.com,@lycos.com,@inbox.lv,@mail.ru,@protonmail.ch,@tutanota.de,@hush.com,@fastmail.fm,@posteo.de,@runbox.com,@zoznam.sk,@gmx.de,@lycos.co.uk,@icloud.co.uk,@ameritech.net,@bellsouth.net,@cox.net,@earthlink.net,@aim.com,@btinternet.com,@virginmedia.com,@orange.fr,@laposte.net,@web.de,@libero.it,@alice.it,@bluewin.ch,@seznam.cz,@wp.pl,@o2.pl,@interia.pl,@onet.pl,@virgilio.it,@tin.it,@tiscali.it,@telia.com,@telia.se,@telus.net,@shaw.ca,@sympatico.ca,@rogers.com,@bell.net,@frontier.com,@charter.net,@comcast.net,@netzero.net,@msn.com,@live.com,@mail.bg,@abv.bg,@inbox.ru,@rambler.ru,@bk.ru,@list.ru,@mail.kz,@mail.ua,@ukr.net,@sina.com,@qq.com,@163.com,@126.com,@yeah.net,@rediffmail.com,@mailinator.com,@yopmail.com,@guerrillamail.com";
        domain=domainList.split(",");
        Random rand = new Random();
        int index = rand.nextInt(domain.length);            //randomized array thing
        System.out.println(domain[index]);
    }

    public static void main(String[] args) {
            MailGenerator object = new MailGenerator();
           object.firstPart();
           object.secondPart();


    }

}
