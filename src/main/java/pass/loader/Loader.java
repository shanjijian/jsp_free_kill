package pass.loader;

import sun.misc.BASE64Decoder;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Loader {
    public static class MyLoader extends ClassLoader { //继承ClassLoader
        public Class get(byte[] b) {
            //defineClass()能将class二进制内容转换成Class对象
            return super.defineClass(null, b, 0, b.length);
        }
    }

    public static void main(String[] args) throws IOException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        BASE64Decoder decoder = new BASE64Decoder();
        String classStr = "yv66vgAAADQAUAoAEQAuBwAvCgACAC4KADAAMQoAMAAyBwAzBwA0CgA1ADYKAAcANwoABgA4CgAGADkKAAIAOggAOwoAAgA8CQAQAD0HAD4HAD8BAAdjb21tYW5kAQASTGphdmEvbGFuZy9TdHJpbmc7AQAGPGluaXQ+AQAVKExqYXZhL2xhbmcvU3RyaW5nOylWAQAEQ29kZQEAD0xpbmVOdW1iZXJUYWJsZQEAEkxvY2FsVmFyaWFibGVUYWJsZQEABHRoaXMBABdMcGFzcy9sb2FkZXIvRXZhbENsYXNzOwEADXN0cmluZ0J1aWxkZXIBABlMamF2YS9sYW5nL1N0cmluZ0J1aWxkZXI7AQAHcHJvY2VzcwEAE0xqYXZhL2xhbmcvUHJvY2VzczsBAA5idWZmZXJlZFJlYWRlcgEAGExqYXZhL2lvL0J1ZmZlcmVkUmVhZGVyOwEABXByaW50AQANU3RhY2tNYXBUYWJsZQcAPgcAQAcALwcAQQcAMwEACkV4Y2VwdGlvbnMHAEIBAAh0b1N0cmluZwEAFCgpTGphdmEvbGFuZy9TdHJpbmc7AQAKU291cmNlRmlsZQEADkV2YWxDbGFzcy5qYXZhDAAUAEMBABdqYXZhL2xhbmcvU3RyaW5nQnVpbGRlcgcARAwARQBGDABHAEgBABZqYXZhL2lvL0J1ZmZlcmVkUmVhZGVyAQAZamF2YS9pby9JbnB1dFN0cmVhbVJlYWRlcgcAQQwASQBKDAAUAEsMABQATAwATQArDABOAE8BAAEKDAAqACsMABIAEwEAFXBhc3MvbG9hZGVyL0V2YWxDbGFzcwEAEGphdmEvbGFuZy9PYmplY3QBABBqYXZhL2xhbmcvU3RyaW5nAQARamF2YS9sYW5nL1Byb2Nlc3MBABNqYXZhL2lvL0lPRXhjZXB0aW9uAQADKClWAQARamF2YS9sYW5nL1J1bnRpbWUBAApnZXRSdW50aW1lAQAVKClMamF2YS9sYW5nL1J1bnRpbWU7AQAEZXhlYwEAJyhMamF2YS9sYW5nL1N0cmluZzspTGphdmEvbGFuZy9Qcm9jZXNzOwEADmdldElucHV0U3RyZWFtAQAXKClMamF2YS9pby9JbnB1dFN0cmVhbTsBABgoTGphdmEvaW8vSW5wdXRTdHJlYW07KVYBABMoTGphdmEvaW8vUmVhZGVyOylWAQAIcmVhZExpbmUBAAZhcHBlbmQBAC0oTGphdmEvbGFuZy9TdHJpbmc7KUxqYXZhL2xhbmcvU3RyaW5nQnVpbGRlcjsAIQAQABEAAAABAAEAEgATAAAAAgABABQAFQACABYAAADnAAUABgAAAEsqtwABuwACWbcAA024AAQrtgAFTrsABlm7AAdZLbYACLcACbcACjoEGQS2AAtZOgXGABIsGQW2AAwSDbYADFen/+kqLLYADrUAD7EAAAADABcAAAAiAAgAAAAKAAQACwAMAAwAFAANACgADwAzABAAQgASAEoAEwAYAAAAPgAGAAAASwAZABoAAAAAAEsAEgATAAEADAA/ABsAHAACABQANwAdAB4AAwAoACMAHwAgAAQAMAAbACEAEwAFACIAAAAeAAL/ACgABQcAIwcAJAcAJQcAJgcAJwAA/AAZBwAkACgAAAAEAAEAKQABACoAKwABABYAAAAvAAEAAQAAAAUqtAAPsAAAAAIAFwAAAAYAAQAAABcAGAAAAAwAAQAAAAUAGQAaAAAAAQAsAAAAAgAt";
        Class result = new MyLoader().get(decoder.decodeBuffer(classStr));
        Constructor cos = result.getConstructor(String.class);
        Object obj = cos.newInstance("whoami");
        System.out.println(obj);
    }
}
