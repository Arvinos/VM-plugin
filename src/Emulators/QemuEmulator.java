package Emulators;

import java.io.IOException;

public class QemuEmulator
{
    private static final String cmd_separator = " ";

    private String m_machineType;

    public QemuEmulator(String machineArchitecture)
    {
        this.m_machineType = new String("qemu-system-" + machineArchitecture);
    }

    public int run(String binaryImagePath)
    {
        int processStatus;

        try
        {
            Process proc = Runtime.getRuntime().exec(this.createCommand(binaryImagePath));
            proc.waitFor();
            proc.destroy();

            processStatus = proc.exitValue();
        }
        catch (InterruptedException | IOException e)
        {
            System.out.println(e.getMessage());
            processStatus = -1;
        }

        return processStatus;
    }

    private String createCommand(String binaryImagePath)
    {
        String command = String.join(cmd_separator, m_machineType, binaryImagePath);

        System.out.println(command);

        return command;
    }
}
