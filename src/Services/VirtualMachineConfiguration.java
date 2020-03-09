package Services;

import com.intellij.openapi.components.Service;

@Service
public class VirtualMachineConfiguration
{
    static private VirtualMachineConfiguration vmConfiguration;
    private        String                      machine;
    private        String                      binaryPath;
    private        String                      commandLineOptions;

    VirtualMachineConfiguration(){}

    public String getMachine()
    {
        return machine;
    }

    public void setMachine(String machine)
    {
        this.machine = machine;
    }

    public String getBinaryPath()
    {
        return binaryPath;
    }

    public void setBinaryPath(String binaryPath)
    {
        this.binaryPath = binaryPath;
    }

    public String getCommandLineOptions()
    {
        return commandLineOptions;
    }

    public void setCommandLineOptions(String commandLineOptions)
    {
        this.commandLineOptions = commandLineOptions;
    }

    static public VirtualMachineConfiguration getInstance()
    {
        if (vmConfiguration == null)
        {
            vmConfiguration = new VirtualMachineConfiguration();
            vmConfiguration.binaryPath = "C:\\Users\\ARVinfinity\\Documents\\HomeProjects\\SunnyOS\\Kernel\\bootloader.bin";
            vmConfiguration.machine = "i386";
            vmConfiguration.commandLineOptions = "";
        }

        return vmConfiguration;
    }

    @Override public String toString()
    {
        return "PluginSettings{" +
                "machine='" + machine + '\'' +
                ", binaryPath='" + binaryPath + '\'' +
                ", commandLineOptions='" + commandLineOptions + '\'' +
                '}';
    }
}
