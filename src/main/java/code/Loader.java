package code;

import sun.misc.BASE64Decoder;

public class Loader {
    public static class MyLoader extends ClassLoader { //继承ClassLoader
        public Class get(byte[] b) {
            return super.defineClass(b, 0, b.length);
        }
    }

    public static void main(String[] args) throws Exception {
        String classStr = "yv66vgAAADQAKQoACQAZCgAaABsIABwKABoAHQcAHgoABQAfCAAgBwAhBwAiAQAGPGluaXQ+AQADKClWAQAEQ29kZQEAD0xpbmVOdW1iZXJUYWJsZQEAEkxvY2FsVmFyaWFibGVUYWJsZQEABHRoaXMBABJMb3JnL2V4YW1wbGUvY2FsYzsBAAh0b1N0cmluZwEAFCgpTGphdmEvbGFuZy9TdHJpbmc7AQABZQEAFUxqYXZhL2lvL0lPRXhjZXB0aW9uOwEADVN0YWNrTWFwVGFibGUHAB4BAApTb3VyY2VGaWxlAQAJY2FsYy5qYXZhDAAKAAsHACMMACQAJQEACGNhbGMuZXhlDAAmACcBABNqYXZhL2lvL0lPRXhjZXB0aW9uDAAoAAsBAAJPSwEAEG9yZy9leGFtcGxlL2NhbGMBABBqYXZhL2xhbmcvT2JqZWN0AQARamF2YS9sYW5nL1J1bnRpbWUBAApnZXRSdW50aW1lAQAVKClMamF2YS9sYW5nL1J1bnRpbWU7AQAEZXhlYwEAJyhMamF2YS9sYW5nL1N0cmluZzspTGphdmEvbGFuZy9Qcm9jZXNzOwEAD3ByaW50U3RhY2tUcmFjZQAhAAgACQAAAAAAAgABAAoACwABAAwAAAAvAAEAAQAAAAUqtwABsQAAAAIADQAAAAYAAQAAAAMADgAAAAwAAQAAAAUADwAQAAAAAQARABIAAQAMAAAAbQACAAIAAAAUuAACEgO2AARXpwAITCu2AAYSB7AAAQAAAAkADAAFAAMADQAAABYABQAAAAcACQAKAAwACAANAAkAEQALAA4AAAAWAAIADQAEABMAFAABAAAAFAAPABAAAAAVAAAABwACTAcAFgQAAQAXAAAAAgAY"; // class的base64编码
        BASE64Decoder code = new sun.misc.BASE64Decoder();
        System.out.println("code = " + code);
        Class result = new MyLoader().get(code.decodeBuffer(classStr));//将base64解码成byte数组，并传入t类的get函数
        System.out.println(result.newInstance().toString());
    }
}