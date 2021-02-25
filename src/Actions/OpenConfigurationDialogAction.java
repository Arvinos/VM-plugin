package Actions;

import Interface.ConfigurationDialogWindow;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import org.jetbrains.annotations.NotNull;

public class OpenConfigurationDialogAction extends AnAction
{
    @Override
    public void actionPerformed(@NotNull AnActionEvent e)
    {
        ConfigurationDialogWindow config = new ConfigurationDialogWindow();
        config.show();
    }
}

