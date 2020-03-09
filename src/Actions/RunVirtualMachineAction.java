package Actions;

import Emulators.QemuEmulator;
import Interface.PluginErrorDialog;
import Interface.RunDialog;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;

public class RunVirtualMachineAction extends AnAction {

    @Override
    public void actionPerformed(AnActionEvent e)
    {
        String imagePath = "C:\\Users\\ARVinfinity\\Documents\\HomeProjects\\SunnyOS\\Kernel\\bootloader.bin";
        String machineArchitecture = "i386";
        int emulatorStatus;

        if(new RunDialog().showAndGet())
        {
            QemuEmulator emulator = new QemuEmulator(machineArchitecture);
            emulatorStatus = emulator.run(imagePath);

            if (emulatorStatus != 0
                && new PluginErrorDialog("Qemu return the follow status: " + emulatorStatus).showAndGet())
            {
                System.out.println("Qemu return the follow status: " + emulatorStatus);
            }
        }
    }
}
