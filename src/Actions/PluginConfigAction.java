package Actions;

import Interface.PluginConfigDialog;
import Interface.PluginSettings;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;

public class PluginConfigAction extends AnAction
{
    @Override
    public void actionPerformed(AnActionEvent e)
    {
        PluginConfigDialog config = new PluginConfigDialog();

        PluginSettings userSettings = config.showAndGetSettings();

        savePluginSettings(userSettings);

    }

    private void savePluginSettings(PluginSettings settings)
    {

    }
}
