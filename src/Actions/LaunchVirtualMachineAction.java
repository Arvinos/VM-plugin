package Actions;

import Emulators.QemuEmulator;
import Interface.ErrorDialogWindow;
import Services.VirtualMachineConfiguration;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;

public class LaunchVirtualMachineAction extends AnAction {

    @Override
    public void actionPerformed(AnActionEvent e)
    {
        VirtualMachineConfiguration vmConfiguration = VirtualMachineConfiguration.getInstance();
        int emulatorStatus;

        QemuEmulator emulator = new QemuEmulator(vmConfiguration.getMachine());
        emulatorStatus = emulator.run(vmConfiguration.getBinaryPath());

        if (emulatorStatus != 0 && new ErrorDialogWindow("Qemu return the follow status: " + emulatorStatus).showAndGet())
        {
            System.out.println("Qemu return the follow status: " + emulatorStatus);
        }
    }
}
