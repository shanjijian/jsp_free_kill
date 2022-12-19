package code;

import sun.misc.BASE64Decoder;

import javax.xml.bind.DatatypeConverter;
import java.io.IOException;

public class Decode {
    public static void main(String[] args) throws IOException {
        String a = new String(new byte[]{99, 109, 100});
        System.out.println("ASCII: " + a);

        String b = new String(DatatypeConverter.parseHexBinary("636d64"));
        System.out.println("HEX: " + b);

        String c = new String(new BASE64Decoder().decodeBuffer("Y21k"));
        System.out.println("BASE64: " + c);

        BASE64Decoder decoder = new BASE64Decoder();
        byte[] bytes = decoder.decodeBuffer("yf25vf///zP/UAn/EP8uBv8vCf8B/y4J/zD/MQn/MP8yBv8zBv80Cf81/zYJ/wb/Nwn/Bf84Cf8F/zkJ/wH/Ogf/Own/Af88CP8P/z0G/z4G/z8A/wFgcgD/EUtpYHVgLmtgbWYuUnNxaG1mOgD/BTtobWhzPQD/FCdLaWB1YC5rYG1mLlJzcWhtZjooVQD/A0JuY2QA/w5LaG1kTXRsYWRxU2Bha2QA/xFLbmJga1VgcWhgYWtkU2Bha2QA/wNzZ2hyAP8bS0x4YmtgcnJrbmBjZHEuRHVga2VucWF4c2RyOgD/AmJsYwD/DHJzcWhtZkF0aGtjZHEA/xhLaWB1YC5rYG1mLlJzcWhtZkF0aGtjZHE6AP8Gb3FuYmRycgD/EktpYHVgLmtgbWYuT3FuYmRycjoA/wFhcQD/F0tpYHVgLmhuLkF0ZWVkcWRjUWRgY2RxOgD/AGAA/wxSc2Biakxgb1NgYWtkBv8+Bv9ABv8vBv9BBv8zAP8JRHdiZG9zaG5tcgb/QgD/B3NuUnNxaG1mAP8TJyhLaWB1YC5rYG1mLlJzcWhtZjoA/wlSbnRxYmRFaGtkAP8QRHVga2VucWF4c2RyLWlgdWAL/xP/QwD/FmlgdWAua2BtZi5Sc3FobWZBdGhrY2RxBv9EC/9F/0YL/0f/SAD/FWlgdWAuaG4uQXRlZWRxZGNRZGBjZHEA/xhpYHVgLmhuLkhtb3RzUnNxZGBsUWRgY2RxBv9BC/9J/0oL/xP/Swv/E/9MC/9N/ysL/07/TwD/AAkL/yr/Kwv/Ef8SAP8ZTHhia2BycmtuYGNkcS5EdWBrZW5xYXhzZHIA/w9pYHVgLmtgbWYuTmFpZGJzAP8PaWB1YC5rYG1mLlJzcWhtZgD/EGlgdWAua2BtZi5PcW5iZHJyAP8SaWB1YC5rYG1mLkR3YmRvc2hubQD/AicoVQD/EGlgdWAua2BtZi5RdG1zaGxkAP8JZmRzUXRtc2hsZAD/FCcoS2lgdWAua2BtZi5RdG1zaGxkOgD/A2R3ZGIA/yYnS2lgdWAua2BtZi5Sc3FobWY6KEtpYHVgLmtgbWYuT3FuYmRycjoA/w1mZHNIbW90c1JzcWRgbAD/FicoS2lgdWAuaG4uSG1vdHNSc3FkYGw6AP8XJ0tpYHVgLmhuLkhtb3RzUnNxZGBsOihVAP8SJ0tpYHVgLmhuLlFkYGNkcTooVQD/B3FkYGNLaG1kAP8FYG9vZG1jAP8sJ0tpYHVgLmtgbWYuUnNxaG1mOihLaWB1YC5rYG1mLlJzcWhtZkF0aGtjZHE6/yD/D/8Q////AP8A/xH/Ev///wH/AP8T/xT/Af8V////5v8E/wX///9KKbb/ALr/AVi2/wJMt/8DKrX/BE26/wVYuv8GWCy1/we2/wi2/wk5AxgDtf8KWDkExf8RKxgEtf8LEQy1/wtWpv7oKSu1/w20/w6w////Av8W////If8H////Cf8D/wr/C/8L/xP/DP8n/w7/Mv8P/0H/Ef9J/xT/F////z3/Bf///0r/GP8Z//////9K/xr/Ev8A/wv/Pv8b/xz/Af8T/zb/Hf8e/wL/J/8i/x//IP8D/y//Gv8h/xL/BP8i////Hf8B/v8n/wQG/yMG/yQG/yUG/yYG/yf///v/GAb/JP8o////A/8A/yn/AP8q/yv/AP8V////Lv8A/wD///8EKbP/Dq////8B/xb///8F/wD///8Y/xf///8L/wD///8E/xj/Gf///wD/LP///wH/LQ==");
        for (int i = 0; i < bytes.length; i++) {
            System.out.println("beforeBytes = " + bytes[i]);
            bytes[i] = (byte) (bytes[i] + 1);
            System.out.println("afterBytes = " + bytes[i]);
        }
        String d = new String(bytes);
        System.out.println("ASCII: " + d);
    }
}
