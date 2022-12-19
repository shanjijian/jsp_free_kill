package pass.loader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EvalClass {
    public String command;

    public EvalClass(String command) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        Process process = Runtime.getRuntime().exec(command);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String print;
        while ((print = bufferedReader.readLine()) != null) {
            stringBuilder.append(print).append("\n");
        }
        this.command = stringBuilder.toString();
    }

    @Override
    public String toString() {
        return this.command;
    }
}
