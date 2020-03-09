package Actions;

import Interface.ConfigurationDialogWindow;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;

public class OpenConfigurationDialogAction extends AnAction
{
    @Override
    public void actionPerformed(AnActionEvent e)
    {
        ConfigurationDialogWindow config = new ConfigurationDialogWindow();
        config.show();
    }
}

